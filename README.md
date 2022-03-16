# semilleroHBT

Taller # 1
1.	Instalar la dependencia Hibernate.
2.	Terminar de mapear la entidad comic, y crear el enumerador Estado.,Ñ
3.	Crear una clase CreacionComicTest en el cual contendrá lo siguiente:

    3.1 Antes de ejecutar las pruebas unitarias, se deben crear 10 comics, haciendo uso de set o haciendo uso de constructores. Esos 10 comics se adicionaran a una lista y algunos deberán contener el estado activo y otros el estado inactivo (la cantidad que uds quieran).
    3.2 Crear dos métodos privados, uno para verificar los comics que se encuentran activos y otro para verificar los comics inactivos, estos deberán retornar una lista con los activos e inactivos respectivamente.
    3.3 Para el método de comics activos, se debe filtrar los que son activos haciendo uso del enumerador para comparar el estado y el método debe retornar una lista con solo los comics activos.
    3.4 Adicional a esto se debe crear una prueba unitaria que permita comprobar que si se están listando solo comics en estado activo, hacer uso de la Clase System.out.println para imprimir todas las propiedades del comic y poderlas visualizar en consola.
    
4. Crear un nuevo método el cual debe generar una excepción indicando el siguiente mensaje “Se ha detectado que de ” + tamanioListaTotal + “ comics se encontraron que ” + numeroTotalActivos + “  se encuentran activos y ” + numeroTotalInactivos + “ inactivos. Los comics inactivos son: ” + nombresComicsInacivos.
5. Realizar prueba unitaria para capturar el mensaje de error producido.

NOTA: Importante documentar el código

# Taller Servicios REST

http://localhost:8085/semillero-servicios/rest/gestionarComicRest/consultarComicTamanioNombre
parametro: lengthComic

Crear un servicio llamado consultarComicTamanioNombre que contendrá un parametro de tipo short Wrapper con el nombre de lengthComic. El cual traerá todos los nombres comics que se encuentren en la tabla Comic, y mediante el parámetro que llega al servicio determinar que nombre de comic supera la longitud del numero ingresado y que comics no superan esa longitud.
El servicio deberá retornar un DTO con una lista de comics que superan o igualan el numero de longitud ingresado y otra lista con los que no lo superan.
Cuando el servicio se ejecute exitosamente debe lanzar un mensaje indicando “Comics procesados exitosamente”, en caso contrario deberá lanzar “Se ha presentado un error tecnico”.

Plus: Controlar la longitud máxima a ingresar al servicio en una excepción indicando en el mensaje lo siguiente: “La longitud máxima permitida es de xxx caracteres”.

Ejemplo: Comics creados 3
-	Dragon ball
-	Hulk
-	Spiderman
Ingreso en mi servicio el numero 5
DTO de salida
{
    "exitoso": true,
    "mensajeEjecucion": "Comics procesados exitosamente",
    "comicsNoSuperanTamanio": [
        "Hulk"
    ],
    "comicsSuperanTamanio": [
        "Spiderman",
        "Dragon ball"
    ]
}

# Taller FINAL

TALLER FINAL

BACK-END
Desarrollar un (1) servicio que permita realizar la compra de un comic, teniendo en cuenta las siguientes características.
-	Se debe crear las clases que administre aparte la compra del comic, se puede llamar GestionarCompraComicRest, GestionarCompraComicBean, IGestionarCompraComic.

-	Si al momento de realizar la compra del comic, este se encuentra en estado INACTIVO, se debe generar una excepción indicando en un mensaje “El comic seleccionado no cuenta con stock en bodega”.

-	Cuando la cantidad ingresada para la compra del comic no supera el stock o cantidad existente se debe actualizar el registro, agregando la fecha de venta, descontado la cantidad ingresada y el registro permanecerá en estado ACTIVO, esto generará una compra exitosa.

-	Si al momento de comprar un comic la cantidad comprada es la misma del stock existente se debe actualizar el registro a estado INACTIVO, actualizar la fecha de venta y descontar la cantidad comprada, que para este caso seria 0, esto generara una compra exitosa.

-	Cuando la cantidad comprada por un comic supera el stock existente, se debe generar una excepción indicando el siguiente mensaje “La cantidad existente del comic es:  numeroComics, y supera la ingresada”.

-	Si la compra es exitosa el mensaje será: “La compra del comic nombreComic fue exitosa”.


FRONT-END
-	Adicionar una nueva opción en la columna acciones que permita realizar la compra del comic, del componente gestionar comic.
-	Al momento de hacer clic en este icono, debe direccionar a un componente nuevo que gestionara la compra, y se le debe enviar la información del registro o comic seleccionado de la tabla.
-	El componente que gestionara la compra del comic deberá contener dos campos, uno indicando el nombre del comic seleccionado y otro donde se ingrese la información de la cantidad a comprar, por último la acción de comprar comic, y otra acción para cancelar la compra.
-	El botón de comprar invocara el servicio de comprar comic y el botón de cancelar regresara a la pantalla de gestionar comic.
-	El formulario deberá validar la obligatoriedad del campo cantidad, este debe ser ingresado y debe ser superior a 0.

-	Se debe administrar en un componente de alertas los posibles mensajes que lanzara el servicio, si es exitosa la compra, debe direccionar a la pantalla de gestionar comic y deberá aparecer una alerta de color azul indicando el mensaje de éxito que lanza el servicio.

Si el mensaje no es exitoso, deberá permanecer en el componente que gestiona la compra y lanzar el mensaje en una alerta roja indicando el mensaje fallido que lanza el servicio.

Para las alertas usar el componente de boostrap.
 
