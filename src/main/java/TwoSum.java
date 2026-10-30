import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        int result[] = null;

        if(nums == null || nums.length < 2)
            throw new IllegalArgumentException("Array length must be at least 2");

        for(int i = 0; i < nums.length ; i++ ){
            int difference =  target - nums[i];
            Integer pos = seen.get(difference);

            if(pos != null){
                result = new int[2];
                result[0] = pos;
                result[1] = i;

                break;
            }

            seen.put(nums[i], i);
        }

        if(result == null)
            throw new IllegalArgumentException("The array doesn't contain valid solution");

        return result;
    }
}
