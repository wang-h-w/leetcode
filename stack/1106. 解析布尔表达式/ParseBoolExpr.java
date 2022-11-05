import java.util.Deque;

class ParseBoolExpr {
	public boolean parseBoolExpr(String expression) {
		Deque<Character> d = new LinkedList<>();
		char[] expr = expression.toCharArray();
		for (char c : expr) {
			if (c != ',' && c != ')') d.offerLast(c);
			else if (c == ')') {
				int t = 0, f = 0;
				while (d.peekLast() != '(') {
					char val = d.pollLast();
					if (val == 't') t++;
					else f++;
				}
				d.pollLast();
				char operator = d.pollLast();
				if (operator == '&') d.offerLast(f > 0 ? 'f' : 't');
				else if (operator == '|') d.offerLast(t > 0 ? 't' : 'f');
				else d.offerLast(t > 0 ? 'f' : 't');
			}
		}
		return d.pollLast() == 't' ? true : false;
	}
}