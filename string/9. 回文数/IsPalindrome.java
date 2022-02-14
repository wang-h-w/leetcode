class IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = Integer.toString(x);
        return checkString(s);
    }

    public boolean checkString(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }
        return checkString(s.substring(1, s.length() - 1));
    }

    public static void main(String[] args) {
        IsPalindrome p = new IsPalindrome();
        int x = 123434321;
        if (p.isPalindrome(x)) {
            System.out.println("right!");
        } else {
            System.out.println("wrong!");
        }
    }
}