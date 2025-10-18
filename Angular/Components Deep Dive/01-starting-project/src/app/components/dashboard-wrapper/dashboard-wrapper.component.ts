import { Component, input, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-dashboard-wrapper',
  standalone: true,
  imports: [],
  templateUrl: './dashboard-wrapper.component.html',
  styleUrl: './dashboard-wrapper.component.css',
  // encapsulation: ViewEncapsulation.None,
  // host: {
  //   class: 'dashboard-item'
  // }
})
export class DashboardWrapperComponent {
  image = input.required<string>();
  heading = input.required<string>();
}
