import { Component, inject, OnInit, signal } from '@angular/core';

import { Place } from '../place.model';
import { PlacesComponent } from '../places.component';
import { PlacesContainerComponent } from '../places-container/places-container.component';
import { HttpClient } from '@angular/common/http';
import { catchError, map, throwError } from 'rxjs';
import { PlacesService } from '../places.service';

@Component({
  selector: 'app-available-places',
  standalone: true,
  templateUrl: './available-places.component.html',
  styleUrl: './available-places.component.css',
  imports: [PlacesComponent, PlacesContainerComponent],
})
export class AvailablePlacesComponent implements OnInit {
  places = signal<Place[] | undefined>(undefined);
  isFetching = signal(false);
  error = signal('');
  private placesService = inject(PlacesService);

  ngOnInit() {
    this.isFetching.set(true);
    this.placesService.loadAvailablePlaces()
      .subscribe({
        next: (places => {
          this.places.set(places);
        }),
        error: (error: Error) => {
          console.log("Inside observer error fn: ", error.message);
          this.error.set(error.message);
        },
        complete: () => {
          this.isFetching.set(false);
        }
      })
  }

  onSelectPlace(selectedPlace: Place) {
    this.placesService.addPlaceToUserPlaces(selectedPlace).subscribe({
      next: (resData) => console.log(resData)
    })
  }
  
}
