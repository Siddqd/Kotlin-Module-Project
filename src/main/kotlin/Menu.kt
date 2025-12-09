class Menu() {
  open val type : String
  open val mlist : MutableList<Item> = mutableListOf()
  open val actionList = mutableListOf<Pair<Int, () -> Unit>>()
  
  fun showMenu() {
    if (!mlist.isEmpty()) {
      mlist.forEachIndexed{i, value - > prinln(i+1 + " " + value.name)}
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
