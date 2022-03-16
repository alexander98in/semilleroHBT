import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GestionarComicComponent } from './semillero/componentes/gestionar-comic/gestionar-comic.component';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';
import { GestionarCompraComponent } from './semillero/componentes/gestionar-compra/gestionar-compra.component';

const routes: Routes = [
  { path: 'bienvenida', 
    component: BienvenidaComponent,
    data : null 
  },
  { path: 'gestionar-comic', 
    component: GestionarComicComponent, 
    data : null 
  },
  {
    path: 'gestionar-compra',
    component: GestionarCompraComponent,
    data : null
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
