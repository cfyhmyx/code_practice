//Design a data structure that supports the following two operations:
//addWord(word), search(word), search(word)
//search(word) can search a literal word or a regular expression string containing only letters a-z or .. A
//. means it can represent any one letter.

public class Leetcode211 {

    public static void main(String args[]) {

    }

    class WordDictionary {

        TrieNode root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new TrieNode();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode index = root;
            for(char ch : word.toCharArray()) {
                if(index.next[ch-'a'] == null) {
                    index.next[ch-'a'] = new TrieNode();
                }
                index = index.next[ch-'a'];
            }
            index.isWord = true;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return searchHelper(0, word.toCharArray(), root);
        }

        private boolean searchHelper(int cur, char[] chars, TrieNode node) {
            if(cur == chars.length) {
                return node.isWord;
            }
            if(chars[cur] == '.') {
                for(int j=0; j<26; j++) {
                    if(node.next[j] != null && searchHelper(cur+1, chars, node.next[j])) {
                        return true;
                    }
                }
                return false;
            } else {
                if(node.next[chars[cur]-'a'] == null) {
                    return false;
                }
                return searchHelper(cur+1, chars, node.next[chars[cur]-'a']);
            }
        }

        class TrieNode{
            TrieNode[] next = new TrieNode[26];
            boolean isWord = false;
        }
    }

}
