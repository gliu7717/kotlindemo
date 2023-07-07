import kotlinx.coroutines.*
import java.util.concurrent.Semaphore
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.thread

fun main(args: Array<String>) {
    //1
    object : Thread() {
        override fun run() {
            sleep(15)
            val ct = currentThread()
            println("thread1: $ct")
        }
    }.start()

    // 2
    val t = Thread {
        Thread.sleep(10)
        val ct = Thread.currentThread()
        println("thread2: $ct")
    }
    t.isDaemon = false
    t.name = "my-thread-"
    t.priority = 2
    t.start()

    // 3
    thread(start = true, isDaemon = false, name = "my-thread--", priority = 3) {
        Thread.sleep(5)
        val ct = Thread.currentThread()
        println("thread3: $ct")
    }

    //thread_test()
    //coroutintest()
}

var sum = 0
fun thread_test(){
    var threads = ArrayList<Thread>()
    for(i in 1..100){
        val thread = Thread{
            accumulate(1)
        }
        threads.add(thread)
        thread.start()
    }
    //Thread.sleep(10)
    threads.forEach {
        it.join()
    }
    println(sum)
}

@Synchronized
fun accumulate(i: Int){
    sum += i
}


var shareSum = 0
var atomicShareSum = AtomicInteger(0)
var lockedshareSum = 0
var shareSum_semLock = 0
fun coroutintest () = runBlocking {
    var coroutines = listOf<Job>()

    val scope = CoroutineScope(newFixedThreadPoolContext(8, "sizeFixedThreadPool"))
    scope.launch {
        coroutines = 1.rangeTo(100).map {
            launch {
                for(i in 1..100){
                    //shareSum += 1
                    accumulateShareSum()
                    atomicAccumulateShareSum()
                    accumulateShareSumWithLock()
                    accumulateShareSum_semlock()
                }
            }
        }
        coroutines.forEach {
            it.join()
        }
    }.join()
    println(" 10000, $shareSum")   // 10000, 9952
    println(" 10000, $atomicShareSum")
    println(" 10000, $lockedshareSum")
    println(" 10000, $shareSum_semLock")
}
@Synchronized
fun accumulateShareSum(){
    shareSum += 1
}

fun atomicAccumulateShareSum(){
    atomicShareSum.incrementAndGet()
}

val reentrantLock = ReentrantLock()
fun accumulateShareSumWithLock(){
    reentrantLock.lock()
    try {
        lockedshareSum += 1
    } finally {
        reentrantLock.unlock()
    }
}

val semaphore = Semaphore(1)
fun accumulateShareSum_semlock(){
    try {
        semaphore.acquire()
        shareSum_semLock += 1
    } finally {
        semaphore.release()
    }
}
