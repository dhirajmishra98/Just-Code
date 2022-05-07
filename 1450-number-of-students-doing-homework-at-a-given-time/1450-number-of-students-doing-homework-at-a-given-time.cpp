class Solution {
public:
    int busyStudent(vector<int>& startTime, vector<int>& endTime, int queryTime) {
        int student = 0;
        for(int i=0;i<startTime.size();i++){
            if(endTime[i]==startTime[i] && endTime[i]==queryTime)
                student++;
            else if(startTime[i]<=queryTime && queryTime<=endTime[i])
                student++;
        }
        return student;
    }
};