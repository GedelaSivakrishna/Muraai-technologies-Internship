import { Component, inject, input, computed, Input } from '@angular/core';
import { UsersService } from '../users.service';
import { RouterLink, RouterOutlet } from "@angular/router";

@Component({
  selector: 'app-user-tasks',
  standalone: true,
  templateUrl: './user-tasks.component.html',
  styleUrl: './user-tasks.component.css',
  imports: [RouterOutlet, RouterLink],
})
export class UserTasksComponent {
  // extracting the userId from url
  // way-1 -> Using signals
  // userId = input.required<string>();
  // way-2 -> using Input Decorator
  private _userId?: string;
  username?: string;

  // extract the username by using the geting users through service and 
  // filter them using id
 private userService = inject(UsersService);

  @Input({required: true})
  set userId(id: string) {
    this._userId = id;
    this.username = this.userService.users.find(user => user.id === this._userId)?.name;
  }
  
}
