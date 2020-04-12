import java.util.*;

/**
 * @author tailor
 * @create 2020/4/12 - 21:53
 * @mail wql2014302721@gmail.com
 */
class Solution {// 使用优先队列
    private class Node{
        char val;
        int freq;
        public Node(char val, int freq){
            this.val = val;
            this.freq = freq;
        }
    }
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.freq - o1.freq;
            }
        });
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, 1);
            }else{
                map.put(ch, map.get(ch)+1);
            }
        }

        for(char key : map.keySet()){
            queue.add(new Node(key, map.get(key)));
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            for (int i = 0; i < temp.freq; i++) {
                sb.append(temp.val);
            }
        }
        return sb.toString();
    }
}
