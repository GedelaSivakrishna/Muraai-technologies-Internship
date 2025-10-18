import { Routes } from "@angular/router";
import { TasksComponent, userTasksResolver } from "../tasks/tasks.component";
import { canLeaveEditPage, NewTaskComponent } from "../tasks/new-task/new-task.component";

export const routes: Routes = [
    {
      path: '',
      redirectTo: "tasks",
      pathMatch: "full"
    },
    {
      path: "tasks",
      component: TasksComponent,
      runGuardsAndResolvers: "always",
      resolve: {
        userTasks: userTasksResolver
      }
    },
    {
      path: "tasks/add",
      component: NewTaskComponent,
      canDeactivate: [canLeaveEditPage]
    }
  ]