import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { ConfirmDeleteComponent } from 'src/app/component/template/confirm-delete/confirm-delete.component';
import { Hospede } from 'src/app/model/hospede.model';
import { HospedeService } from 'src/app/service/hospede.service';

@Component({
  selector: 'app-hospede-list',
  templateUrl: './hospede-list.component.html',
  styleUrls: ['./hospede-list.component.css']
})
export class HospedeListComponent implements OnInit {

  hospedes: Hospede[] = [];
  displayedColumns: string[] = ['id', 'cpf', 'nomeHospede', 'dtNascimento', 'acoes'];
  dataSource!: MatTableDataSource<Hospede>;

  @ViewChild(MatPaginator) paginator !: MatPaginator;

  constructor(
    private service: HospedeService,
    private dialog: MatDialog
  ) { }

  atualizarDados(): void{
    this.service.findAll().subscribe( hospedes =>{
      this.dataSource = new MatTableDataSource(hospedes)
      this.dataSource.paginator = this.paginator;
      console.log(this.hospedes);
    })
  }

  ngOnInit(): void {
    this.atualizarDados();
    console.log(this.hospedes);
  }

  delete(hospede: Hospede): void{
    const dialogRef = this.dialog.open(ConfirmDeleteComponent, {
      data: {
        message: 'Deseja realmente excluir o quarto' + hospede.nomeHospede + '?',
        buttonText:{
          ok: "Excluir",
          cancel: "Desistir"
        }
      }
    })
    dialogRef.afterClosed().subscribe((confirm: boolean) =>{
      if(confirm){
        this.service.delete(hospede).subscribe(() =>{
          this.service.showMessage("Hospede excluido com sucesso");
          this.atualizarDados();
        })
      }
    })
  }


}
