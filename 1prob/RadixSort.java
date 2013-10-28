import java.util.ArrayList;
import java.util.List;

public class RadixSort {

	public int numBuckets = 10;
	public int[] unsorted;
	public int[] sorted;
	
	public static void main(String[] args){

		RadixSort rad = new RadixSort();
		rad.unsorted = new int[] {9,3,6,3,7};
	
		rad.sorted = rad.sort(rad.unsorted, 10);
		for(int i=0;i<rad.unsorted.length-1;i++){
			System.out.print(rad.unsorted[i]+",");
		}
		for(int i=0; i< rad.sorted.length-1;i++){
			System.out.print(rad.sorted[i]+",");
		}
	}


	public int[] sort(int[] us, int base) {

		ArrayList[] buckets = new ArrayList[10];

		for (int i = 0; i < us.length -1; i++) {
			int max = us[i];
			// get the biggest number
			if ( max < us[i + 1]) {
				max = us[i - 1];
			}
			int digits = (int) (Math.log10(max) + 1);
			// run through the whole array j times where j is the jumber of
			// digits
			for (int j = 1; j < digits-1; j++) {
					int divisor = 1;
					int digit = us[i] / divisor % 10;
					buckets[digit].add(us[i]);
			}
		}
		return sorted;
	}

}
