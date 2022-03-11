package algorithm.src;

public class String_Is_Subsequence_392 {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) return false;
        int sLen = s.length(), tLen = t.length();
        if (sLen > tLen) return false;
        int target = 0, sample = 0;
        while (sample < sLen && target < tLen) {
            if (t.charAt(target) != s.charAt(sample)) target++;
            else { target++; sample++; }
        }
        return sample == sLen;
    }
}
