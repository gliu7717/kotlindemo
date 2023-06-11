

/* before java 8, no lamda function, if I want to write a button click listener call back function, we should write this

button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    }
});

After java 8, we can write this simple code with lambda

button.setOnClickListener(v -> {

}); with java8
or even simpler code in kotlin
button.setOnClickListener {
}

lambda is no name class, it makes the code simple and clean, easpiecally for the method with sinlge parameter.
 */

fun lamda_expression()
{
    // format
    // {（parameters）-> return_type }
    // var l = {x:Int -> "$x"}    == > （Int）-> String

    val simpleLambda : () -> Unit = { println("Hello") }
    // can be simplified to
    // val simpleLambda = { println("Hello") }

    val lambda1 = { println("Hello Lambdas") }

    val lambda2 : (String) -> Unit = { name: String ->
        println("My name is $name")
    }

    lambda1()
    lambda2("Gerry")

    var addFive = { x: Int -> x + 5 }
    var s = addFive.invoke(5)
    println(s)
    println(addFive(5))

    val sum = {x:Int, y:Int ->x+y}
    println(sum(1,2))


    // create a filtered list of even values
    val vals = listOf(1, 2, 3, 4, 5, 6).filter { num ->
        num.mod(2) == 0
    }
    val vals1 = listOf(1, 2, 3, 4, 5, 6).filter({ it.mod(2) == 0 })
    val vals2 = listOf(1, 2, 3, 4, 5, 6).filter{ it.mod(2) == 0 }

    println (vals.toString())
    for (element in vals1) {
        println(element)
    }
    println (vals2.toString())
    //In this case, everything after the call to .filter is the lambda.

    val lambda_m1 : (String, String) -> String = { first: String, last: String ->
        "My name is $first $last"
    }
    val lambda_m2 = { first: String, last: String ->
        "My name is $first $last"
    }
    val lambda_m3 : (String, String) -> String = { first, last ->
        "My name is $first $last"
    }
}

//
fun convert(x:Double,   converter:(Double)->Double): Double {
    val result  = converter(x)
    return result
}

// return a lambda function
fun getLambda(x:Int):(Int)->Int
{
    if(x == 0){
        return {it * 10}
    }else{
        return {it * 20}
    }
}

fun combine(lambda1:(Double)->Double, lambda2:(Double)->Double) : (Double)->Double{
    return {x:Double -> lambda2(lambda1(x))}
}


fun main(args: Array<String>) {
    println("Let's talk about lambda function")
    lamda_expression()

    println(convert(10.0, { x:Double-> x+10 } ))
    println(convert(10.0) {x:Double->x+10} )

    val m = getLambda(0)
    println(m(10))
    val n = getLambda(1)
    println(n(10))


    val l1 = {x:Double -> x*2}
    val l2 = {x:Double -> x/4}
    val combine = combine(l1,l2)
    println(combine(10.0))

    // this is if expression, not a lambda
    var name = "gerry"

    val greeting = if(name.isNullOrBlank()) {
        "Hello you!"
    } else {
        "Hello $name"
    }
}
