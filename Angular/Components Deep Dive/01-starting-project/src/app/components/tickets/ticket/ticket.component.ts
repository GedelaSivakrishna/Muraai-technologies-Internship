import { Component, input, output, signal } from '@angular/core';
import { Ticket } from '../ticket.model';

@Component({
  selector: 'app-ticket',
  standalone: true,
  imports: [],
  templateUrl: './ticket.component.html',
  styleUrl: './ticket.component.css'
})
export class TicketComponent {
  ticket = input.required<Ticket>();
  open = signal(false);
  close = output<string>();

  onToggle() {
    this.open.update((wasVisible) => !wasVisible);
  }

  onMarkAsCompleted() {
    this.close.emit(this.ticket().id)
    // this.onToggle();
  }

}
