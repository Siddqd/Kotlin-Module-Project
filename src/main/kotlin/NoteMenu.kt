class NoteMenu(val note : Note) {
    fun start() {
        var nom : Int?
        while (true) {
            showMenu()
            nom = readlnOrNull()?.toIntOrNull()
            when (nom) {
                0 -> println(note.text)
                1 -> break
                null -> println("Введите число!")
                else -> println("Пункта меню с таким номер нет ...")
            }
        }
    }

    fun showMenu() {
        println("Меню просмотра заметки: ${note.name}")
        println("0. Вывести текст заметки")
        println("1. Назад")
    }
}