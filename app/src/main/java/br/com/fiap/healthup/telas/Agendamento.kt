/*
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.healthup.R
import java.util.Calendar

@Composable
fun Agendamentos(navController: NavController) {
    val linhaDeBusca = remember { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf(Calendar.getInstance()) }
    var descrition = remember { mutableStateOf("") }

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
                        .clickable { navController.navigate("homePage") }
                )
                Text(
                    //texto home page
                    text = stringResource(id = R.string.Agendametos),
                    fontSize = 24.sp,
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
            Spacer(modifier = Modifier.height(20.dp))

            TextField( //textfield da linha de pesquisa
                value = linhaDeBusca.value,
                onValueChange = {
                    linhaDeBusca.value = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = stringResource(id = R.string.searching2))
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
            Spacer(modifier = Modifier.height(10.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .background(colorResource(id = R.color.white))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logotiposemfundo),
                    contentDescription = "logo",
                    modifier = Modifier.size(200.dp)
                )
            }

            OutlinedTextField(
                value = descrition.value,
                onValueChange = {
                    descrition.value = it
                },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                label = {
                    Text(text = stringResource(id = R.string.Descrition))
                },

                textStyle = TextStyle(color = Color.White),
                shape = RoundedCornerShape(16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = colorResource(id = R.color.colorRed),
                    focusedBorderColor = colorResource(id = R.color.colorRed)
                )
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = stringResource(id = R.string.searching2),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.corDaLetra2),
                    textAlign = TextAlign.Center
                )
            }

        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun AgendamentosPrev() {
    val navController = rememberNavController()
    Agendamentos(navController)

}*/
