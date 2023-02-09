class AuthenticationManager {
    private int timeToLive;
    private Map<String, Integer> map;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.map = new HashMap<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + timeToLive);
    }
    
    public void renew(String tokenId, int currentTime) {
        if (!map.containsKey(tokenId) || map.get(tokenId) <= currentTime) return;
        generate(tokenId, currentTime);
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int res = 0;
        for (String tokenId : map.keySet()) {
            if (map.get(tokenId) > currentTime) res++;
        }
        return res;
    }
}