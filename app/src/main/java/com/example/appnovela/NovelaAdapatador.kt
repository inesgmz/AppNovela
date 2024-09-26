package com.example.appnovela

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class NovelaAdaptador(
    private val listaNovelas: MutableList<Novela>,
    private val onDeleteClick: (Int) -> Unit,
    private val onFavoritoClick: (Int) -> Unit
) : RecyclerView.Adapter<NovelaAdaptador.NovelaViewHolder>() {

    class NovelaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titulo: TextView = view.findViewById(R.id.novelaTitulo)
        val autor: TextView = view.findViewById(R.id.novelaAutor)
        val año: TextView = view.findViewById(R.id.novelaAño)
        val sinopsis: TextView = view.findViewById(R.id.novelaSinopsis)
        val btnFavorito: Button = view.findViewById(R.id.btnFavorito)
        val reseñasText: TextView = view.findViewById(R.id.reseñasText)
        val editTextReseña: EditText = view.findViewById(R.id.editTextReseña)
        val btnAgregarReseña: Button = view.findViewById(R.id.btnAgregarReseña)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NovelaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_novela, parent, false)
        return NovelaViewHolder(view)
    }

    override fun onBindViewHolder(holder: NovelaViewHolder, position: Int) {
        val novela = listaNovelas[position]
        holder.titulo.text = novela.titulo
        holder.autor.text = "● Autor: ${novela.autor}"
        holder.año.text = "● Año: ${novela.año}"
        holder.sinopsis.text = "● Sinopsis: ${novela.sinopsis}"

        // Muestra las reseñas
        holder.reseñasText.text = "Reseñas: ${novela.reseñas.joinToString(", ")}"

        // Maneja el botón de añadir reseña
        holder.btnAgregarReseña.setOnClickListener {
            val nuevaReseña = holder.editTextReseña.text.toString()
            if (nuevaReseña.isNotBlank()) {
                novela.reseñas.add(nuevaReseña)
                holder.reseñasText.text = "Reseñas: ${novela.reseñas.joinToString(", ")}"
                holder.editTextReseña.text.clear() // Limpiar el EditText
                Toast.makeText(holder.itemView.context, "Reseña añadida", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(holder.itemView.context, "Por favor, escribe una reseña", Toast.LENGTH_SHORT).show()
            }
        }

        // Maneja el botón de favorito
        holder.btnFavorito.text = if (novela.esFavorita) "⭐" else "☆"  // Cambia entre estrella llena y vacía
        holder.btnFavorito.setBackgroundColor(if (novela.esFavorita) Color.YELLOW else Color.TRANSPARENT)

        holder.btnFavorito.setOnClickListener {
            novela.esFavorita = !novela.esFavorita // Cambia el estado de favorito
            onFavoritoClick(position) // Notifica sobre el cambio
            notifyItemChanged(position) // Notifica que el item ha cambiado

            val mensaje = if (novela.esFavorita) {
                "Novela añadida a favoritos"
            } else {
                "Novela eliminada de favoritos"
            }
            Toast.makeText(holder.itemView.context, mensaje, Toast.LENGTH_SHORT).show()
        }

        // Maneja la eliminación de novela con clic largo
        holder.itemView.setOnLongClickListener {
            onDeleteClick(position) // Llama a la función onDeleteClick para eliminar el elemento
            true
        }
    }

    override fun getItemCount(): Int {
        return listaNovelas.size
    }

    fun eliminarNovela(position: Int) {
        listaNovelas.removeAt(position)
        notifyItemRemoved(position)
    }
}

