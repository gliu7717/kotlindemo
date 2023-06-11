interface MyInterface {
    fun bar()
    fun foo() {
        println("foo")
    }

    // fun hello()
}

class MyImpl : MyInterface {
    override fun bar() {
        println("bar")
    }
    override fun foo() {
        println("overrid foo")
    }
}
fun main(args: Array<String>) {
    val c =  MyImpl()
    c.foo();
    c.bar();
}
