package main

class ItemController(private val itemService: ItemService) {
    fun startQuiz() {
        println("Lets play a fun Kotlin quiz.\nPlease select how many question do you want to play with:")
        val numberOfQuestions = readlnOrNull()?.toIntOrNull() ?: 0
        val questionToPlayWith = itemService.selectRandomItems(numberOfQuestions)
        var numberOfCorrects = 0
        for(question in questionToPlayWith){
            println(question.question)
            for((index, answer) in question.answers.withIndex()){
                println("\t${index+1}.) $answer")
            }
            println("Please select your answer from 1 to 4:")
            var answerByUser = readlnOrNull()?.toIntOrNull() ?: 0
            while (answerByUser < 1 || answerByUser > question.answers.size){
                println("The given number has to be between 1 and 4. " +
                        "Please enter a new number.")
                answerByUser = readlnOrNull()?.toIntOrNull() ?: 0
            }
            if(answerByUser == question.correct){
                println("Correct!")
                numberOfCorrects++
            }else
            {
                println("Wrong! The correct answer was ${question.correct}.")

            }
        }
        println("Your final score is $numberOfCorrects/$numberOfQuestions")
    }
}