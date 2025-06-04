class AnswerString {
    public String answerString(String word,int numFriends) {
        if(numFriends==1){
            return word;
        }
        String maxSuffix=lastSubstring(word);
        int totalLen=word.length();
        int suffixLen=maxSuffix.length();

        return maxSuffix.substring(0,Math.min(suffixLen,totalLen-numFriends+1));
    }

    public String lastSubstring(String u) {
        int start=0,candidate=1,length=u.length();

        while(candidate<length) {
            int offset=0;

            while(candidate+offset<length && u.charAt(start+offset)==u.charAt(candidate+offset)) {
                offset++;
            }

            if(candidate+offset<length && u.charAt(start+offset)<u.charAt(candidate+offset)) {
                int prevStart=start;
                start=candidate;
                candidate=Math.max(candidate+1,prevStart+offset+1);
            } else {
                candidate+=offset+1;
            }
        }

        return u.substring(start);
    }
}
