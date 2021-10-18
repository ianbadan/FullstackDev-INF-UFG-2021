import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { Hospede } from '../model/hospede.model';

@Injectable({
  providedIn: 'root'
})
export class HospedeService {
  urlBase: string = "http://localhost:8080/hospedes/"
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
  create(hospede: Hospede) : Observable<Hospede>{
    console.log(hospede);
    return this.http.post<Hospede>(this.urlBase, hospede);
  }

  //read
    //findAll
  findAll(): Observable<Hospede[]>{
    return this.http.get<Hospede[]>(this.urlBase);
  }
    //findById
  findById(id : string) : Observable<Hospede>{
    return this.http.get<Hospede>(this.urlBase + id);
  }
  //update
  update(hospede: Hospede) : Observable<Hospede>{
    return this.http.put<Hospede>(this.urlBase, hospede);
  }
  //delete
  delete(hospede: Hospede) : Observable<Hospede>{
    return this.http.delete<Hospede>(this.urlBase + hospede.idHospede);
  }

}
