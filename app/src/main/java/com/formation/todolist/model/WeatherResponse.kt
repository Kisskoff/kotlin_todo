package com.formation.todolist.model

data class WeatherResponse(
    val cod:String,
    val message:Int,
    val cnt:Int,
    val list:List<Forecast>,
    val city: City,
)

data class City(
    val id: Int,
    val name : String,
    val coord :Coord,
    val country: String,
    val population: Int,
    val timezone:Int,
    val sunrise:Int,
    val sunset:Int,

//    "city": {
//    "id": 2293538,
//    "name": "Abidjan",
//    "coord": {
//        "lat": 5.3094,
//        "lon": -4.0197
//    },
//    "country": "CI",
//    "population": 3677115,
//    "timezone": 0,
//    "sunrise": 1784614246,
//    "sunset": 1784658829
//}
)

data class Coord(
    val lat: Float,
    val lon: Float,
   // "lat": 5.3094,
    //"lon": -4.0197
)

data class Forecast(
    val dt:Int,
    val main:Main,
    val weather: List<Weather>,
    val clouds: Clouds,
    val wind:Wind,
    val visibility:Int,
    val pop: Double,
    val sys:Sys,
    val dt_txt:String
)

data class Main(
    val temp: Double,
    val feels_like: Double,
    val temp_min : Double,
    val temp_max : Double,
    val presure: Int,
    val sea_level: Int,
    val ground_level: Int,
    val humidity: Int,
    val temp_kf: Double,
    val dew_point: Double
)

data class Weather(
    val id:Int,
    val main:String,
    val description:String,
    val icon:String
)

data class Clouds(
    val all:Int
)

data class Wind(
    val speed: Double,
    val deg:Int,
    val gust: Double
)

data class Sys(
    val pod:String
)
//
//{
//    "dt": 1784656800,
//    "main": {
//    "temp": 24.98,
//    "feels_like": 25.67,
//    "temp_min": 24.98,
//    "temp_max": 24.98,
//    "pressure": 1013,
//    "sea_level": 1013,
//    "grnd_level": 1012,
//    "humidity": 82,
//    "temp_kf": 0,
//    "dew_point": 21.69
//},
//    "weather": [
//    {
//        "id": 804,
//        "main": "Clouds",
//        "description": "couvert",
//        "icon": "04d"
//    }
//    ],
//    "clouds": {
//    "all": 94
//},
//    "wind": {
//    "speed": 4.85,
//    "deg": 212,
//    "gust": 5.65
//},
//    "visibility": 10000,
//    "pop": 0.1,
//    "sys": {
//    "pod": "d"
//},
//    "dt_txt": "2026-07-21 18:00:00"
//}