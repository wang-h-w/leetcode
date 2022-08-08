import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
	Iterator<Integer> iter;
	Integer next;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		iter = iterator;
		if (iter.hasNext()) next = iter.next();
	}

	 // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		Integer temp = next;
		next = iter.hasNext() ? iter.next() : null;
		return temp;
	}

	@Override
	public boolean hasNext() {
		return next != null;
	}
}