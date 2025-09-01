import java.util.Stack;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 1) {
            return pushed[0] == popped[0];
        }

        int popIndex = 0;
        Stack<Integer> st = new Stack<>();

        for (int ele : pushed) {
            st.push(ele);

            while (!st.isEmpty() && st.peek() == popped[popIndex]) {
                st.pop();
                popIndex++;
            }
        }
        return st.isEmpty();
    }
}

