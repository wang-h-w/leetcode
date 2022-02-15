import java.util.Stack;

class IsValid_stack {
	public boolean isValid(String s) {
        Stack<Character>stack = new Stack<Character>();
        for(char c: s.toCharArray()){
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
		IsValid_switch v = new IsValid_switch();
		String s = "){";
		if (v.isValid(s)) {
			System.out.println("valid");
		} else {
			System.out.println("not valid");
		}
	}
}