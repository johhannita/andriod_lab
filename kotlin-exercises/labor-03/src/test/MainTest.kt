package test

import main.ItemController
import main.ItemRepository
import main.ItemService

fun main(){
    val itemRepository = ItemRepository
//    println("Random item: ${itemRepository.randomItem()}")

    val itemService = ItemService(itemRepository)
//    println(itemService.selectRandomItems(5))

    val itemController = ItemController(itemService)
    itemController.startQuiz()
}