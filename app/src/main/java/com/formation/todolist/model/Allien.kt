package com.formation.todolist.model

import androidx.annotation.DrawableRes
import com.formation.todolist.R

data class Alien(
    @DrawableRes val image: Int = R.drawable.alien0,
    val timeToAtteck: Int = 600,
    val distance :Int = 600,
    val position : Float = 1.0F,
    val isActive : Boolean = false,
)
