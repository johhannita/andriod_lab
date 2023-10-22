package main

class ItemService(private val itemRepository: ItemRepository) {
    fun selectRandomItems(numberOfItems: Int): List<Item> {
        var validNumberOfItems = numberOfItems
        while (validNumberOfItems > itemRepository.size() || validNumberOfItems < 1){
            println("The given number has to be between 1 and 10. " +
                    "Please enter a new number.")
            validNumberOfItems = readLine()?.toIntOrNull() ?: 0
        }
        val items = mutableListOf<Item>()
        while(items.size < validNumberOfItems){
            val item = itemRepository.randomItem()
            if(!items.contains(item)){
                items.add(item)
            }
        }
        return items
    }

}