import {
  afterNextRender,
  Component,
  DestroyRef,
  inject,
  OnInit,
} from '@angular/core';
import {
  AbstractControl,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { debounceTime, of } from 'rxjs';

function mustContainHashTag(control: AbstractControl) {
  if (control.value?.includes('#')) {
    return null;
  }

  return { doNotContainHashtag: true };
}

function isEmailUnique(control: AbstractControl) {
  if (control.value === 'gedelasivakrishna1@gmail.com') {
    return of({ emailExists: true });
  }

  return of(null);
}

let savedEmail: string;
const savedForm = localStorage.getItem("reactive-form");
if(savedForm) {
  const loadedForm = JSON.parse(savedForm);
  savedEmail = loadedForm.email;
  // this.form.controls.email.setValue(savedEmail);
}

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent implements OnInit {
  destroyRef = inject(DestroyRef);
  form = new FormGroup({
    email: new FormControl(savedEmail, {
      validators: [Validators.required, Validators.email],
      asyncValidators: [isEmailUnique],
    }),
    password: new FormControl('', {
      validators: [
        Validators.required,
        Validators.minLength(6),
        mustContainHashTag,
      ],
    }),
  });

  ngOnInit() {
    const subscription = this.form.valueChanges
      .pipe(debounceTime(500))
      .subscribe({
        next: (value) => {
          localStorage.setItem(
            'reactive-form',
            JSON.stringify({ email: value.email })
          );
        }
      });

    this.destroyRef.onDestroy(() => subscription.unsubscribe());
  }

  get emailIsInvalid() {
    return (
      this.form.controls.email.touched &&
      this.form.controls.email.dirty &&
      this.form.controls.email.invalid
    );
  }

  get passwordIsInvalid() {
    return (
      this.form.controls.password.touched &&
      this.form.controls.password.dirty &&
      this.form.controls.password.invalid
    );
  }

  onSubmit() {
    console.log(this.form);
    const enteredEmail = this.form.value.email;
    const enteredPassword = this.form.value.password;
    console.log(enteredEmail, enteredPassword);
    this.form.reset();
  }
}
