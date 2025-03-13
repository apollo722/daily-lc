class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length()<=10 || s.length()>10000) return new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        HashSet<String> ans = new HashSet<>();
        for(int i=0; i+10<=s.length();i++){
            String sub = s.substring(i,i+10);
            if(!set.add(sub)) ans.add(sub);
        }
        return new ArrayList<>(ans);
        
    }
}