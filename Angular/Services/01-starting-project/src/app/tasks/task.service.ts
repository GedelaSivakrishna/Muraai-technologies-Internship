import { Injectable, signal } from '@angular/core';
import { Task, TaskStatus } from './task.model';

// @Injectable({
//   providedIn: 'root',
// })
export class TaskService {
  private tasks = signal<Task[]>([]);

  allTasks = this.tasks.asReadonly();

  //  getTasks() {
  //   const storedTasks = localStorage.getItem("tasks");
  //   // if(storedTasks) {
  //   //   this.tasks.set(JSON.parse(storedTasks));
  //   // }
  //   return this.tasks.asReadonly();
  //  }

  addTask(taskData: { title: string; description: string }) {
    const newTask: Task = {
      id: new Date().getTime().toString(),
      ...taskData,
      status: 'OPEN',
    };
    this.tasks.update((prev) => [...prev, newTask]);
    // localStorage.setItem("tasks", JSON.stringify(this.tasks()));
  }

  //  getFilteredTasks(filter: string) {
  //   return signal(this.tasks().filter((task) => task.status === filter)).asReadonly();
  //  }

  updateTaskStatus(taskId: string, newStatus: TaskStatus) {
    this.tasks.update((prevTasks) => prevTasks.map((task) => 
        task.id === taskId ? {...task, status: newStatus} : task));
    // localStorage.setItem("tasks", JSON.stringify(this.tasks()));
  }
}
