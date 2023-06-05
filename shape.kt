import java.awt.Point
import kotlin.math.sqrt

/*
abstract class shape {
    var  size= 0
    abstract fun draw()
    abstract fun update()
}
*/

open class Shape {
    var  size= 0
    open fun draw()
    {
        println("drawing a shape")
    }
    open fun update()
    {
        println("updating a shape")
    }
}
class MyPoint (var x:Int, var y: Int)
{

}

class Line (var start: MyPoint, var end:MyPoint): Shape()
{
    var length = sqrt(((end.y - start.y) * (end.y - start.y) + (end.x - start.x) * (end.y - start.x)).toDouble())

    init {
        println("First initializer block that prints $length")
    }

    val area = 0.0

    init {
        println("Second initializer block that prints ${area}")
    }

    constructor ( start: MyPoint,  end:MyPoint, l:Line): this( start,end)
    {
    }

    override fun draw() {
        println("drawing a line from : ${start.x}, ${start.y} to ${end.x}, ${end.y} length is $length")
    }
}

fun drawShape(shape:Shape)
{
    shape.draw()
}

fun drawShape()
{
    val myShape = object:Shape(){
        override  fun draw(){
            println("drawing a shape")
        }
        override  fun update(){
            println("updating a shape")
        }
    }
    myShape.draw()
    with(myShape)
    {
        draw()
        update()
    }

    myShape.apply {
        size=1
    }
}