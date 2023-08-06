package com.example.layoutchat.model

data class Usuarios(
    val nome: String? = null,
    val foto: Int, //como as imagens sao locais, elas retornam inteiro. Da internet vem como string.
    val mensagempadrao: String? = null,
    val bolinhavalor: String? = null
) {

}