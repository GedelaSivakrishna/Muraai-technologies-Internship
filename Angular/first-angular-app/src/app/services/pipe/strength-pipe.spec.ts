import { StrengthPipe } from './strength-pipe';

describe('StrengthPipe', () => {

  it('create an instance', () => {
    const pipe = new StrengthPipe();
    expect(pipe).toBeTruthy();
  });

  it('should return weak if 5 is passed', () => {
    let strengthPipe = new StrengthPipe();
    expect(strengthPipe.transform(5)).toEqual('5 (weak)');
  })

  it('should return strong if 10 is passed', () => {
    let strengthPipe = new StrengthPipe();
    expect(strengthPipe.transform(10)).toEqual('10 (strong)');
  })
  it('should return strongest if 20 is passed', () => {
    let strengthPipe = new StrengthPipe();
    expect(strengthPipe.transform(20)).toEqual('20 (strongest)');
  })


});
