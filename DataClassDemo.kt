data class User(val name: String, val age: Int)
{
    var email: String = ""
}
fun dataClassDemo()
{
    val jon = User("John", 10)
    val jon1= jon
    println(jon == jon1)
    println(jon.toString())
    println(jon.name)
    println(jon.component2())
}