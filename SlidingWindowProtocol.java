/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn;
import java.util.Arrays;

public class SlidingWindowProtocol {
private int windowSize;
private int[] frames;
private boolean[] ack;
public SlidingWindowProtocol(int windowSize,int frameCount) {
    this.windowSize= windowSize;
        this.frames= new int[frameCount];
        this.ack= new boolean[frameCount];
        for (int i=0;i<frameCount;i++) {
            frames[i]=i;
            ack[i]=false;
        }
    }
public void sendFrames() {
    int sendIndex= 0;
    while (sendIndex<frames.length) {
        for (int i=0;i<windowSize&&(sendIndex + i)<frames.length;i++) {
            System.out.println("Sending frames"+frames[sendIndex+i]);
        }
        for(int i=0;i<windowSize&&(sendIndex+i)<frames.length;i++){
            ack[sendIndex+i]=recieveAck(sendIndex+i);
        }
        while (sendIndex<frames.length && ack[sendIndex]) {
         sendIndex++;
        }
      }
    }
private boolean recieveAck(int frame) {
    System.out.println("Receiving ack for frame" + frame);
    return true;
}
public static void main(String[] args) {
        int windowSize = 4;
        int frameCount = 10;
        int framec=frameCount/2;
      if(framec<windowSize){
          System.out.println("error");
      }else{
        SlidingWindowProtocol swp = new SlidingWindowProtocol(windowSize, frameCount);
        swp.sendFrames();
    }
    }
}
