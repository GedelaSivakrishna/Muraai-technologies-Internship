import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Post } from '../../model/Post';
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-post',
  imports: [ RouterLink ],
  templateUrl: './post.html',
  styleUrl: './post.css'
})
export class PostComponent {
    @Input({ required: true}) post!: Post;
    @Output() delete = new EventEmitter();

    OnDelete(event: Event) {
      event.stopPropagation();
      this.delete.emit(this.post);
    }

}
