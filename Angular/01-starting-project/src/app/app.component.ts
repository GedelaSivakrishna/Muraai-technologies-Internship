import { Component, signal } from '@angular/core';
import { HeaderComponent } from './header/header';
import { UserComponent } from "./user/user.component";
import { DUMMY_USERS } from './dummy-users';
import { TasksComponent } from './tasks/tasks.component';
import { NgFor, NgIf } from "@angular/common"

type User = {
      id: string;
      avatar: string;
      name: string;
    };

@Component({
  selector: 'app-root',
  // standalone: true,
  // imports: [HeaderComponent, UserComponent, TasksComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  users = DUMMY_USERS;
  selectedUser?: User;
  // menuOptions = 
  onSelectUser(id: string) {
    this.selectedUser = this.users.find(user => user.id === id);
  }

}
