package com.formation.todolist.ui.view

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.formation.todolist.ui.theme.TodoListTheme
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.formation.todolist.viewModel.TodoListViewModel

@Composable
fun BodyTodo(
    modifier: Modifier = Modifier,
    vm: TodoListViewModel = viewModel()
) {
   // var tasks = listOf<Todo>(Todo(title="Tâche 1",description="Description 1",isDone=false), Todo(title="Tâche 2", description = "Description 2",isDone=true))
    ////
    val state by vm.uiState.collectAsState()

    Log.d("UI", state.tasks.toString())

    LaunchedEffect(state.tasks) {
        Log.d("BODY", state.tasks.toString())
    }
    ///
    Column(
        modifier = modifier,
//            .fillMaxSize()
//            .background(color = MaterialTheme.colorScheme.primary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp),

        ) {
        OutlinedTextField(
            value = state.textFieldValue,
            onValueChange = {newValue ->
                vm.textFieldChange(newValue)
            },
            label = { Text("Nouvelle tâche") },
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                //.background(color = MaterialTheme.colorScheme.primary)
                .fillMaxWidth(),
            singleLine = true,
            trailingIcon = {
                IconButton(onClick = {
                    vm.addTodo()
                }) {
                    Icon(
                        imageVector = Icons.Default.Add, contentDescription = "Ajouter"
                    )
                }
            }
        )
        // pourcentage
        Text(
            text = "Pourcentage : ${state.percentDone}%",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        // liste des tâches
        if (state.tasks.isEmpty()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Aucune tâche",
                     modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
            {
                items(items = state.tasks) { task ->
                    TodoItem(
                        todo = task,
                        onDeletee = {vm.deleteTodo(todo = task)},
                        onChangeDone = {

                            Log.d("BodyTodo", "onChangeDone: ${task.title}")

                            vm.updateTodoDone(todo = task)
                        }
                    )
//                    FilterChipSample(todo =task  )
//                    ClickableListItems(
//                        todo = task,
//                        onDeletee = {},
//                        onChangeDone = {}
//                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BodyTodoPreview() {
    TodoListTheme {
        BodyTodo()
    }
}