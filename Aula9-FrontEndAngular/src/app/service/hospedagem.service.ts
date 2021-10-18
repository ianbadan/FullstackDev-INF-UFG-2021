import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { Hospedagem } from '../model/hospedagem.model';

@Injectable({
  providedIn: 'root'
})
export class HospedagemService {
  
  urlBase: string = "http://localhost:8080/hospedagens/"
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
  create(hospedagem: Hospedagem) : Observable<Hospedagem>{
    console.log(hospedagem);
    return this.http.post<Hospedagem>(this.urlBase, hospedagem);
  }

  //read
    //findAll
  findAll(): Observable<Hospedagem[]>{
    return this.http.get<Hospedagem[]>(this.urlBase);
  }
    //findById
  findById(id : string) : Observable<Hospedagem>{
    return this.http.get<Hospedagem>(this.urlBase + id);
  }
  //update
  update(hospedagem: Hospedagem) : Observable<Hospedagem>{
    return this.http.put<Hospedagem>(this.urlBase, hospedagem);
  }
  //delete
  delete(hospedagem: Hospedagem) : Observable<Hospedagem>{
    return this.http.delete<Hospedagem>(this.urlBase + hospedagem.idHospedagem);
  }

}
