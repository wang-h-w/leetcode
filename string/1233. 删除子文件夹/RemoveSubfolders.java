class RemoveSubfolders {
	public List<String> removeSubfolders(String[] folder) {
		Arrays.sort(folder);
		List<String> res = new LinkedList<>();
		String prev = "null";
		for (String s : folder) {
			if (s.startsWith(prev + "/")) continue;
			res.add(s);
			prev = s;
		}
		return res;
	}
}