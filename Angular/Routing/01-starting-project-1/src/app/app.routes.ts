import { Routes } from "@angular/router";
import { TasksComponent } from "./tasks/tasks.component";
import { NoTaskComponent } from "./tasks/no-task/no-task.component";
import { UserTasksComponent } from "./users/user-tasks/user-tasks.component";
import { LoginComponent } from "./login/login.component";
import { AuthGuardService } from "./services/guards/auth-guard.service";
import { NewTaskComponent } from "./tasks/new-task/new-task.component";

export const routes: Routes = [
    {
        path: "",
        component: NoTaskComponent
    }
    ,
    {
        // canActivate: [AuthGuardService],
        path: "users/:userId",
        component: UserTasksComponent,
        children: [
            {
                path: "tasks",
                component: TasksComponent
            },
            {
                path: "tasks/new",
                component: NewTaskComponent
            }
        ]
    },
    {
        path: "login",
        component: LoginComponent
    }
];