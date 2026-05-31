class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        for(int asteriod:asteroids){
            if(mass<asteriod){
                return false;
            }else if(mass>=1e5){
                return true;
            }

            mass+=asteriod;
        }
        return true;
    }
}