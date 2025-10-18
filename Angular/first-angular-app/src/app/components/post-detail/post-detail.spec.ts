import { ComponentFixture, TestBed } from "@angular/core/testing"
import { PostDetailComponent } from "./post-detail"
import { ActivatedRoute } from "@angular/router";
import { PostService } from "../../services/Post/post";
import { of } from "rxjs";
import { By } from "@angular/platform-browser";

describe("PostDetail Component", () => {
  let fixture: ComponentFixture<PostDetailComponent>;
  let mockPostService: jasmine.SpyObj<PostService>;

  beforeEach(() => {
    let mockActivatedRoute = {
      snapshot: {
        paramMap: {
          get: (id: number) => {
            return "3";
          }
        }
      }
    };
    mockPostService = jasmine.createSpyObj(['getPost', 'updatePost']);
    let mockLocation = jasmine.createSpyObj(['goBack']);

    TestBed.configureTestingModule({
      imports: [PostDetailComponent],
      providers: [
        {
          provide: ActivatedRoute,
          useValue: mockActivatedRoute
        },
        {
          provide: PostService,
          useValue: mockPostService
        },
        {
          provide: Location,
          useValue: mockLocation
        }
      ]
    });

    fixture = TestBed.createComponent(PostDetailComponent);

  });

  it('should display the title in post detail template', () => {
    const mockData = {
      id: 1,
      userId: 1,
      body: "Body",
      title: "Title"
    };
    mockPostService.getPost.and.returnValue(of(mockData));
    fixture.detectChanges();
    const para = fixture.debugElement.query(By.css('p')).nativeElement;
    expect(para.textContent).toEqual(fixture.componentInstance.post.title);
  })

})