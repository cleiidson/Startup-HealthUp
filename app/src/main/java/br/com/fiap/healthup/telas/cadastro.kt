package br.com.fiap.healthup.telas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.input.KeyboardCapitalization
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
fun SignUp(navController: NavController) {

    val username = remember {
        mutableStateOf("")
    }

    val name = remember {
        mutableStateOf("")
    }

    val email = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }

    var lembrarSenha by remember {
        mutableStateOf(false
        )
    }

    val tamanhoMaxSenha = 8

    var erroEmail by remember {
        mutableStateOf(false)
    }

    var erroPassword by remember {
        mutableStateOf(false)
    }

    var erroUsername by remember {
        mutableStateOf(false)
    }

    var erroName by remember {
        mutableStateOf(false)
    }

    var passwordErrorText by remember { mutableStateOf("") }

    var usernameErrorText by remember{
        mutableStateOf("")
    }
    var nameErrorText by remember{
        mutableStateOf("")
    }
    var emailErrorText by remember{
        mutableStateOf("")
    }

    val minCaracteres = 6

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.white))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logotipo),
                    contentDescription = "logo",
                    modifier = Modifier
                        .size(180.dp)
                        .padding(top = 15.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.CreateAccount),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.colorRed),
                    textAlign = TextAlign.Center
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                        .padding(bottom = 28.dp)
                ) {
                    Spacer(modifier = Modifier.height(16.dp)) // Espaçamento entre elementos

                    Card( //card usado pra manter as informções de preenchimento de cadastro
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(400.dp),
                        colors = CardDefaults
                            .cardColors(containerColor = Color(0xfff9f6f6)),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(
                                vertical = 16.dp,
                                horizontal = 32.dp
                            )
                        )
                        {
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
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                                trailingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.baseline_verified_user_24),
                                        contentDescription = "icon verificado"
                                    )
                                },
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
                                value = name.value,
                                onValueChange = {
                                    name.value = it
                                },
                                modifier = Modifier.fillMaxWidth(),
                                label = {
                                    Text(stringResource(id = R.string.name))
                                },
                                colors = OutlinedTextFieldDefaults.colors(
                                    unfocusedBorderColor = colorResource(id = R.color.corDaLetra),
                                    focusedBorderColor = colorResource(id = R.color.corDaLetra)
                                ),
                                shape = RoundedCornerShape(10.dp),
                                keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words),
                                trailingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.baseline_person_24),
                                        contentDescription = "icon person"
                                    )
                                }, isError = erroName
                            )
                            if (erroName) {
                                Text(
                                    text = nameErrorText,
                                    fontSize = 12.sp,
                                    color = Color.Red,
                                    modifier = Modifier.padding(start = 8.dp, top = 4.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            OutlinedTextField(
                                value = email.value,
                                onValueChange = {
                                    email.value = it
                                },
                                modifier = Modifier.fillMaxWidth(),
                                label = {
                                    Text(stringResource(id = R.string.email))
                                },
                                colors = OutlinedTextFieldDefaults.colors(
                                    unfocusedBorderColor = colorResource(id = R.color.corDaLetra),
                                    focusedBorderColor = colorResource(id = R.color.corDaLetra)
                                ),
                                shape = RoundedCornerShape(10.dp),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                                trailingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.baseline_alternate_email_24),
                                        contentDescription = "icon email"
                                    )
                                },
                                isError = erroEmail
                            )
                            if (erroEmail) {
                                Text(
                                    text = emailErrorText,
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
                                trailingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.baseline_password_24),
                                        contentDescription = "icon password"
                                    )
                                },
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
                            //funçoes criadas para fazer a validação dos dados preenchidos

                            fun validateEmail(email: String): Boolean {
                                return if (email.length >= minCaracteres) {
                                    erroEmail = false
                                    emailErrorText = ""
                                    true
                                } else {
                                    erroEmail = true
                                    emailErrorText = "Minimum 6 characters"
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

                            fun validateUsername(username: String): Boolean {
                                return if (username.length >= minCaracteres) {
                                    erroUsername = false
                                    usernameErrorText = ""
                                    true
                                } else {
                                    erroUsername = true
                                    usernameErrorText = "Minimum 6 characters"
                                    false
                                }
                            }

                            fun validateName(name: String): Boolean {
                                return if (name.length >= minCaracteres) {
                                    erroName = false
                                    nameErrorText = ""
                                    true
                                } else {
                                    erroName = true
                                    nameErrorText = "Minimum 6 characters"
                                    false
                                }
                            }
                            Spacer(modifier = Modifier.weight(1f))

                            Button( //butão de seguir
                                onClick = {
                                    // Verificando se tanto o e-mail, senha, usuário e email são válidos
                                    if ( validateUsername(username.value) && validateName(name.value) && validateEmail(email.value) && validatePassword(password.value)) {

                                        // Se validado,  pode navegar para a próxima tela
                                        navController.navigate("homePage")
                                    }
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(40.dp),
                                shape = RoundedCornerShape(16.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = colorResource(
                                        id = R.color.colorRed
                                    )
                                )
                            )
                            {
                                Text(
                                    text = stringResource(id = R.string.SIGNUP),
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    fontSize = 14.sp,
                                )
                            }
                        }
                    }
                }
                Row( //row para o checkbox
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
                //butão para caso já tenha uma conta
                Button(onClick = { navController.navigate("login")},
                    modifier = Modifier.size(width = 250.dp, height = 40.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black),
                ) {
                    Text(
                        text =stringResource(id = R.string.information2)
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PrevCadastro() {
    val navController = rememberNavController()
   SignUp(navController)
}
