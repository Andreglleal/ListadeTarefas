package com.aulasandroid.listadetarefas.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aulasandroid.listadetarefas.componentes.CaixaDeTexto

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SalvarTarefas(
    navController: NavController
) {
    var tituloTarefa = remember {
        mutableStateOf("")
    }
    var descricaoTarefa = remember {
        mutableStateOf("")
    }
    var semprioridadeTarefa = remember {
        mutableStateOf(false)
    }
    var prioridadeTarefaAlta = remember {
        mutableStateOf(false)
    }
    var prioridadeTarefaMedia = remember {
        mutableStateOf(false)
    }
    var prioridadeTarefaBaixa = remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Blue
                ),
                title = {
                    Text(
                        text = "Salvar Tarefas",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            CaixaDeTexto(
                value = tituloTarefa.value,
                onValueChange = {
                    tituloTarefa.value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 90.dp, 20.dp, 0.dp),
                label = "Título Tarefa",
                maxLines = 1,
                KeyboardType = KeyboardType.Text
            )

            CaixaDeTexto(
                value = descricaoTarefa.value,
                onValueChange = {
                    descricaoTarefa.value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(20.dp, 10.dp, 20.dp, 0.dp),
                label = "Descrição Tarefa",
                maxLines = 6,
                KeyboardType = KeyboardType.Text
            )
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ){
                Text(text = "Nivel de Prioridade")

                RadioButton(
                    selected = prioridadeTarefaBaixa.value,
                    onClick = {
                        prioridadeTarefaBaixa.value = true
                    },
                    colors = RadioButtonColors(
                        selectedColor = Color.Green,
                        unselectedColor = Color(0xFF03F484),
                        disabledSelectedColor = Color.Blue,
                        disabledUnselectedColor = Color(0xFF03F484)
                    )
                )

                RadioButton(
                    selected = prioridadeTarefaMedia.value,
                    onClick = {
                        prioridadeTarefaMedia.value = true
                    },
                    colors = RadioButtonColors(
                        selectedColor = Color.Yellow,
                        unselectedColor = Color(0xFFF4E003),
                        disabledSelectedColor = Color.Yellow,
                        disabledUnselectedColor = Color(0xFFF4E003),
                    )
                )

                RadioButton(
                    selected = prioridadeTarefaAlta.value,
                    onClick = {
                        prioridadeTarefaAlta.value = true
                    },
                    colors = RadioButtonColors(
                        selectedColor = Color.Red,
                        unselectedColor = Color(0xFFF4034F),
                        disabledSelectedColor = Color.Red,
                        disabledUnselectedColor = Color(0xFFF4034F)
                    )
                )
            }
        }
    }
}
