import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Hotel } from 'src/app/model/hotel.model';
import { HotelService } from 'src/app/service/hotel.service';

@Component({
  selector: 'app-hotel-update',
  templateUrl: './../hotel-form/hotel-form.component.html',
  styleUrls: ['./../hotel-form/hotel-form.component.css']
})
export class HotelUpdateComponent implements OnInit {

  titulo: string = "Alterar dados do Hotel"
  
  hotel: Hotel = {
    nmHotel: "",
    enderecoHotel: "",
    qtdEstrelas: 0
  }

  constructor(
    private route: ActivatedRoute,
    private service: HotelService,
    private router: Router
  ) { }


  ngOnInit(): void {
    let id = this.route.snapshot.paramMap.get('id');
    if(id != null){
        this.service.findbyId(id).subscribe(hotel =>{
            this.hotel=hotel;
        })
    }
  }

  salvar(): void{
    this.service.update(this.hotel).subscribe(() => {
        this.service.showMessage("Hotel atualizado com sucesso!")
        this.router.navigate(['/hoteis'])
    })
  }

}
