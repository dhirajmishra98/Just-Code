//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;

#define ll long long


// } Driver Code Ends
//User function template for C++
class Solution{
public:
	#define ll long long

	ll countSubarray(int arr[], int n, int k) {
	    
        ll ans = 0,count = 0;
        for(int i=0;i<n;i++){
            if(arr[i] > k){
                ans = ans + (count*(count+1)/2);
                count=0;
            } else {
                count++;
            }
        }
        ans = ans+ (count*(count+1)/2);
        ll N = n;
        ll total = N*(N+1)/2;
        return total-ans;
	}

};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, k, i;
        cin >> n >> k;
        int arr[n];
        for (i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        auto ans = ob.countSubarray(arr, n, k);
        cout << ans << "\n";
    }
    return 0;
}
// } Driver Code Ends