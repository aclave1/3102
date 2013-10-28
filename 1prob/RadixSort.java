import java.util.ArrayDeque;
import java.util.Random;

public class RadixSort {

	public int numBuckets = 10;
	public int[] unsorted;
	public int[] sorted;

	public static void main(String[] args) {
		Random rand = new Random();
		RadixSort rad = new RadixSort();
		rad.unsorted = new int[10];
		rad.sorted = new int[rad.unsorted.length];
		
		for (int i = 0; i < rad.unsorted.length; i++) {
			rad.unsorted[i] = Math.abs(rand.nextInt(101));
		}
		rad.unsorted[rad.unsorted.length-1] = 100;

		rad.sorted = rad.sort(rad.unsorted, 10);
		for (int i = 0; i < rad.unsorted.length - 1; i++) {
			System.out.print(rad.unsorted[i] + ",");
		}
		System.out.println();
		for (int i = 0; i < rad.sorted.length - 1; i++) {
			System.out.print(rad.sorted[i] + ",");
		}
	}

	public int[] sort(int[] us, int base) {

		ArrayDeque<Integer>[] buckets = new ArrayDeque[10];
		for (int i = 0; i < 10; i++) {
			buckets[i] = new ArrayDeque<Integer>();
		}
		int max = 0;
		for (int i = 0; i < us.length - 1; i++) {
			max = us[i];
			// get the biggest number
			if (max < us[i + 1]) {
				max = us[i + 1];
			}
		}
		int digits = (int) (Math.log10(max) + 1);
		// run through the whole array j times where j is the number of
		// digits
		int divisor = 1;
		for (int j = 0; j < digits; j++) {
			for (int i = 0; i < us.length; i++) {
				int val = us[i];
				int digit = val / divisor % 10;
				buckets[digit].add(us[i]);
			}
			int index = 0;
			for (ArrayDeque<Integer> deq : buckets) {
				while (!deq.isEmpty()) {
					int num = deq.remove();
					us[index++] = num;
				}
			}
			divisor *= 10;
		}
		return us;
	}
}
