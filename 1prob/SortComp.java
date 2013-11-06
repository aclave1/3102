/**
@Authors: 
Alex Clavelle
Kelsey Cameron

 */

import java.util.Arrays;
import java.util.Random;

public class SortComp {

	public static void main(String[] args) {

		Random rand = new Random();
		System.out.println("Average times for quicksort:");
		// increase input array size
		for (int size = 10000; size <= 1000000; size *= 10) {
			// run it multiple times and average the time
			double average = 0;
			int i = 1;
			for (; i <= 10; i++) {
				int[] unsorted = new int[size];
				// fill
				for (int j = 0; j < unsorted.length - 1; j++) {
					unsorted[j] = rand.nextInt();
				}
				double start, end;
				start = System.nanoTime();
				Arrays.sort(unsorted);
				end = System.nanoTime();
				average += (end - start);

			}

			average /= i;

			System.out.printf("length: %d \ntime elapsed:%f micro-sec \n",
					size, average / 1000);
			
		}
		System.out.println();
		/* Start radix timing */
		System.out.println("Average times for radixsort");
		// increase input array size
		for (int size = 10000; size <= 1000000; size *= 10) {
			// run it multiple times and average the time
			double average = 0;
			int i = 1;
			for (; i <= 10; i++) {
				int[] unsorted = new int[size];
				// fill
				for (int j = 0; j < unsorted.length - 1; j++) {
					unsorted[j] = rand.nextInt();
				}
				double start, end;
				start = System.nanoTime();
				Arrays.sort(unsorted);
				end = System.nanoTime();
				average += (end - start);

			}
			average /= i;
			System.out.printf("length: %d \ntime elapsed:%f micro-sec \n", size,
					average / 1000);

		}

	}
}
