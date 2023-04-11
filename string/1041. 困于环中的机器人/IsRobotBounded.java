class IsRobotBounded {
	public boolean isRobotBounded(String instructions) {
		int x = 0, y = 0, d = 0; // 0-N, 1-E, 2-S, 3-W
		for (int i = 0; i < instructions.length(); i++) {
			char c = instructions.charAt(i);
			if (c == 'G') {
				if (d == 0) y++;
				else if (d == 1) x++;
				else if (d == 2) y--;
				else if (d == 3) x--;
			} else if (c == 'L') {
				d = (d + 3) % 4;
			} else if (c == 'R') {
				d = (d + 5) % 4;
			}
		}
		return (x == 0 && y == 0) || d != 0;
	}
}