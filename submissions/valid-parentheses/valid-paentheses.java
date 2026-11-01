import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i =0 ; i < s.length(); i++) {
            char current = s.charAt(i);
            if (stack.isEmpty() || Set.of('(','[','{').contains(current)){
                stack.push(current);
            }
            if (current == ')'){
                if (stack.peek()!= '(') return false;
                else stack.pop();
            }
            if (current == '}'){
                if (stack.peek()!= '{') return false;
                else stack.pop();
            }
            if (current == ']'){
                if (stack.peek()!= '[') return false;
                else stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
