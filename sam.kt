//Using lambdas for Single Access Method (or SAM) conversions in Kotlin

/*
If you need to provide an instance of an interface with a single abstract method,
SAM conversion lets us use a lambda to represent that interface rather than
having to instantiate a new class instance to implement the interface.
 */


fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

fun interface Observer<T> {
    fun onChanged(t: T)
}


fun main() {
    /*
    val observer = object: Observer<String> {
        override fun onChanged(t: String) {
            println("$t")
        }
    }
     */

    val observer = Observer<String> {
        println("$it")
    }

    observer.onChanged("test")
}

