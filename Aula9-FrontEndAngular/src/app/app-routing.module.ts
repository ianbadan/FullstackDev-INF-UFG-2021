import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './component/view/home/home.component';
import { HospedagemFormComponent } from './component/view/hospedagem/hospedagem-form/hospedagem-form.component';
import { HospedagemListComponent } from './component/view/hospedagem/hospedagem-list/hospedagem-list.component';
import { HospedeFormComponent } from './component/view/hospede/hospede-form/hospede-form.component';
import { HospedeListComponent } from './component/view/hospede/hospede-list/hospede-list.component';
import { HotelFormComponent } from './component/view/hotel/hotel-form/hotel-form.component';
import { HotelListComponent } from './component/view/hotel/hotel-list/hotel-list.component';
import { QuartoFormComponent } from './component/view/quarto/quarto-form/quarto-form.component';
import { QuartosListComponent } from './component/view/quarto/quartos-list/quartos-list.component';

const routes: Routes = [
  {path: "", component: HomeComponent},
  
  {path: "hoteis", component: HotelListComponent},
  {path: "hoteis/form", component: HotelFormComponent},

  {path: "quartos", component: QuartosListComponent},
  {path: "quartos/form", component: QuartoFormComponent},

  {path: "hospedes", component: HospedeListComponent},
  {path: "hospedes/form", component: HospedeFormComponent},

  {path: "hospedagens", component: HospedagemListComponent},
  {path: "hospedagens/form", component: HospedagemFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
