package main

interface IDictionary {
    fun add(word: String): Boolean
    fun find(word: String): Boolean
    fun size(): Int

    companion object {
        const val DICTIONARY_NAME = "C:\\Users\\rjohh\\IdeaProjects\\andriod_lab\\kotlin-exercises\\labor-02\\src\\resources\\text.txt"
    }
}