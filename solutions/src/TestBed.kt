import java.util.stream.Collectors
import java.util.stream.IntStream
import kotlin.concurrent.timer
import kotlin.system.measureTimeMillis


fun  main(args: Array<String>) {
        println("Starting")
        var pre = intArrayOf(5,0,-5,-10,-1,3,2,4,10,7,6,8,20,15,25)
        val tester = ConstructBinaryTreeFromTraversals()
        tester.inOrderTraverse(tester.constructFromPre(pre))



    }
