import java.util.*;

class Solution {
    class Node {
        String name;
        Map<String, Node> children = new HashMap<>();
        boolean deleted = false;

        Node(String name) { this.name = name; }
    }

    private final Map<String, List<Node>> groups = new HashMap<>();

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths){
        Node root = new Node("");

        for (List<String> path : paths) {
            Node cur = root;
            for (String dir : path) {
                cur = cur.children.computeIfAbsent(dir, Node::new);
            }
        }

        serialize(root);

        for (List<Node> same : groups.values()) {
            if (same.size() > 1) {
                for (Node n : same) markDeleted(n);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        collect(root, new ArrayList<>(), ans);
        return ans;
    }

    private String serialize(Node node) {
        if (node.children.isEmpty()) return "";

        List<String> parts = new ArrayList<>();
        for (Map.Entry<String, Node> e : node.children.entrySet()) {
            String childSig = serialize(e.getValue());
            parts.add(e.getKey() + "#" + childSig);
        }
        Collections.sort(parts);

        StringBuilder sb = new StringBuilder("(");
        for (String p : parts) sb.append(p).append(",");
        sb.append(")");
        String sig = sb.toString();

        groups.computeIfAbsent(sig, k -> new ArrayList<>()).add(node);
        return sig;
    }

    private void markDeleted(Node node) {
        node.deleted = true;
        for (Node child : node.children.values()) markDeleted(child);
    }

    private void collect(Node node, List<String> path,
                         List<List<String>> res) {
        for (Map.Entry<String, Node> e : node.children.entrySet()) {
            Node child = e.getValue();
            if (child.deleted) continue;

            path.add(child.name);
            res.add(new ArrayList<>(path));
            collect(child, path, res);
            path.removeLast();
        }
    }
}