import { Component, inject, input, OnInit } from '@angular/core';
import {
  ActivatedRoute,
  ActivatedRouteSnapshot,
  ResolveFn,
  RouterLink,
  RouterOutlet,
  RouterStateSnapshot,
} from '@angular/router';
import { UsersService } from '../users.service';

@Component({
  selector: 'app-user-tasks',
  standalone: true,
  templateUrl: './user-tasks.component.html',
  styleUrl: './user-tasks.component.css',
  imports: [RouterOutlet, RouterLink],
})
export class UserTasksComponent {
  userName = input.required<string>();
  name = input.required<string>();
}

export const resolveUserName: ResolveFn<string> = (
  activatedRouteSnapshot: ActivatedRouteSnapshot,
  routerStateSnapshot: RouterStateSnapshot
) => {
  const userService = inject(UsersService);
  const userName =
    userService.users.find(
      (u) => u.id === activatedRouteSnapshot.paramMap.get('userId')
    )?.name || '';
  return userName;
};

export const resolveTitle: ResolveFn<string> = (route, state) => {
  return resolveUserName(route, state) + "'s Tasks";
}
