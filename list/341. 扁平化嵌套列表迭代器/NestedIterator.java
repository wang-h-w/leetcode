public class NestedIterator implements Iterator<Integer> {

	private List<Integer> list = new ArrayList<>();
	private int index;

	private void addToList(List<NestedInteger> nestedList) {
		for (NestedInteger i : nestedList) {
        	if (i.isInteger()) list.add(i.getInteger());
        	else addToList(i.getList());
        }
	}

    public NestedIterator (List<NestedInteger> nestedList) {
        addToList(nestedList);
        index = 0;
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }
}