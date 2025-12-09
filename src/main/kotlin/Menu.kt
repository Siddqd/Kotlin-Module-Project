open class Menu<E : Item>() {
  open val mlist : MutableList<E> = mutableListOf()
  open val actionList = mutableListOf<Pair<Int, () -> Unit>>()
  
  open fun showMenu() {
    if (!mlist.isEmpty()) {
      mlist.forEachIndexed{i, value -> println((i+1).toString() + ". " + value.name)}
    }
  }

  fun selectMenu(nom : Int) {
    val action = actionList.find { it.first == nom }
    action!!.second()
  }

  open fun start() {
    var nom : Int?
    while (true) {
      showMenu()
      nom = readlnOrNull()?.toIntOrNull()
      if(nom == null) {
        println("Введите число!")
      } else if (actionList.find {it.first == nom} == null) {
        println("Пункта меню с таким номер нет ...")
      } else {
        break
      }
    }
    actionList.find{it.first == nom}!!.second()
    }
  }

      


