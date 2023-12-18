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
fun Medicines2(navController: NavController) {
    val linhaDeBusca = remember { mutableStateOf("") }


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
                    //texto HealthUp
                    text = "HealthUp",
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

            Column( //essa column armazena tudo da seção medicines pra baixo
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Medicines",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.colorRed),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable { }
                    ) {
                        Image( //IMAGEM ITEM DOS MEDICAMENTOS
                            painter = painterResource(id = R.drawable.vitamina),
                            contentDescription = "Enterogermina ",
                            modifier = Modifier
                                .size(70.dp)
                                .padding(top = 10.dp)
                        )
                        Text(text = stringResource(id = R.string.enterogermina),//DESCRICAO DO ITEM
                            Modifier
                                .padding(top = 10.dp),
                            textAlign = TextAlign.Center,
                            color = Color(R.color.corDaLetra)
                        )
                        Text(text = "R$ 43,90",
                            color = Color(0xFF028001)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable {  }
                    ) {
                        Image( //IMAGEM ITEM DOS MEDICAMENTOS
                            painter = painterResource(id = R.drawable.vitaminab1),
                            contentDescription = "Tiamina ",
                            modifier = Modifier
                                .size(70.dp)
                                .padding(top = 10.dp)
                        )
                        Text(text = stringResource(id = R.string.tiamina),//DESCRICAO DO ITEM
                            Modifier
                                .padding(top = 10.dp),
                            textAlign = TextAlign.Center,
                            color = Color(R.color.corDaLetra)
                        )
                        Text(text = "R$ 43,19",
                            color = Color(0xFF028001)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable {  }
                    ) {
                        Image( //IMAGEM ITEM DOS MEDICAMENTOS
                            painter = painterResource(id = R.drawable.flaveno),
                            contentDescription = "Flaveno ",
                            modifier = Modifier
                                .size(70.dp)
                                .padding(top = 10.dp)
                        )
                        Text(text = stringResource(id = R.string.flaveno),//DESCRICAO DO ITEM
                            Modifier
                                .padding(top = 10.dp),
                            textAlign = TextAlign.Center,
                            color = Color(R.color.corDaLetra)
                        )
                        Text(text = "R$ 43,19",
                            color = Color(0xFF028001)
                        )
                    }


                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MedicinesPrev2() {
    val navController = rememberNavController()
    Medicines2(navController)
}
