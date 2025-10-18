import { TestBed } from "@angular/core/testing";
import { LoggerService } from "./logger"

describe('LoggerService', () => {

    let logger: LoggerService;

    beforeEach(()=>{
        TestBed.configureTestingModule({
            providers: [LoggerService]
        })
        logger = TestBed.inject(LoggerService);
    })

    it('should have an empty messages array', () => {
        expect(logger.messages.length).toBe(0);
    })

    it('should insert a message to the array', () => {
        logger.messages.push('message');
        expect(logger.messages.length).toBe(1);
    })

    it('should clear the messages', () => {
        logger.clear();
        expect(logger.messages.length).toBe(0);
    })
    
})