package com.aulasandroid.listadetarefas.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aulasandroid.listadetarefas.R
import com.aulasandroid.listadetarefas.itemlista.TarefaItem
import com.aulasandroid.listadetarefas.model.Tarefa


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListaTarefas(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Blue
                ),
                title = {
                    Text(
                        text = "Lista de Tarefas",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("salvarTarefas")
                },
                containerColor = Color.Blue,
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_add),
                    contentDescription = "Ícone de adicionar tarefas"
                )
            }
        }, containerColor = Color.Black
    ) {
        val listaTarefas : MutableList<Tarefa> = mutableListOf(
            Tarefa(
                titulo = "Jogar video game",
                descricao = "ghgdkyhjbfwefwguywegfvfqecv",
                prioridade = 0
            ),
            Tarefa(
                titulo = "Estudar as Musicas de Domingo",
                descricao = "ghgdkyhjbfwefwguywegfvfqecv",
                prioridade = 1
            ),
            Tarefa(
                titulo = "Estudar Android",
                descricao = "ghgdkyhjbfwefwguywegfvfqecv",
                prioridade = 2
            ),
            Tarefa(
                titulo = "Ficar com a Familia",
                descricao = "ghgdkyhjbfwefwguywegfvfqecv",
                prioridade = 3
            )
        )
        LazyColumn {
          itemsIndexed(listaTarefas){position, _ ->
              TarefaItem( position, listaTarefas)

          }

        }
    }
}








