class IsoMorphicStrings {

    fun isIsomorphic(s: String, t: String): Boolean {
        val charMap = mutableMapOf<Char,Char>()
        val charSet = mutableSetOf<Char>()
        for (i in s.indices) {
            val sAt = s[i]
            val tAt = t[i]
            if (charMap.containsKey(sAt)) {
                if (charMap[sAt] != tAt) {
                    return false
                }
            }
            else {
                if (charSet.contains(tAt)) {
                    return false
                }
                charMap[sAt] = tAt;
                charSet.add(tAt)
            }
        }
        return true;
    }
}