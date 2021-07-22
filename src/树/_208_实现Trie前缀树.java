package 树;

import java.util.LinkedList;
import java.util.List;

/*
 *请你实现 Trie 类：
Trie() 初始化前缀树对象。
void insert(String word) 向前缀树中插入字符串 word 。
boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 
 * 
 * 
 * 
 */
public class _208_实现Trie前缀树 {
	private _208_实现Trie前缀树[] children;
    private boolean isEnd;

    public _208_实现Trie前缀树() {
        children = new _208_实现Trie前缀树[26];
        isEnd = false;
    }
    
    public void insert(String word) {
    	_208_实现Trie前缀树 node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new _208_实现Trie前缀树();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
    	_208_实现Trie前缀树 node = searchPrefix(word);
        return node != null && node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private _208_实现Trie前缀树 searchPrefix(String prefix) {
    	_208_实现Trie前缀树 node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

}
