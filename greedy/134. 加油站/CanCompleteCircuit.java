class CanCompleteCircuit {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int neg = 0, pos = 0, start = 0;
		boolean flag = true;
		for (int i = 0; i < gas.length; i++) {
			pos += gas[i];
			if (pos < cost[i]) {
				neg += pos - cost[i];
				pos = 0;
				flag = true;
				continue;
			}
			if (flag) {
				start = i;
				flag = false;
			}
			pos -= cost[i];
		}
		if (pos + neg >= 0) return start;
		else return -1;
	}

	public static void main(String[] args) {
		CanCompleteCircuit circuit = new CanCompleteCircuit();
		int[] gas = new int[] {1,2,3,4,5};
		int[] cost = new int[] {3,4,5,1,2};
		System.out.println(circuit.canCompleteCircuit(gas, cost));
	}
}