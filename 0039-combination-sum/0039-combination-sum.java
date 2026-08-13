class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        back(candidates,target,0,new ArrayList<>(),res);
        return res;
       
    }
    private void back(int candidates[],int target,int s,ArrayList<Integer> cur,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(cur));
        }
        for(int i=s;i<candidates.length;i++){
            if(candidates[i]>target){
                break;
            }
            cur.add(candidates[i]);
            back(candidates,target-candidates[i],i,cur,res);
            cur.remove(cur.size()-1);
        }
    }
}