/*
https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

逐层处理，每一层链接下一层
每一层需要知道的是
1. 层头在哪，这样才能逐个处理下一层的节点
2. 处理本层的下一层时，下一层节点的prev是什么，这样才能逐个的链接

所以需要curLevel，来表示每一层的head，和prev，来表示正在处理的下一层节点的前置节点
一开始curLevel即为root，当curLevel不为null时，进入该层并处理
先把这一层需要的prev重置为null，因为这一层刚开始嘛
之后用一个ptr逐个扫描这一层的节点，从curLevel开始
因为开始处理这一层的节点了，所以curLevel要先置成null，以便跳出循环，如果还有下一层，那么处理到下面的时候会把curLevel再置成非null
对于每个节点的左右子节点，即将prev.next设为node，以链接
如果prev==null，那证明这一层刚开始，是处理的本层第一个节点，那么这个节点一定是层头，即下一层的curLevel
如此循环每一层，直到curLevel为null，即不存在下一层了，跳出循环返回root即可

Time: O(n)
Space: O(1)
*/

class Solution {
    Node curLevel, prev;
    public Node connect(Node root) {
        curLevel = root;
        while (curLevel != null) {
            Node cur = curLevel;
            curLevel = null;
            prev = null;
            while (cur != null) {
                process(cur.left);
                process(cur.right);
                cur = cur.next;
            }
        }
        return root;
    }

    private void process(Node node) {
        if (node != null) {
            if (prev != null) prev.next = node;
            else curLevel = node;
            prev = node;
        }
    }
}