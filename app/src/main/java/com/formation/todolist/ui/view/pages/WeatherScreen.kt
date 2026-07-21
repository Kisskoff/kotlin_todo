package com.formation.todolist.ui.view.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.formation.todolist.model.ErrorView
import com.formation.todolist.model.ForecastView
import com.formation.todolist.model.LoadingView
import com.formation.todolist.ui.theme.TodoListTheme
import com.formation.todolist.ui.uiState.WeatherUIState
import com.formation.todolist.ui.view.CustomTextField
import com.formation.todolist.ui.view.WeatherComponent
import com.formation.todolist.ui.view.WeatherItem
import com.formation.todolist.viewModel.WeatherViewModel

@Composable
fun WeatherScreen(modifier: Modifier = Modifier, vm: WeatherViewModel = viewModel()) {

   // var textFieldValue = TextFieldState()
   // val searchState = rememberTextFieldState()

    val manager = LocalFocusManager.current

   // var searchState by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(text = "Weather")
        // search

        CustomTextField(
            modifier = Modifier.fillMaxWidth(),
            value = vm.city,
            onChange = { vm.updateTextField(it)},
            label = "",
            keyboardType = KeyboardType.Number,
            manager = manager,
            onSend = {
                vm.launchApi()
                manager.clearFocus()
            }

        )

        // meteo recap
       // WeatherComponent(forecast = (vm.weatherState as WeatherUIState.SUCCES).forecast.list.first(), city = vm.city)


        // weather listle

        when(val state = vm.weatherState) {
            is WeatherUIState.LOADING -> LoadingView(modifier=modifier)
            is WeatherUIState.ERROR -> ErrorView(error = (vm.weatherState as WeatherUIState.ERROR).error)
            is WeatherUIState.SUCCES -> {

                WeatherComponent(
                    result = state.forecast,
                )

                ForecastView(
                    result = state.forecast
                )
            }
              //  ForecastView(result = (vm.weatherState as WeatherUIState.SUCCES).forecast)
        }
    }
}

@Preview
@Composable
private fun WeatherScreenPreview() {

    TodoListTheme {
        WeatherScreen()
    }

}
