import java.util.ArrayList;
import java.util.List;

public class RadixSort {

	public int numBuckets = 10;
	public int[] unsorted;
	public int[] sorted;

	public int[] sort(int[] us, int base) {

		ArrayList[] buckets = new ArrayList[10];

		for (int i = 0; i < us.length; i++) {
			int max = us[i];
			// get the biggest number
			if (max < us[i + 1]) {
				max = us[i - 1];
			}
			int digits = (int) (Math.log10(max) + 1);
			// run through the whole array j times where j is the jumber of
			// digits
			for (int j = 0; j < digits; j++) {
				
			}

		}
		return sorted;
	}

}
