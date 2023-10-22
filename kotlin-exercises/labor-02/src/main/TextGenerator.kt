package main

import kotlin.random.Random

class TextGenerator {
    val learnedPairs = mutableMapOf<Pair<String, String>, MutableList<String>>()

    fun learnWords(input: String) {
        val distinctWords = input.split(" ")
        for(index in 0 .. distinctWords.size - 2){
            val prefix = Pair(distinctWords[index], distinctWords[index + 1])
            val postfix = if (index + 2 >= distinctWords.size) "" else distinctWords[index + 2]

            learnedPairs.computeIfAbsent(prefix) { mutableListOf() }.add(postfix)
        }
    }

    fun generateText(): String {
        val generatedText = mutableListOf<String>()
        var wordPair = learnedPairs.keys.first()
        generatedText.add(wordPair.first)
        while(learnedPairs.containsKey(wordPair)){
            generatedText.add(wordPair.second)
            val postfixes = learnedPairs[wordPair]!!
            val randomIndex = Random.nextInt(learnedPairs[wordPair]!!.size)
            val chosenPostfix = postfixes[randomIndex]
            println(generatedText.joinToString (" "))
            val newPair = Pair(wordPair.second, chosenPostfix)
            wordPair = newPair
        }
        return generatedText.joinToString(" ")
    }

}