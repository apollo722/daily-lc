/*
https://leetcode.com/problems/web-crawler/

bfs模板

Time: O(n)
Space: O(n)
*/

class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Queue<String> q = new LinkedList<>();
        q.add(startUrl);
        HashSet<String> visited = new HashSet<>();
        visited.add(startUrl);
        String hostName = getHost(startUrl);
        while (!q.isEmpty()) {
            String url = q.poll();
            for (String nextUrl : htmlParser.getUrls(url)) {
                if (getHost(nextUrl).equals(hostName) && !visited.contains(nextUrl)) {
                    visited.add(nextUrl);
                    q.add(nextUrl);
                }
            }
        }
        return new ArrayList<>(visited);
    }

    private String getHost(String url) {
        return url.split("/")[2];
    }
}