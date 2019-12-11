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
            else {
                Character topElement = charStack.empty() ? '#' : charStack.pop();
                if (topElement != correspondingChars.get(c)) {
                    return false;
                }
            }
        }
        return charStack.isEmpty();
    }
}
