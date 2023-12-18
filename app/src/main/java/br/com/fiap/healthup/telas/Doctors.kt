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
fun DoctorsList(navController: NavController) {
    // Lista de médicos com nome, especialidade e idade
    val doctors = listOf(
        Doctor("Dra. Maria", "Psicólogo", 35),
        Doctor("Dr. Carlos", "Cardiologista", 45),
        Doctor("Dra. Laura", "Nutricionista", 30),
        Doctor("Dr. José", "Educador Físico", 38),
    )

    // Variável para armazenar o texto de pesquisa
    val linhaDeBusca = remember { mutableStateOf("") }

    // Layout principal da tela
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
                // Ícone de seta para voltar
                Image(
                    painter = painterResource(id = R.drawable.leftchevron),
                    contentDescription = "Icon",
                    modifier = Modifier.size(24.dp).clickable { navController.navigate("homePage") }
                )
                Text(
                    text = stringResource(id = R.string.ListofDoctors),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.colorRed),
                )
                Spacer(modifier = Modifier.weight(1f)) // Espaço flexível entre elementos

                // Ícone de perfil
                Image(
                    painter = painterResource(id = R.drawable.pessoa),
                    contentDescription = "Icon",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { navController.navigate("perfil") }
                )

                Spacer(modifier = Modifier.width(8.dp))

                // Ícone de carrinho
                Image(
                    painter = painterResource(id = R.drawable.comprasonline),
                    contentDescription = "Icon",
                    modifier = Modifier.size(24.dp)
                )
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

            // Título da lista de médicos
            Text(
                text = stringResource(id = R.string.textDoctors),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.colorRed),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Lista de médicos/especialistas
            LazyColumn {
                items(doctors) { doctor ->
                    DoctorItem(doctor = doctor)
                }
            }
        }
    }
}

@Composable
fun DoctorItem(doctor: Doctor) {
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
            // Nome do médico
            Text(
                text = doctor.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            // Especialidade do médico
            Text(
                text = doctor.specialty,
                fontSize = 14.sp,
                color = Color.Gray
            )

            // Idade do médico
            Text(
                text = "Idade: ${doctor.age} anos",
                fontSize = 14.sp,
                color = Color.Gray
            )

        }
    }
}
data class Doctor(val name: String, val specialty: String, val age: Int)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DoctorListPrev() {
    val navController = rememberNavController()
    DoctorsList(navController)

}
