class Solution {
    public int[][] kClosest(int[][] points, int k) {
        class Pair {
            double dist;
            int[] point;
            Pair(int[] point, double dist) {
                this.dist = dist;
                this.point = point;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.dist, a.dist));

        for (int i = 0; i < points.length; i++) {
            double dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            pq.offer(new Pair(points[i], dist));
            if (pq.size() > k) pq.poll();
        }

        int[][] res = new int[k][2];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.poll().point;
        }
        return res;
    }
}