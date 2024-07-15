public class Trie {

    public class Node {
        Node[] kids = new Node[26];
        boolean end;

        public void Node() {
            boolean end = false;
            for (int i = 0; i < 26; i++) {
                kids[i] = null;
            }
        }

    }

    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        int len = word.length();
        int idx;
        Node curr = root;

        for (int depth = 0; depth < len; depth++) {
            // - ascii of a to start at idx 0
            idx = word.charAt(depth) - 'a';
            if ( curr.kids[idx] == null ) {
                curr.kids[idx] = new Node();
            }
            curr = curr.kids[idx];
        }
        // we're at the end of the word
        curr.end = true;
    }

    public boolean wordSearch(String word) {
        int len = word.length();
        int idx;
        Node curr = root;

        for (int depth = 0; depth < len; depth++) {
            idx = word.charAt(depth) - 'a';
            if ( curr.kids[idx] == null ) {
                return false;
            }
            curr = curr.kids[idx];
        }

        return (curr != null && curr.end);
    }


    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("cool");
        trie.insert("car");
        trie.insert("hey");
        trie.insert("horse");

        System.out.println(trie.wordSearch("car")); // true
        System.out.println(trie.wordSearch("cr")); // false
        System.out.println(trie.wordSearch("horrse")); // false
        System.out.println(trie.wordSearch("horse")); // true
        System.out.println(trie.wordSearch("hey")); // true




    }



}





