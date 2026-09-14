import { Component } from '@angular/core';
import { MatSlideToggle } from '@angular/material/slide-toggle';
import { DashboardComponent } from './schematics/dashboard/dashboard.component';
import { NavbarComponent } from './schematics/navbar/navbar.component'
import { AutoComplete } from './components/auto-complete/auto-complete'


@Component({
  selector: 'app-root',
  imports: [ MatSlideToggle, DashboardComponent, NavbarComponent, AutoComplete ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  
}
