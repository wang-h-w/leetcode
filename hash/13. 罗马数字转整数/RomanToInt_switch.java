public class RomanToInt_switch {
	/**
	 * 方法体中的循环，尽量提高重复变量的利用率
	 */
	public int romanToInt(String s) {
		int result = 0;
		int preNum = getValue(s.charAt(0));

        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                result -= preNum;
            } else {
                result += preNum;
            }
            preNum = num;
        }
        result += preNum;

		return result;
	}

	private int getValue(char c) {
		switch(c) {
			case 'I': return 1;
			case 'V': return 5;
			case 'X': return 10;
			case 'L': return 50;
			case 'C': return 100;
			case 'D': return 500;
			case 'M': return 1000;
		}
		return 0;
	}

	public static void main(String[] args) {
		String s = "MCMXCIV";
		RomanToInt_HashMap r = new RomanToInt_HashMap();
		System.out.println(r.romanToInt(s));
	}
}