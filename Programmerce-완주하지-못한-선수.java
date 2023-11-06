import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> map = new HashMap<>();
        String ans = "";
        
        for (int i = 0; i < participant.length; i++) {
            String thisPar = participant[i];
            if (map.containsKey(thisPar)) {
                map.put(thisPar, map.get(thisPar) + 1);
            } else {
                map.put(thisPar, 1);
            }
        }
        
        for (int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.get(completion[i]) - 1);
        }
    
        for (String key : map.keySet()) {
            if (map.get(key) > 0) {
                ans = key;
                break;
            }
	    };
        
        return ans;
    }
}
