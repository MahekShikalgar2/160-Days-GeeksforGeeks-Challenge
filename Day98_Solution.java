class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        ArrayList<Double> medians = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); 
        
        for(int num : arr){
            if(maxHeap.isEmpty() || num <= maxHeap.peek()){
                maxHeap.add(num);
            }else{
                minHeap.add(num);
            }
            if(maxHeap.size() > minHeap.size() + 1){
                minHeap.add(maxHeap.poll());
            }else if(minHeap.size() > maxHeap.size()){
                maxHeap.add(minHeap.poll());
            }
            if(maxHeap.size() == minHeap.size()){
                medians.add((double) (maxHeap.peek() + minHeap.peek()) / 2);
            }else{
                medians.add((double) maxHeap.peek());
            }
        }
        return medians;
    }
}