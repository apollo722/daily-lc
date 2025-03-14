class AuthenticationManager {

    private static int ttl;
    HashMap<String, Integer> tokenTTLMap;
    Queue<String> queue;

    public AuthenticationManager(int timeToLive) {
        this.tokenTTLMap = new HashMap<>();
        this.queue = new ArrayDeque<>();
        this.ttl = timeToLive;
    }
    
    private void removeExpired(int currentTime) {

        while(!queue.isEmpty()) {
            String token = queue.peek();
            
            if(tokenTTLMap.containsKey(token) && tokenTTLMap.get(token) > currentTime) {
                break;
            } 

            queue.poll();
            tokenTTLMap.remove(token);
        }

    }

    public void generate(String tokenId, int currentTime) {

        if(!this.tokenTTLMap.containsKey(tokenId)) {
            this.queue.add(tokenId);
        }

        this.tokenTTLMap.put(tokenId, currentTime + this.ttl);
        this.removeExpired(currentTime);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(this.tokenTTLMap.containsKey(tokenId) && this.tokenTTLMap.get(tokenId) > currentTime) {
            this.tokenTTLMap.put(tokenId, currentTime + this.ttl);
            this.queue.remove(tokenId);
            this.queue.add(tokenId);
        }   
        this.removeExpired(currentTime);
    }
    
    public int countUnexpiredTokens(int currentTime) {
        this.removeExpired(currentTime);
        
        return queue.size();
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */