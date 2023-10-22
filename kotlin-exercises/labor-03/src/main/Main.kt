package main

fun main() {
    val itemRepository = ItemRepository
    val itemService = ItemService(itemRepository)
    val itemController = ItemController(itemService)
    itemController.startQuiz()
}