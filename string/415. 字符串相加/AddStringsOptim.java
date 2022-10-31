class AddStrings {
	public String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while(i >= 0 || j >= 0 || carry != 0){
            if (i>=0) carry += num1.charAt(i--) - '0';
            if (j>=0) carry += num2.charAt(j--) - '0';
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
	}

	public static void main(String[] args) {
		AddStrings as = new AddStrings();
		System.out.println(as.addStrings("11","123"));
		System.out.println(as.addStrings("456","77"));
		System.out.println(as.addStrings("100000","999999"));
	}
}