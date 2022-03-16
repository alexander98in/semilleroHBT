import { Component, OnInit } from '@angular/core';
import { ComicDTO } from '../../dto/comic-dto';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { GestionarComicService } from '../../servicios/gestionar-comic.service';

@Component({
  selector: 'app-gestionar-compra',
  templateUrl: './gestionar-compra.component.html',
  styleUrls: ['./gestionar-compra.component.css']
})
export class GestionarCompraComponent implements OnInit {

  public gestionarCompraForm: FormGroup;
  public formularioValido: boolean;
  public comicAComprar = null;

  public totalPagar: any;
  public mensajeEjecucion: string;

  constructor(
    private formBuilder: FormBuilder,
    private serviciosComic: GestionarComicService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {
    console.log("Componente de comprar");
    this.gestionarCompraForm = this.formBuilder.group({
      cantidadAComprar: [
        null, 
        Validators.required
      ],
    })
    
  }

  ngOnInit() {
    this.formularioValido = true;
    this.activatedRoute.params
     .subscribe(comic => {
       this.comicAComprar = comic;
     });

    console.log(this.comicAComprar);
  }

  private limpiarFormulario() : void {
    this.gestionarCompraForm.reset();//Opcion 1 limpiar
  }

  get f() {
    return this.gestionarCompraForm.controls;
  }

  public cancelarCompra(): void {
    this.router.navigate(['gestionar-comic'], { skipLocationChange : true } );

  }

  public realizarCompra(): void {
    if(this.gestionarCompraForm.invalid) {
      this.formularioValido = false;
      return;
    }

    this.formularioValido = true;
    let cantidad = this.f.cantidadAComprar.value;
    this.serviciosComic.realizarCompra(cantidad, this.comicAComprar.id)
      .subscribe(resp => {
        console.log(resp);
        this.router.navigate(['gestionar-comic'], { skipLocationChange : true } );
    })
  }

}
