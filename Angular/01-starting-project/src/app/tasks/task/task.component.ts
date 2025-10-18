import { DatePipe } from '@angular/common';
import { Component, inject, Input } from '@angular/core';
import { CardComponent } from '../../shared/card/card.component';
import { TasksService } from '../tasks.service';
import { type Task } from './task.model';

@Component({
  selector: 'app-task',
  // standalone: true,
  // imports: [CardComponent, DatePipe],
  templateUrl: './task.component.html',
  styleUrl: './task.component.css',
})
export class TaskComponent {
  @Input({ required: true }) task!: Task;
  //  @Output() complete = new EventEmitter();
  private tasksService = inject(TasksService);

  onComplete(taskId: string) {
    this.tasksService.removeTask(taskId);
  }
}
