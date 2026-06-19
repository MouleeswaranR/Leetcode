//use max heap to get max value from 1st half of stream at any point
//use min heap to get min value from 2nd half of stream at any point

class MedianFinder {
    private PriorityQueue<Integer> maxHeap;//stores in descending order (max value at top)
    private PriorityQueue<Integer> minHeap;//stores in ascneding order (min value at top)
    public MedianFinder() {
        maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        minHeap=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        //if max heap is empty or number inserting is less than top of max heap,insert it into max heap
        if(maxHeap.isEmpty()|| num<maxHeap.peek()){
            maxHeap.offer(num);
        }else{//if number is greater than max heap top element , insert it into minheap
            minHeap.offer(num);
        }

        //always maintain size difference between the heaps <=1,balance it by taking extra element and put in into other heap
        if(Math.abs(maxHeap.size()-minHeap.size())>1){
            minHeap.offer(maxHeap.poll());
        }else if(minHeap.size()>maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        //if both heap size is same, even number of median values
        if(maxHeap.size()==minHeap.size()){
            return (double)(minHeap.peek()+maxHeap.peek())/2;
        }

        //else always max heap will have the maximum median till now found
        return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */