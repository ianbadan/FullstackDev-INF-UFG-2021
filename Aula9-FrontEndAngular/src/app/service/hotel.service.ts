import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { Hotel } from '../model/hotel.model';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  urlBase: string = "http://localhost:8080/hoteis/"
  constructor(
    private http: HttpClient,
    private snackBar: MatSnackBar
  ) { }

  showMessage(msg: string, isError: boolean = false): void {
    this.snackBar.open(msg, "Fechar",
    {
      verticalPosition:'top',
      horizontalPosition: 'right',
      duration: 3000,
      panelClass: isError ? ['msg-error'] : ['msg-success']
    }
    )

  }

  //create
  create(hotel: Hotel) : Observable<Hotel>{
    console.log(hotel);
    return this.http.post<Hotel>(this.urlBase, hotel);
  }

  //read
    //findAll
  findAll() : Observable<Hotel[]> {
    return this.http.get<Hotel[]>(this.urlBase);
  } 
    //findById
  findbyId(id : string) : Observable<Hotel>{
    return this.http.get<Hotel>(this.urlBase + id);
  }

  //update
  update(hotel: Hotel) : Observable<Hotel>{
    return this.http.put<Hotel>(this.urlBase, hotel);
  }
  //delete
  delete(hotel: Hotel): Observable<Hotel>{
    return this.http.delete<Hotel>(this.urlBase + hotel.idHotel);
  }
}
