class Solution {
    public int findBestValue(int[] arr, int target) {
        int left=0;
        int right=0;
        for(int num:arr){
            right=Math.max(right,num);
        }
            while(left<=right){
                int mid=left+(right-left)/2;
                int sum=getSum(arr,mid);
                if(sum<target){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }
            int sumleft=getSum(arr,left);
            int sumright=getSum(arr,right);
            if(Math.abs(sumleft-target)<Math.abs(sumright-target)){
                return left;
            }
            return right;
    }
        private int getSum(int[] arr,int value){
            int sum=0;
            for(int num:arr){
                sum+=Math.min(num,value);
        }
        return sum;
        
    }
}