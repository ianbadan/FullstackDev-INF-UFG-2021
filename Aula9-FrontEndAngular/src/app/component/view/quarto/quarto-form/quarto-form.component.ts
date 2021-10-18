import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Quarto } from 'src/app/model/quarto.model';
import { Hotel } from 'src/app/model/hotel.model';
import { HotelService } from 'src/app/service/hotel.service';
import { QuartoService } from 'src/app/service/quarto.service';
import { CategoriaQuarto } from 'src/app/enum/categoriaQuarto.enum';

@Component({
  selector: 'app-quarto-form',
  templateUrl: './quarto-form.component.html',
  styleUrls: ['./quarto-form.component.css']
})
export class QuartoFormComponent implements OnInit {
  titulo: string = "Cadastro de um novo quarto";

  quarto: Quarto = {
    hotel: <Hotel>{},
    categoriaQuarto: CategoriaQuarto.PADRAO,
    qtdLeito: 0,
    nrQuarto: 0,
    prDiaria: 0
  };

  public categorias = Object.values(CategoriaQuarto);
  public hoteis : Hotel[] = [];
  

  constructor(
    private quartoService: QuartoService,
    private hotelService: HotelService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.hotelService.findAll().subscribe(hoteis => {
      this.hoteis = hoteis;
    })
  }

  salvar(): void{
      this.quartoService.create(this.quarto).subscribe( () =>{
      this.quartoService.showMessage("Quarto cadastrado com sucesso!");
      this.router.navigate(['/quartos']);
    });
  }

}
