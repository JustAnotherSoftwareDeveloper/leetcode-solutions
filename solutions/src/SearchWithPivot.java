public class SearchWithPivot {
    public int search(int[] nums, int target) {
        int highest = nums.length-1;
        int lowest = 0;
        int higher = nums.length-1;
        int lower = 0;
        while (higher > lower && lower >= lowest && higher <= highest) {
            System.out.println(String.format("%s %s",higher,lower));
            int mid = (higher + lower)/2;
            if (nums[mid] == target) {
                return mid;
            }
            //Sorted from lower..mid
            if (nums[mid] > nums[lower]) {
                if (target >= nums[lower] && target <= nums[mid]) {
                    higher = mid;
                }
                else {
                    lower = mid+1;
                }
            }
            //nums[lower] >= nums[mid]
            else {
                if (target <= nums[higher] && target >= nums[mid]) {
                    lower = mid+1;
                }
                else {
                    higher = mid;
                }
            }
        }
        return -1;
    }

}


