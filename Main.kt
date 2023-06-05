import java.io.File

fun main(args: Array<String>) {
    val from  =MyPoint(1,2)
    val to =  MyPoint(3,4)
    val line = Line(from,to)
    var shape = Shape()
    drawShape(shape)
    drawShape(line)
}
/*
fun main(args: Array<String>) {

println("Hello World!")
args.map(::println)

// Try adding program arguments via Run/Debug configuration.
// Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
println("Program arguments: ${args.joinToString()}")
println(ifExpressionDemo(2))

val v = whenExpress(1)
println(v)
rangesDemo()
listRangeDemo()
simpleLambdaDemo()
dataClassDemo()
drawShape()
val files = File("Test").listFiles()

println(files?.size?: "empty") // size is printed if files is not null

infixFuncDemo()
}
*/
fun ifExpressionDemo(x:Int):String
{
    return if (x == 1) {
        "one"
    } else if (x == 2) {
        "two"
    } else {
        "other"
    }
}
fun whenExpress(obj: Any): String =
    when (obj) {
        1          -> "One"
        "Hello"    -> "Greeting"
        is Long    -> "Long"
        !is String -> "Not a string"
        else       -> "Unknown"
    }
fun rangesDemo()
{
    val grade = 11
    if (grade in 10..12) {
        println("can be high school student.")
    }
    for (oddNum in 1..100 step 2) {
        print(oddNum)
        print(' ')
    }
    println()
}

fun listRangeDemo() {
    val list = listOf("a", "b", "c")

    for (item in list) {
        println(item)
    }

    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range, too")
    }
}

fun simpleLambdaDemo()
{
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { println(it) }

    for (item in fruits) {
        println(item)
    }

    when {
        "orange" in fruits -> println("juicy")
        "apple" in fruits -> println("apple is fine too")
    }
}
fun canReturnNull(v: Any): Int?
{
    if (v is String) {
        // `v` is automatically cast to `String` in this branch
        return v.length
    }
    return null
}

class Person(val name: String) {
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) { likedPeople.add(other) }  // 6
}
fun infixFuncDemo()
{
    infix fun Int.times(str: String) = str.repeat(this)        // 1
    println(2 times "Bye ")                                    // 2

    val pair = "Ferrari" to "Katrina"                          // 3
    println(pair)

    infix fun String.onto(other: String) = Pair(this, other)   // 4
    val myPair = "McLaren" onto "Lucas"
    println(myPair)

    val sophia = Person("Sophia")
    val claudia = Person("Claudia")
    sophia likes claudia                                       // 5
}