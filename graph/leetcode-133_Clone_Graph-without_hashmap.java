// https://leetcode.com/problems/clone-graph/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Node[] visited = new Node[101]; // max constraint of 100
        Arrays.fill(visited, null);
        
        return helper(visited, node);
    }
    
    private Node helper(Node[] visited, Node node) {
        if(node == null) return null;
        if(visited[node.val] != null) return visited[node.val];
        
        Node clone = new Node(node.val);
        visited[node.val] = clone;
        
        for(Node neighbor: node.neighbors) {
            clone.neighbors.add(helper(visited, neighbor));
        }
        
        return clone;
    }
}
