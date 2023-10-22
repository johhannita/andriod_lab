package main

import java.io.File

//object, nem class. singleton
// egy peldany jon letre es nem kell mindig ujra olvassa a fajlt -> hatekonyabb, gyorsabb lesz
object ItemRepository {
    private var items: MutableList<Item> = mutableListOf()

    init {
        val lines = File("C:\\Users\\rjohh\\IdeaProjects\\andriod_lab\\kotlin-exercises\\labor-03\\src\\resources\\questions.txt")
            .useLines { it.toList() }

        for(i in lines.indices step 6){
            val question = lines[i]

            val answer1 = lines[i + 1]
            val answer2 = lines[i + 2]
            val answer3 = lines[i + 3]
            val answer4 = lines[i + 4]

            val correct = lines[i + 5].toInt()

            save(Item(question, listOf(answer1, answer2, answer3, answer4), correct))
        }
    }
    fun randomItem() = items.random()

    private fun save(newItem: Item) = items.add(newItem)

    fun size() = items.size
}