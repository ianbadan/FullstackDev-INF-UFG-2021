import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './component/view/home/home.component';
import { HospedagemFormComponent } from './component/view/hospedagem/hospedagem-form/hospedagem-form.component';
import { HospedagemListComponent } from './component/view/hospedagem/hospedagem-list/hospedagem-list.component';
import { HospedagemUpdateComponent } from './component/view/hospedagem/hospedagem-update/hospedagem-update.component';
import { HospedeFormComponent } from './component/view/hospede/hospede-form/hospede-form.component';
import { HospedeListComponent } from './component/view/hospede/hospede-list/hospede-list.component';
import { HospedeUpdateComponent } from './component/view/hospede/hospede-update/hospede-update.component';
import { HotelFormComponent } from './component/view/hotel/hotel-form/hotel-form.component';
import { HotelListComponent } from './component/view/hotel/hotel-list/hotel-list.component';
import { HotelUpdateComponent } from './component/view/hotel/hotel-update/hotel-update.component';
import { QuartoFormComponent } from './component/view/quarto/quarto-form/quarto-form.component';
import { QuartoListComponent } from './component/view/quarto/quarto-list/quarto-list.component';
import { QuartoUpdateComponent } from './component/view/quarto/quarto-update/quarto-update.component';

const routes: Routes = [
  {path: "", component: HomeComponent},
  
  {path: "hoteis", component: HotelListComponent},
  {path: "hoteis/form", component: HotelFormComponent},
  {path: "hoteis/:id", component: HotelUpdateComponent},

  {path: "quartos", component: QuartoListComponent},
  {path: "quartos/form", component: QuartoFormComponent},
  {path: "quartos/:id", component: QuartoUpdateComponent},

  {path: "hospedes", component: HospedeListComponent},
  {path: "hospedes/form", component: HospedeFormComponent},
  {path: "hospedes/:id", component: HospedeUpdateComponent},

  {path: "hospedagens", component: HospedagemListComponent},
  {path: "hospedagens/form", component: HospedagemFormComponent},
  {path: "hospedagens/:id", component: HospedagemUpdateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
