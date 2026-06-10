class Solution {
public int strStr(String haystack, String needle) {
int n1 = haystack.length();
int n2 = needle.length();


for (int i = 0; i <= n1 - n2; i++) {

if (compare(haystack, needle, i)) {
return i;
}
}
return -1;
}


private boolean compare(String haystack, String needle, int start) {
for (int i = 0; i < needle.length(); i++) {
if (haystack.charAt(start + i) != needle.charAt(i)) {
return false;
}
}
return true;
}
}
