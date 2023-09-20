package br.com.fiap.healthup

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
//import androidx.navigation.compose.composable
import br.com.fiap.healthup.telas.Login
import br.com.fiap.healthup.telas.PaginaInicial
import br.com.fiap.healthup.telas.SignUp
import br.com.fiap.healthup.ui.theme.HealthUPTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.animation.composable

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

                    }
                }
            }
        }
    }
}