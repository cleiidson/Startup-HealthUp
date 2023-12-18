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
fun Medicines(navController: NavController) {
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
                        .clickable { navController.navigate("homePage") } //quando clica na setinha volta para home
                )
                Text(
                    //texto HealthUp
                    text = "HealthUp",
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
                        .clickable { navController.navigate("medicines2") } //navegação para proxima tela
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
                    text = stringResource(id = R.string.Medicines),
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
                            painter = painterResource(id = R.drawable.ibuprofeno),
                            contentDescription = "ibuprofeno",
                            modifier = Modifier
                                .size(70.dp)
                                .padding(top = 10.dp)

                        )
                        Text( //DESCRICAO DO ITEM
                            text = stringResource(id = R.string.ibuprofeno),
                            Modifier
                                .padding(top = 10.dp),
                            textAlign = TextAlign.Center,
                            color = Color(R.color.corDaLetra)
                        )
                        Text(
                            text = "R$ 10,59",
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
                        modifier = Modifier.clickable { }
                    ) {
                        Image( //IMAGEM ITEM DOS MEDICAMENTOS
                            painter = painterResource(id = R.drawable.paracetamol),
                            contentDescription = "icon paracetamol",
                            modifier = Modifier
                                .size(70.dp)
                                .padding(top = 10.dp)
                        )
                        Text( //DESCRICAO DO ITEM
                            text = stringResource(id = R.string.paracetamol),
                            Modifier
                                .padding(top = 10.dp),
                            textAlign = TextAlign.Center,
                            color = Color(R.color.corDaLetra)
                        )
                        Text(
                            text = "R$ 21,17",
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
                        modifier = Modifier.clickable { }
                    ) {
                        Image(//IMAGEM ITEM DOS MEDICAMENTOS
                            painter = painterResource(id = R.drawable.aspirina),
                            contentDescription = "aspirina",
                            modifier = Modifier
                                .size(70.dp)
                                .padding(top = 10.dp)
                        )
                        Text( //DESCRICAO DO ITEM
                            text = stringResource(id = R.string.aspirina),
                            Modifier
                                .padding(top = 10.dp),
                            textAlign = TextAlign.Center,
                            color = Color(R.color.corDaLetra)
                        )
                        Text(
                            text = "R$ 19,80",
                            color = Color(0xFF028001)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))

            }

            Row ( modifier = Modifier.fillMaxWidth(),

                horizontalArrangement = Arrangement.Center) {
                Image(//IMAGEM PARA O ROLAMENTO DE MAIS PRODUTOS
                    painter = painterResource(id = R.drawable.downarrow),
                    contentDescription = "more",
                    modifier = Modifier
                        .clickable { }
                        .size(34.dp)
                        .clickable { navController.navigate("medicines2") } //navegação para proxima tela
                )

            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MedicinesPreview() {
    val navController = rememberNavController()
    Medicines(navController)
}
