import java.util.*;

public class ValidParentheses {

    private Map<Character, Character> closingKeys = new HashMap<>();

    private void loadClosingKeys(){
        closingKeys.put('{','}');
        closingKeys.put('(',')');
        closingKeys.put('[',']');
        closingKeys.put('<','>');
    }

    private boolean isClosingKey(char key){
        return closingKeys.get(key) == null;
    }

    public boolean isValid(String text){

        loadClosingKeys();
        if(text.compareTo("") == 0)
            return true;

        char[] textArray = text.toCharArray();

        Deque<Character> stack = new ArrayDeque<>();

        for(char c : textArray) {
            if(isClosingKey(c)){

                if(stack.isEmpty())
                    return false;

                char previousKey = stack.peek();
                char closingKey = closingKeys.get(previousKey);

                if(c == closingKey){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }


}
