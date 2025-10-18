import { AfterContentInit, Component, contentChild, ContentChild, ElementRef, HostBinding, HostListener, inject, input, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-control',
  standalone: true,
  imports: [],
  templateUrl: './control.component.html',
  styleUrl: './control.component.css',
  // changing the scope of the styles from component level
  // to global scope
  encapsulation: ViewEncapsulation.None,
  host: {
    class: 'control', // adds the 'control' classs to app-control element wherever it's used in the app
    '(click)': 'onClick()'
  }
})
export class ControlComponent {
  
  // The below approach exists to support backward compatability
  // @HostBinding('class') className = 'control';
  // @HostListener('click') onClick() {
  //   console.log("Clicked on host element");
  // }

  label = input.required<string>();
  private el = inject(ElementRef);
  @ContentChild("input") private input?: ElementRef<HTMLInputElement | HTMLTextAreaElement>;
  // private input = contentChild<ElementRef<HTMLInputElement | HTMLTextAreaElement>>("input");

  // ngOnInit() {
  //   console.log("ON INIT");
  //   console.log(this.input);
  // }

  // ngAfterContentInit() {
  //     console.log("AFTER CONTENT INIT");
  //     console.log(this.input);
  // }

  onClick() {
      console.log("Clicked on host element");
      console.log(this.el);
      console.log(this.input);
  }

}
