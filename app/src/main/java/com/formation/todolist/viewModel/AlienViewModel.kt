package com.formation.todolist.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.formation.todolist.R
import com.formation.todolist.model.Alien
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AlienViewModel() : ViewModel() {
    private val _uiState = MutableStateFlow(Alien())
    var state: StateFlow<Alien> = _uiState.asStateFlow()

    // setipCoritines
    var alienCoroutine: Job = Job()

    // onStart
    fun onStart() {
        setAlienActivity(true)
        // lance coroutine
        viewModelScope.launch {
            alienCoroutine = launch {
                attack()
            }
        }
    }

    //onCancel
    fun onCancel() {
        alienCoroutine.cancel()
        setAlienActivity(false)
    }

    // onReset
    fun onReset() {
        _uiState.update {
            it.copy(
                image = R.drawable.alien0,
                isActive = false,
                distance = 600,
                position = 1.0F
            )
        }
    }

    //update position

    fun updatePosition(): Float {
        val curentDistance = _uiState.value.distance.toFloat()
        val totalAttack = _uiState.value.timeToAtteck.toFloat()
        val position = curentDistance / totalAttack

        if (curentDistance == 0.0F) return 1.0F

        return position
    }

    // update image
    fun updateImage(currentImage: Int): Int {
        return when (currentImage) {
            R.drawable.alien0 -> R.drawable.alien1
            R.drawable.alien1 -> R.drawable.alien2
            R.drawable.alien2 -> R.drawable.alien3
            R.drawable.alien3 -> R.drawable.alien4
            R.drawable.alien4 -> R.drawable.alien5
            R.drawable.alien5 -> R.drawable.alien6
            R.drawable.alien6 -> R.drawable.alien7
            R.drawable.alien7 -> R.drawable.alien8
            else -> R.drawable.alien0
        }
    }


    // update Activity

    fun setAlienActivity(boolean: Boolean) {
        _uiState.update { it.copy(isActive = boolean) }
    }

    // suspend attack
    suspend fun attack() {
        while (_uiState.value.distance > 0) {
            delay(50)
            val newImage = updateImage(_uiState.value.image)

            _uiState.update {
                it.copy(
                    image = newImage,
                    distance = _uiState.value.distance - 5,//it.distance - 1
                    position = updatePosition()
                )
            }
        }
    }
}