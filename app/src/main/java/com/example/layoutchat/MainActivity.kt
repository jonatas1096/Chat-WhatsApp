package com.example.layoutchat

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.layoutchat.classes.Item
import com.example.layoutchat.model.Usuarios
import com.example.layoutchat.ui.theme.LayoutChatTheme
import com.example.layoutchat.ui.theme.branco
import com.example.layoutchat.ui.theme.corwhatsapp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutChatTheme {
                Main()
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter") //isso serve para tirar o erro de padding do scaffold
@Composable
fun Main() {


    //começo scaffold padrão
    Scaffold(
        topBar ={
            TopAppBar(
                title = {
                    Text(text = "WhatsApp") //titulo da aplicação
                },
                backgroundColor = corwhatsapp,
                contentColor = branco,

                actions = {
                    IconButton(onClick = { //função onclick padrão. Tô comentando p lembrar que MUITAS coisas podem possuir isso

                    }) {//Esses image vectors são disponibilizados pelo próprio android:
                        Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_camera), //aqui é a sintaxe necessária p achar
                            contentDescription = "",
                            modifier = Modifier.size(24.dp))


                    }

                    IconButton(onClick = {

                    }) {
                        Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_lupa),
                            contentDescription = "",
                            modifier = Modifier.size(24.dp))


                    }

                    IconButton(onClick = {

                    }) {
                        Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_opcoes),
                            contentDescription = "",
                            modifier = Modifier.size(24.dp))


                    }
                }
            )



        },
        backgroundColor = branco, //atributos finais do scaffold
        modifier = Modifier.fillMaxSize()
    ){
        Column() { //essa column serviu para posicionar o que eu queria um abaixo do outro, inclusive as Rows.
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(
                        onClick = {

                        }
                    )

            ) {
                IconButton(onClick = {

                },
                    modifier = Modifier.padding(start = 20.dp)
                ) {
                    Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_arquivados),
                        contentDescription = "",
                        modifier = Modifier.size(24.dp))


                }

                Text(text = "Arquivados", fontSize = 17.sp,fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(top = 13.dp, start = 7.dp)
                )


            }
            Row(modifier = Modifier.background(Color.Gray) //essa é a linha cinza que separa os chats, é uma row bem fina
                .fillMaxWidth()
                .height(1.dp)) {

            }



            //Chamando a função da lista
            ListaUsuarios()
        }


    }

}


@Composable
fun ListaUsuarios(){

    val context = LocalContext.current //recebendo o contexto da aplicação (não sei ate agora o que significa).

    //Começo da lista de contatos.

    val listaUsuarios: MutableList<Usuarios> = mutableListOf(
        //aqui dentro desses parenteres começa a criação dos itens da lista
        Usuarios("Severo Snape",R.drawable.severosnape,"Potter?! ONDE ESTÁ HARRY POTTER?!","1"), //primeiro item da lista criado.
        Usuarios("Batman que ri",R.drawable.batmanqueri,"KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK","2"),
        Usuarios("Annie Leonhart",R.drawable.annieleonhart,"Amigo, por acaso você sabe onde o Eren está?","1"),
        Usuarios("Leonardo di Caprio",R.drawable.leonardo,"Oi.linda.Rsrs.   Já.fez.18????????","1"),
        Usuarios("Luffy",R.drawable.luffy,"Vai ser rapidão pô, eu sei onde o one piece ta","4"),
        Usuarios("Inosuke",R.drawable.inosuke,"KONPACHIRO!! ESCUTA AQUI SEU @$#%@! LARGA ESSA PORRA","1"),
        Usuarios("Barbie",R.drawable.barbie,"Enfim, é assim que o patriarcado constrói uma cultura inferior para as mulheres","687"),

    )


    //Agora a coluna na vertical para puxar esses itens que criamos:
    LazyColumn(){
        itemsIndexed(listaUsuarios){position, _ ->
            Item(listaUsuarios = listaUsuarios, position = position, context = context)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Main()
}