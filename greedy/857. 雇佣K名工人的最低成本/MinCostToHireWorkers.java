class MinCostToHireWorkers {
	public double mincostToHireWorkers(int[] q, int[] w, int k) {
		double[][] workers = new double[q.length][2];
		for (int i = 0; i < q.length; i++) { //保存工人价性比
			workers[i] = new double[]{(double)(w[i]) / q[i], (double)q[i]};
		}
		Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0])); // 从小到达排列价性比
		double res = Double.MAX_VALUE;
		double qsum = 0.0; // qsum保存K个工人的质量和
		PriorityQueue<Double> pq = new PriorityQueue<>();
		for (double[] worker: workers) {
			qsum += worker[1];
			pq.add(-worker[1]); // 从大到小排列，每次把质量最高的排除掉
			if (pq.size() > k) qsum += pq.poll(); // 正负抵消
			if (pq.size() == k) res = Math.min(res, qsum * worker[0]);
       }
       return res;
   }
}