package heaps;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.Collections;
import java.util.PriorityQueue;

public class HighestProductOfStream {
    PriorityQueue<Integer> heap;
    int product = 1;
    int numberOfElements;


    public static void main(String[] args) throws InvalidArgumentException {
        HighestProductOfStream hps = new HighestProductOfStream(3);
        hps.newValue(3);
        hps.newValue(4);
        hps.newValue(10);
        hps.newValue(12);
        hps.newValue(0);
        hps.newValue(30);
        hps.newValue(8);
        hps.newValue(6);

        int hp = hps.getHighestProductOf();
    }

    public HighestProductOfStream(int numberOfElements){
        this.numberOfElements = numberOfElements;
        heap =  new PriorityQueue();
    }

    public void newValue(int value){
        if (heap.size() < numberOfElements){
            heap.add(value);
            product *= value;
            return;
        }

        if (heap.peek() < value) {
            int minValueInHeap = heap.poll();
            product /= minValueInHeap;
            heap.add(value);
            product *= value;
        }

    }

    public int getHighestProductOf() throws  InvalidArgumentException{
        if (numberOfElements > heap.size()){
            throw new InvalidArgumentException(new String[]{"Stream does not contain enough elements yet"});
        }

        return product;
    }


}
