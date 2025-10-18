import { Component } from '@angular/core';

@Component({
  selector: 'app-task1',
  imports: [],
  templateUrl: './task1.html',
  styleUrl: './task1.css'
})
export class Task1 {
  tasks = [
    {
      id: 1,
      name: "Wakeup early in the morning",
    },
    {
      id: 2,
      name: "Have lunch at noon",
    },
    {
      id: 3,
      name: "Go to bed early",
    }];
}
