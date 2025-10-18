import { of } from 'rxjs';
import { Post } from '../../model/Post';
import { PostsComponent } from './posts';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { PostService } from '../../services/Post/post';
import { routes } from '../../app.routes';
import { provideRouter } from '@angular/router';
import { By } from '@angular/platform-browser';
import { PostComponent } from '../post/post';

describe('Posts Componenet', () => {
  let posts: Post[] = [];
  let postsComponent: PostsComponent;
  let mockPostService: any;
  let fixture: ComponentFixture<PostsComponent>;

  beforeEach(() => {
    posts = [
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

    mockPostService = jasmine.createSpyObj(['getPosts', 'deletePost']);

    TestBed.configureTestingModule({
      imports: [PostsComponent, PostComponent],
      providers: [
        {
          provide: PostService,
          useValue: mockPostService
        },
        provideRouter(routes)
      ]
    })

    fixture = TestBed.createComponent(PostsComponent);
    postsComponent = fixture.componentInstance;
    // postsComponent.posts = posts;
  });

  // describe("Delete: ", () => {

  //   beforeEach(()=>{
  //     mockPostService.deletePost.and.returnValue(of(true));
  //   })

  //   it('should delete the selected post', () => {
  //         postsComponent.deletePost(posts[1]);
  //         expect(postsComponent.posts.length).toBe(2);
  //   });
  
  //   it('should call the deletePost method in postService once', () => {
  //     postsComponent.deletePost(posts[1]);
  //     expect(mockPostService.deletePost).toHaveBeenCalledTimes(1);
  //   });
  
  //   it('should delete the post from the posts array', () => {
  //     postsComponent.deletePost(posts[0]);
      
  //     for(let post of postsComponent.posts) {
  //         expect(post.id).not.toEqual(1);
  //     }
  
  //   });

  // })

  describe('Get: ', () => {
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

    it('should get the posts & set it to components posts array', () => {
      mockPostService.getPosts.and.returnValue(of(posts));
      fixture.detectChanges();
      expect(postsComponent.posts.length).toBe(posts.length);
    })
  })

  it('should check if app-post template should is created 3 times', () => {
    mockPostService.getPosts.and.returnValue(of(posts));
    postsComponent.getPosts();
    // The below statement calls the ngOnInit() of the component
    fixture.detectChanges();
    let debugElement = fixture.debugElement;
    let postsElement = debugElement.queryAll(By.css('.post'));
    expect(postsElement.length).toBe(posts.length);
  })

  it('should create the child components as the length of posts length', () => {
    mockPostService.getPosts.and.returnValue(of(posts));
    postsComponent.getPosts();
    fixture.detectChanges();
    let debugElements = fixture.debugElement.queryAll(By.directive(PostComponent));
    expect(debugElements.length).toBe(posts.length);
  })

  it('should check if app-post component is receiving the post', () => {
    mockPostService.getPosts.and.returnValue(of(posts));
    postsComponent.getPosts();
    fixture.detectChanges();
    const postDebugElements = fixture.debugElement.queryAll(By.directive(PostComponent));
    for(let i = 0; i < postDebugElements.length; i++) {
      const postElement = postDebugElements[i].componentInstance;
      expect(postElement.post).toEqual(posts[i]);
    }
  })

  it('should trigger the delete method with post when delete button on child component is clicked', () => {
    spyOn(postsComponent, "deletePost");
    mockPostService.getPosts.and.returnValue(of(posts));
    // spyOn(postsComponent, "getPosts").and.returnValue(of(posts));
    fixture.detectChanges();
    const postComponentDEs = fixture.debugElement.queryAll(By.directive(PostComponent));
    for(let i = 0; i < postComponentDEs.length; i++) {
      const postComponentButton = postComponentDEs[i].query(By.css("button"));
      postComponentButton.triggerEventHandler("click", { preventDefault: () => {},
      stopPropagation: () => {}});
      expect(postsComponent.deletePost).toHaveBeenCalledWith(posts[i]);
    }
  })

  it('should trigger the delete method of PostComponent when delete event is emitted in PostComponent', () => {
    spyOn(postsComponent, "deletePost");
    mockPostService.getPosts.and.returnValue(of(posts));
    fixture.detectChanges();
    const postDEs = fixture.debugElement.queryAll(By.directive(PostComponent));
    for(let i = 0; i < postDEs.length; i++) {
      const postDE = postDEs[i];
      postDE.componentInstance.delete.emit(posts[i]);
      expect(postsComponent.deletePost).toHaveBeenCalledWith(posts[i]);
    }
  })

});
