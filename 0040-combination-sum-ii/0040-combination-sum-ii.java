class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      List<List<Integer>> res=new ArrayList<>();
      Arrays.sort(candidates);
      back(candidates,target,0,new ArrayList<>(),res);
      return res;
    }
    private void back(int[] candidates,int target,int s,ArrayList<Integer> cur, List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i=s;i<candidates.length;i++){
            if(i>s && candidates[i]==candidates[i-1]){
                continue;
            }
            if(target==0){
                break;
            }
            if(candidates[i]>target){
                break;
            }
            cur.add(candidates[i]);
            back(candidates,target-candidates[i],i+1,cur,res);
            cur.remove(cur.size()-1);
        }


    }
}