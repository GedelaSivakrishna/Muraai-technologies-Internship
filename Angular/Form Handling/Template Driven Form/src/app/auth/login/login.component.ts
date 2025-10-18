import { afterNextRender, Component, DestroyRef, inject, viewChild } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { debounce, debounceTime } from 'rxjs';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ FormsModule ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {

  // email = "";
  // password = "";

  form = viewChild.required<NgForm>("form");
  destroyRef = inject(DestroyRef);

  constructor() {
    afterNextRender(() => {

      const savedForm = localStorage.getItem("template-form");

      if(savedForm) {
        const loadedFormData = JSON.parse(savedForm);
        setTimeout(() => {
          this.form().controls["email"].setValue(loadedFormData.email);
        }, 1)
      }
      
      const subscription = this.form().valueChanges?.pipe(
        debounceTime(500)
      ).subscribe({
        next: ({email}) => localStorage.setItem("template-form", JSON.stringify({email: email}))
      });

      this.destroyRef.onDestroy(() => subscription?.unsubscribe());
    });
  }

  onSubmit(formData: NgForm) {
    if(formData.form.invalid) {
      return;
    }
    console.log(formData);
    const enteredEmail = formData.form.value.email;
    const enteredPassword = formData.form.value.password;
    console.log(enteredEmail, enteredPassword);
    // console.log(this.email, this.password);

    formData.form.reset();

  }

}
