package com.aulasandroid.listadetarefas.repositorio

import com.aulasandroid.listadetarefas.datasource.DataSource

class TarefasRepositorio {
    private val dataSource = DataSource()

    fun salvarTarefa(titulo: String, descricao: String, prioridade: Int) {
        dataSource.salvarTarefa(titulo, descricao, prioridade)
    }

}