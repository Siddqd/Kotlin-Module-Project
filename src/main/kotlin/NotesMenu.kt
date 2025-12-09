import kotlin.system.exitProcess

class NotesMenu(val archive : Archive) : Menu<Note>() {
    override val mlist: MutableList<Note> = archive.notes
    override val actionList = mutableListOf<Pair<Int, () -> Unit>>(

    )
    //убрать в class Menu?
    init {
        actionList.add(0 to {
            addNote()
            start()
        },)
        mlist.forEachIndexed { index, note ->
            actionList += (index + 1) to { viewNote(note) }
        }
        actionList += (mlist.size + 1) to {}
    }

    override fun showMenu() {
        println("Список заметок архива ${archive.name}:")
        println("0. Создать заметку")
        super.showMenu()
        println((mlist.size + 1).toString() + ". Назад")
    }

//    override fun start() {
//        showMenu()
//    }
    fun viewNote(note: Note) {
        val noteMenu = NoteMenu(note)
        noteMenu.start()
        this.start()
    }

    fun addNote() {
        println("Введите название заметки:")
        val nameNote : String = readln()
        if (nameNote == null || nameNote.isEmpty()) {
            println("Ошибка! Пустое имя заметки")
            return
        }
        println("Введите текст заметки:")
        val textNote : String = readln()
        if (nameNote == null || nameNote.isEmpty()) {
            println("Ошибка! Пустой текст заметки")
            return
        }
        val size = actionList.size
        mlist.add(Note(nameNote, textNote))
        actionList.removeAt(size-1)
        actionList.add(size-1 to { viewNote(mlist[size-2]) })
        actionList.add(size to {})
    }

    fun updateActionList() {

    }
}