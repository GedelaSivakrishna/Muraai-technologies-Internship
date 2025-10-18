

describe('First Test ', () => {
    let variable: any;

    beforeEach(() => {
        variable = {};
    })

    it('a should be true', () => {
        // arrange - initialization phase
        variable.a = false;

        // act - logical processing
        variable.a = true;

        // assert
        expect(variable.a).toBe(true);
    })
    
})