package com.aulasandroid.listadetarefas.datasource

import com.google.firebase.firestore.FirebaseFirestore

class DataSource {

    private val dataBase = FirebaseFirestore.getInstance()

    fun salvarTarefa(titulo: String, descricao: String, prioridade: Int){
        val tarefaMap = hashMapOf(
            "titulo" to titulo,
            "descricao" to descricao,
            "prioridade" to prioridade
        )
        dataBase.collection("tarefas").document(titulo).set(tarefaMap).addOnCompleteListener {

        }.addOnFailureListener {

        }
    }
}