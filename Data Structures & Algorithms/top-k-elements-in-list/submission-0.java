class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();
        List<List<Integer>> count = new ArrayList<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i <= nums.length; i++) {
            count.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            count.get(entry.getValue()).add(entry.getKey());
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = nums.length; i >= 0 && ans.size() < k; i--) {
            for (int num : count.get(i)) {
                ans.add(num);
                if (ans.size() == k) break;
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}