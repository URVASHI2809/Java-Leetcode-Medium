class AddSpaces {
    public String addSpaces(String s, int[] spaces) {
        int n = s.length();
        int m = spaces.length;
        char[] newChrs = new char[n + m];
        char[] sChr = s.toCharArray();

        int i = 0, idx = 0;
        for (int spc : spaces) {
            while (i < spc) {
                newChrs[idx++] = sChr[i++];
            }
            newChrs[idx++] = ' ';
        }
        while (i < n) {
            newChrs[idx++] = sChr[i++];
        }
        return new String(newChrs);
    }
    public static void main(String[] args) {
        AddSpaces space = new AddSpaces();
        String s = "LeetcodeHelpsMeLearn";
        int[] spaces = {8,13,15};
        String result = space.addSpaces(s, spaces);
        System.out.println(result);
    }
}
