package problemSet_1;

/**
 * Created by Prakash on 01-11-2018.
 */
public class Test {
    public static void main(String[] a) {
        Heap<Integer> heap = new Heap<Integer>(false, 2, Integer.class);
        heap.offer(2);
        heap.offer(1);
        heap.offer(3);
        System.out.println(heap.poll());
        System.out.println(heap.size());

    }
}
