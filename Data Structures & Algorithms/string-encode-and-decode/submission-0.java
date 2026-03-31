class Solution {

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str.length() + "#" + str);
        }

        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            
            res.add(str.substring(i, i + length));
            i += length;
        }
        
        return res;
    }
}
