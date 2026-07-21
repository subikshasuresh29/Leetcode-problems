class Solution {
    public String reorganizeString(String s) {

        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c - 'a']++;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++)
            if (count[i] > 0)
                pq.offer(new int[]{i, count[i]});
        StringBuilder ans = new StringBuilder();
        while (pq.size() > 1) {
            int[] first = pq.poll();
            int[] second = pq.poll();

            ans.append((char)(first[0] + 'a'));
            ans.append((char)(second[0] + 'a'));

            if (--first[1] > 0) pq.offer(first);
            if (--second[1] > 0) pq.offer(second);
        }
        if (!pq.isEmpty()) {
            if (pq.peek()[1] > 1) return "";
            ans.append((char)(pq.poll()[0] + 'a'));
        }
        return ans.toString();
    }
}