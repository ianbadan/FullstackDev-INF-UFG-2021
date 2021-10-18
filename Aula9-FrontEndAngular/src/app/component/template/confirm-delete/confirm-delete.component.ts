import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-confirm-delete',
  templateUrl: './confirm-delete.component.html',
  styleUrls: ['./confirm-delete.component.css']
})
export class ConfirmDeleteComponent implements OnInit {

  message: string = "Deseja excluir este elemento?";
  confirmButtonText = "Excluir";
  cancelButtonText = "Cancelar";

  constructor(
    @Inject (MAT_DIALOG_DATA)  private data: any,
    private dialogRef: MatDialogRef<ConfirmDeleteComponent>
  ) { 
    if(data){
      this.message = data.message || this.message;
      if(data.buttonText){
        this.confirmButtonText = data.buttonText.ok || this.confirmButtonText;
        this.cancelButtonText = data.buttonText.cancel || this.cancelButtonText;
      }
    }
  }

  ngOnInit(): void {
  }

  onConfirmClick(): void{
    console.log("confirmed");
    this.dialogRef.close(true);
  }
}
