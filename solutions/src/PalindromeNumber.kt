class PalindromeNumber {

    fun isPalindrome(x: Int ) : Boolean {
        if (x < 0) {
            return false;
        }

        var reversed = 0;
        var original = x ;
        do {
            reversed*=10;
            val toAdd = original % 10;
            reversed+=toAdd;
            original/=10;
        } while (original > 0)

        return reversed == x;
    }
}