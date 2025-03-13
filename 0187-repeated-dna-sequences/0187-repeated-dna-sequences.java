class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        Set<String> set = new HashSet<>();
        Set<String> ans = new HashSet<>();
       

        int i =0;
        int j =0;
        StringBuilder sb = new StringBuilder();

        while(j<s.length()){

            sb.append(s.charAt(j));

            if(j-i+1<10){
                j++;
            } else {
                if(set.contains(sb.toString())){
                    ans.add(sb.toString());
                }else {
                    set.add(sb.toString());
                }
                sb.delete(0,1);
                i++;
                j++;
            } 

        }
         List<String> res = new ArrayList<>(ans);
        return res;
        
    }
}