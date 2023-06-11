abstract class A{
    open var test = 10
    open fun x(): Int = 5
}

interface B{
    var testb:Int
    fun x(): Int = 1
}

interface C{
    var testc:Int
    fun x(): Int = 0
}

class D(var y: Int = 0):A() ,B,C{
    override var test = 20
    override var testb = 20
    override var testc = 20

    override fun x(): Int {
        println("call x(): Int in D")
        if (y > 0){
            return y
        }else if (y < -200){
            return super<C>.x()
        }else if (y < -100){
            return super<B>.x()
        }else{
            return super<A>.x()
        }
    }
}

fun main(args: Array<String> ) {
    println(D(3).x())
    println(D(-10).x())
    println(D(-110).x())
    println(D(-230).x())
}
