import java.util.Scanner;
import java.util.Stack;

public class Balanced {
    static boolean isBalanced(String str) {
        if (str.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        stack.push(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(str.charAt(i));
                continue;
            }

            char top = stack.peek();
            char c = str.charAt(i);

            if (c == ']' && top == '[') {
                stack.pop();
                continue;
            }

            if (c == '}' && top == '{') {
                stack.pop();
                continue;
            }

            if (c == ')' && top == '(') {
                stack.pop();
                continue;
            }

            stack.push(c);
        }

        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (isBalanced(input)) {
            System.out.println("balanced");
        } else {
            System.out.println("not balanced");
        }
    }
}
