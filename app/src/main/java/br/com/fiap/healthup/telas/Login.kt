package br.com.fiap.healthup.telas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.healthup.R


@Composable
fun Login(navController: NavController) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    var usernameErrorText by remember{
        mutableStateOf("")
    }

    var lembrarSenha by remember {
        mutableStateOf(false
        )
    }

    var erroUsername by remember {
        mutableStateOf(false)
    }

    var erroPassword by remember {
        mutableStateOf(false)
    }

    val tamanhoMaxSenha = 8

    var passwordErrorText by remember { mutableStateOf("") }

    val minCaracteres = 6

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.leftchevron),
                    contentDescription = "Icon",
                    modifier = Modifier.size(24.dp)
                        .clickable { navController.navigate("cadastro") }
                )

                Text(
                    text = stringResource(id = R.string.signIn),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.colorRed),
                    modifier = Modifier.padding(start = 14.dp)
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 60.dp)
                    .background(colorResource(id = R.color.white))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logotiposemfundo),
                    contentDescription = "logo",
                    modifier = Modifier.size(200.dp)
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.LOGIN),
                    modifier = Modifier.fillMaxWidth().padding(top = 5.dp),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.colorRed),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = username.value,
                    onValueChange = {
                        username.value = it

                    },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(text = stringResource(id = R.string.username))
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = colorResource(id = R.color.corDaLetra),
                        focusedBorderColor = colorResource(id = R.color.corDaLetra)
                    ),
                    shape = RoundedCornerShape(10.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    isError = erroUsername
                )
                if (erroUsername) {
                    Text(
                        text = usernameErrorText,
                        fontSize = 12.sp,
                        color = Color.Red,
                        modifier = Modifier.padding(start = 8.dp, top = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = password.value,
                    onValueChange = {
                        if (it.length <= tamanhoMaxSenha) password.value = it
                        passwordErrorText =""

                    },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(text = stringResource(id = R.string.password))
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = colorResource(id = R.color.corDaLetra),
                        focusedBorderColor = colorResource(id = R.color.corDaLetra)
                    ),
                    shape = RoundedCornerShape(10.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = PasswordVisualTransformation(),
                    isError = erroPassword
                )
                if (erroPassword) {
                    Text(
                        text = passwordErrorText,
                        fontSize = 12.sp,
                        color = Color.Red,
                        modifier = Modifier.padding(start = 8.dp, top = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 15.dp)
                ) {
                    Checkbox(
                        checked = lembrarSenha,
                        onCheckedChange = {
                            lembrarSenha = it
                        },
                    )
                    Text(
                        text = stringResource(id = R.string.information),
                        fontSize = 18.sp,
                        color = Color(R.color.corDaLetra),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
            //fazendo a validação e se for o caso, exibir a mensagem de erro
            fun validateUsername(username: String): Boolean {
                return if (username.length >= minCaracteres) {
                    erroUsername = false
                    usernameErrorText = ""
                    true
                } else {
                    erroUsername = true
                    usernameErrorText = "Minimum 6 characters" //não colocar no strings para traduzir essa parte que tem texto nas funções
                    false
                }
            }
            fun validatePassword(password: String): Boolean {
                return if (password.length >= tamanhoMaxSenha) {
                    erroPassword = false
                    passwordErrorText = ""
                    true
                } else {
                    erroPassword = true
                    passwordErrorText = "Password must be 8 characters long"
                    false
                }
            }

            Button(
                onClick = {
                    // Verificando se a senha e o username tem a quantidade de caracteres necessários para seguir
                    if (validateUsername(username.value) && validatePassword(password.value)) {

                        // se for válido, pode navegar para a próxima tela aqui
                        navController.navigate("homePage")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.colorRed)
                )
            ) {
                Text(
                    text = stringResource(id = R.string.SIGNIN),
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 16.sp,
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PrevLogin() {
    val navController = rememberNavController()
    Login(navController)
}



