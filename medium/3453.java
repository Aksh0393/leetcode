class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0.0;
        double epsilon = 1e-5;
        double low = Double.MAX_VALUE;
        double high = -Double.MAX_VALUE;
        double result = 0.0;
        for (int[] square : squares) {
            double sideLength = square[2];
            totalArea += sideLength * sideLength;
            low = Math.min(low, square[1]);
            high = Math.max(high, square[1]+ sideLength);
        }
        while (high - low > epsilon) {

            double mid = low + (high - low) / 2.0;

            if (check(squares, mid, totalArea)) {
                high = mid;
                result = mid;

            } else
                low = mid;

        }
        return result;
    }

    private boolean check(int[][] squares, double mid, double totalArea) {
        double coveredArea =0.0;
        for(int square[]:squares)
        {
            double sideLength = square[2];
            double y = square[1];
            double topY = y + sideLength;
            double bottomY = y;
            if(mid >=topY)
                coveredArea+= sideLength*sideLength;
            else if( mid > bottomY)
                coveredArea+= sideLength* (mid - bottomY);
            
        }
        return coveredArea >= totalArea/2.0;
    }
}