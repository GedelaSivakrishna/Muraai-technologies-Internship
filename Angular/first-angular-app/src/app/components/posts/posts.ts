import { Component, OnInit } from '@angular/core';
import { Post } from '../../model/Post';
import { PostService } from '../../services/Post/post';
import { CommonModule } from "@angular/common";
import { PostComponent } from "../post/post";

@Component({
  selector: 'app-posts',
  imports: [CommonModule, PostComponent],
  templateUrl: './posts.html',
  styleUrl: './posts.css',
})
export class PostsComponent implements OnInit {

  constructor(private postService: PostService) {}

  posts: Post[] = [];

  ngOnInit(): void {
   this.getPosts();
  };

  getPosts() {
    this.postService.getPosts().subscribe((posts) => {
      this.posts = posts;
    })
  }

  deletePost(post: Post) {
    this.posts = this.posts.filter(p => p.id !== post.id);
    this.postService.deletePost(post).subscribe();
  }

}
