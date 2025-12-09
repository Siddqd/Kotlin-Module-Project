class ArhivesMenu : Menu () {

  @override actionList = MutableListOf <Pair<Int,()-> Unit>> (
    0 to { createArchive() }
    1 to { break }
  )
    
  @override fun showMenu() {
    println("Список архивов:")
    println("0. Создать архив")
    super.showMenu()
    prinln(mlist.size + 1 + ". Выход")
  }

  fun addArchive() {
    println("Введите название архива:")
    val nameArch : String = readline()
    val size = actionList.size
    mlist.add(Archive(nameArch))
    actionList.removeAt(size-1)
    actionList.add(size-1 to { mlist(size).showMenu() })
    actionList.add(size to { break })
    
  }

  
}
