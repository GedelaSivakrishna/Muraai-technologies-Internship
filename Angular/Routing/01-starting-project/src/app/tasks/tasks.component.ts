import {
  Component,
  computed,
  DestroyRef,
  effect,
  inject,
  input,
  OnInit,
  signal,
} from '@angular/core';

import { TaskComponent } from './task/task.component';
import { Task } from './task/task.model';
import { TasksService } from './tasks.service';
import {
  ActivatedRoute,
  ActivatedRouteSnapshot,
  ResolveFn,
  RouterLink,
  RouterStateSnapshot,
} from '@angular/router';

@Component({
  selector: 'app-tasks',
  standalone: true,
  templateUrl: './tasks.component.html',
  styleUrl: './tasks.component.css',
  imports: [TaskComponent, RouterLink],
})
export class TasksComponent {
  userId = input.required<string>();
  order = input<'asc' | 'desc' | undefined>();
  userTasks = input.required<Task[]>();

}

export const userTasksResolver: ResolveFn<Task[]> = (
  route: ActivatedRouteSnapshot,
  state: RouterStateSnapshot
) => {
  const tasksService = inject(TasksService);
  const order = route.queryParamMap.get("order");
  const userTasks = tasksService.allTasks().filter(u => u.userId === route.paramMap.get('userId'));
  userTasks.sort((a, b) => {
    if(order === "asc") {
      return a.id < b.id ? -1 : 1;
    }
    else {
      return a.id < b.id ? 1 : -1;
    }
  })
  return userTasks;
};
