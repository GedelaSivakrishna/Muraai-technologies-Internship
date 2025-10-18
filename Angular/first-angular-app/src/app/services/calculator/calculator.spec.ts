import { TestBed } from "@angular/core/testing";
import { LoggerService } from "../Logger/logger";
import { CalculatorService } from "./calculator"

function setUp() {
  const mockLoggerService = jasmine.createSpyObj('LoggerService', ['log']);
     TestBed.configureTestingModule({
      providers: [CalculatorService, {
        provide: LoggerService,
        useValue: mockLoggerService
      }]
     })
    const calculator = TestBed.inject(CalculatorService);
    const loggerServiceSpy = TestBed.inject(LoggerService);
    return {calculator, loggerServiceSpy};
}

describe("Calculator Service", () => {

  it('should add two numbers', () => {
    const {calculator, loggerServiceSpy} = setUp();
    expect(calculator.add(2,3)).toBe(5);
    expect(loggerServiceSpy.log).toHaveBeenCalledTimes(1);
  })

  it("should substract two numbers", () => {
    const {calculator, loggerServiceSpy} = setUp();
    expect(calculator.substract(10,8)).toBe(2);
    expect(loggerServiceSpy.log).toHaveBeenCalledTimes(1);
  })

})
