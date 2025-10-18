import { HttpClient } from "@angular/common/http"
import { PostService } from "./post";
import { of } from "rxjs";
import { fakeAsync, TestBed, tick } from "@angular/core/testing";

describe('Post Service', () => {
    let httpClientSpy: jasmine.SpyObj<HttpClient>;
    let postService: PostService;
    let posts = [
        {
          userId: 1,
          id: 1,
          title: 'Title 1',
          body: 'Body 1',
        },
        {
          userId: 1,
          id: 2,
          title: 'Title 2',
          body: 'Body 2',
        },
        {
          userId: 1,
          id: 3,
          title: 'Title 3',
          body: 'Body 3',
        },
      ];

    beforeEach(() => {
        httpClientSpy = jasmine.createSpyObj('HttpClient', ['get']);
        TestBed.configureTestingModule({
          providers: [
            PostService,
            {
              provide: HttpClient,
              useValue: httpClientSpy
            }
          ]
        })
        postService = TestBed.inject(PostService);
    })

    it('should fetch the posts when get method is called', fakeAsync((done: DoneFn) => {
        httpClientSpy.get.and.returnValue(of(posts));
        postService.getPosts().subscribe({
            next: (postsData) => {
                setTimeout(() => {
                  expect(postsData).toEqual(posts);
                  // done();
                },10000);
                tick(10000);
            }
        })
        expect(httpClientSpy.get).toHaveBeenCalledTimes(1);
    }))
    
})