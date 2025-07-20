class Solution {
    class TrieNode {
        String node;
        HashMap<String, TrieNode> map = new HashMap<>();
        boolean isRemoved = false;

        TrieNode(String node) {
            this.node = node;
        }
    }

    TrieNode root;

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        root = new TrieNode("*");

        for (List<String> list : paths) {
            insertIntoTrie(root, list);
        }

        HashMap<String, TrieNode> visited = new HashMap<>();
        markRepeated(root, visited);

        List<List<String>> ans = new ArrayList<>();
        List<String> cur = new ArrayList<>();

        for (Map.Entry<String, TrieNode> entry : root.map.entrySet()) {
            save(entry.getValue(), cur, ans);
        }

        return ans;

    }

    public void insertIntoTrie(TrieNode root, List<String> lists) {
        TrieNode cur = root;

        for (String str : lists) {
            if (!cur.map.containsKey(str)) {
                TrieNode newNode = new TrieNode(str);
                cur.map.put(str, newNode);
                cur = cur.map.get(str);
            } else {
                cur = cur.map.get(str);
            }
        }
    }

    public String markRepeated(TrieNode root, HashMap<String, TrieNode> visited) {
        List<String> childrenSignatures = new ArrayList<>();

        for (Map.Entry<String, TrieNode> entry : root.map.entrySet()) {
            String childSignature = markRepeated(entry.getValue(), visited);
            childrenSignatures.add(entry.getKey() + childSignature); 
        }

        Collections.sort(childrenSignatures);
        String key = String.join("", childrenSignatures);

        if (!key.isEmpty()) {
            key = "[" + key + "]"; 

            if (visited.containsKey(key)) {
                root.isRemoved = true;
                visited.get(key).isRemoved = true;
            } else {
                visited.put(key, root);
            }
        }

        return key;
    }

    public void save(TrieNode root, List<String> cur, List<List<String>> ans) {
        if (root.isRemoved) {
            return;
        }

        cur.add(root.node);
        ans.add(new ArrayList<>(cur));

        for (Map.Entry<String, TrieNode> entry : root.map.entrySet()) {
            save(entry.getValue(), cur, ans);
        }

        cur.remove(cur.size() - 1);
    }
}