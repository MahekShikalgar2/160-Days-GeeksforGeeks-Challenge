class Solution {
    static class Job{
        int deadline;
        int profit;
        
        public Job(int deadline, int profit){
            this.deadline = deadline;
            this.profit = profit;
        }
        
    } 

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        Job[] jobs = new Job[n];
        for(int i=0; i<n; i++){
            jobs[i] = new Job(deadline[i], profit[i]);
        }
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        
        int maxDeadline = 0;
        for(int i=0; i<n; i++){
            maxDeadline = Math.max(maxDeadline, jobs[i].deadline);
        }
        boolean[] slots = new boolean[maxDeadline];
        int jobCount = 0;
        int totalProfit = 0;
        
        for(int i=0; i<n; i++){
            for(int j=Math.min(maxDeadline - 1, jobs[i].deadline -1); j>=0; j--){
                if(!slots[j]){
                    slots[j] = true;
                    jobCount++;
                    totalProfit += jobs[i].profit;
                    break;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(jobCount);
        result.add(totalProfit);
        return result;
        
        
    }
}