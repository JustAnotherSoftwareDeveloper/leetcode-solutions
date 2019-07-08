import java.util.stream.Collectors
import java.util.stream.IntStream
import kotlin.concurrent.timer
import kotlin.system.measureTimeMillis


fun  main(args: Array<String>) {

        val tester = WordSearchTwo()
        //val board = arrayOf(charArrayOf('o','a','a','n'), charArrayOf('e','t','a','e'), charArrayOf('i','h','k','r'), charArrayOf('i','f','l','v'))
        //val board = arrayOf(charArrayOf('b','b','a','a','b','a'), charArrayOf('b','b','a','b','a','a'), charArrayOf('b','b','b','b','b','b'), charArrayOf('a','a','a','b','a','a'), charArrayOf('a','b','a','a','b','b'))
        //val board = arrayOf(charArrayOf('a','b'), charArrayOf('a','a'))
        val board = arrayOf(charArrayOf('b','a','a','b','a','b'),charArrayOf('a','b','a','a','a','a'),charArrayOf('a','b','a','a','a','b'),charArrayOf('a','b','a','b','b','a'),charArrayOf('a','a','b','b','a','b'),charArrayOf('a','a','b','b','b','a'),charArrayOf('a','a','b','a','a','b'))
        //val board = arrayOf(charArrayOf('a'))

        //val words = arrayOf("oath","pea","eat","rain")
        //val words = arrayOf("ab","ac","abb","acb")
        //val words = arrayOf("abbbababaa")
        //val words = arrayOf("aba","baa","bab","aaab","aaaa","aaba","aaa")
        val words = arrayOf("bbaabaabaaaaabaababaaaaababb","aabbaaabaaabaabaaaaaabbaaaba","babaababbbbbbbaabaababaabaaa","bbbaaabaabbaaababababbbbbaaa","babbabbbbaabbabaaaaaabbbaaab","bbbababbbbbbbababbabbbbbabaa","babababbababaabbbbabbbbabbba","abbbbbbaabaaabaaababaabbabba","aabaabababbbbbbababbbababbaa","aabbbbabbaababaaaabababbaaba","ababaababaaabbabbaabbaabbaba","abaabbbaaaaababbbaaaaabbbaab","aabbabaabaabbabababaaabbbaab","baaabaaaabbabaaabaabababaaaa","aaabbabaaaababbabbaabbaabbaa","aaabaaaaabaabbabaabbbbaabaaa","abbaabbaaaabbaababababbaabbb","baabaababbbbaaaabaaabbababbb","aabaababbaababbaaabaabababab","abbaaabbaabaabaabbbbaabbbbbb","aaababaabbaaabbbaaabbabbabab","bbababbbabbbbabbbbabbbbbabaa","abbbaabbbaaababbbababbababba","bbbbbbbabbbababbabaabababaab","aaaababaabbbbabaaaaabaaaaabb","bbaaabbbbabbaaabbaabbabbaaba","aabaabbbbaabaabbabaabababaaa","abbababbbaababaabbababababbb","aabbbabbaaaababbbbabbababbbb","babbbaabababbbbbbbbbaabbabaa")
        //val words = arrayOf("a")
        val solution = tester.findWords(board,words)

        println(solution)

    }
