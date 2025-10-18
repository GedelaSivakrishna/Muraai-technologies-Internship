import { first } from "rxjs";
import { Post } from "../../model/Post";
import { PostComponent } from "./post"
import { ComponentFixture, TestBed } from "@angular/core/testing";
import { provideRouter } from "@angular/router";
import { routes } from "../../app.routes"
import { DebugElement } from "@angular/core";
import { By } from "@angular/platform-browser";

describe('Post Component', () => {

    let component: PostComponent;
    let fixture: ComponentFixture<PostComponent>;

    beforeEach(()=>{
        TestBed.configureTestingModule({
            imports: [PostComponent],
            providers: [
                provideRouter(routes)
            ]
        });
        fixture = TestBed.createComponent(PostComponent);
        component = fixture.componentInstance;
    })

    it('should create a component', () => { 
        expect(component).toBeDefined();
    })

    it('should emit an event when delete button is clicked', () => {
        const post: Post = {id: 1, userId: 1, body: "body 1", title: "title 1"};
        component.post = post;
        component.delete.pipe(first()).subscribe((selectedPost) => {
            expect(selectedPost).toEqual(post);
        })
        component.OnDelete(new MouseEvent("click"));
    })

    it('should find the paragraph', () => {
        const debugElement: DebugElement = fixture.debugElement;
        const paraDebugElement = debugElement.query(By.css('p'));
        const paragraph: HTMLElement = paraDebugElement.nativeElement;
        expect(paragraph.textContent).toEqual("I'm Para");
    })

    it('should render title in anchor tag', () => {
        const post: Post = {id: 1, userId: 1, body: "body 1", title: "title 1"};
        component.post = post;
        fixture.detectChanges();
        const postElement = fixture.nativeElement;
        const anchorElement = postElement.querySelector('a');
        expect(anchorElement.textContent).toEqual(post.title);
    })

    it('should render title in anchor tag using debug element', () => {
        const post: Post = {id: 1, userId: 1, body: "body 1", title: "title 1"};
        component.post = post;
        fixture.detectChanges();
        const postDebugElement = fixture.debugElement;
        const anchorElement: HTMLElement = postDebugElement.query(By.css('a')).nativeElement;
        expect(anchorElement.textContent).toEqual(post.title);
    })
    
})