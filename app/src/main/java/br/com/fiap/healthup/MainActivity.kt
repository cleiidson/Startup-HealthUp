package br.com.fiap.healthup

//import androidx.navigation.compose.composable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import br.com.fiap.healthup.telas.Cardiology
import br.com.fiap.healthup.telas.Chat
import br.com.fiap.healthup.telas.ComentariosList
import br.com.fiap.healthup.telas.ComentariosList2
import br.com.fiap.healthup.telas.Diets
import br.com.fiap.healthup.telas.Diets2
import br.com.fiap.healthup.telas.DoctorsList
import br.com.fiap.healthup.telas.Login
import br.com.fiap.healthup.telas.Medicines
import br.com.fiap.healthup.telas.Medicines2
import br.com.fiap.healthup.telas.Memory
import br.com.fiap.healthup.telas.Memory2
import br.com.fiap.healthup.telas.Memory3
import br.com.fiap.healthup.telas.PaginaInicial
import br.com.fiap.healthup.telas.SignUp
import br.com.fiap.healthup.telas.TelaPerfil
import br.com.fiap.healthup.telas.Workouts
import br.com.fiap.healthup.telas.Workouts2
import br.com.fiap.healthup.ui.theme.HealthUPTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HealthUPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberAnimatedNavController()
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = "cadastro",
                        exitTransition = {
                            slideOutOfContainer(towards = AnimatedContentScope.SlideDirection.Start,
                                tween(1000) //segundos em milissegundos
                            ) + fadeOut(animationSpec = tween(2000))
                        },
                        enterTransition = {
                            slideIntoContainer(towards = AnimatedContentScope.SlideDirection.Down,
                                animationSpec = tween(2000)
                            )
                        }
                    ) {
                        composable(route = "cadastro") {
                            SignUp(navController)
                        }
                        composable(route = "homePage") {
                            PaginaInicial(navController)
                        }
                        composable(route = "login") {
                            Login(navController)
                        }
                        composable(route = "workouts") {
                            Workouts(navController)
                        }
                        composable(route = "workouts2") {
                            Workouts2(navController)
                        }
                        composable(route = "perfil") {
                            TelaPerfil(navController)
                        }

                        composable(route = "diets2") {
                            Diets2(navController)
                        }
                        composable(route = "diets") {
                            Diets(navController)
                        }
                        composable(route = "medicines") {
                            Medicines(navController)
                        }
                        composable(route = "medicines2") {
                            Medicines2(navController)
                        }
                        /*composable(route = "agendamentos") {
                            Agendamentos(navController)
                        }*/
                        composable(route = "doctorsList") {
                            DoctorsList(navController)
                        }
                        composable(route = "cardiology") {
                            Cardiology(navController)
                        }
                        composable(route = "coments") {
                            ComentariosList(navController)
                        }
                        composable(route = "coments2") {
                            ComentariosList2(navController)
                        }
                        composable(route = "memory") {
                            Memory(navController)
                        }
                        composable(route = "memory2") {
                            Memory2(navController)
                        }
                        composable(route = "memory3") {
                            Memory3(navController)
                        }
                        composable(route = "chat") {
                            Chat(navController)
                        }

                    }
                }
            }
        }
    }
}