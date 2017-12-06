//In English, we have a concept called root, which can be followed by some other words to form another longer word.
//let's call this word successor. For example, the root an, followed by other, which can form another word another.
//Now, given a dictionary consisting of many roots and a sentence.
//You need to replace all the successor in the sentence with the root forming it.
//If a successor has many roots can form it, replace it with the root with the shortest length.
//You need to output the sentence after the replacement.

import java.util.List;

public class Leetcode648 {

    public static void main(String args[]) {

    }

    public String replaceWords(List<String> dict, String sentence) {
        Trie trie = new Trie();
        for(String str : dict) {
            trie.insert(str);
        }
        String[] words = sentence.split(" ");
        for(int i=0; i<words.length; i++) {
            String root = trie.search(words[i]);
            if(root != null) {
                words[i] = root;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String word : words) {
            sb.append(word).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    class Trie {

        TrieNode root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode index = root;
            StringBuilder sb= new StringBuilder();
            for(char ch : word.toCharArray()) {
                 if(index.next[ch-'a'] == null) {
                     index.next[ch-'a'] = new TrieNode();
                 }
                 index = index.next[ch-'a'];
                 sb.append(ch);
            }
            index.isWord = true;
            index.word = sb.toString();
        }

        /** Returns if the word is in the trie. */
        public String search(String word) {
            TrieNode index = root;
            for(char ch : word.toCharArray()) {
                if(index.next[ch-'a'] == null) {
                    return null;
                }
                index = index.next[ch-'a'];
                if(index.isWord) {
                    return index.word;
                }
            }
            return null;
        }

        class TrieNode{
            TrieNode[] next = new TrieNode[26];
            boolean isWord = false;
            String word = "";
        }
    }

}
