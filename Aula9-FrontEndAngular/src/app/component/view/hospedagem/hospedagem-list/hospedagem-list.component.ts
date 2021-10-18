import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { ConfirmDeleteComponent } from 'src/app/component/template/confirm-delete/confirm-delete.component';
import { Hospedagem } from 'src/app/model/hospedagem.model';
import { HospedagemService } from 'src/app/service/hospedagem.service';

@Component({
  selector: 'app-hospedagem-list',
  templateUrl: './hospedagem-list.component.html',
  styleUrls: ['./hospedagem-list.component.css']
})
export class HospedagemListComponent implements OnInit {
  
  hospedagens: Hospedagem[] = [];
  displayedColumns: string[] = ["id", "quarto", "hospede", "dtCheckin", "dtCheckout", 'acoes'];
  dataSource!: MatTableDataSource<Hospedagem>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private service: HospedagemService,
    private dialog: MatDialog
  ) { }

  atualizarDados(): void{
    this.service.findAll().subscribe(hospedagens =>{
      this.dataSource = new MatTableDataSource(hospedagens);
      this.dataSource.paginator = this.paginator;
    })
  }

  ngOnInit(): void {
    this.atualizarDados();
  }

  delete(hospedagem: Hospedagem): void{
    const dialogRef = this.dialog.open(ConfirmDeleteComponent, {
      data: {
        message: 'Deseja realmente excluir esta hospedagem ?',
        buttonText:{
          ok: "Excluir",
          cancel: "Desistir"
        }
      }
    })
    dialogRef.afterClosed().subscribe((confirm: boolean) =>{
      if(confirm){
        this.service.delete(hospedagem).subscribe(() =>{
          this.service.showMessage("Hospedagem excluida com sucesso");
          this.atualizarDados();
        })
      }
    })
  }

}
