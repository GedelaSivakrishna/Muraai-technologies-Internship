import { Component, inject, input, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { TasksService } from '../tasks.service';
import { CanDeactivateFn, Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-new-task',
  standalone: true,
  imports: [FormsModule, RouterLink],
  templateUrl: './new-task.component.html',
  styleUrl: './new-task.component.css',
})
export class NewTaskComponent {
  userId = input.required<string>();
  enteredTitle = signal('');
  enteredSummary = signal('');
  enteredDate = signal('');
  submitted = false;
  private tasksService = inject(TasksService);
  private router = inject(Router);

  onSubmit() {
    this.tasksService.addTask(
      {
        title: this.enteredTitle(),
        summary: this.enteredSummary(),
        date: this.enteredDate(),
      },
      this.userId()
    );
    this.submitted = true;
    // console.log("Before Routing");
    this.router.navigate(["/user", this.userId(), "tasks"], {
      replaceUrl: true
    });
    // console.log("After Routing");
  }
}

export const canLeaveEditPage: CanDeactivateFn<NewTaskComponent> = (component) => {
  if(component.submitted) {
    return true;
  }
  if(component.enteredDate() || component.enteredSummary() || component.enteredTitle()) {
    return window.confirm("Do want to leave the page ? You will lose all the entered data.");
  }
  return true;
}