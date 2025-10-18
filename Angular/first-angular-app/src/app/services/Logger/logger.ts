import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoggerService {

  messages: string[] = [];
  
  log(message: string) {
    console.log("Log method called");
    this.messages.push(message);
  }

  clear() {
    this.messages = [];
  }

}
