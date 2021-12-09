import java.util.*;

public class Valid_Parentheses_20 {
    private HashMap<Character, Character> mappings;

    public void Solution() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {
        //initialize a stack to be used
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //if current char is closing bracket
            if (this.mappings.containsKey(c)) {
                //get top ele, if stack is empty, set a dummy value #
                char topElement = stack.empty() ? '#' : stack.pop();
                //if mapping for this bracket doesn't match top element, return false
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                //if it's a opening bracket, push to stakc
                stack.push(c);
            }
        }
        //if stack still contains elements, it's valid
        return stack.isEmpty();
    }
}
