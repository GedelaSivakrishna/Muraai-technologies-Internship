import { Directive, ElementRef, inject } from '@angular/core';

@Directive({
  selector: '[appLog]',
  standalone: true,
  host: {
    '(click)': "onClick()"
  }
})
export class LogDirective {

  private hostRef = inject(ElementRef);

  onClick() {
    console.log("Clicked");
    console.log(this.hostRef.nativeElement);
  }

}
