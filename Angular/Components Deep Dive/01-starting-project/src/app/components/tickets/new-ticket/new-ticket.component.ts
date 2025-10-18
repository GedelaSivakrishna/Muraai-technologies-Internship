import { afterNextRender, afterRender, AfterViewInit, Component, ElementRef, EventEmitter, OnInit, output, Output, viewChild, ViewChild, ViewChildren } from '@angular/core';
import { ButtonComponent } from "../../button/button.component";
import { ControlComponent } from "../../control/control.component";
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-new-ticket',
  standalone: true,
  imports: [ButtonComponent, ControlComponent, FormsModule],
  templateUrl: './new-ticket.component.html',
  styleUrl: './new-ticket.component.css'
})
export class NewTicketComponent {

  @ViewChild('form') private form?: ElementRef<HTMLFormElement>;
  // @Output() add = new EventEmitter<{ title: string; request: string}>();
  add = output<{ title: string; request: string}>();
  enteredTitle = '';
  enteredRequest = '';
  // @ViewChildren
  // private form = viewChild.required<ElementRef<HTMLFormElement>>('form');

  // ngOnInit() {
  //   console.log("ON INIT");
  //   console.log(this.form?.nativeElement);
  // }

  // ngAfterViewInit() {
  //     console.log("AFTER VIEW INIT");
  //     console.log(this.form?.nativeElement);
  // }

  constructor() {
    // afterRender(() => {
    //   console.log("AfterRender");
    // });

    // afterNextRender(() => {
    //   console.log("AfterNextRender");
    // });
  }

  onSubmit() {
    this.add.emit({
      title: this.enteredTitle,
      request: this.enteredRequest
    });
    // this.form?.nativeElement.reset();
    this.enteredTitle = '';
    this.enteredRequest = '';
  }

}
