/**
@Authors: 
Alex Clavelle
Kelsey Cameron

 */

import java.util.Arrays;
import java.util.Random;

@SuppressWarnings("unused")
public class SortComp {

	public static void main(String[] args) {

		Random rand = new Random();
		System.out.println("Average times for quicksort:");
		//increase input array size
		for(int size = 10000; size < 10000001;size*=10){
			//run it multiple times and average the time
			double average = 0;
			for(int i = 1; i <= 10; i++){
				int[] unsorted = new int[size];
				//fill
				for(int j = 0;j<unsorted.length-1;j++){
					unsorted[j] = rand.nextInt();
				}
				double start,end;
				start = System.nanoTime();
				Arrays.sort(unsorted);
				end = System.nanoTime();
				average += (end - start);
						
			}
			average /=11.0;
			
			System.out.printf("length: \n%d \ntime elapsed:%f\n",size,average);
			
			
		}
		
		
		
		
	}
}
