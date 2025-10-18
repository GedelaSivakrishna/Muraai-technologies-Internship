import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-demo',
  imports: [],
  templateUrl: './demo.html',
  styleUrl: './demo.css'
})
export class Demo implements OnInit {

  @Input({ required: true}) name!: string;
  var = true;

  constructor() {
    console.log("In constructor: ", this.name, this.var);
   }

   ngOnInit() {
    console.log("In ngOnInit: ", this.name, this.var);
   }

}
