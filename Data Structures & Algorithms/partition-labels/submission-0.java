class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> lastOccuranceMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            lastOccuranceMap.put(s.charAt(i), i);
        }

        int first = 0;
        int last = 0;
        for (int i = 0; i < s.length(); i++) {
            last = Math.max(last, lastOccuranceMap.get(s.charAt(i)));

            if(i == last) {
                result.add(i - first + 1);
                first = i + 1;
            }
        }

        return result;
    }
}
