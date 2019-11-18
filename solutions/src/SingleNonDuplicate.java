public class SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        int lower = 0;
        int higher = nums.length-1;

        while (lower <= higher) {
            Integer mid = lower + (higher-lower)/2;
            if (lower == higher) {
                return nums[lower];
            }
            if (mid %2 == 0) {
                if(nums[mid] == nums[mid+1]) {
                    lower = mid+2;
                }
                else {
                    higher = mid;
                }
            }
            else {
                if (nums[mid] == nums[mid-1]) {
                    lower = mid+1;
                }
                else {
                    higher=mid -1;
                }
            }

        }


        return 0;
    }
}
