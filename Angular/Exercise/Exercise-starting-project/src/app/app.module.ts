import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { InvestmentResultsComponent } from './components/investment-results/investment-results.component';
import { BrowserModule } from '@angular/platform-browser';
import { UserInputModule } from './components/user-input/userInput.module';

@NgModule({
  declarations: [
    AppComponent,
    InvestmentResultsComponent,
    HeaderComponent,
  ],
  bootstrap: [AppComponent],
  imports: [BrowserModule, UserInputModule],
})
export class AppModule {}
