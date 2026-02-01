import java.util.*;

class Solution {

    record Pair(String node, long cost) {
    };

    String source;
    String target;
    HashMap<String, List<Pair>> graph;
    TreeSet<Integer> validLengths;
    long dp[];
    HashMap<String, HashMap<String, Long>> djkistraDp;

    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {

        this.source = source;
        this.target = target;
        graph = new HashMap<>();
        validLengths = new TreeSet<>();
        djkistraDp = new HashMap<>();
        int n = original.length;
        dp = new long[source.length() + 1];
        Arrays.fill(dp, -1);
        for (int i = 0; i < n; i++)
            graph.computeIfAbsent(original[i], k -> new ArrayList<>()).add(new Pair(changed[i], cost[i]));

        for (String gg : original)
            validLengths.add(gg.length());

        long ans = solve(0);
        return ans == Long.MAX_VALUE ? -1 : ans;

    }

    private long solve(int i) {
        if (i >= source.length())
            return 0;

        if (dp[i] != -1)
            return dp[i];
        long minCost = Long.MAX_VALUE;
        if (source.charAt(i) == target.charAt(i))
            minCost = Math.min(minCost, solve(i + 1));
        if (source.substring(i).equals(target.substring(i)))
            return 0;

        for (int len : validLengths) {
            if (i + len > source.length())
                break;
            String src = source.substring(i, i + len);
            String dest = target.substring(i, i + len);
            if (!graph.containsKey(src))
                continue;
            long pathCost = djkistra(src, dest);
            if (pathCost == Long.MAX_VALUE)
                continue;
            long subProblem = solve(i + len);
            if (subProblem == Long.MAX_VALUE)
                continue;
            minCost = Math.min(minCost, pathCost + subProblem);
        }

        return dp[i] = minCost;

    }

    private long djkistra(String src, String dest) {
        if (djkistraDp.containsKey(src) && djkistraDp.get(src).containsKey(dest))
            return djkistraDp.get(src).get(dest);
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(p -> p.cost));
        HashMap<String, Long> dist = new HashMap<>();
        dist.put(src, 0L);
        pq.offer(new Pair(src, 0L));
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            String node = curr.node;
            long cost = curr.cost;
            if (node.equals(dest))
                break;

            if (!graph.containsKey(node))
                continue;
            for (Pair neighbour : graph.getOrDefault(node, new ArrayList<>())) {
                String nextNode = neighbour.node;
                long nextCost = cost + neighbour.cost;
                if (nextCost < dist.getOrDefault(nextNode, Long.MAX_VALUE)) {
                    dist.put(nextNode, nextCost);
                    pq.offer(new Pair(nextNode, nextCost));
                }
            }

        }
        djkistraDp.computeIfAbsent(src, k -> new HashMap<>()).put(dest, dist.getOrDefault(dest, Long.MAX_VALUE));
        return dist.getOrDefault(dest, Long.MAX_VALUE);
    }
}