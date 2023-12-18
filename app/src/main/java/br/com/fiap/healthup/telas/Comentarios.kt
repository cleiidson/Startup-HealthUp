package br.com.fiap.healthup.telas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.healthup.R

@Composable
fun ComentariosList(navController: NavController) {
    // Lista de comentários com nome e mensagem
    val comentarios = listOf(
        Comentario("Maria", stringResource(R.string.comment_maria)),
        Comentario("Carlos", stringResource(R.string.comment_carlos)),
    )

    // Variável para armazenar o texto de pesquisa
    val linhaDeBusca = remember { mutableStateOf("") }

    // Layout principal da tela
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0Xffffffff))
                .padding(30.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Image( //imagem da setinha
                    painter = painterResource(id = R.drawable.leftchevron),
                    contentDescription = "Icon",
                    modifier = Modifier.size(24.dp).clickable { navController.navigate("homePage") }
                )
                Text(
                    //texto comentários
                    text = stringResource(id = R.string.Comments),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.colorRed),
                )
                Spacer(modifier = Modifier.weight(1f)) //usei esse spacer pra deixar as duas imagens no fim com espaço flexivel

                Image(
                    painter = painterResource(id = R.drawable.setadireita),
                    contentDescription = "Icon",
                    modifier = Modifier
                        .clickable { }
                        .size(34.dp)
                        .padding(end = 10.dp)
                        .clickable { navController.navigate("coments2") }
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

            Spacer(modifier = Modifier.height(20.dp))

            // Campo de pesquisa
            TextField(
                value = linhaDeBusca.value,
                onValueChange = { linhaDeBusca.value = it },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = stringResource(id = R.string.searching))
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_search_24),
                        contentDescription = "icon lupa de pesquisa"
                    )
                },
                shape = RoundedCornerShape(10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Título da lista de comentários
            Text(
                text = stringResource(id = R.string.Comments),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.colorRed),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Lista de comentários
            LazyColumn {
                items(comentarios) { comentario ->
                    ComentarioItem(comentario = comentario)
                    Spacer(modifier = Modifier.height(16.dp)) // Espaçamento entre comentários
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            Row ( modifier = Modifier.fillMaxWidth(),

                horizontalArrangement = Arrangement.Center) {
                Image(
                    painter = painterResource(id = R.drawable.downarrow),
                    contentDescription = "mais",
                    modifier = Modifier
                        .clickable { }
                        .size(34.dp)
                        .clickable { navController.navigate("coments2") }
                )

            }
        }
    }
}

@Composable
fun ComentarioItem(comentario: Comentario) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            // Nome do autor do comentário
            Text(
                text = comentario.author,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            // Mensagem do comentário
            Text(
                text = comentario.message,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}

data class Comentario(val author: String, val message: String)


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun comentsListPrev() {
    val navController = rememberNavController()
    ComentariosList(navController)

}