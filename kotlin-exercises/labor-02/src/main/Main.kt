@file:Suppress("DEPRECATION")

package main

import java.util.*
import kotlin.system.measureTimeMillis

fun main(){
//    //PROBLEM 1.
//    val dict: IDictionary = DictionaryProvider.createDictionary(DictionaryType.ARRAY_LIST)
//    val dictHash : IDictionary = DictionaryProvider.createDictionary(DictionaryType.HASH_SET)
//    val dictTree : IDictionary = DictionaryProvider.createDictionary(DictionaryType.TREE_SET)
//    println("Number of words: ${dict.size()}")
//    var word: String?
//    while(true){
//        print("What to find? ")
//        word = readlnOrNull()
//        if( word.equals("quit")){
//            break
//        }
//        val findTimeDict = measureTimeMillis {
//            val result = word?.let { dict.find(it) }
//            println("Dictionary Result: $result")
//        }
//
//        val findTimeDictHash = measureTimeMillis {
//            val result = word?.let { dictHash.find(it) }
//            println("Dictionary Hash Result: $result")
//        }
//
//        val findTimeDictTree = measureTimeMillis {
//            val result = word?.let { dictTree.find(it) }
//            println("Dictionary Tree Result: $result")
//        }
//
//        println("Search Time (Dictionary): $findTimeDict ms")
//        println("Search Time (Dictionary Hash): $findTimeDictHash ms")
//        println("Search Time (Dictionary Tree): $findTimeDictTree ms")
//    }
//    //PROBLEM 2.
//    val name = "John Smith"
//    println("$name: ${name.monogram()}")
//    val stringList: List<String> = listOf("apple", "pear", "melon", "strawberry")
//    println(stringList.joinElements('#'))
//    println(stringList.longestElement())
    //PROBLEM 3.
    val date1 = Date(2024, 10, 15)
    val date2 = Date(2004, 2, 30)
    println("${date1.year}.${date1.month}.${date1.day} is leap year: ${date1.isLeapYear()}")
    println("${date2.year}.${date2.month}.${date2.day} is valid date: ${date2.isValidDate()}")
    val validDatesList : MutableList<Date> = mutableListOf()
    while (validDatesList.size < 10){
        val newDate = generateRandomDate()
        if (newDate.isValidDate()){
            validDatesList.add(newDate)
        }
        else{
            println("${newDate.year}.${newDate.month}.${newDate.day}")
        }
    }
    println("Valid dates: ")
    validDatesList.forEach{ println("${it.year}.${it.month}.${it.day}") }
    println("Valid dates sorted: ")
    validDatesList.sortedWith(MyDate).forEach{ println("${it.year}.${it.month}.${it.day}") }
    validDatesList.sortedWith(MyDate).reversed().forEach{ println("${it.year}.${it.month}.${it.day}") }
}

fun generateRandomDate(): Date {
    val random = Random()

    val year = 1900 + random.nextInt(100)
    val month = 1 + random.nextInt(50)
    val day = 1 + random.nextInt(50)

    return Date(year, month, day)
}

//extension functions
fun String.monogram(): String = this.split(" ").map{it[0]}.joinToString("")
fun List<String>.joinElements(separator: Char): String = this.joinToString(separator.toString())
fun List<String>.longestElement() : String = this.sortedByDescending{it.length}[0]
fun Date.isLeapYear() : Boolean = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
fun Date.isValidDate() : Boolean = year in 1..9999 && month in 1..12 && day in 1..dayOfTheMonth()
fun Date.dayOfTheMonth() : Int {
    return when {
        month in listOf(1, 3, 5, 7, 8, 10, 12) -> 31
        month in listOf(4, 6, 9, 11) -> 30
        month == 2 && this.isLeapYear() -> 29
        else -> 28
    }
}