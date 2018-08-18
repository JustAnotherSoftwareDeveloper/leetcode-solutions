import java.util.*

class Rand10 {
    //https://leetcode.com/problems/implement-rand10-using-rand7/description/
     fun rand7() : Int {
         return 1 + Random().nextInt(6)
     }

     fun rand10(): Int {
         var randVal: Int;
         do {
             val rand1 = rand7()
             val rand2 = rand7()
             randVal = rand1 + (rand2 -1)*7

         } while (randVal > 40)
         return 1 + (randVal -1) % 10
     }
}