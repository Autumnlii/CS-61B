package lecture;

/**
 * Created by qiuying on 2021/1/25.
 */

public class AListGeneric<Glorp> {
    private Glorp[] items;
    int size;

    public AListGeneric() {
        items = (Glorp[]) new Object[8];
        size = 0;
    }


    private void resize(int capacity) {
        Glorp[] a = (Glorp[]) new Object[capacity] ;
        System.arraycopy(items, 0, a, 0, size);
        items = a;


    }




    public void addLast(Glorp x) {

        // this is how to resize the array list
        if(size == items.length) {
            //int[] a = new int[size +1];
            //System.arraycopy(items, 0, a, 0, size);
            //items = a;
            //resize(size+1); // be careful, add a factor cam be very slow- addiction is slow
            resize(size*10); // this method is faster- multiplication is great performance, how python list is implemented
        }
        items[size] = x;
        size = size + 1;
    }

    public Glorp getLast() {
        return items[size - 1];
    }

    public Glorp get(int i){
        return items[i];
    }

    public int size() {
        return size;
    }

    public Glorp removeLast()
    {
        Glorp x = getLast();
        items[size -1] = null; // java only destroys unwanted objects when the last reference has been lost, the memory will be lost
        size = size -1;
        return x;
        // there are other ways:
        //int returnItem = items[size - 1];
        //items[size - 1] = 0;
        //size = size - 1;
        //return returnItem;

    }
}
