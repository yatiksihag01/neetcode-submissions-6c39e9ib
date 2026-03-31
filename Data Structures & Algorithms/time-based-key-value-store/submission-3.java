class TimeMap {

    class ValueTimeMap {
        private String value;
        private int timeStamp;

        public ValueTimeMap(String value, int timeStamp) {
            this.value = value;
            this.timeStamp = timeStamp;
        }

        public String getValue() {
            return this.value;
        }

        public int getTimeStamp() {
            return this.timeStamp;
        }
    }

    private HashMap<String, List<ValueTimeMap>> map = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        ValueTimeMap valueTime = new ValueTimeMap(value, timestamp);
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(valueTime);
    }
    
    public String get(String key, int timestamp) {
        List<ValueTimeMap> ls = map.get(key);
        if (ls == null) return "";

        String ans = "";
        int low = 0;
        int high = ls.size() - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;
            ValueTimeMap valueTime = ls.get(mid);
            int timeAtMid = valueTime.getTimeStamp();

            if (timestamp >= timeAtMid) {
                ans = valueTime.getValue();
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
