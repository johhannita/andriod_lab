package test

import main.TextGenerator

fun main(){
    val textGenerator = TextGenerator()
    textGenerator.learnWords("Now is not the time for sleep, now is the time for party!")
    textGenerator.generateText()
}