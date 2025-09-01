import java.util.Stack;

class Solution {
    public static boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == 'c') {
                
                if (st.size() < 2 || st.pop() != 'b' || st.pop() != 'a') {
                    return false;
                }
            } else {
                st.push(ch);
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("aabcbc"));   
       
    }
}

