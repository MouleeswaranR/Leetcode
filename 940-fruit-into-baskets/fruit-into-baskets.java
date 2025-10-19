class Solution {
    public int totalFruit(int[] fruits) {
        int left=0,right=0,maxlen=0;
      Map<Integer,Integer> mpp=new HashMap<>();
      while(right<fruits.length){
        mpp.put(fruits[right],mpp.getOrDefault(fruits[right],0)+1);
        if(mpp.size()>2){
            mpp.put(fruits[left],mpp.get(fruits[left])-1);
            if(mpp.get(fruits[left])==0)mpp.remove(fruits[left]);
            left++;
        }
        if(mpp.size()<=2){
            maxlen=Math.max(maxlen,right-left+1);
        }
        right++;
      }
      return maxlen;
    }
}

// public class Solution {
//     public int totalFruit(int[] fruits) {
//         int n = fruits.length;
//         int lastFruit = -1, secondLastFruit = -1;
//         int lastCount = 0, currMax = 0, max = 0;

//         for (int i = 0; i < n; i++) {
//             int fruit = fruits[i];

//             if (fruit == lastFruit || fruit == secondLastFruit) {
//                 currMax++;
//             } else {
//                 currMax = lastCount + 1;
//             }

//             if (fruit == lastFruit) {
//                 lastCount++;
//             } else {
//                 lastCount = 1;
//                 secondLastFruit = lastFruit;
//                 lastFruit = fruit;
//             }

//             max = Math.max(max, currMax);
//         }

//         return max;
//     }
// }