package com.aulasandroid.listadetarefas.datasource

import com.aulasandroid.listadetarefas.model.Tarefa
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DataSource {

    private val dataBase = FirebaseFirestore.getInstance()

    private val _todatarefas = MutableStateFlow<MutableList<Tarefa>>(mutableListOf())
    private val todastarefas: StateFlow<MutableList<Tarefa>> = _todatarefas

    fun salvarTarefa(titulo: String, descricao: String, prioridade: Int) {
        val tarefaMap = hashMapOf(
            "titulo" to titulo,
            "descricao" to descricao,
            "prioridade" to prioridade
        )
        dataBase.collection("tarefas").document(titulo).set(tarefaMap).addOnCompleteListener {

        }.addOnFailureListener {

        }
    }

    fun recuperarTarefas(): Flow<MutableList<Tarefa>> {

        val listaTarefas: MutableList<Tarefa> = mutableListOf()

        dataBase.collection("tarefas").get().addOnCompleteListener { querySnapshot ->
            if (querySnapshot.isSuccessful){
                for (documento in querySnapshot.result ){
                    val tarefa = documento.toObject(Tarefa::class.java)
                    listaTarefas.add(tarefa)
                    _todatarefas.value = listaTarefas
                }
            }
        }
        return todastarefas
    }
    fun deletarTarefa(tarefa: String){
        dataBase.collection("tarefas").document(tarefa).delete().addOnCompleteListener {

        }.addOnFailureListener {

        }
    }
}