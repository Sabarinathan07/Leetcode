class Solution {
    public String shortestPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;
        while (j > 0 && i < s.length() - 1) {
            // System.out.println(s.charAt(i) + " number. " + s.charAt(j));

            int temp = j;
            while (i < temp && s.charAt(i) == s.charAt(temp)) {

                // System.out.println(i + " another num " + temp+" j. "+j);
                if (i == temp || i + 1 == temp) {
                    System.out.println(s.substring(j, s.length()) + s);
                    return s.substring(j, s.length()) + s;
                }
                System.out.println(s.substring(j, s.length()) + s);
                i = i + 1;
                temp = temp - 1;

            }

            System.out.println(i + "  another num j  " + j + "" + i);
            j--;
        }
        return "h";
    }

}