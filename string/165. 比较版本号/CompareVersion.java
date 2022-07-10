class CompareVersion {
	public int compareVersion(String version1, String version2) {
		int i = 0, j = 0;
		while (i < version1.length() || j < version2.length()) {
			int a = 0, b = 0;
			while (i < version1.length() && version1.charAt(i) != '.') a = a * 10 + version1.charAt(i++) - '0';
			while (j < version2.length() && version2.charAt(j) != '.') b = b * 10 + version2.charAt(j++) - '0';
			if (a < b) return -1;
			else if (a > b) return 1;
			i++;
			j++;
		}
		return 0;
	}

	public static void main(String[] args) {
		CompareVersion c = new CompareVersion();
		System.out.println(c.compareVersion("1.01", "1.001"));
	}
}