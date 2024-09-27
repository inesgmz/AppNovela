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
## Clase Novela
- La clase Novela es una data class de Kotlin que representa el modelo de una novela dentro de la aplicación AppNovela.
- Esta clase contiene las propiedades básicas que describen una novela, como su título, autor, año de publicación, sinopsis, reseñas y una marca para indicar si es una novela favorita.
### Propiedades
- titulo: String
- autor: String
- año: Int
- sinopsis: String
- reseñas: MutableList<String>
- esFavorita: Boolean
### Funcionalidades
- AgregarReseñas
- Marcar como favorita
## Clase NovelaAdaptador
- La clase NovelaAdaptador es un adaptador personalizado para un RecyclerView que muestra una lista de novelas en la aplicación AppNovela.
- Esta clase gestiona la visualización de los elementos de la lista, así como las interacciones del usuario, como agregar reseñas, marcar novelas como favoritas y eliminar elementos.
### Parámetros del constructor
- listaNovelas: MutableList<Novela>: Lista mutable de objetos Novela que contiene los datos que se mostrarán en el RecyclerView.
- onDeleteClick: (Int) -> Unit: Función de callback que se ejecuta cuando se quiere eliminar una novela. Recibe la posición de la novela en la lista.
- onFavoritoClick: (Int) -> Unit: Función de callback que se ejecuta cuando se marca o desmarca una novela como favorita. También recibe la posición de la novela en la lista.
### Vista de los elementos
    - Clase interna: NovelaViewHolder
            - La clase NovelaViewHolder extiende de RecyclerView.ViewHolder y es responsable de mantener las vistas individuales dentro del RecyclerView.
            - Componentes de la Vista:
                - titulo: TextView: Muestra el título de la novela.
                - autor: TextView: Muestra el autor de la novela.
                - año: TextView: Muestra el año de publicación de la novela.
                - sinopsis: TextView: Muestra una breve sinopsis de la novela.
                - reseñasText: TextView: Muestra las reseñas acumuladas de la novela.
                - editTextReseña: EditText: Campo de entrada para agregar una nueva reseña.
                - btnAgregarReseña: Button: Botón para agregar la reseña introducida en el EditText.
                - btnFavorito: Button: Botón para marcar o desmarcar la novela como favorita.
    - Metodos Principales: 
            - onCreateViewHolder:
                - Este método se encarga de inflar el diseño de cada ítem en la lista desde un archivo XML llamado item_novela. 
                - Retorna un objeto de tipo NovelaViewHolder, que contiene las vistas individuales para cada novela.
            - onBindViewHolder:
                - Este método enlaza los datos de una novela específica a las vistas correspondientes en el ViewHolder. 
                - Aquí se configuran las acciones que el usuario puede realizar, como agregar reseñas, marcar como favorita o eliminar la novela.
            - getItemCount
                - Este método devuelve el tamaño de la lista de novelas, es decir, cuántos elementos se mostrarán en el RecyclerView.
            - eliminarNovela
                - Este método elimina una novela de la lista en la posición especificada y notifica al RecyclerView que el ítem ha sido eliminado, para que se actualice la vista.

