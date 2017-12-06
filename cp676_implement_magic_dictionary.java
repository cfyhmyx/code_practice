//Implement a magic directory with buildDict, and search methods.
//For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.
//For the method search, you'll be given a word, and judge whether if you modify exactly one character into another character in this word,
//the modified word is in the dictionary you just built.

public class Leetcode676 {

    public static void main(String args[]) {
        MagicDictionary test = new MagicDictionary();
        String[] dict = {"hello", "leetcode"};
        test.buildDict(dict);
        boolean result = test.search("hello");
        System.out.println(result);
    }

    static class MagicDictionary {

        TrieNode root;

        /** Initialize your data structure here. */
        public MagicDictionary() {
            root = new TrieNode();
        }

        /** Build a dictionary through a list of words */
        public void buildDict(String[] dict) {
            for(String word : dict) {
                TrieNode index = root;
                for(char ch : word.toCharArray()) {
                    if(index.next[ch-'a'] == null) {
                        index.next[ch-'a'] = new TrieNode();
                    }
                    index = index.next[ch-'a'];
                }
                index.isWord = true;
            }
        }

        /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
        public boolean search(String word) {
            char[] chars = word.toCharArray();
            for(int i=0; i<chars.length; i++) {
                char temp = chars[i];
                for(char ch = 'a'; ch<='z'; ch++) {
                    if(temp == ch) continue;
                    chars[i] = ch;
                    String newStr = new String(chars);
                    if(searchHelper(newStr)){
                        return true;
                    }
                    chars[i] = temp;
                }
            }
            return false;
        }

        public boolean searchHelper(String word) {
            TrieNode index = root;
            for(char ch : word.toCharArray()) {
                if(index.next[ch-'a'] == null) {
                    return false;
                }
                index = index.next[ch-'a'];
            }
            return index.isWord;
        }

        class TrieNode{
            TrieNode[] next = new TrieNode[26];
            boolean isWord = false;
        }
    }

}
