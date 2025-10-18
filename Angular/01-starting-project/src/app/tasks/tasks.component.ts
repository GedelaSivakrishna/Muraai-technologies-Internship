import { Component, Input, OnChanges, OnInit } from '@angular/core';
import { AddTaskComponent } from './add-task/add-task.component';
import { TaskComponent } from './task/task.component';
import { NewTaskData } from './task/task.model';
import { TasksService } from './tasks.service';

@Component({
  selector: 'app-tasks',
  // standalone: true,
  // imports: [TaskComponent, AddTaskComponent],
  templateUrl: './tasks.component.html',
  styleUrl: './tasks.component.css',
})
export class TasksComponent implements OnInit {
  // Here the '?' mark says the name can be either a string or undefined
  @Input() userId!: string;
  @Input() name?: string;

  constructor(private tasksService: TasksService) {}

  ngOnInit() {
    console.log(this.selectedUserTasks);
  }
  
  addTaskFlag = false;

  get selectedUserTasks() {
    return this.tasksService.getUserTasks(this.userId);
  }

  onAddTask() {
    this.addTaskFlag = true;
  }

  onCloseAddTask() {
    this.addTaskFlag = false;
  }

}
