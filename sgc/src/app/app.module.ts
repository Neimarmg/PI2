import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { TabelaUsuariosComponent } from './tabela-usuarios/tabela-usuarios.component';
import { UsuarioService } from "app/usuario.service";
import { FormUsuariosComponent } from './form-usuarios/form-usuarios.component';
import { Routes, RouterModule } from "@angular/router";
const rotas:Routes=[
  { path:'lista', component:TabelaUsuariosComponent },
  { path:'novo', component:FormUsuariosComponent },
  { path:'edicao/:ind', component:FormUsuariosComponent },
  { path:'',redirectTo:'/lista',pathMatch:'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    TabelaUsuariosComponent,
    FormUsuariosComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(rotas)
  ],
  providers: [UsuarioService],
  bootstrap: [AppComponent]
})
export class AppModule { }
