package com.formation.todolist.model

data class Todo(
    val title: String,
    val description: String,
    var isDone: Boolean
)
