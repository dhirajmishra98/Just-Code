class MyHashMap {
    Integer[] arr = new Integer[1000001];
    
    public MyHashMap() {
        
    }
    
    public void put(int key, int value) {
        arr[key] = value;
     }
    
    public int get(int key) {
        return arr[key] == null?-1:arr[key];
    }
    
    public void remove(int key) {
        arr[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */