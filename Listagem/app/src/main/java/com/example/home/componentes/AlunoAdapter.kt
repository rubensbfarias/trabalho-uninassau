package com.example.home.componentes
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.home.MainActivity
import com.example.home.R
import com.example.home.users.Aluno
import com.squareup.picasso.Picasso

class AlunoAdapter(
    var listal: List<Aluno>,
    val alunoV: MainActivity
): RecyclerView.Adapter<AlunoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlunoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_main, parent, false)

        return AlunoViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlunoViewHolder, position: Int) {
        Picasso.get()
            .load(listal[position].imagemUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.imagem)

        holder.nome.text = listal[position].nome
        holder.matricula.text = listal[position].matricula

        holder.card.setOnClickListener {
            (alunoV as IOnClick).onClickAluno(listal[position])
            holder.card.setOnClickListener {
                (alunoV as IOnClick).onClickElement(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return listal.size
    }
}