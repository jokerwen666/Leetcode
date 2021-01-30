package Stack.leetcode1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Zhang Bowen
 * @Description
 * @ClassName Solution
 * @date 2021.01.30 17:13
 */
public class Solution {
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int value = 0;
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++){
            //如果之前已经出现过相同元素，则不覆盖位置
            //题目条件是只会存在一组有效答案，因此如果有效答案是不同的两个数，则比可能出现重复
            //如果答案是两个相同的数，则让后出现的覆盖之前出现的，因为下面遍历的时候会从前向后遍历
            if(map.get(nums[i]) != null)
                map.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {
            value = target - nums[i];
            //value在数组中有对应位置，且该位置不是当前数本身，则说明找到了结果
            if(map.get(value) != null && map.get(value) != i) {
                result[0] = i;
                result[1] = map.get(value);
                break;
            }
        }
        return result;
    }


    //改进版，只需要遍历一遍数组，边存边找
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if(map.containsKey(value))
                return new int[]{i,map.get(value)};
            map.put(i,nums[i]);
        }
        return new int[]{};
    }

}
