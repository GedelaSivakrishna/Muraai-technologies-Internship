import { Routes } from '@angular/router';
import { PostsComponent } from './components/posts/posts';
import { PostDetailComponent } from './components/post-detail/post-detail';

export const routes: Routes = [
    {
        path: "posts",
        component: PostsComponent
    },
    {
        path: "detail/:id", // id is route parameter
        component: PostDetailComponent
    }
];
