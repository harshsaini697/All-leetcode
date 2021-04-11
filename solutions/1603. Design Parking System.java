class ParkingSystem {
    int[] freq;
    public ParkingSystem(int big, int medium, int small) {
        freq = new int[4];
        freq[1] = big;
        freq[2] = medium;
        freq[3] = small;
    }
    
    public boolean addCar(int carType) {
        int spaces = freq[carType];
        if(spaces > 0) {
            freq[carType] = spaces - 1;
            return true;
        }
        return false;
    }
}
​
/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
