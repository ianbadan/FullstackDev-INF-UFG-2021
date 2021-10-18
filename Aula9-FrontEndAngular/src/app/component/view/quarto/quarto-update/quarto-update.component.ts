import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoriaQuarto } from 'src/app/enum/categoriaQuarto.enum';
import { Hotel } from 'src/app/model/hotel.model';
import { Quarto } from 'src/app/model/quarto.model';
import { HotelService } from 'src/app/service/hotel.service';
import { QuartoService } from 'src/app/service/quarto.service';

@Component({
  selector: 'app-quarto-update',
  templateUrl: './../quarto-form/quarto-form.component.html',
  styleUrls: ['./../quarto-form/quarto-form.component.css']
})
export class QuartoUpdateComponent implements OnInit {

  titulo: string= "Alterar dados do Hotel"

  quarto: Quarto = {
    hotel: <Hotel>{},
    categoriaQuarto: CategoriaQuarto.PADRAO,
    qtdLeito: 0,
    nrQuarto: 0,
    prDiaria: 0
  }

  constructor(
    private route: ActivatedRoute,
    private service: QuartoService,
    private router: Router,
    private hotelService: HotelService
  ) { }

  public categorias = Object.values(CategoriaQuarto);
  public hoteis : Hotel[] = [];

  ngOnInit(): void {
    this.hotelService.findAll().subscribe(hoteis => {
      this.hoteis = hoteis;
    })

    let id = this.route.snapshot.paramMap.get('id');
    if(id != null){
      this.service.findById(id).subscribe(quarto => {
        this.quarto = quarto;
        console.log(this.quarto);
      })
    }
  }

  salvar(): void{
    console.log(this.quarto);
    this.service.update(this.quarto).subscribe(() => {
      this.service.showMessage("Quarto atualizado com sucesso");
      this.router.navigate(['/quartos']);
    })
  }
}
