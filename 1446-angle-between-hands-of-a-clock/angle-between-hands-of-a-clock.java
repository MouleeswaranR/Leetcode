class Solution {
    public double angleClock(int hour, int minutes) {
        double minAngle=6.0*minutes;
        double hourAngle=30*(hour%12)+0.5*minutes;

        double absDiff=Math.abs(minAngle-hourAngle);

        return Math.min(absDiff,360-absDiff);
    }
}