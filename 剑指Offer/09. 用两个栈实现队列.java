import java.util.Deque;
import java.util.LinkedList;

class CQueue {
	private Deque<Integer> in, out;

	public CQueue() {
		in = new LinkedList<>();
		out = new LinkedList<>();
	}

	public void appendTail(int value) {
		in.push(value); // equal to offerFirst()/addFirst()
	}

	public int deleteHead() {
		if (out.isEmpty()) while (!in.isEmpty()) out.push(in.poll());
		if (out.isEmpty()) return -1;
		else return out.poll(); // equal to pollFirst()/removeFirst()
	}
}