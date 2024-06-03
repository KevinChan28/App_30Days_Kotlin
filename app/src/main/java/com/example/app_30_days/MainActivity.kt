package com.example.app_30_days

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.example.app_30_days.ui.theme.App_30_daysTheme
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import androidx.navigation.*
import java.time.*
import androidx.navigation.NavHostController
import androidx.navigation.NavArgs
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App_30_daysTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                }
            }
        }
    }
}
val green500 = Color(0xFF7AC74C)
val green700 = Color(0xFF4CAF50)
val white = Color.White

data class Challenge(
    val day: Int,
    val title: String,
    val image: String,
    val description: String
)

val challenges = listOf(
    Challenge(1, "Medita durante 5 minutos", "meditating", "Dedica unos minutos a la meditación para calmar tu mente y reducir el estrés."),
    Challenge(2, "Lee un libro durante 30 minutos", "reading", "Sumergirte en la lectura puede ayudarte a relajarte, aprender cosas nuevas y ampliar tu perspectiva."),
    Challenge(3, "Sal a caminar durante 30 minutos", "walking", "La actividad física regular es esencial para la salud física y mental."),
    Challenge(4, "Aprende una palabra nueva", "dictionary", "Aumenta tu vocabulario aprendiendo una palabra nueva cada día."),
    Challenge(5, "Expresa gratitud", "gratitude", "Escribe tres cosas por las que estás agradecido."),
    Challenge(6, "Haz algo creativo", "painting", "Dedica tiempo a una actividad creativa, como pintar, dibujar o escribir."),
    Challenge(7, "Conecta con un ser querido", "talking", "Llama o envía un mensaje a un amigo o familiar con el que no hayas hablado en mucho tiempo."),
    Challenge(8, "Duerme 8 horas", "sleeping", "Dormir lo suficiente es esencial para la salud física y mental."),
    Challenge(9, "Come alimentos saludables", "healthy_food", "Elige alimentos nutritivos para tu cuerpo y tu mente."),
    Challenge(10, "Bebe suficiente agua", "drinking_water", "Mantente hidratado bebiendo mucha agua a lo largo del día."),
    Challenge(11, "Practica mindfulness", "meditation", "Presta atención al momento presente y sé consciente de tus pensamientos y sentimientos."),
    Challenge(12, "Haz ejercicio", "exercise", "Dedica al menos 30 minutos a la actividad física moderada la mayoría de los días de la semana."),
    Challenge(14, "Sal de tu zona de confort", "mountain_climbing", "Prueba algo nuevo y desafiante."),
    Challenge(15, "Aprende de tus errores", "reading", "No tengas miedo de cometer errores, ya que son oportunidades para aprender y crecer."),
    Challenge(16, "Ayuda a los demás", "volunteering", "Dedica tiempo a ayudar a otras personas necesitadas."),
    Challenge(17, "Perdona a los demás", "handshake", "Libera el rencor y el resentimiento perdonando a las personas que te han hecho daño."),
    Challenge(18, "Practica el amor propio", "smiling", "Cuídate física y emocionalmente."),
    Challenge(19, "Acepta el cambio", "falling_leaf", "El cambio es inevitable, así que aprende a aceptarlo y adaptarte a él."),
    Challenge(20, "Vive el presente", "beach", "No te preocupes por el pasado ni te angusties por el futuro, disfruta del presente."),
    Challenge(21, "Agradece lo que tienes", "gratitude", "Concéntrate en las cosas buenas de tu vida y exprésales gratitud."),
    Challenge(22, "Haz algo por el medio ambiente", "recycling", "Toma medidas para proteger el planeta."),
    Challenge(23, "Desarrolla una nueva habilidad", "learning", "Aprende algo nuevo que te interese."),
    Challenge(24, "Conecta con la naturaleza", "hiking", "Pasa tiempo al aire libre y disfruta de la belleza de la naturaleza."),
    Challenge(25, "Practica la respiración profunda", "yoga", "La respiración profunda puede ayudarte a calmarte y reducir el estrés."),
    Challenge(26, "Baila", "dancing", "Baila para divertirte y liberar endorfinas."),
    Challenge(27, "Aprende a cocinar algo nuevo", "cooking", "Experimenta con nuevas recetas y sabores."),
    Challenge(28, "Organiza tu espacio", "cleaning", "Un espacio organizado puede ayudarte a sentirte más tranquilo y productivo."),
    Challenge(29, "Ahorra dinero", "saving_money", "Establece un presupuesto y ahorra para tus metas."),
    Challenge(30, "Celebra tus logros", "celebrating", "Tómate un tiempo para apreciar tus logros y sentirte orgulloso de ti mismo."),
)

@Composable
fun MainScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text(
            text = "Desafíos 30 Días",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Default,
            color = green700,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(challenges) { challenge ->
                ChallengeItem(challenge = challenge, navController = navController)
            }
        }
    }
}



@Composable
fun ChallengeItem(challenge: Challenge, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .clickable { navController.navigate("challenge/${challenge.day}")}
            .padding(16.dp)
        ) {
        Text(
        text = "</span>{challenge.day}",
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Default,
        color = green500
        )
        Text(
            text = challenge.title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.Default,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
            // Cargar imagen
            val imagePainter: Painter = painterResource(id = R.drawable.ic_launcher_background)
            Image(
                painter = imagePainter,
                contentDescription = challenge.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )
    }
    }
}
@Composable
fun ChallengeDetailsScreen(challenge: Challenge) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Desafío ${challenge.day}",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Default,
            color = green700,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Cargar imagen
        val imagePainter: Painter = painterResource(id = challenge.image )
        Image(
            painter = imagePainter,
            contentDescription = challenge.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = challenge.description,
            fontSize = 16.sp,
            fontFamily = FontFamily.Default,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App_30_daysTheme {

    }
}