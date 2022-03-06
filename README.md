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
