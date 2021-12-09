//http://www.thealmightyguru.com/Wiki/index.php?title=Caesar_cipher
//https://www.hackerrank.com/challenges/caesar-cipher-1/problem

public class Caesar_Cipher {
    //given a String, and int k, move k steps every element in String clockwise
    // sample: encrypted = 'VTAOG' k = 2
    //output: 'TRYME'
    //对String元素做操作，一定要用charAt()
    //algo:
    // 1. use StringBuilder to store temp result, cause String is immutable, and return sb.toString
    // 2. iterate every element in String:
    //    2.1 for each element in String, use .charAt() to c

    public String simpleCipher(String encrypted, int k) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < encrypted.length(); i++) {
            char c = encrypted.charAt(i);
            int i1 = (c - 'A' - k + 26) % 26 + 'A';
            result.append((char)i1);
        }
        return result.toString();
    }

    public static void main(String[] args) {
//        AmazonCipher sol = new AmazonCipher();
        String str = "VTAOG";
        int k = 2;
        System.out.println(sol.simpleCipher(str, k));
    }
}
