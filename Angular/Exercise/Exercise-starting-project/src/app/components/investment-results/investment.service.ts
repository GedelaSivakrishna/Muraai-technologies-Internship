import { Injectable, signal } from "@angular/core";
import { InvestmentResult } from "./investmentResult.model";

@Injectable({
    providedIn: "root"
})
export class InvestmentService {

    storedData = localStorage.getItem("investmentResults");
    data: InvestmentResult[] = (this.storedData !== null && this.storedData !== undefined) ? JSON.parse(this.storedData) : [];
    annualData = signal<InvestmentResult[]>(this.data);
     
    calculateInvestmentResults(initialInvestment: number, duration: number, annualInvestment: number, expectedReturn: number) {
        let investmentValue = initialInvestment;
      
        for (let i = 0; i < duration; i++) {
          const year = i + 1;
          const interestEarnedInYear = investmentValue * (expectedReturn / 100);
          investmentValue += interestEarnedInYear + annualInvestment;
          const totalInterest =
            investmentValue - annualInvestment * year - initialInvestment;
          this.annualData.update((prevValue) => [ ...prevValue ,{
            year: year,
            interest: interestEarnedInYear,
            valueEndOfYear: investmentValue,
            annualInvestment: annualInvestment,
            totalInterest: totalInterest,
            totalAmountInvested: initialInvestment + annualInvestment * year,
          }] );
          localStorage.setItem("investmentResults", JSON.stringify(this.annualData()));
        }
      
        return this.annualData();
      }

      getInvestmentResults() {
        return this.annualData();
      }

}