import { Component, computed, inject } from '@angular/core';
import { InvestmentResult } from './investmentResult.model';
import { InvestmentService } from './investment.service';
import { CurrencyPipe } from '@angular/common';

@Component({
  selector: 'app-investment-results',
  // standalone: true,
  // imports: [CurrencyPipe],
  templateUrl: './investment-results.component.html',
  styleUrl: './investment-results.component.css'
})
export class InvestmentResultsComponent {
  private investmentService = inject(InvestmentService);
  annualData = computed(() => this.investmentService.getInvestmentResults());
}
