class Solution {
    int memo[101][101][601];

public:
    int solve(vector<pair<int,int>>& count,int m,int n,int index){
        if(index>=count.size()||(m==0 && n==0))return 0;

        if(memo[m][n][index]!=-1){
            return memo[m][n][index];
        }
        int take=0;
        if(count[index].first<=m && count[index].second<=n){
            take=1+solve(count,m-count[index].first,n-count[index].second,index+1);
        }

        int skip=solve(count,m,n,index+1);

        return memo[m][n][index]=max(skip,take);
    }
public:
    int findMaxForm(vector<string>& strs, int m, int n) {
        int N=strs.size();

        vector<pair<int,int>> count(N);

        for(int i=0;i<N;i++){

            int zeros=0,ones=0;

            for(char& ch:strs[i]){
                if(ch=='0')
                    zeros++;
                else
                    ones++;
            }

            count[i]={zeros,ones};
        }
        memset(memo,-1,sizeof(memo));
        return solve(count,m,n,0);
    }
};