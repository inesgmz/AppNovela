# Proyecto AppNovela
- Appnovela es una aplicación de Android desarrollada en Kotlin que permite a los usuarios agregar, eliminar y marcar novelas como favoritas.
- Utiliza un RecyclerView para mostrar una lista de novelas y un adaptador personalizado para gestionar las interacciones del usuario
## Clase MainActivity.kt
- La clase MainActivity extiende ComponentActivity, que es la actividad principal de la aplicación.
### Funcionalidades 
- onCreate: Aquí se configuran los componentes principales, como el RecyclerView para la lista de novelas, y los EditText y Button para agregar nuevas novelas.
    - RecyclerView: Componente que permite mostrar listas de elementos de forma eficiente.
          - Se usa LinearLayoutManager para organizar los elementos en una lista vertical.
          - Se utiliza un NovelaAdaptador que gestiona las interacciones con la lista, como la eliminación y la notificación de favoritos.
    - Botón Agregar Novela: Se configura un OnClickListener para capturar la información introducida en los EditText y agregar una nueva novela a la lista.
- agregarNovela:
    - Esta función recibe los datos de la novela título, autor, año, sinopsis, crea una nueva instancia de la clase Novela y la añade a la lista listaNovelas.
    - Notifica al adaptador que se ha insertado un nuevo elemento y muestra un mensaje de confirmación al usuario.
- eliminarNovela : Función que elimina una novela de la lista cuando el usuario lo solicita. Utiliza el adaptador para eliminar la novela en la posición correspondiente y notifica al usuario con un Toast.
- mostrarNotificacionFavorito : Esta función muestra una notificación (Toast) indicando si una novela ha sido marcada o desmarcada como favorita.
# Clase Novela
- La clase Novela es una data class de Kotlin que representa el modelo de una novela dentro de la aplicación AppNovela.
- Esta clase contiene las propiedades básicas que describen una novela, como su título, autor, año de publicación, sinopsis, reseñas y una marca para indicar si es una novela favorita.
## Propiedades
- titulo: String
- autor: String
- año: Int
- sinopsis: String
- reseñas: MutableList<String>
- esFavorita: Boolean
## Funcionalidades
- AgregarReseñas
- Marcar como favorita
