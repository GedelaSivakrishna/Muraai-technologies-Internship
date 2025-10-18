import { Component, DestroyRef, effect, inject, OnInit, signal } from '@angular/core';
import { toObservable, toSignal } from '@angular/core/rxjs-interop';
import { interval, map, Observable } from "rxjs";

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html'
})
export class AppComponent implements OnInit {

  count = signal(0);
  interval$ = interval(1000);
  // signals created using toSignal() has undefined as initial value, we can manually set it to 
  // value of our choice
  // observables don't have initial value
  intervalSignal = toSignal(this.interval$, { initialValue: 0 });
  customInterval$ = new Observable((subscriber) => {
    let timesExecuted = 0;
    const interval = setInterval(()=>{
      if(timesExecuted > 3) {
        clearInterval(interval);
        subscriber.complete();
        return;
      }
      subscriber.next({ message: "New Message"});
      ++timesExecuted;
    }, 2000);
  });
  private destroyRef = inject(DestroyRef);

  constructor() {
    // effect( () => {
    //   console.log(`Clicked ${this.count()} times.`);
    // } );
  }

  ngOnInit() {
    // const subscription = interval(1000).pipe(
    //   map(val => val * 2)
    // ).subscribe((val) => {
    //   console.log(val);
    // });

    // this.destroyRef.onDestroy(() => {
    //   subscription.unsubscribe();
    // })

    // toObservable(this.count).subscribe((val) => console.log(`Clicked ${val} times.`));
    
    this.customInterval$.subscribe({
      next: (val) => console.log(val),
      complete: () => console.log("Completed!")
    });
  }

  onClick() {
    this.count.update(prevVal => prevVal + 1);
  }
  
}
