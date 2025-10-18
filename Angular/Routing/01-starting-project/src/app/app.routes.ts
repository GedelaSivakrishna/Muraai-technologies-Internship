import { inject } from '@angular/core';
import { CanMatchFn, RedirectCommand, Router, Routes } from '@angular/router';
import { NotFoundComponent } from './not-found/not-found.component';
import { NoTaskComponent } from './tasks/no-task/no-task.component';
import {
  resolveTitle,
  resolveUserName,
  UserTasksComponent,
} from './users/user-tasks/user-tasks.component';
import { routes as userRoutes } from './users/users.routes';
import { ExampleCanMatchClassGuard } from './RouteGuards/ExampleClassGuard.guard';

const exampleCanMatchGuard: CanMatchFn = (route, segments) => {
  const router = inject(Router);
  const shouldGetAccess = Math.random();
  if (shouldGetAccess < 1) {
    return true;
  }
  return new RedirectCommand(router.parseUrl('/unauthorized'));
};

export const routes: Routes = [
  {
    path: '',
    component: NoTaskComponent,
    // redirectTo: "/user/u1",
    // pathMatch: "full"
    title: 'No Task Selected',
  },
  {
    path: 'user/:userId',
    component: UserTasksComponent,
    canMatch: [exampleCanMatchGuard],
    // canMatch: [ExampleCanMatchClassGuard],
    children: userRoutes,
    data: {
      name: 'Gedela Sivakrishna',
    },
    resolve: {
      userName: resolveUserName,
      // userName: UserNameResolver
    },
    title: resolveTitle,
  },
  {
    path: '**',
    component: NotFoundComponent,
  },
];
