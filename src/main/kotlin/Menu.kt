class Menu() {
  open val type : String
  open val mlist : MutableList<Item> = mutableListOf()
  open val actionList = mutableListOf<Pair<Int, () -> Unit>>()
  
  fun showMenu() {
    if (!lambdaList.isEmpty()) {
      lambdaList.forEach(println(lambdaList.first))
        println(lambdaList.first)
    }
  }
  fun selectMenu(nom : Int) {
    val action = actionList.find { it.first == nom }
    if (action != null) {
        action.second()
    } else {
        println("Действие '$name' не найдено!")
    }
  }

      

}
