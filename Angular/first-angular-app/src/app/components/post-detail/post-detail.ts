import { Component, OnInit } from '@angular/core';
import { PostService } from '../../services/Post/post';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Post } from '../../model/Post';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-post-detail',
  imports: [FormsModule],
  templateUrl: './post-detail.html',
  styleUrl: './post-detail.css',
})
export class PostDetailComponent implements OnInit {

  post!: Post;

  constructor(
    private postService: PostService,
    private route: ActivatedRoute,
    private location: Location
  ) {}

  ngOnInit() {
    this.getPost();
  }

  getPost() {
    const id = this.route.snapshot.paramMap.get("id");
    id && this.postService.getPost(+id).subscribe((post) => this.post = post);
  }

  goBack() {
    this.location.back();
  }

  save() {
    this.postService.updatePost(this.post).subscribe(() => this.goBack());
  }

}
