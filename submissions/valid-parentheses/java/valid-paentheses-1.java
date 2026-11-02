import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character,Character> parentheses = Map.of(
            '(',')',
            '[',']',
            '{','}'
        );
        for (int i =0 ; i < s.length(); i++) {
            char current = s.charAt(i);
            if (parentheses.containsKey(current)){
                stack.push(current);
            }else{
                if (stack.isEmpty() || parentheses.get(stack.pop()) != current ){
                    return false;
                }
            }
            
        }
        return stack.isEmpty();
    }
}