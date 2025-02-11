package com.aulasandroid.listadetarefas.repositorio

import com.aulasandroid.listadetarefas.datasource.DataSource
import com.aulasandroid.listadetarefas.model.Tarefa
import kotlinx.coroutines.flow.Flow

class TarefasRepositorio {
    private val dataSource = DataSource()

    fun salvarTarefa(titulo: String, descricao: String, prioridade: Int) {
        dataSource.salvarTarefa(titulo, descricao, prioridade)
    }
    fun recuperarTarefas():Flow<MutableList<Tarefa>>{
        return dataSource.recuperarTarefas()
    }
    fun deletarTarefa(tarefa: String){
        dataSource.deletarTarefa(tarefa)

    }
}