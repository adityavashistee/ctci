import java.util.*;

import java.lang.Math;
class ArraysSoln{

	public static boolean findDifferencePair(int[] nums,int target){
		Arrays.sort(nums);
		int i=0, j=1;
		while(i<j){
			if(nums[j]-nums[i] == target) return true;
			else if(nums[j]-nums[i] >= target) i++;
			else j++;
		}
		return false;
	}

	public static int findSubArrayWitheq1and0(int[] nums){
		int[] leftSum = new int[nums.length];
		int max=-1;
		int sum=0;
		// case 1 when starting index is included in the max array
		for (int i=0;i<nums.length ;i++ ) {
			if(nums[i]==0){
				leftSum[i]=--sum;
			}
			else{
				leftSum[i]=++sum;
			}
			if(leftSum[i]==0) max=i+1;
		}

		//case 2 when starting index is not included
		Map<Integer,Integer> hm= new HashMap<Integer,Integer>(); 
		for (int j=0;j<nums.length ;j++) {
			int key = leftSum[j];
			if(!hm.containsKey(key)) hm.put(key,j);

			else {
				Integer temp = hm.get(key);
				if(j-temp >max) max = j-temp;
			}
		}
		return max;
	}

	public static void printOddElements(int[] nums){
		int xor =nums[0];
		for(int i=1;i<nums.length;i++){
			xor=xor ^ nums[i];
		}

		int xor2 = xor & ~(xor-1); // this will give the right most set bit

		//divide the array into tow parts one divisible by xor2 and one not
		int j=0,k=nums.length-1;
		while(j<k){
			if((nums[j] & xor2) >0) j++;
			else {
				int temp=nums[j];
				nums[j]=nums[k];
				nums[k]=temp;
				--k;
			}
		}
		int num1=0,num2=0;
		for(int a=0;a<nums.length;a++){
			if(a<j)num1=num1^nums[a];
			else num2=num2 ^ nums[a];
		}
		System.out.println(num1+" "+num2);
	}

	public static boolean findAdditionPair(int[] nums,int target){
		Arrays.sort(nums);
		int i=0, j=nums.length-1;
		while(i<j){
			if(nums[i]+nums[j] == target) return true;
			else if(nums[i]+nums[j]>target) j--;
			else i++;
		}
		return false;
	}

	public static int maxSubarrayProduct(int arr[])
    {
        int maxoutput=1;
        int maxindex=1;
        int minindex=1;
        for (int i=0; i<arr.length ;i++) {
        	
        }
        return 0;
    }

	public static void main(String[] args) {
		//System.out.println("Hello World");
		int[] arr = {1,2,10 ,3, 7, 0, 9, 8};
		System.out.println(findDifferencePair(arr,0));
		System.out.println(findAdditionPair(arr,5));
		int[] arr2 = {1,0,0,1,0,1,1};
		System.out.println(findSubArrayWitheq1and0(arr2));
		int[] arr3 ={1,1,0,1,1,0};
		System.out.println(findSubArrayWitheq1and0(arr3));
		//int[] arr4=
		printOddElements(new int[] {10,20,3,3,10,20,2,5,10,5,20,5,10,20});
	}
}