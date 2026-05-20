class Solution {
    public String foreignDictionary(String[] words) {
        HashMap<Character, Set<Character>> hm = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();

        for (String word : words)
            for (char c : word.toCharArray()) {
                hm.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());

            if (w1.length() > w2.length() &&
                    w1.substring(0, minLen).equals(w2.substring(0, minLen)))
                return "";

            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    char u = w1.charAt(j), v = w2.charAt(j);
                    if (hm.get(u).add(v))                    // ✅ only if edge is new
                        indegree.put(v, indegree.get(v) + 1);
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        for (char c : indegree.keySet())
            if (indegree.get(c) == 0) q.offer(c);

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char curr = q.poll();
            sb.append(curr);
            for (char next : hm.get(curr)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) q.offer(next);
            }
        }

        return sb.length() == hm.size() ? sb.toString() : "";
    }
}