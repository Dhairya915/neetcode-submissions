class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(b[0], a[0]);
            }
            return Integer.compare(b[1], a[1]);
        });

        for (int i = 0; i < k; i++) {
            int ans = Math.abs(arr[i] - x);
            pq.offer(new int[] {ans, arr[i]});
        }

        for (int i = k; i < arr.length; i++) {
            int[] top = pq.poll();
            int diff = top[0];
            int val = top[1];

            int sum = Math.abs(arr[i] - x);

            if (sum < diff || (sum == diff && arr[i] < val)) {
                pq.offer(new int[] {sum, arr[i]});
            } else {
                pq.offer(top);
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            ans.add(top[1]);
        }

        Collections.sort(ans);
        return ans;
    }
}