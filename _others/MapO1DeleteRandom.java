import java.util.*;
class MapO1DeleteRandom {
    Map<String, Integer> kvMap;
    Map<Integer, Integer> freqMap;
    Random rand;
    List<Integer> values;
    Map<Integer, Integer> idxMap;
    int curIdx = 0;

    public MapO1DeleteRandom() {
        kvMap = new HashMap<>();
        freqMap = new HashMap<>();
        rand = new Random();
        values = new ArrayList<>();
        idxMap = new HashMap<>();
    }

    public void put(String key, int value) {
        if (kvMap.containsKey(key) && kvMap.get(key) == value) return;
        if (kvMap.containsKey(key)) {
            int oldValue = kvMap.get(key);
            int oldValFreq = freqMap.get(oldValue);
            if (oldValFreq == 1) {
                int oldFreqIdx = idxMap.get(oldValue);
                int lastValue = values.get(values.size() - 1);
                values.set(oldFreqIdx, lastValue);
                idxMap.put(lastValue, oldFreqIdx);
                values.remove(values.size() - 1);
                idxMap.remove(oldValue);
                freqMap.remove(oldValue);
                curIdx--;
            } else {
                freqMap.put(oldValue, oldValFreq - 1);
            }
            if (freqMap.containsKey(value)) {
                freqMap.put(value, freqMap.get(value) + 1);
            } else {
                freqMap.put(value, 1);
                values.add(value);
                idxMap.put(value, curIdx);
                curIdx++;
            }
        } else {
            if (freqMap.containsKey(value)) {
                freqMap.put(value, freqMap.get(value) + 1);
            } else {
                freqMap.put(value, 1);
                values.add(value);
                idxMap.put(value, curIdx);
                curIdx++;
            }
        }
        kvMap.put(key, value);
    }

    public int get(String key) {
        return kvMap.getOrDefault(key, -1);
    }

    public void delete(String key) {
        if (kvMap.containsKey(key)) {
            int value = kvMap.get(key);
            int freq = freqMap.get(value);
            if (freq == 1) {
                int idx = idxMap.get(value);
                int lastValue = values.get(values.size() - 1);
                values.set(idx, lastValue);
                idxMap.put(lastValue, idx);
                values.remove(values.size() - 1);
                idxMap.remove(value);
                freqMap.remove(value);
                curIdx--;
            } else {
                freqMap.put(value, freq - 1);
            }
            kvMap.remove(key);
        }
    }

    public int getRandom() {
        int idx = rand.nextInt(values.size());
        return values.get(idx);
    }

    public static void main (String[] args) {
        MapO1DeleteRandom map = new MapO1DeleteRandom();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        System.out.println(map.get("a"));
        System.out.println(map.get("b"));
        System.out.println(map.get("c"));
        System.out.println(map.get("d"));
        System.out.println(map.get("e"));
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int val = map.getRandom();
            count.put(val, count.getOrDefault(val, 0) + 1);
        }
        for (int key : count.keySet()) {
            System.out.println(key + " " + count.get(key));
        }
        map.delete("a");
        map.delete("b");
        map.put("c", 3);
        count.clear();
        for (int i = 0; i < 10000; i++) {
            int val = map.getRandom();
            count.put(val, count.getOrDefault(val, 0) + 1);
        }
        for (int key : count.keySet()) {
            System.out.println(key + " " + count.get(key));
        }
        System.out.println(map.get("a"));
        System.out.println(map.get("c"));
    }
}