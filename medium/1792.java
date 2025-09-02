import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // int n = classes.length;
        // double PR[] = new double[n];
        // for (int i = 0; i < n; i++)
        //     PR[i] = (double) classes[i][0] / classes[i][1];
        // while (extraStudents-- > 0) {
        //     double newPR[] = new double[n];
        //     for (int i = 0; i < n; i++)
        //         newPR[i] = (double) (classes[i][0] + 1) / (classes[i][1] + 1);
        //     double maxDelta = -1;
        //     int maxDeltaIndex = -1;
        //     for (int i = 0; i < n; i++) {
        //         double delta = newPR[i] - PR[i];
        //         if (delta > maxDelta) {
        //             maxDelta = delta;
        //             maxDeltaIndex = i;
        //         }
        //     }
        //     PR[maxDeltaIndex] = newPR[maxDeltaIndex];
        //     classes[maxDeltaIndex][0]++;
        //     classes[maxDeltaIndex][1]++;
        // }
        // double total = 0.0;
        // for (int i = 0; i < n; i++)
        //     total += PR[i];

        // return total / n;


        int n = classes.length;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for (int i = 0; i < n; i++) {
            double Pr = (double) classes[i][0] / classes[i][1];
            double newPr = (double) (classes[i][0] + 1) / (classes[i][1] + 1);
            double delta = newPr - Pr;
            pq.offer(new double[]{delta, i});
        }

        while (extraStudents-- > 0) {

            double[] curr = pq.poll();
            int index = (int)curr[1];

            classes[index][0]++;
            classes[index][1]++;

            double pr = (double) classes[index][0] / classes[index][1];
            double newPr = (double) (classes[index][0] + 1) / (classes[index][1] + 1);
            double delta = newPr - pr;
            pq.add(new double[]{delta,index});

        }

        double total =0.0;

        for(int i=0;i<n;i++)
            total += (double) classes[i][0] / classes[i][1];

        return total / n;
    }
}