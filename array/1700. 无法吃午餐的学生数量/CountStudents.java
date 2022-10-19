class CountStudents {
	public int countStudents(int[] students, int[] sandwiches) {
		int ptr1 = 0, ptr2 = 0, n = students.length;
		boolean[] ate = new boolean[n];
		while (ptr2 < n) {
			int cnt = 0;
			while (cnt < n - ptr2) {
				while (ate[ptr1]) ptr1 = ptr1 < n - 1 ? ptr1 + 1 : 0;
				if (students[ptr1] != sandwiches[ptr2]) {
					ptr1 = ptr1 < n - 1 ? ptr1 + 1 : 0;
					cnt++;
				} else break;
			}
			if (cnt >= n - ptr2) break;
			ate[ptr1] = true;
			ptr2++;
		}
		return n - ptr2;
	}

	public static void main(String[] args) {
		CountStudents count = new CountStudents();
		System.out.println(count.countStudents(new int[] {1,1,0,0}, new int[] {0,1,0,1}));
		System.out.println(count.countStudents(new int[] {1,1,1,0,0,1}, new int[] {1,0,0,0,1,1}));
	}
}