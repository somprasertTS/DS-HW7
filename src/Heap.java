/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package hw7;

/**
 *
 * @author patiw
 */
public class Heap {
    boolean isMinHeap; // true if minHeap, false if maxHeap
    int heapSize;
    Node[] arr;//Array as a complete binary tree
    int back;
    // For each node to be inserted into the heap, timeCounter will increase by 1
    int timeCounter;
    public Heap(boolean isMinHeap, int size){
        arr = new Node[size+1];
        heapSize = size;
        back = 1;
        this.isMinHeap = isMinHeap;
        timeCounter = 0;
    }
    public Node top(){
        return arr[1];
    }

    public void push(Node node){
        int posn=timeCounter+1;
        arr[timeCounter+1]=node;
        while(posn>0 && arr[posn].price>arr[posn/2].price) {
            swap(posn, posn/2);
            posn = posn/2;
        }
        back++;
        timeCounter++;
        timestamp=timeCounter;
    }
    public Node pop(){
        Node temp=arr[1];
        arr[1]=arr[timeCounter];
        int posn=1;
        while (posn<timeCounter-1){
            if(arr[posn].price>arr[posn*2].price){
                swap(posn,posn*2);
                posn=posn*2;
            }else if(arr[posn].price>arr[(posn*2)+1].price){
                swap(posn,(posn*2)+1);
                posn=(posn*2)+1;
            }
        }
        // 1. mark the root for return
        // 2. Replace the last node with the root
        // 3. Sift (percolate) down
        return temp; // You may have to fix this line
    }

    // Optional: If you do not know what this function does, you do not have to use it
    public void swap(int index1, int index2){
        Node temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    // Optional: If you do not know what this function does, you do not have to use it
    public void printArray(){
        System.out.print("[");
        for (int i=1; i<back; i++){
            System.out.print(arr[i].price);
            if (i<back-1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

}
