import { Component, inject, signal } from '@angular/core';
import { InvestmentService } from '../investment-results/investment.service';

@Component({
  selector: 'app-user-input',
  templateUrl: './user-input.component.html',
  styleUrl: './user-input.component.css'
})
export class UserInputComponent {
  initialInvestment = signal('');
  annualInvestment = signal('');
  expectedReturn = signal('');
  duration = signal('');
  private investmentService = inject(InvestmentService);

  onSubmit(event: Event) {
    event.preventDefault();
    console.log(this.initialInvestment);
    console.log(this.annualInvestment);
    console.log(this.expectedReturn);
    console.log(this.duration);
    this.investmentService.calculateInvestmentResults(
      +this.initialInvestment(),
      +this.duration(),
      +this.annualInvestment(),
      +this.expectedReturn(),
    )
    this.initialInvestment.set('');
    this.annualInvestment.set('');
    this.expectedReturn.set('');
    this.duration.set('');
  }

}
