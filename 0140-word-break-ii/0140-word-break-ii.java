class Solution {

    Set<String> set=new HashSet<>();

    List<String> res=new ArrayList<>();
    int n;

    public void solve(String s,int id,StringBuilder cur)
    {
        if(id >= n)
        {
            res.add(cur.toString());
            return;
        }

        for(int i=id+1;i<=n;i++)
        {
            String temp=s.substring(id,i);
            if(set.contains(temp))
            {
                int len=cur.length();
                if(cur.length() != 0)
                {
                    cur.append(" ");
                }
                solve(s,i,cur.append(temp));
                cur.setLength(len);
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {

        for(String ss:wordDict)
        {
            set.add(ss);
        }

        n=s.length();

        solve(s,0,new StringBuilder());

        return res;
        
    }
}