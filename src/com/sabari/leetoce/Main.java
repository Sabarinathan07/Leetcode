package com.sabari.leetoce;

public class Main {


        public int[] removeElement(int[] nums, int val) {
            // int len = nums.length;
//            int[] expectedNums = new int[nums.length-1];
            int[] expectedNums=null;
            for(int i=0;i<nums.length;i++){
                expectedNums = new int[nums.length-1];

                if(nums[i]==val){

                    for(int j = 0, k = 0 ; j<nums.length; j++){
                        if(j==i){
                            continue;
                        }
                        expectedNums[k] = nums[j];
                        k++;
                    }
                    nums = expectedNums;
                }

            }

            return expectedNums;

        }


    public static void main(String[] args) {
	    int nums[] = {3,2,2,3};
        int val = 3;
        Main obj = new Main();
        int res[] = obj.removeElement(nums,val);
        for(int i : res){
            System.out.println(i);
        }
    }
}
