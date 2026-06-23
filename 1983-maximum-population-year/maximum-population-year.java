class Solution {
    //using Line sweep technique
    public int maximumPopulation(int[][] logs) {

        List<int[]> events=new ArrayList<>();//{year,event(either +1 or -1)}

        //creating events birthyear = +1, deathyear = -1
        for(int[] log:logs){
            int birthYear=log[0],deathYear=log[1];
            events.add(new int[]{birthYear,+1});
            events.add(new int[]{deathYear,-1});
        }

        //sorting based on years, if years are same , death should be counted first
        Collections.sort(events,(a,b)->{
            //if year are same,based on death
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return Integer.compare(a[0],b[0]);//sort on year
        });

        int currPopulation=0,maxPopulation=0,year=0;

        //process events sorted ascendingly based on years
        for(int[] event:events){
            int currYear=event[0],val=event[1];

            currPopulation+=val;
            //if current population on current year is greater than already maximum population,update it
            if(currPopulation>maxPopulation){
                maxPopulation=currPopulation;
                year=currYear;
            }
        }

        return year;
    }
    

    //Difference Array Technique
    // public int maximumPopulation(int[][] logs) {

    //     int[] years=new int[2051];//years maximum: 1950-2050 according to constraints


    //     for(int[] log:logs){//marking birth year as +1  until death, death year as  -1
    //         int birthYear=log[0],deathYear=log[1];
    //         years[birthYear]+=1;
    //         years[deathYear]-=1;
    //     }

    //     int currPopulation=0,maxPopulation=0,year=0;

    //     //process based on years
    //     for(int yr=1950;yr<=2050;yr++){

    //         currPopulation+=year[yr];
    //         //if current population on current year is greater than already maximum population,update it
    //         if(currPopulation>maxPopulation){
    //             maxPopulation=currPopulation;
    //             year=currYear;
    //         }
    //     }

    //     return year;
    // }

}