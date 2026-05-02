class Solution {
    int[] memo;

    public int isGood(int num){
        if(memo[num]!=-1)return memo[num];

        if(num==0)return 0;

        int remain=isGood(num/10);
        if(remain==2)return memo[num]=2;

        int digit_check;
        int d=num%10;

        if(d==0||d==1||d==8){
           digit_check=0;
        }else if(d==2||d==5||d==6||d==9){
            digit_check=1;
        }else{
            return memo[num]=2;
        }

        if(remain==0 && digit_check==0){
            return memo[num]=0;
        }

        return memo[num]=1;
    }
    public int rotatedDigits(int n) {
        memo=new int[n+1];

        Arrays.fill(memo,-1);


        int count=0;

        for(int i=1;i<=n;i++){
            if(isGood(i)==1){
                count++;
            }
        }

        return count;
    }
}