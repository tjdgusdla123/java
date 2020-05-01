package javaapp0427;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class Queue {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = 
				new PriorityQueue<>();
		pq.add(100);
		pq.add(50);
		pq.add(300);
		
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		
		ArrayDeque <Integer> ad = 
			new ArrayDeque<Integer>();
		

	}

}
