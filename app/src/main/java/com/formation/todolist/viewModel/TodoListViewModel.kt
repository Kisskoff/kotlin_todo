package com.formation.todolist.viewModel
import android.util.Log
import androidx.lifecycle.ViewModel
import com.formation.todolist.model.Todo
import com.formation.todolist.ui.uiState.TodoListState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TodoListViewModel : ViewModel() {
    //1.private de stat
    private val _uiState = MutableStateFlow(TodoListState())
    //2.avoir une reference
    val uiState: StateFlow<TodoListState> = _uiState.asStateFlow()


    //.3 methode de modifcation de state

    // 3.1. textfield
    fun textFieldChange (newValue: String){
        _uiState.update { it.copy(textFieldValue = newValue)}
    }

    // 3.2. percentDone
    fun percentDoneChange (){
        //1. recupere la liste des taches (tous les elements)
        val alltasks = _uiState.value.tasks
        //2. recupere toutes les taches dont isDone est true
        val doneTasks = alltasks.filter { it.isDone }
        //3. la taille des deux
        val allTasksCount = alltasks.size
        val allTaskDoneCount = doneTasks.size
        //4. calculer le pourcentage

        if (allTasksCount == 0) {
            _uiState.update { it.copy(percentDone = 0)}
            return
        }

        val calc: Double = allTaskDoneCount.toDouble() / allTasksCount.toDouble()

        val calculatedPercent : Int = (calc * 100).toInt()

        // 5. mettre a jour le state
        _uiState.update { it.copy(percentDone = calculatedPercent)}
    }
    // 3.3. recupere les tasks et les mettres en mutable
    fun getTasksToMutable() : MutableList<Todo>{
        // liste vide
        val list : MutableList<Todo> = mutableListOf()

        list  += _uiState.value.tasks

        return list
        //
    }
    // 3.4. isLoading
    // 3.5. error
    // 3.6. addTodo

    fun addTodo(){

        // si le textfield est vide, on quitte la fonction

        if (_uiState.value.textFieldValue.isEmpty()) {
            return
        }

        // 3.6.1. creer une nouvelle tache

        val newTodo = Todo(
            title = _uiState.value.textFieldValue,
            description = "Description de la tache ${_uiState.value.textFieldValue}",
            isDone = false
        )
        // 3.6.2. ajouter la tache dans la liste


        _uiState.update { it.copy(tasks = it.tasks + newTodo, textFieldValue = "")}
// 3.6.3. vider le textfield
    //    textFieldChange("")
        // 3.6.4. mettre a jour le pourcentage
        percentDoneChange()

    }

    // 3.7. deleteTodo
    fun deleteTodo(todo: Todo){
        val list = getTasksToMutable()
        list.remove(todo)

        _uiState.update { it.copy(tasks = list)}

        percentDoneChange()
    }
    // 3.8. updateTodo boolean
//    fun updateTodoDone(todo: Todo){
//        val list = getTasksToMutable()
//        val index = list.indexOfFirst { it == todo }
//       if (index != -1) {
//           list[index].isDone = !list[index].isDone
//       }
//
//        Log.d("TodoListViewModel A", "updateTodoDone: $index")
//
//        Log.d("TodoListViewModel B", "updateTodoDone: ${list[index].isDone}")
//
//        Log.d("TodoListViewModel C", "updateTodoDone: $list")
//
//        _uiState.update { it.copy(tasks = list)}
//
//        percentDoneChange()
//    }


    fun updateTodoDone(todo: Todo) {
        val newList = _uiState.value.tasks.map {
            if (it == todo) {
                it.copy(isDone = !it.isDone)
            } else {
                it
            }
        }

        _uiState.update { state ->
            state.copy(tasks = newList)
        }

        Log.d("STATE", _uiState.value.tasks.toString())

        percentDoneChange()
    }

}