class Solution {
    static class Activity {
       int start;
       int finish;
       
       public Activity(int start, int finish){
           this.start = start;
           this.finish = finish;
          
       }
    }
       public int activitySelection(int[] start, int[] finish){
           Activity[] activities = new Activity[start.length];
           for(int i=0; i<start.length; i++){
               activities[i] = new Activity(start[i], finish[i]);
           }
           Arrays.sort(activities, (a, b) -> a.finish - b.finish);
           
           int count = 1;
           int prevFinish = activities[0].finish;
           
           for(int i=1; i<activities.length; i++){
               if(activities[i].start > prevFinish){
                   count++;
                   prevFinish = activities[i].finish;
               }
           }
           return count;
       }
    }

