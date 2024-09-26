package com.example.appnovela

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import android.widget.EditText

class MainActivity : ComponentActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var novelaAdaptador: NovelaAdaptador
    private lateinit var listaNovelas: MutableList<Novela>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializa la lista de novelas
        listaNovelas = mutableListOf()

        // Configura el RecyclerView y el adaptador
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Aquí pasas una lambda para manejar el clic de eliminación
        novelaAdaptador = NovelaAdaptador(listaNovelas, { position ->
            eliminarNovela(position) }) { position -> mostrarNotificacionFavorito(position)
        }
        recyclerView.adapter = novelaAdaptador

        val editTextTitulo: EditText = findViewById(R.id.editTextTitulo)
        val editTextAutor: EditText = findViewById(R.id.editTextAutor)
        val editTextAño: EditText = findViewById(R.id.editTextAño)
        val editTextSinopsis: EditText = findViewById(R.id.editTextSinopsis)

        // Inicializa el botón para agregar novelas
        val btnAgregarNovela: Button = findViewById(R.id.btnAgregarNovela)
        btnAgregarNovela.setOnClickListener {
            val titulo = editTextTitulo.text.toString()
            val autor = editTextAutor.text.toString()
            val año = editTextAño.text.toString().toIntOrNull() // Convertir a Int, maneja si es null
            val sinopsis = editTextSinopsis.text.toString()

            if (titulo.isNotBlank() && autor.isNotBlank() && año != null) {
                agregarNovela(titulo, autor, año, sinopsis)
                // Limpiar los campos después de agregar
                editTextTitulo.text.clear()
                editTextAutor.text.clear()
                editTextAño.text.clear()
                editTextSinopsis.text.clear()
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos correctamente", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun agregarNovela(titulo: String, autor: String, año: Int, sinopsis: String) {
        val nuevaNovela = Novela(titulo, autor, año, sinopsis)
        listaNovelas.add(nuevaNovela)
        novelaAdaptador.notifyItemInserted(listaNovelas.size - 1)
        Toast.makeText(this, "Novela agregada", Toast.LENGTH_SHORT).show()
    }

    // Función que maneja la eliminación de una novela
    private fun eliminarNovela(position: Int) {
        novelaAdaptador.eliminarNovela(position)
        Toast.makeText(this, "Novela eliminada", Toast.LENGTH_SHORT).show()
    }
    private fun mostrarNotificacionFavorito(position: Int) {
        val novela = listaNovelas[position]
        if (novela.esFavorita) {
            Toast.makeText(this, "${novela.titulo} añadida a favoritos", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "${novela.titulo} eliminada de favoritos", Toast.LENGTH_SHORT).show()
        }
    }
}

