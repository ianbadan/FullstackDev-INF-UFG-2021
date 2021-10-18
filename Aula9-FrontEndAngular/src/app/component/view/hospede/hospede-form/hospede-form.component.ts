import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Hospede } from 'src/app/model/hospede.model';
import { HospedeService } from 'src/app/service/hospede.service';
import { NgxMaskModule } from 'ngx-mask';

@Component({
  selector: 'app-hospede-form',
  templateUrl: './hospede-form.component.html',
  styleUrls: ['./hospede-form.component.css']
})
export class HospedeFormComponent implements OnInit {

  titulo: string = "Cadastro de um novo hospede";

  hospede: Hospede = {
    nomeHospede : "",
    dtNascimento: new Date,
    cpf : ""
  };
  

  constructor(
    private service: HospedeService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  salvar(): void{
    this.service.create(this.hospede).subscribe(() =>{
      this.service.showMessage("Hospede cadastrado com sucesso!");
      this.router.navigate(['/hospedes']);
    })
  }
}
