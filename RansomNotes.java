/*Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int a[] = new int[26];
        int b[] = new int[26];
        magazine.codePoints().forEach(ch -> {
            a[ch-97]++;
        });
        ransomNote.codePoints().forEach(ch -> {
            b[ch-97]++;
        });
        
        for(int i = 0; i < 26; i++) {
            // debug
            //System.out.println("a[" + i + "]=" + a[i] + ", b["+ i +"]=" + b[i]);
            if(b[i] > 0 && (a[i] - b[i]) < 0) {
                return false;
            }
        }
        return true;
    }
}
