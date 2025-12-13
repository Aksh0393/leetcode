import java.util.*;

class Solution {
    public List<String> validateCoupons(
        List<String> codes,
        List<String> businessLines,
        List<Boolean> isActives
    ) {
        int n = codes.size();

        // Mapping from business line name to its required sort order
        Map<String, Integer> businessLineSortOrder = new HashMap<>();
        businessLineSortOrder.put("electronics", 0);
        businessLineSortOrder.put("grocery", 1);
        businessLineSortOrder.put("pharmacy", 2);
        businessLineSortOrder.put("restaurant", 3);

        // Store each valid coupon with info needed for sorting
        // Each CouponInfo stores (sortIndex, code)
        List<CouponInfo> sortableCoupons = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            // Check coupon is currently active
            if (!isActives.get(i)) continue;

            // Check if business line is valid
            if (!businessLineSortOrder.containsKey(businessLines.get(i))) continue;

            // Check if code is non-empty and only alphanumeric or underscore
            String code = codes.get(i);
            if (code.isEmpty()) continue;
            boolean isCodeValid = true;
            for (char c : code.toCharArray()) {
                if (!Character.isLetterOrDigit(c) && c != '_') {
                    isCodeValid = false;
                    break;
                }
            }
            if (!isCodeValid) continue;

            // Everything is valid, collect coupon for sorting
            int sortIndex = businessLineSortOrder.get(businessLines.get(i));
            sortableCoupons.add(new CouponInfo(sortIndex, code));
        }

        // Sort by business line order, then code alphabetically
        Collections.sort(sortableCoupons);

        // Gather the sorted coupon codes
        List<String> sortedValidCodes = new ArrayList<>();
        for (CouponInfo coupon : sortableCoupons) {
            sortedValidCodes.add(coupon.code);
        }

        return sortedValidCodes;
    }

    // Helper class for sorting
    static class CouponInfo implements Comparable<CouponInfo> {
        int sortIndex;
        String code;

        CouponInfo(int sortIndex, String code) {
            this.sortIndex = sortIndex;
            this.code = code;
        }

        @Override
        public int compareTo(CouponInfo other) {
            if (this.sortIndex != other.sortIndex) {
                return Integer.compare(this.sortIndex, other.sortIndex);
            }
            return this.code.compareTo(other.code);
        }
    }
}