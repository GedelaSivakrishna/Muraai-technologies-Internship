import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Post } from '../../model/Post';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private httpClient: HttpClient) {}
  
  getPosts() {
    return this.httpClient.get<Post[]>('https://jsonplaceholder.typicode.com/posts');
  }
  
  getPost(postId: number) {
    return this.httpClient.get<Post>(`https://jsonplaceholder.typicode.com/posts/${postId}`);
  }

  deletePost(post: Post) {
   return this.httpClient.delete(`https://jsonplaceholder.typicode.com/posts/${post.id}`);
  }
  
  updatePost(post: Post) {
   return this.httpClient.put(`https://jsonplaceholder.typicode.com/posts/${post.id}`, post);
  }

}
