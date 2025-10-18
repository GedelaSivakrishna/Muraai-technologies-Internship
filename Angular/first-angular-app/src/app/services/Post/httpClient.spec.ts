import { HttpClient, provideHttpClient } from '@angular/common/http';
import { HttpTestingController, provideHttpClientTesting } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';

describe('HttpClient Service', () => {
  let httpClient: HttpClient;
  let httpTestingController: HttpTestingController;
  let url = "https://dummyjson.com/products";

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        provideHttpClient(),
        provideHttpClientTesting()],
    });
    httpClient = TestBed.inject(HttpClient);
    httpTestingController = TestBed.inject(HttpTestingController);

  });

  it('should make a get request', () => {
    const mockData = {
        name: "Siva"
    }
    httpClient.get(url).subscribe((data) => {
        expect(data).toEqual(mockData);
    });
    const httpRequest = httpTestingController.expectOne(url);
    // setting the response to fake api call
    httpRequest.flush(mockData);
    expect(httpRequest.request.method).toEqual('GET');
  });

  it('should test multiple requests', () => {
    const testData = [{name: "siva"}, {name: "krishna"}, {name: "Gedela Sivakrishna"}];
    
    httpClient.get(url).subscribe(data => {
        expect(data).toEqual([]);
    });

    httpClient.get(url).subscribe(data => {
        expect(data).toEqual([testData[0]]);
    });

    httpClient.get(url).subscribe(data => {
        expect(data).toEqual(testData);
    });

    let requests = httpTestingController.match(url);
    expect(requests.length).toBe(3);

    requests[0].flush([]);
    requests[1].flush([testData[0]]);
    requests[2].flush(testData);

  })


});
