class Solution {
    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = s.split(" ");
        for(int i =0;i<words.length;i++){
            for(int j=words[i].length()-1;j>=0;j--){
                stringBuilder.append(words[i].charAt(j));
            }
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }
}
