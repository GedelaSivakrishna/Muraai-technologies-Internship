import { Component } from '@angular/core';
import { DashboardWrapperComponent } from './components/dashboard-wrapper/dashboard-wrapper.component';
import { HeaderComponent } from './components/header/header.component';
import { ServerComponent } from './components/server/server.component';
import { TicketsComponent } from './components/tickets/tickets.component';
import { TrafficComponent } from './components/traffic/traffic.component';

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  imports: [
    HeaderComponent,
    ServerComponent,
    TicketsComponent,
    TrafficComponent,
    DashboardWrapperComponent,
  ],
})
export class AppComponent {
  dashboardItems = [
    {
      id: 1,
      image: 'status.png',
      heading: 'Server Status',
    },
    {
      id: 2,
      image: 'globe.png',
      heading: 'Traffic',
    },
    {
      id: 3,
      image: 'list.png',
      heading: 'Support Tickets',
    },
  ];

  // constructor() {
  //   console.log("Constructor");
  // }

  // ngOnChanges() {
  //   console.log("ngOnChanges");
  // }

  // ngOnInit() {
  //   console.log("ngOnInIt");
  // }

  // ngDoCheck() {
  //   console.log("ngDoCheck");
  // }

  // ngAfterContentInit() {
  //     console.log("ngAfterContentInit");
  // }

  // ngAfterContentChecked() {
  //   console.log("ngAfterContentChecked");
  // }

  // ngAfterViewInit() {
  //   console.log("ngAfterViewInit");
  // }

  // ngAfterViewChecked() {
  //   console.log("ngAfterViewChecked");
  // }

  // ngOnDestroy() {
  //   console.log("ngOnDestroy");
  // }
}
