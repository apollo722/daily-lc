/*
https://leetcode.com/problems/design-a-food-rating-system/

将需要的信息用map存起来
对于每种cuisine，将所属的food用treeset存储即可
每次change rating先remove，再add back即可
注意customized lambda升序rating就要降序str

Time: O(nlogn)，对于每种food，每次insert都需要logn，而每次查询对于java来说，first与last的查询都需要logn
Space: O(n)，不管怎么存，最多也不会超过n，因为总共就n种food
*/

class FoodRatings {
    HashMap<String, TreeSet<String>> m;
    HashMap<String, Integer> idxMap;
    int[] rt;
    String[] cs;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        m = new HashMap<>();
        idxMap = new HashMap<>();
        this.cs = cuisines;
        this.rt = ratings;
        for (int i = 0; i < foods.length; i++) {
            String c = cs[i], f = foods[i];
            int r = rt[i];
            idxMap.put(f, i);
            if (!m.containsKey(c)) {
                m.put(c, new TreeSet<>((a, b) -> {
                    if (rt[idxMap.get(a)] == rt[idxMap.get(b)]) return b.compareTo(a);
                    return rt[idxMap.get(a)] - rt[idxMap.get(b)];
                }));
            }
            m.get(c).add(f);
        }
    }
    
    public void changeRating(String food, int newRating) {
        int idx = idxMap.get(food);
        String c = cs[idx];
        m.get(c).remove(food);
        rt[idx] = newRating;
        m.get(c).add(food);
    }
    
    public String highestRated(String cuisine) {
        return m.get(cuisine).last();
    }
}