import java.util.*;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();
        Set<Character> openChars = new HashSet<>();
        openChars.add('(');
        openChars.add('[');
        openChars.add('{');
        Map<Character,Character> correspondingChars = new HashMap<>();
        correspondingChars.put(')','(');
        correspondingChars.put('}', '{');
        correspondingChars.put(']','[');
        for (Character c: s.toCharArray()) {
            if (openChars.contains(c)) {
                charStack.push(c);
            }
            else if (!charStack.isEmpty() && correspondingChars.get(c) == charStack.peek()) {
                charStack.pop();
            }
            else {
                return charStack.isEmpty();
            }
        }
        return true;
    }
}
