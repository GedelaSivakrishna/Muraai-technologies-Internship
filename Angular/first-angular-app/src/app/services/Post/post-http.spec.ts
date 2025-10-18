import { HttpClient, provideHttpClient } from "@angular/common/http"
import { HttpTestingController, provideHttpClientTesting } from "@angular/common/http/testing";
import { TestBed } from "@angular/core/testing";
import { PostService } from "./post";

describe('Post-Http Service', () => {
    let httpClient: HttpClient;
    let httpTestingController: HttpTestingController;
    let url = "https://jsonplaceholder.typicode.com/posts";
    let postService: PostService;
    const posts = [
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
        TestBed.configureTestingModule({
            providers: [
                PostService,
                provideHttpClient(),
                provideHttpClientTesting()
            ]
        });

        httpTestingController = TestBed.inject(HttpTestingController);
        postService = TestBed.inject(PostService);
    })

    afterEach(()=>{
        httpTestingController.verify();
    })

    it('should fetch the posts from the url ', (done: DoneFn) => {
        postService.getPosts().subscribe(data => {
            expect(data).toEqual(posts);
            done();
        });
        // postService.getPost(1).subscribe();
        const request = httpTestingController.expectOne(url);
        request.flush(posts);
        expect(request.request.method).toBe("GET");

        // httpTestingController.verify();
    });

    it('should fetch the single post with the given id', () => {
        postService.getPost(1).subscribe();
        // postService.getPost(2).subscribe();
        const httpRequest = httpTestingController.expectOne("https://jsonplaceholder.typicode.com/posts/1");
        expect(httpRequest.request.method).toBe("GET");
    })

})