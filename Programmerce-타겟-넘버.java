import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int n = numbers.length;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, numbers[0]));
        queue.add(new Node(0, -numbers[0]));
        
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            
            if (cur.i == n - 1) {
                if (cur.v == target) {
                    answer++;
                }
                continue;
            }
            
            queue.add(new Node(cur.i + 1, cur.v + numbers[cur.i + 1]));
            queue.add(new Node(cur.i + 1, cur.v - numbers[cur.i + 1]));
        }
        
        return answer;
    }
    
    static class Node {
        int i;
        int v;
        
        Node(int i, int v) {
            this.i = i;
            this.v = v;
        }
    }
}
