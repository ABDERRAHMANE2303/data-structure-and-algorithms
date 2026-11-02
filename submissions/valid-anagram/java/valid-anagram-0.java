import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] frequencies = new int[26];
        for  (int i=0; i<s.length(); i++){
            frequencies[s.charAt(i) - 'a'] += 1;
            frequencies[t.charAt(i) - 'a'] -=1;
        }
        return Arrays.equals(frequencies, new int[26]);
    }
}