class Solution {
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                map.put(bills[i],map.getOrDefault(bills[i],0)+1);
            } else if(bills[i]==10){
                if(map.containsKey(5)){
                    map.put(bills[i],map.getOrDefault(bills[i],0)+1);
                    int freq = map.get(5);
                    if(freq == 1) map.remove(5);
                    else map.put(5,freq-1);
                }else{
                    return false;
                }
            }else {
                int temp = bills[i];
                map.put(bills[i],map.getOrDefault(bills[i],0)+1);
                if(map.containsKey(10)){
                    int freq = map.get(10);
                    if(freq == 1) map.remove(10);
                    else map.put(10,freq-1);
                    temp -= 10;
                }
                if(map.containsKey(5)){
                    if(temp == 20){
                        if(map.get(5) < 3) return false;
                        else {
                            int freq = map.get(5);
                            map.put(5,freq-3);
                        }
                    } else{
                            if(map.get(5) < 1) return false;
                        else {
                            int freq = map.get(5);
                            if(freq == 1) map.remove(5);
                            else map.put(5,freq-1);
                        }
                        }
                    }
                else{
                    return false;
                }
                }
            }
        
        return true;
    }
}