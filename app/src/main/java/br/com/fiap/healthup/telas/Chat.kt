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
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.healthup.R

@Composable
fun Chat(navController: NavController) {
    var mensagem by remember { mutableStateOf("") }
    var mensagemEnviada by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
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
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { navController.navigate("homePage") }
                )
                Text(
                    //texto como posso ajudar
                    text = stringResource(id = R.string.Help),
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.colorRed),
                )
                Spacer(modifier = Modifier.weight(1f)) //usei esse spacer pra deixar as duas imagens no fim com espaço flexivel

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

            Spacer(modifier = Modifier.height(30.dp))

            // Campo de entrada de mensagem
            TextField(
                value = mensagem,
                onValueChange = { mensagem = it },
                label = { Text(stringResource(id = R.string.chatMsg1)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Botão de enviar
            Button(
                onClick = {
                    //  define que a mensagem foi enviada
                    mensagemEnviada = true
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(stringResource(id = R.string.enviar))
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Feedback "mensagem enviada, aguarde a resposta"
            if (mensagemEnviada) {
                Text(
                    text = stringResource(id = R.string.chatMsg2),
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.colorGreen)
                )
            }
        }
    }
}





@Preview
@Composable
fun ChatPrev() {
    val navController = rememberNavController()
    Chat(navController)

}