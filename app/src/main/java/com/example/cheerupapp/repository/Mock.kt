package com.example.cheerupapp.repository

import android.content.ClipDescription
import com.example.cheerupapp.Infra.MotivationConstant
import java.util.*

data class  Phrase (val description: String, val category: Int)


class Mock {

    private  val ALL = MotivationConstant.FRASEFILTER.ALL
    private  val BOMDIA = MotivationConstant.FRASEFILTER.BOMDIA
    private  val HAPPY = MotivationConstant.FRASEFILTER.HAPPY

    private val mListPhrases: List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", HAPPY),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", HAPPY),
        Phrase("Quando está mais escuro, vemos mais estrelas!", HAPPY),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", HAPPY),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", HAPPY),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", HAPPY),
        Phrase("Não é a linguagem de programação que define o programador, mas sim sua lógica.", BOMDIA),
        Phrase("O resultado do programa é relativo o nível de conhecimento do programador.", BOMDIA),
        Phrase("A questão não é saber os códigos ou linhas de comando, é saber o que fazer com eles.", BOMDIA),
        Phrase(" Uma linguagem não faz seu código ser bom, programadores bons fazem seu código ser bom.", BOMDIA),
        Phrase("Às vezes, vale a pena ficar na cama na segunda-feira, em vez de passar o resto da semana depurando o código de segunda-feira.", BOMDIA),
        Phrase("Faça como um programador. Quando tudo está errado e confuso, apague tudo e recomece do zero.", BOMDIA),
        Phrase("Não se preocupe se não funcionar direito. Se tudo desse certo, você perderia o emprego.", BOMDIA)
    )

    fun getPhrase(categoryId: Int) : String {

        val filtered = mListPhrases.filter { (it.category == categoryId || categoryId == ALL) }

        val rand =  Random().nextInt(filtered.size)

        return filtered[rand].description
    }

}