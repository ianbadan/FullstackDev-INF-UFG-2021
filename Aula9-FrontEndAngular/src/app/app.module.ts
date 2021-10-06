import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { HeaderComponent } from './component/template/header/header.component';
import { SidenavComponent } from './component/template/sidenav/sidenav.component';
import { FooterComponent } from './component/template/footer/footer.component';

import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatListModule} from '@angular/material/list';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatIconModule} from '@angular/material/icon';
import { HotelListComponent } from './component/view/hotel/hotel-list/hotel-list.component';
import { QuartosListComponent } from './component/view/quarto/quartos-list/quartos-list.component';
import { HospedeListComponent } from './component/view/hospede/hospede-list/hospede-list.component';
import { HospedagemListComponent } from './component/view/hospedagem/hospedagem-list/hospedagem-list.component';
import { HomeComponent } from './component/view/home/home.component';
import { HotelFormComponent } from './component/view/hotel/hotel-form/hotel-form.component';
import { QuartoFormComponent } from './component/view/quarto/quarto-form/quarto-form.component';
import { HospedeFormComponent } from './component/view/hospede/hospede-form/hospede-form.component';
import { HospedagemFormComponent } from './component/view/hospedagem/hospedagem-form/hospedagem-form.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SidenavComponent,
    FooterComponent,
    HotelListComponent,
    QuartosListComponent,
    HospedeListComponent,
    HospedagemListComponent,
    HomeComponent,
    HotelFormComponent,
    QuartoFormComponent,
    HospedeFormComponent,
    HospedagemFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatToolbarModule,
    MatAutocompleteModule,
    MatDatepickerModule,
    MatListModule,
    MatSidenavModule,
    MatIconModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
