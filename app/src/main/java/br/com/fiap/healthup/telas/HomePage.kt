package br.com.fiap.healthup.telas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
fun PaginaInicial(navController: NavController) {
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
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    //texto home page
                    text = stringResource(id = R.string.HomePage),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.colorRed),
                    )
                Spacer(modifier = Modifier.weight(1f)) //usei esse spacer pra deixar as duas imagens no fim com espaço flexivel

                Image( //IMAGEM PERFIL
                    painter = painterResource(id = R.drawable.pessoa),
                    contentDescription = "Icon",
                    modifier = Modifier.size(24.dp).clickable { navController.navigate("perfil") } //FAZENDO A NAVEGAÇÃO PARA A TELA PERFIL
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

            Column( //essa column armazena tudo da seção serviços pra baixo
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = stringResource(id = R.string.Services),
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
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                )
                {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image( //IMAGEM DE WORKOUTS
                            painter = painterResource(id = R.drawable.musculacao),
                            contentDescription = "icon musculação",
                            modifier = Modifier
                                .size(70.dp)
                                .padding(top = 10.dp)
                                .clickable { navController.navigate("workouts") }
                        )
                        Text(text = stringResource(id = R.string.Workouts),
                            Modifier.clickable { navController.navigate("workouts") }.padding(top = 10.dp),
                            textAlign = TextAlign.Center,
                            color = Color(R.color.corDaLetra))
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image( //IMAGEM DIETAS
                            painter = painterResource(id = R.drawable.dieta),
                            contentDescription = "icon dieta",
                            modifier = Modifier
                                .size(70.dp)
                                .padding(top = 10.dp)
                                .clickable { navController.navigate("diets") } //FAZENDO A NAVEGAÇÃO PARA A TELA DIETS
                        )
                        Text(
                            text = stringResource(id = R.string.Diets),
                            textAlign = TextAlign.Center,
                            color = Color(R.color.corDaLetra),
                            modifier = Modifier.padding(top = 10.dp, end = 5.dp)
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image( //IMAGEM MEDICINES
                            painter = painterResource(id = R.drawable.medicamento),
                            contentDescription = "icon medicamentos",
                            modifier = Modifier
                                .size(70.dp)
                                .padding(top = 10.dp)
                                .clickable { navController.navigate("medicines") } //FAZENDO A NAVEGAÇÃO PARA A TELA MEDICINES
                        )
                        Text(text = stringResource(id = R.string.Medicines),
                            textAlign = TextAlign.Center,
                            color = Color(R.color.corDaLetra),
                            modifier = Modifier.padding(top = 10.dp))
                    }

                }

                Spacer(modifier = Modifier.height(25.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    )
                    {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(  //IMAGEM MEMORY
                                painter = painterResource(id = R.drawable.perdadememoria),
                                contentDescription = "icon perda de memória",
                                modifier = Modifier
                                    .size(70.dp)
                                    .padding(top = 10.dp)
                                    .clickable { navController.navigate("memory") }
                            )
                            Text(
                                text = stringResource(id = R.string.Memory),
                                Modifier.padding(top = 10.dp),
                                textAlign = TextAlign.Center,
                                color = Color(R.color.corDaLetra)
                            )
                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image( //IMAGEM CARDIOLOGY
                                painter = painterResource(id = R.drawable.coracao),
                                contentDescription = "icon coração",
                                modifier = Modifier
                                    .size(70.dp)
                                    .padding(top = 10.dp)
                                    .clickable { navController.navigate("cardiology") }
                            )
                            Text(
                                text = stringResource(id = R.string.Cardiology),
                                textAlign = TextAlign.Center,
                                color = Color(R.color.corDaLetra),
                                modifier = Modifier.padding(top = 10.dp, end = 5.dp)
                            )
                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image( //IMAGEM COMENTARIOS
                                painter = painterResource(id = R.drawable.comentarios),
                                contentDescription = "icon comentários",
                                modifier = Modifier
                                    .size(70.dp)
                                    .padding(top = 10.dp)
                                    .clickable { navController.navigate("coments") }
                            )
                            Text(
                                text = stringResource(id = R.string.Comments),
                                textAlign = TextAlign.Center,
                                color = Color(R.color.corDaLetra),
                                modifier = Modifier.padding(top = 10.dp).clickable { navController.navigate("coments") }
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(25.dp))

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,

                        )
                        {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(end = 16.dp) // Adicionei padding à direita para aproximar as colunas

                            ) {
                                Image( //IMAGEM PERFIL
                                    painter = painterResource(id = R.drawable.perfildeusuario),
                                    contentDescription = "icon perfil",
                                    modifier = Modifier
                                        .size(70.dp)
                                        .padding(top = 10.dp)
                                        .clickable { navController.navigate("perfil") } //FAZENDO A NAVEGAÇÃO PARA A TELA PERFIL
                                )
                                Text(
                                    text = stringResource(id = R.string.Profile),
                                    Modifier.padding(top = 10.dp),
                                    textAlign = TextAlign.Center,
                                    color = Color(R.color.corDaLetra)
                                )
                            }
                            

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(start = 16.dp) // Adicionei padding à esquerda para aproximar as colunas
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.doutor),
                                    contentDescription = "icon doctor",
                                    modifier = Modifier
                                        .size(70.dp)
                                        .padding(top = 10.dp)
                                        .clickable { navController.navigate("doctorsList") }
                                )
                                Text(
                                    text = stringResource(id = R.string.ListofDoctors),
                                    Modifier.padding(top = 10.dp),
                                    textAlign = TextAlign.Center,
                                    color = Color(R.color.corDaLetra)
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(95.dp)) //espaçamento longo dado pra ficar mais embaixo possível

                    Row(  //essa row armazena as partes inferiores que exibe na tela
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                            .background(Color(0xfff9f6f6))
                    ) {
                        /*Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image( //HOME - NÃO TEM NENHUMA FUNÇÃO ATRIBUIDA
                                painter = painterResource(id = R.drawable.homepreto),
                                contentDescription = "Button home",
                                modifier = Modifier
                                    .size(50.dp)
                            )
                        }*/
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image( //IMAGEM ESTETOSCOPIO
                                painter = painterResource(id = R.drawable.estetoscopio),
                                contentDescription = "Icon estetoscopio",
                                modifier = Modifier
                                    .size(45.dp)
                                    .clickable { navController.navigate("doctorsList")  } // SERÁ USADO O CLICKABLE PARA IR PARA LIST OF DOCTORS
                            )
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Button(onClick = { navController.navigate("chat") }, //CHAT PARA UMA POSSIVEL CONVERSA COM ROBO
                                modifier = Modifier
                                    .size(90.dp)) {
                                Text(text = "Chat",
                                    fontSize = 16.sp,
                                )
                            }
                        }
                        /*Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image( //IMAGEM CALENDARIO
                                painter = painterResource(id = R.drawable.calendariopreto),
                                contentDescription = "Icon calendario",
                                modifier = Modifier
                                    .size(50.dp)
                            )
                        }*/
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image( //IMAGEM PERFIL
                                painter = painterResource(id = R.drawable.perfilpreto),
                                contentDescription = "Icon persona",
                                modifier = Modifier
                                    .size(50.dp)
                                    .clickable { navController.navigate("perfil") } //FAZENDO A NAVEGAÇÃO PARA A TELA PERFIL
                            )

                        }
                    }
                }
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PrevPagInicial() {
    val navController = rememberNavController()
    PaginaInicial(navController)
}
