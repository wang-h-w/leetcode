class MinNumberOfHours {
	public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int experience) {
		int sum = 0, res = 0;
		for (int e : energy) sum += e;
		if (initialEnergy <= sum) res += sum + 1 - initialEnergy;
		for (int e : experience) {
			if (initialExperience <= e) {
				res += e + 1 - initialExperience;
				initialExperience = e + 1;
			}
			initialExperience += e;
		}
		return res;
	}
}