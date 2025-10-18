import { Injectable } from "@angular/core";
import { NewTaskData, Task } from "./task/task.model";

@Injectable({
  providedIn:"root"
})
export class TasksService {
  
    private dummyTasks: Task[] = [];

    constructor() {
      this.dummyTasks = JSON.parse(localStorage.getItem("tasks")!);
    }
     
    getUserTasks(userId: string) {
      return this.dummyTasks.filter((task) => task.userId === userId);
    }

    addTask(taskData: NewTaskData, userId: string) {
        this.dummyTasks.unshift({
            id: new Date().getTime().toString(),
            userId: userId,
            title: taskData.title,
            summary: taskData.summary,
            dueDate: taskData.date
          });
          localStorage.setItem("tasks", JSON.stringify(this.dummyTasks));
    }

    removeTask(id: string) {
        this.dummyTasks = this.dummyTasks.filter((task) => task.id !== id);
        localStorage.setItem("tasks", JSON.stringify(this.dummyTasks));
    }

}