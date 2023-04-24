//{ Driver Code Starts
//Initial Template for C++


#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution
{
public:
    vector<int> nearestSmallerTower(vector<int> arr)
    {
        int minl, minr, findl=false, findr=false, find=false;
        vector<int> ans(arr.size());
        int mini = INT_MAX;
        
        for(auto i:arr)
            mini = min(mini, i);
        
        for(auto i=0; i<arr.size(); ++i){
            if(arr[i]==mini){
                ans[i]=-1;
            }
        }
        
        for(int i=0; i<arr.size(); ++i){
            int j=i-1, k=i+1;
            if(ans[i]==-1)
                continue;
            while(j>=0 || k<arr.size()){
                findl=false, findr=false, find=false;
                if(j>=0 && arr[j]<arr[i]){
                    minl=arr[j];
                    findl=true;
                }
                if(k<arr.size() && arr[k]<arr[i]){
                    minr=arr[k];
                    findr=true;
                }
                
                if(findl==false && findr==false && k>arr.size() && arr[j]==arr[i]){
                    ans[i] = ans[j];
                    find=true;
                    break;
                }
                else if(findl==true && findr==true){
                    if(minl < minr)
                        ans[i] = j;
                    else if(minr < minl)
                        ans[i] = k;
                    else
                        ans[i] = j;
                    find=true;
                    break;
                }
                else if(findl==true){
                    ans[i]=j;
                    find=true;
                    break;
                }
                else if(findr==true){
                    ans[i]=k;
                    find=true;
                    break;
                }
                
                if(j>=0)    j--;
                if(k<arr.size())    k++;
            }
            if(findl==false && findr==false && find==false)
                ans[i]=-1;
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int n;
        cin >> n;
        vector<int> v(n);
        for (int i = 0; i < n; i++)
        {
            cin >> v[i];
        }
        Solution ob;
        vector<int> ans = ob.nearestSmallerTower(v);
        for (int i = 0; i < n; i++)
        {
            cout << ans[i] << " ";
        }
        cout << "\n";
    }
    return 0;
}
// } Driver Code Ends