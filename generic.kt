class Stack<T>(vararg items: T) {

    val elements = items.toMutableList()

    fun push(element: T) {
        elements.add(element)
    }

    fun pop(): T? {
        if (!isEmpty()) {
            return elements.removeAt(elements.size - 1)
        }
        return null
    }

    fun isEmpty(): Boolean {
        return elements.isEmpty()
    }
}

fun <T> stackOf(vararg elements: T): Stack<T> {
    return Stack(*elements) // spread opeator *
}


fun main() {
    val stack = Stack(3,4,2,6)
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
    println(stack.pop()) // null

    val stack2 = stackOf("HI", "Hello", "Bye")

    for(i in 1..3) {
        println(stack2.pop())
    }
}