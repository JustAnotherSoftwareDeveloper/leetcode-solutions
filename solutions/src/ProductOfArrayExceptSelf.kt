//https://leetcode.com/problems/product-of-array-except-self/
class ProductOfArrayExceptSelf {

    fun productExceptSelf(nums: IntArray): IntArray {
        var products = 1

        val productsUpTo =
        nums.map {
            products *= it
            products
        }
        products = 1
        val productsDownTo =
        nums.reversed().map {
            products*=it
            products
        }.reversed()



        return nums.mapIndexed{ index, _ ->
            val below = if (index > 0) productsUpTo[index-1] else 1
            val above = if (index < nums.lastIndex) productsDownTo[index+1] else 1
            below*above

        }.toIntArray()


    }
}