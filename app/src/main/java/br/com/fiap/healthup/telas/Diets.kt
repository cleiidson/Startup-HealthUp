package br.com.fiap.healthup.telas

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.healthup.R

@Composable
fun Diets(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.leftchevron),
                        contentDescription = "Icon",
                        modifier = Modifier
                            .clickable { }
                            .size(34.dp)
                            .padding(start = 10.dp)
                            .clickable { navController.navigate("homePage") }
                    )

                    Text(
                        text = stringResource(id = R.string.Diets),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.colorRed),
                        modifier = Modifier.padding(16.dp),
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.weight(1f)) //usei esse spacer pra deixar as duas imagens no fim com espaço flexivel

                Image(
                    painter = painterResource(id = R.drawable.setadireita),
                    contentDescription = "Icon",
                    modifier = Modifier
                        .clickable { }
                        .size(34.dp)
                        .padding(end = 10.dp)
                        .clickable { navController.navigate("diets2") }
                )


                Image( //IMAGEM PERFIL
                    painter = painterResource(id = R.drawable.pessoa),
                    contentDescription = "Icon",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { navController.navigate("perfil") } //FAZENDO A NAVEGAÇÃO PARA A TELA PERFIL
                ) //imagem pessoa do canto

                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.comprasonline),
                    contentDescription = "Icon",
                    modifier = Modifier.size(24.dp)
                ) // imagem do carrinho
            }

            Spacer(modifier = Modifier.height(40.dp))

            val categoryNordic = stringResource(id = R.string.Nordic_DietCategory)
            val categoryMind = stringResource(id = R.string.Mind_DietCategory)
            val categoryVegan = stringResource(id = R.string.Vegan_DietCategory)


            Category3(categoryNordic, R.drawable.dietanordica) {
                // criar uma tela cheia de dicas de dietas especificas
            }
            Spacer(modifier = Modifier.height(18.dp))
            Category3(categoryMind, R.drawable.dietamind) {
                // criar uma tela cheia de dicas de dietas especificas
            }
            Spacer(modifier = Modifier.height(18.dp))
            Category3(categoryVegan, R.drawable.dietavegana) {
                // criar uma tela cheia de dicas de dietas especificas
            }

            Spacer(modifier = Modifier.height(25.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.downarrow),
                    contentDescription = "more",
                    modifier = Modifier
                        .clickable { }
                        .size(50.dp)
                        .clickable { navController.navigate("diets2") }
                )

            }

        }
    }
}

@Composable
fun Category3(category: String, backgroundResId: Int, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(173.dp)
    ) {
        Image(
            painter = painterResource(id = backgroundResId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clickable { }// Ação a ser executada quando a imagem é clicado
                .alpha(0.5f) //usado para dar o efeito de transparencias nas fotos
        )

        // Organize a imagem e o texto verticalmente
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Spacer(modifier = Modifier.height(8.dp)) // Adicione um espaço entre a imagem e o texto
            ClickableText(
                text = AnnotatedString(category),
                onClick = { offset ->
                    // Ação a ser executada quando o texto clicável é clicado
                    onClick()
                },
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                modifier = Modifier.padding(start = 16.dp) // Adicionei padding à esquerda do texto
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DietsPrev() {
    val navController = rememberNavController()
    Diets(navController)
}