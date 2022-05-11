class Solution {
public:
    bool squareIsWhite(string coordinates) {
       return (((coordinates[0]-65)+(coordinates[1]-65))%2==0)?false:true;
    }
};