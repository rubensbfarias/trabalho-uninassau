package com.example.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.home.componentes.AlunoAdapter
import com.example.home.componentes.IOnClick
import com.example.home.users.Aluno

class MainActivity : AppCompatActivity(), IOnClick {

    lateinit var recyclerV: RecyclerView
    lateinit var adtr: AlunoAdapter

    private var itensC = mutableListOf<Int>()
    private var totalC: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listaAlunos = mutableListOf(
            Aluno("https://icon-library.com/images/avatar-icon-images/avatar-icon-images-4.jpg", "Allyson", "123"),
            Aluno("https://icon-library.com/images/avatar-icon-images/avatar-icon-images-6.jpg","Ellen","456"),
            Aluno("https://icon-library.com/images/avatar-icon-images/avatar-icon-images-4.jpg", "Rubens","789"),
            Aluno("https://icon-library.com/images/avatar-icon-images/avatar-icon-images-6.jpg", "Wanessa","987"),
            Aluno("https://icon-library.com/images/avatar-icon-images/avatar-icon-images-4.jpg", "Otto","654"),
            Aluno("https://icon-library.com/images/avatar-icon-images/avatar-icon-images-4.jpg", "Jefferson","321")
        )
        recyclerV = findViewById(R.id.recycler_view)
        adtr = AlunoAdapter(listaAlunos, this)
        recyclerV.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerV.adapter = adtr

    }

    override fun onClickAluno(aluno: Aluno) {
        val alunotela = Intent(this, MainActivity2::class.java)
        intent.putExtra("aluno", "Aluno")
        startActivity(intent)
    }

    override fun onClickElement(position: Int) {
        Toast.makeText(this, "Item ${position}", Toast.LENGTH_LONG).show() // ${} = interpolação

        if(!itensC.contains(position)) {
            itensC.add(position)
        }
        Log.d("ITEM", "Clicks: ${++totalC}: $itensC")
    }

}