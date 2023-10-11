package main

import kotlin.system.measureTimeMillis

fun main(){
    //PROBLEM 1.
    val dict: IDictionary = DictionaryProvider.createDictionary(DictionaryType.ARRAY_LIST)
    val dictHash : IDictionary = DictionaryProvider.createDictionary(DictionaryType.HASH_SET)
    val dictTree : IDictionary = DictionaryProvider.createDictionary(DictionaryType.TREE_SET)
    println("Number of words: ${dict.size()}")
    var word: String?
    while(true){
        print("What to find? ")
        word = readlnOrNull()
        if( word.equals("quit")){
            break
        }
        val findTimeDict = measureTimeMillis {
            val result = word?.let { dict.find(it) }
            println("Dictionary Result: $result")
        }

        val findTimeDictHash = measureTimeMillis {
            val result = word?.let { dictHash.find(it) }
            println("Dictionary Hash Result: $result")
        }

        val findTimeDictTree = measureTimeMillis {
            val result = word?.let { dictTree.find(it) }
            println("Dictionary Tree Result: $result")
        }

        println("Search Time (Dictionary): $findTimeDict ms")
        println("Search Time (Dictionary Hash): $findTimeDictHash ms")
        println("Search Time (Dictionary Tree): $findTimeDictTree ms")
    }
    //PROBLEM 2.
    val name = "John Smith"
    println("$name: ${name.monogram()}")
    //PROBLEM 3.
    val stringList: List<String> = listOf("apple", "pear", "melon", "strawberry")
    println(stringList.joinElements('#'))
    println(stringList.longestElement())
}

//extension function
fun String.monogram(): String = this.split(" ").map{it[0]}.joinToString("")
fun List<String>.joinElements(separator: Char): String = this.joinToString(separator.toString())
fun List<String>.longestElement() : String = this.sortedByDescending{it.length}[0]