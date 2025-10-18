import { NgFor } from '@angular/common';
import { Component, signal, computed, effect, Input } from '@angular/core';
// import { _ } from "lodash"

@Component({
  selector: 'app-signals',
  templateUrl: './signals.component.html',
  standalone: true,
  imports: [NgFor],
})
export class SignalsComponent {
  actions = signal<string[]>([]);
  counter = signal(0);
  doubleCounter = computed(() => this.counter() * 2);
  // private loggingEffect = effect(() => {
  //   console.log(`The count is: ${this.counter()}`);
  // });
  menuOptions = signal(["pizza", "biriyani", "ice cream"]);
  selectedOption = signal(this.menuOptions()[0]);
  // name = "siva";
  // @Input({ required: true}) roll?: number;
  // showCount = signal(false);
  // count = signal(0);
  // conditionalCount = computed(() => {
  //   if(this.showCount()) {
  //     return `The current counter val: ${this.counter()}`;
  //   } else {
  //     return `Nothing to show!`;
  //   }
  // }) 
  
  constructor() {
    // console.log("constructor counter val: ", this.counter());
    // console.log("constructor name val: ", this.name);
    // console.log("constructor roll val: ", this.roll);
    // effect(() => {
    //   console.log("Current value: ",this.counter());
    // });
    // console.log(this.conditionalCount());
    // this.counter.set(1);
    // console.log(this.conditionalCount());
    // this.showCount.set(true);
    // console.log(this.conditionalCount());
    // this.counter.set(2);
    // console.log(this.conditionalCount());
    // this.showCount.set(false);
    // console.log(this.conditionalCount());
    // this.counter.set(3);
    // console.log(this.conditionalCount());
    console.log(this.selectedOption());
    this.menuOptions.set(["samosa", "pizza", "biriyani", "ice cream"]);
    console.log(this.selectedOption());
  }

  // ngOnInit() {
  //   console.log("ngOnInit roll val: ", this.roll);
  // }

  increment() {
    // this.counter.update(oldValue => oldValue);
    this.counter.update(oldValue => oldValue + 1);
    // this.actions.update((oldActions) => [...oldActions]);
    this.actions.update((oldActions) => [...oldActions, 'INCREMENT']);
  }

  decrement() {
    this.counter.update(oldValue => oldValue - 1);
    this.actions.update((oldActions) => [...oldActions, 'DECREMENT']);
  }
}
