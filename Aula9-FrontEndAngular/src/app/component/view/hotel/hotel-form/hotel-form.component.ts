import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Hotel } from 'src/app/model/hotel.model';
import { HotelService } from 'src/app/service/hotel.service';

@Component({
  selector: 'app-hotel-form',
  templateUrl: './hotel-form.component.html',
  styleUrls: ['./hotel-form.component.css']
})
export class HotelFormComponent implements OnInit {

  titulo: string = "Cadastro de um novo hotel";
  
  hotel: Hotel = {
    nmHotel: "",
    enderecoHotel: "",
    qtdEstrelas: 0
  }
  constructor(
    private service: HotelService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  salvar(): void{
    this.service.create(this.hotel).subscribe(() => {
        this.service.showMessage("Hotel Cadastrado com sucesso!");
        this.router.navigate(['/hoteis']);
    })
  }

}
