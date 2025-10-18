import { Component, DestroyRef, effect, inject, OnDestroy, OnInit, signal } from '@angular/core';

@Component({
  selector: 'app-server',
  standalone: true,
  imports: [],
  templateUrl: './server.component.html',
  styleUrl: './server.component.css'
})
export class ServerComponent implements OnInit {
  currentStatus = signal<'online' | 'offline' | 'unknown'>('online');
  // intervalId!: ReturnType<typeof setInterval>;
  private destroyRef = inject(DestroyRef);

  constructor() {
    // executes evrytime the used signal in the effect callback changes
      // effect((onCleanup) => {
      //     let status = this.currentStatus();
      //     const intervalId = setInterval(() => {
      //       console.log("Current status = ", status);
      //     }, 1000);

      //     onCleanup(() => {
      //       console.log("Clearing the timeout");
      //       clearInterval(intervalId);
      //     });
      // });  
  }

  // Runs once after all the input properties are initiallized. Any data fetching logic should
  // be written in ngOnInit(). Keep the constructor clean.
  ngOnInit() {
   const intervalId =  setInterval(()=>{
      const rndm = Math.random();

      if(rndm < 0.5) {
        this.currentStatus.set('online');
      }
      else if (rndm < 0.9) {
        this.currentStatus.set('offline');
      }
      else {
        this.currentStatus.set('unknown');
      }
    }, 5000);

    this.destroyRef.onDestroy(() => {
      clearInterval(intervalId);
    })
  }

  // ngOnDestroy() {
  //   clearInterval(this.intervalId);
  // }

}
