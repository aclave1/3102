import java.util.Arrays;

public class KHeap {
	public Node[] heap;
	public int end;
	public int k;

	public KHeap(int numChildren) {
		k = numChildren;
		heap = new Node[100];
		end = 0;
	}

	public Node getChild(Node p, int num) {
		if (num < k && num >= 0) {
			return heap[k * p.pos + num];
		} else
			return null;
	}

	public int parentPos(Node q) {
		return (int) Math.floor((q.pos - 1) / k);
	}

	public void resize() {
		heap = Arrays.copyOf(heap, (heap.length * 2));
	}

	public Node minChild(Node p) {
		int min = 100000;
		int minPos = 0;
		for (int i = p.pos + 1; i <= (k * p.pos) + k; i++) {
			if (heap[i] != null) {
				if (heap[i].key < min) {
					minPos = i;
				}
			}
		}
		return heap[minPos];
	}

	public void insert(int v) {
		if (size() == 0) {
			heap[0] = new Node(v);
			end++;
			return;
		}
		if (size() == heap.length) {
			resize();
		}
		int hole = end;
		Node q = new Node(v);
		heap[hole] = q;
		q.pos = hole;
		q.parPos = parentPos(q);
		while (q.key < heap[q.parPos].key) {
			swap(q, heap[q.parPos]);
		}
		end++;

	}

	public void swap(Node q, Node p) {
		int tempPos, tempPar;
		tempPos = p.pos;
		tempPar = p.parPos;
		heap[p.pos] = q;
		heap[q.pos] = p;
		p.pos = q.pos;
		p.parPos = q.parPos;
		q.pos = tempPos;
		q.parPos = tempPar;
	}

	public int size() {
		return end;
	}

	public Node extractMin() {
		Node min = heap[0];
		heap[0] = heap[end - 1];
		heap[0].pos = 0;
		heap[0].parPos = 0;
		heap[end - 1] = null;
		end--;
		Node newMin = heap[0];
		while (newMin.key > minChild(newMin).key) {
			Node oldMin = newMin;
			newMin = minChild(newMin);
			swap(newMin, minChild(oldMin));
		}
		return min;
	}

}
