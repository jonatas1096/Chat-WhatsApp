package com.example.layoutchat.classes

import android.content.Context
import android.graphics.Paint.Style
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.layoutchat.R
import com.example.layoutchat.model.Usuarios

@Composable
fun Item(
    listaUsuarios: MutableList<Usuarios>,
    position: Int,
    context: Context,
){

    val nomeUsuarios = listaUsuarios[position].nome
    val fotoUsuarios = listaUsuarios[position].foto
    val mensagempadrao = listaUsuarios[position].mensagempadrao
    val bolinhavalor = listaUsuarios[position].bolinhavalor


    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        val (nome,foto,mensagem,linha, bolinha) = createRefs() //criando referencias para os elementos do app

        Image(painter = painterResource(id = fotoUsuarios), //achando o caminho da imagem
            contentDescription = "SeveroMuitoBravo",
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape) //arredondar a imagem
                .constrainAs(foto) { //começando o constraint da imagem
                    top.linkTo(
                        parent.top, //indicando que o alinhamento é baseado no topo
                        margin = 15.dp
                    ) //margem referente ao topo da imagem


                    start.linkTo(
                        parent.start,
                        margin = 15.dp
                    ) //mesma coisa, margem referente à esqueda (start)


                },

            contentScale = ContentScale.Crop //isso aqui escala ela realmente como um circulo. É automatico, corrige o "corte" que o shape fez anteriormente.
        )

        TextButton( //Esse é o nome do usuario
            onClick = {
                Toast.makeText(context,"Usuário: $nomeUsuarios", Toast.LENGTH_SHORT).show()
            },
            colors = ButtonDefaults.buttonColors( //aqui é para mudar a cor do conteudo e a cor de background do botão
                contentColor = Color.Black,
                backgroundColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                //.border(border = BorderStroke(1.dp, color = Color.Black))
                .constrainAs(nome) {
                    start.linkTo(
                        parent.start,
                        margin = 107.dp
                    ) //resumo: Comece ao final (end) da foto. Esse constraint é legal.
                    top.linkTo(
                        parent.top,
                        margin = 5.dp
                    ) //resumo: parent padrão que adiciona a margem em relação ao topo.
                    end.linkTo(parent.end) //mesma coisa, mas adiciona uma margem à direita (end).
                    width = Dimension.fillToConstraints
                },
        ) {
            Text(text = nomeUsuarios!!,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth()

            )
        }


        TextButton( //aqui vai ficar a ultima mensagem do usuario
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                backgroundColor = Color.White,
            ),
            modifier = Modifier
                .fillMaxWidth()
                //.border(border = BorderStroke(1.dp, color = Color.Black))
                .constrainAs(mensagem) {
                    top.linkTo(
                        nome.bottom,
                        margin = (-20).dp
                    ) //aqui é uma gambiarra, ja que eu nao estava gostando de onde a imagem startava
                    end.linkTo(parent.end, margin = 20.dp)
                    start.linkTo(parent.start, margin = 107.dp)
                    width = Dimension.fillToConstraints
                }

        ) {
                Text(
                    text = mensagempadrao!!,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color(0xFF02C256),
                    style = TextStyle(
                        fontSize = 12.sp
                    ),
                    modifier = Modifier//.border(border = BorderStroke(1.dp, color = Color.Red))
                        .fillMaxWidth()
                        .padding(start = 5.dp)
                )
        }

        //bolinha da mensagem
        Box(
            modifier = Modifier
                .size(25.dp)
                .constrainAs(bolinha){
                    start.linkTo(parent.start, margin = 365.dp)
                    top.linkTo(parent.top, margin = 45.dp)
                }
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_circulo),
                contentDescription = "bolinha",
                modifier = Modifier
                    .size(30.dp)
                    .align(Alignment.Center)
            )
            if (bolinhavalor != null) {
                Text(
                    text = bolinhavalor,
                    fontSize = 12.sp,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }



        Row(modifier = Modifier
            .background(Color.Gray) //essa é a linha cinza que separa os chats, é uma row bem fina
            .fillMaxWidth()
            .height(1.dp)
            .constrainAs(linha) {
                top.linkTo(mensagem.bottom, margin = 5.dp)
                start.linkTo(foto.end, margin = 25.dp)

            }
        ) {

        }


    }
}


