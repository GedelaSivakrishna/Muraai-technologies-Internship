import { CommonModule } from '@angular/common';
import { Component, signal } from '@angular/core';
import { ChildComponent } from './components/child/child';

@Component({
  selector: 'app-root',
  imports: [ CommonModule, ChildComponent ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  show: boolean = false;
  items = ["item1", "item2", "item3"];
  day = 1;
}
