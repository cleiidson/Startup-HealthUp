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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
fun TelaPerfil(navController: NavController) {


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

    val address = remember {
        mutableStateOf("")
    }

    var successMessageVisible by remember { mutableStateOf(false) }

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
    var erroAddress by remember {
        mutableStateOf(false)
    }

    var passwordErrorText by remember { mutableStateOf("") }

    var usernameErrorText by remember {
        mutableStateOf("")
    }
    var nameErrorText by remember {
        mutableStateOf("")
    }
    var emailErrorText by remember {
        mutableStateOf("")
    }
    var addressErrorText by remember {
        mutableStateOf("")
    }

    val minCaracteres = 6 //variavel para manter o minimo de caracteres

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0Xffffffff))
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            )
            {
                Image( //imagem da setinha
                    painter = painterResource(id = R.drawable.leftchevron),
                    contentDescription = "Icon",
                    modifier = Modifier
                        .clickable { }
                        .size(34.dp)
                        .padding(start = 10.dp)
                        .clickable { navController.navigate("homePage") }
                )

                Text(
                    text = stringResource(id = R.string.Profile),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.colorRed),
                    modifier = Modifier
                        .padding(16.dp),
                    textAlign = TextAlign.Center
                )
            }

            Image(
                painter = painterResource(id = R.drawable.perfildeusuario),
                contentDescription = "Icon persona",
                modifier = Modifier
                    .size(130.dp)
                    .fillMaxWidth()
                    .padding(start = 13.dp, top = 10.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = stringResource(id = R.string.EDIT_PROFILE),
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(start = 13.dp),
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.colorRed)
            )
            Spacer(modifier = Modifier.height(13.dp))

            OutlinedTextField( //textfield dos dados para atualizar
                value = username.value,
                onValueChange = {
                    username.value = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = stringResource(id = R.string.username))
                },
                placeholder = {
                    Text(text = stringResource(id = R.string.Confirm_your_username))
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
            if (erroUsername) { // se houver erro exibe a mensagem
                Text(
                    text = usernameErrorText,
                    fontSize = 12.sp,
                    color = Color.Red,
                    modifier = Modifier.padding(start = 8.dp, top = 4.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField( //textfield dos dados para atualizar
                value = name.value,
                onValueChange = {
                    name.value = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(stringResource(id = R.string.name))
                },
                placeholder = {
                    Text(text = stringResource(id = R.string.Confirm_your_name))
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
            if (erroName) { // se houver erro exibe a mensagem
                Text(
                    text = nameErrorText,
                    fontSize = 12.sp,
                    color = Color.Red,
                    modifier = Modifier.padding(start = 8.dp, top = 4.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField( //textfield dos dados para atualizar
                value = email.value,
                onValueChange = {
                    email.value = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(stringResource(id = R.string.email))
                },
                placeholder = {
                    Text(text = stringResource(id = R.string.Confirm_your_email))
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
            if (erroEmail) { // se houver erro exibe a mensagem
                Text(
                    text = emailErrorText,
                    fontSize = 12.sp,
                    color = Color.Red,
                    modifier = Modifier.padding(start = 8.dp, top = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField( //textfield dos dados para atualizar
                value = password.value,
                onValueChange = {
                    if (it.length <= tamanhoMaxSenha) password.value = it
                    passwordErrorText = ""
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = stringResource(id = R.string.password))
                },
                placeholder = {
                    Text(text = stringResource(id = R.string.Confirm_your_password))
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
            if (erroPassword) { // se houver erro exibe a mensagem
                Text(
                    text = passwordErrorText,
                    fontSize = 12.sp,
                    color = Color.Red,
                    modifier = Modifier.padding(start = 8.dp, top = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = address.value,
                onValueChange = {
                    if (it.length <= tamanhoMaxSenha) address.value = it
                    addressErrorText = "" //estabelecido um tamano maximo da senha
                },
                modifier = Modifier
                    .fillMaxWidth(),
                label = {
                    Text(text = stringResource(id = R.string.address))
                },
                placeholder = {
                    Text(text = stringResource(id = R.string.Confirm_your_address))
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = colorResource(id = R.color.corDaLetra),
                    focusedBorderColor = colorResource(id = R.color.corDaLetra)
                ),
                shape = RoundedCornerShape(10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                visualTransformation = PasswordVisualTransformation(),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_edit_location_24),
                        contentDescription = "icon endereço"
                    )
                },
                isError = erroPassword
            )
            if (erroAddress) { // se houver erro exibe a mensagem
                Text(
                    text = addressErrorText,
                    fontSize = 12.sp,
                    color = Color.Red,
                    modifier = Modifier.padding(start = 8.dp, top = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            if (successMessageVisible) { //se tudo for feito corretamente a mensagem de sucesso aparece
                Text(
                    text = stringResource(id = R.string.Data_updated_successfully),
                    color = Color.Green,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(1.dp)
                )
            }

            Spacer(modifier = Modifier.height(1.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

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

                fun validateAddress(address: String): Boolean {
                    return if (address.length >= minCaracteres) {
                        erroAddress = false
                        addressErrorText = ""
                        true
                    } else {
                        erroAddress = true
                        addressErrorText = "Minimum 6 characters"
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

                fun validateAddres(name: String): Boolean {
                    return if (name.length >= minCaracteres) {
                        erroAddress = false
                        addressErrorText = ""
                        true
                    } else {
                        erroAddress = true
                        addressErrorText = "Minimum 6 characters"
                        false
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))

                // Adicionando um Spacer antes dos botões para ajustar a posição para cima
                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {
                        if (validateUsername(username.value) && validateName(name.value) && validateEmail(
                                email.value
                            ) && validatePassword(password.value) && validateAddress(address.value)
                        ) {
                            successMessageVisible = true
                            // Limpar os campos de entrada de texto
                            username.value = ""
                            name.value = ""
                            email.value = ""
                            password.value = ""
                            address.value = ""
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(60.dp)
                        .padding(end = 8.dp), // Adicionei um espaço à direita entre os botões
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.colorRed)
                    )
                ) {
                    Text(
                        text = stringResource(id = R.string.ENTER),
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 16.sp,
                    )

                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        navController.navigate("homePage")
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(60.dp)
                        .padding(start = 8.dp), // Adicionei um espaço à esquerda entre os botões

                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray // cor cinza para o botão Cancel
                    )
                ) {
                    Text(
                        text = stringResource(id = R.string.CANCEL),
                        fontWeight = FontWeight.Bold,
                        color = Color.White, // a cor do texto para o botão Cancel branca
                        fontSize = 16.sp,
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TelaPerfilPreviwe() {
    val navController = rememberNavController()
    TelaPerfil(navController)

}