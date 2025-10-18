import { Component, ElementRef, Inject, inject, viewChild } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TaskService } from '../task.service';
import { TaskServiceToken } from '../../../main';

@Component({
  selector: 'app-new-task',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './new-task.component.html',
  styleUrl: './new-task.component.css',
})
export class NewTaskComponent {
  private formEl = viewChild<ElementRef<HTMLFormElement>>('form');
  // private taskService = inject(TaskService);

  constructor( @Inject(TaskServiceToken) private taskService: TaskService ) {}

  onAddTask(title: string, description: string) {
    this.formEl()?.nativeElement.reset();
    this.taskService.addTask({title, description});
  }
}
