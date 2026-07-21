package com.formation.todolist.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil3.network.HttpException
import com.formation.todolist.model.WeatherResponse
import com.formation.todolist.services.WeatherApi
import com.formation.todolist.ui.uiState.WeatherUIState
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.launch
import okio.IOException

class WeatherViewModel : ViewModel() {
// etat de la textfield
    var city : String by mutableStateOf("Abidjan")
    // etat de l appel de l api
    var weatherState: WeatherUIState by mutableStateOf(WeatherUIState.LOADING)
    //
    fun updateTextField(text :String){
        city = text
    }
    //
    fun launchApi(){
        // lance coroutine avec weatherservice
        viewModelScope.launch {
            weatherState = try {

                val result = WeatherApi.weatherService.getForecast(q=city)

                println("COUNTRY : ${result}")

                println(result)

                WeatherUIState.SUCCES(convertData(result))

            } catch (iO: IOException){

                println(
                    "IOException ${iO.message}"
                )

                WeatherUIState.ERROR(error = iO.message.toString())

            } catch (http: HttpException){
                println(
                    "http ${http.message}"
                )

                WeatherUIState.ERROR(error = http.message.toString())
            }
        }
       //
    }
    fun convertData(string: String): WeatherResponse{
        val gson = Gson()
        val type = object : TypeToken<WeatherResponse>(){}.type
        return gson.fromJson(string,type)
    }
}