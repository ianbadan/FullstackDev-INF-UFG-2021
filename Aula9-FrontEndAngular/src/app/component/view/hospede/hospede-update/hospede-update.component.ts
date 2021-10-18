import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Hospede } from 'src/app/model/hospede.model';
import { HospedeService } from 'src/app/service/hospede.service';
import { HotelService } from 'src/app/service/hotel.service';

@Component({
  selector: 'app-hospede-update',
  templateUrl: './../hospede-form/hospede-form.component.html',
  styleUrls: ['./../hospede-form/hospede-form.component.css']
})
export class HospedeUpdateComponent implements OnInit {

  titulo: string = "Alteraro dados do hospede";

  hospede: Hospede = <Hospede>{
    
  }
  constructor(
    private route: ActivatedRoute,
    private service: HospedeService,
    private router: Router
  ) { }

  ngOnInit(): void {
    let id = this.route.snapshot.paramMap.get('id');
    if(id != null){
        this.service.findById(id).subscribe(hospede =>{
            this.hospede=hospede;
        })
    }
  }

  salvar(): void{
    this.service.update(this.hospede).subscribe(() => {
        this.service.showMessage("Hospede atualizado com sucesso!")
        this.router.navigate(['/hospedes'])
    })
  }

}
