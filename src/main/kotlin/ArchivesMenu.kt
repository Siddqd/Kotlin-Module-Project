import kotlin.system.exitProcess

class ArchivesMenu : Menu<Archive>() {
  override val mlist: MutableList<Archive> = mutableListOf()
  override val actionList = mutableListOf<Pair<Int, () -> Unit>>(
      0 to {
        addArchive()
        start()
      },
      1 to { exitProcess(0) },
  )
    
  override fun showMenu() {
    println("Список архивов:")
    println("0. Создать архив")
    super.showMenu()
    println((mlist.size + 1).toString() + ". Выход")
  }

  fun addArchive() {
    println("Введите название архива:")
    val nameArch : String = readln()
    if (nameArch == null || nameArch.isEmpty()) {
      println("Ошибка! Пустое имя архива")
      return
    }
    val size : Int = actionList.size
    mlist.add(Archive(nameArch))
    actionList.removeAt(size-1)
    actionList.add(size-1 to { viewArchive(mlist[size-2])})
    actionList.add(size to { exitProcess(0) })
  }

  fun viewArchive(archive: Archive) {
    val notesMenu = NotesMenu(archive)
    notesMenu.start()
    this.start()
  }

//  override fun start() {
//    var nom : Int?
//    while (true) {
//      showMenu()
//      nom = readlnOrNull()?.toIntOrNull()
//      if(nom == null) {
//        println("Введите число!")
//      } else if (actionList.find {it.first == nom} == null) {
//        println("Пункта меню с таким номер нет ...")
//      } else {
//        break
//      }
//    }
//    actionList.find{it.first == nom}!!.second()
//  }
  
}
