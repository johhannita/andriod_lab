package main

import java.util.Base64
import kotlin.random.Random

fun main(args: Array<String>) {
    println("1.====")
    val sum = 2 + 3
    var sum2 = 6 + 8
    sum2 = 15
    val test: Int = 949956
    println("sum=$sum")
    println("sum2=$sum2")
    println("testInt=$test")

    val testArray = listOf(2,3,4)
    val daysOfTheWeek = listOf("Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday", "Sunday")
    println(testArray)
    println(daysOfTheWeek)

    println("2.====")
    for(day: String in daysOfTheWeek){
        println(day)
    }

    println("======")
    daysOfTheWeek.filter{
        it.startsWith("T")
    }.forEach{
        println(it)
    }
    println("======")


    daysOfTheWeek.filter{
        it.contains("e")
    }.forEach{
        println(it)
    }
    println("======")


    daysOfTheWeek.filter{
        it.length == 6
    }.forEach{
        println(it)
    }
    println("======")
    println("3.====")
    for(i in 1..100){
        if(isPrime(i)){
            println(i)
        }
    }
    println("======")
    println("4.====")
    val codedName = encode("Johanna")
    println(codedName)
    println(decode(codedName))

    println("5.====")
    val list: List<Int> = listOf(1,2,23,45,7,6,79)
    println(evenNumbers(list))

    println("6.====")
    println(list.map{it*2})
    println(daysOfTheWeek.map{it.uppercase()})
    println(daysOfTheWeek.map{it.replaceFirstChar {it.uppercase()  }})
    println(daysOfTheWeek.map{it.length})
    println(daysOfTheWeek.map{it.length}.average())
    
    println("7.====")
    val copyDaysOfTheWeek = daysOfTheWeek.toMutableList().filter{!it.contains('n')}
    println(copyDaysOfTheWeek)

    for((index, value) in copyDaysOfTheWeek.withIndex()) {
        println("Item at $index is value $value")
    }

    println(copyDaysOfTheWeek.sorted())

    println("8.====")
    val randomArray = IntArray(10) {Random.nextInt(0, 100)}
    randomArray.forEach{ println(it) }
    println(randomArray.sorted())
    println("The list contains an even number: ${randomArray.any{it%2==0}}")
    println("All of the element of the list is an even number: ${randomArray.all{it%2==0}}")
    var average: Double = 0.0
    randomArray.forEach { average += it.toDouble()/randomArray.size }
    println(average)
}

fun isPrime(num: Int): Boolean {
    if (num <= 1) {
        return false
    }
    if (num == 2) {
        return true
    }
    if (num % 2 == 0) {
        return false
    }

    val sqrt = Math.sqrt(num.toDouble()).toInt()
    for (i in 3..sqrt step 2) {
        if (num % i == 0) {
            return false
        }
    }

    return true
}

fun encode(s: String): String {
    return Base64.getEncoder().encodeToString(s.toByteArray())
}

fun decode(s: String): String {
    return String(Base64.getDecoder().decode(s))
}

fun evenNumbers(list: List<Int>): List<Int> = list.filter{it%2 == 0}

fun groupAnagrams(strings: Array<String>): List<List<String>> {
    val anagramGroups = mutableMapOf<String, MutableList<String>>()

    for (word in strings) {
        val keyString = word.lowercase().toCharArray().sorted().joinToString("")
        if (!anagramGroups.containsKey(keyString)) {
            anagramGroups[keyString] = mutableListOf()
        }
        anagramGroups[keyString]?.add(word.lowercase())
    }
    return anagramGroups.values.toList()
}