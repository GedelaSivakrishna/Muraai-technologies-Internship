package Leetcode.Easy;

public class FindKthCharacterInStringGame1 {

    public static char f(String word, int k) {
        // base case
        if (word.length() >= k) return word.charAt(k - 1);
        
        String nextWord = "";
        for(char ch : word.toCharArray()) {
            nextWord += (char)++ch;
        }

        return f(word + nextWord, k);
    }
    
    public static char kthCharacter(int k) {
        return f("a", k);
    }

    public static void main(String[] args) {
        System.out.println(kthCharacter(5)); // b
        System.out.println(kthCharacter(10)); // c
    }
}
