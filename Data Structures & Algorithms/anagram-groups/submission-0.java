class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) return List.of(List.of(strs[0]));
        
        String[] strsSorted = strs.clone();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strsSorted) {
            String original = str;
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            str = new String(chars);
            map.computeIfAbsent(str, k -> new ArrayList<>()).add(original);
        }
        
        return List.copyOf(map.values());

    }
}
