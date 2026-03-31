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

        int minDiff = 1001;
        String ans = "";
        for (ValueTimeMap valueTime : ls) {
            int currDiff = timestamp - valueTime.getTimeStamp();
            if (currDiff < 0) continue;
            else if (currDiff < minDiff) {
                minDiff = currDiff;
                ans = valueTime.getValue();
            }
        }
        return ans;
    }
}
