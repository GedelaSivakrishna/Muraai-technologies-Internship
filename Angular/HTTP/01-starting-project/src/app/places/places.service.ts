import { inject, Injectable, signal } from '@angular/core';

import { Place } from './place.model';
import { HttpClient } from '@angular/common/http';
import { catchError, map, tap, throwError } from 'rxjs';
import { ErrorService } from '../../shared/error.service';

@Injectable({
  providedIn: 'root',
})
export class PlacesService {
  private errorService = inject(ErrorService);
  private userPlaces = signal<Place[]>([]);
  private httpClient = inject(HttpClient);

  loadedUserPlaces = this.userPlaces.asReadonly();

  loadAvailablePlaces() {
    return this.fetchPlaces(
      "http://localhost:3000/places",
      "Something went wrong while fetching the places. Try again later"
    )
  }

  loadUserPlaces() {
    return this.fetchPlaces(
      "http://localhost:3000/user-places",
      "Something went wrong while fetching your favourite places. Try again later"
    ).pipe(
      tap({
        next: (places) => this.userPlaces.set(places)
      })
    );
  }

  addPlaceToUserPlaces(place: Place) {
    // optimistic updating
    const prevPlaces = this.userPlaces();
    if(!prevPlaces.some((p) => p.id === place.id)) {
      this.userPlaces.set([...prevPlaces, place]);
    }

    return this.httpClient.put<{userPlaces: Place[]}>("http://localhost:3000/user-places", {
      placeId: place.id
    }).pipe(
      catchError((error) => {
        this.errorService.showError("Error while adding the place to favourite items");
        this.userPlaces.set(prevPlaces);
        return throwError(() => 
        new Error("Error while adding the place to favourite items"))
      })
    );
  }

  removeUserPlace(place: Place) {
    const prevPlaces = this.userPlaces();
    if(prevPlaces.some((p) => p.id === place.id)) {
      this.userPlaces.update(favourites => favourites.filter((p) => p.id !== place.id))
    }
   return this.httpClient.delete<{ userPlaces: Place[]}>(`http://localhost:3000/user-places/${place.id}`)
      .pipe(
        catchError(() => {
          this.errorService.showError("Error while removing place from favourites");
          this.userPlaces.set(prevPlaces);
          return throwError(() => 
            new Error("Error while removing place from favourites"))
        }
      ));
  }

  private fetchPlaces(url: string, errorMessage: string) {
    return this.httpClient.get<{places: Place[]}>(url)
    .pipe(
      map((resData) => resData.places),
      catchError((error) => {
        console.log(error);
        return throwError(() => 
          new Error(
            errorMessage
          )
        )
      })
    );
  }

}
