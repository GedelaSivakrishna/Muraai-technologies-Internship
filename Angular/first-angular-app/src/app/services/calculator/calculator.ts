import { inject, Injectable } from '@angular/core';
import { LoggerService } from '../Logger/logger';

@Injectable({
  providedIn: 'root'
})
export class CalculatorService {

  constructor(private logger: LoggerService) {}

  add(a: number, b: number) {
    this.logger.log("Addition method called");
    return a + b;
  }
  
  substract(a: number, b: number) {
    this.logger.log("Substraction method called");
    return a - b;
  }

}
