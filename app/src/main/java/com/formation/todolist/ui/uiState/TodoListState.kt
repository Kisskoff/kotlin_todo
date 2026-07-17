package com.formation.todolist.ui.uiState

import com.formation.todolist.model.Todo

data class TodoListState(
    val textFieldValue: String = "",
    val percentDone: Int = 100,
    val tasks: List<Todo> = listOf(),
    val isLoading: Boolean = false,
    val error: String? = ""
)