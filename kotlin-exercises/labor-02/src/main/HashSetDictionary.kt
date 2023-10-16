package main

import java.io.File

object HashSetDictionary : IDictionary {

    private val words = hashSetOf<String>()
    init {
        File(IDictionary.DICTIONARY_NAME).forEachLine { words.add(it) }
    }
    override fun add(word: String) = words.add(word)

    override fun find(word: String) = words.find { it == word } != null

    override fun size() = words.size
}