import { Component, signal } from '@angular/core';
import {MatTabsModule} from '@angular/material/tabs';
import {MatTableModule} from '@angular/material/table';
import {MatFormFieldModule} from '@angular/material/form-field';
import {FormsModule} from '@angular/forms';
import DOMPurify from 'dompurify';

export interface PeriodicElement {
  name: string;
  position: number;
}

const ELEMENT_DATA: PeriodicElement[] = [
  {position: 1, name: 'Wakeup early in the morning'},
  {position: 2, name: 'Drink enough water'},
  {position: 3, name: 'Go for a walk'},
  {position: 4, name: 'Go to bed early'},
];

@Component({
  selector: 'app-root',
  imports: [ MatTabsModule, MatTableModule, FormsModule, MatFormFieldModule
  ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('angular-assignment-1');
  // currentTab = 1;
  // onTaskClick(tabId: number) {
  //   this.currentTab = tabId;
  // }

  displayedColumns: string[] = ['position', 'name'];
  dataSource = ELEMENT_DATA;
  name?: string;

  onSubmit(usernameInput: HTMLInputElement) {
    this.name = DOMPurify.sanitize(usernameInput.value);
    usernameInput.value = "";
  }

}
