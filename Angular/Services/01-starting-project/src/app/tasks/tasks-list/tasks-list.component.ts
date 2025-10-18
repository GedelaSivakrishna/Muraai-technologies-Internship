import { Component, computed, inject, signal } from '@angular/core';

import { TaskItemComponent } from './task-item/task-item.component';
import { TaskService } from '../task.service';
import { TaskServiceToken } from '../../../main';
import { TASK_STATUS_OPTIONS_TOKEN, taskStatusOptionsProvider } from '../task.model';

@Component({
  selector: 'app-tasks-list',
  standalone: true,
  templateUrl: './tasks-list.component.html',
  styleUrl: './tasks-list.component.css',
  imports: [TaskItemComponent],
  providers: [ taskStatusOptionsProvider ]
})
export class TasksListComponent {
  selectedFilter = signal<string>('all');
  private taskService = inject(TaskServiceToken);
  taskStatusOptions = inject(TASK_STATUS_OPTIONS_TOKEN);
  tasks = computed(() => {
    switch(this.selectedFilter()) {
      case "open":
        return this.taskService.allTasks().filter(task => task.status === "OPEN");
      case "in-progress":
        return this.taskService.allTasks().filter(task => task.status === "IN_PROGRESS");
      case "done":
        return this.taskService.allTasks().filter(task => task.status === "DONE");
      default:
        return this.taskService.allTasks();
    }
  });

  onChangeTasksFilter(filter: string) {
    this.selectedFilter.set(filter);
  }
}
