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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.healthup.R

@Composable
fun Memory2(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0Xffffffff))
                .padding(30.dp)
        )
        {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Image( //imagem da setinha
                    painter = painterResource(id = R.drawable.leftchevron),
                    contentDescription = "Icon",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { navController.navigate("memory") }
                )
                Text(
                    //texto home page
                    text = stringResource(id = R.string.Memory),
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
                        .clickable { navController.navigate("memory3") }
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


            Column( //essa column armazena tudo da seção serviços pra baixo
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = stringResource(id = R.string.dicasMemoria),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp),
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.colorRed),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(20.dp))
            }

            // Dica 3: Atividade Física
            Text(
                text = stringResource(id = R.string.atividadeFisica),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = stringResource(id = R.string.atividadeFisicaTexto),
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Dica 4: Exercícios Cognitivos
            Text(
                text = stringResource(id = R.string.atividadeCognitiva),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = stringResource(id = R.string.exerciciosCognitivosTexto),
                fontSize = 14.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(22.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.downarrow),
                    contentDescription = "more",
                    modifier = Modifier
                        .clickable { }
                        .size(30.dp)
                        .clickable { navController.navigate("memory3") }
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Memory2pev() {
    val navController = rememberNavController()
    Memory2(navController)


}