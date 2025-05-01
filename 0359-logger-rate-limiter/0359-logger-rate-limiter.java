class Logger {
    HashMap<String, Integer> m;

    public Logger() {
        m = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!m.containsKey(message) || timestamp - m.get(message) >= 10) {
            m.put(message, timestamp);
            return true;
        } 
        return false;
    }
}