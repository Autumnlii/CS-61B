package lecture;



/**
 * Created by qiuying on 2021/1/25.
 * AList Invariants
 * * The position of the next itemm to be inserted is always size
 * * size is always the number of items in the AList
 * * The last item in the list is always in position size -1
 *
 * Resizing arrays
 * ** resizing slowness-addiction is slow, multiplication is faster
 *
 * Mwemory Efficiency
 * * Define the usage ratio  R = size/items.length
 * typical solution: half array size when R < 0.25
 *
 * Generic ArrayList, instead of int, can make array list as items
 */
public class AList {
  int[] items;
  int size;

  public AList() {
      items = new int[100];
      size = 0;
  }


  private void resize(int capacity) {
      int[] a = new int[capacity];
      System.arraycopy(items, 0, a, 0, size);
      items = a;


  }




  public void addLast(int x) {

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

  public int getLast() {
      return items[size - 1];
  }

  public int get(int i){
      return items[i];
  }

  public int size() {
      return size;
    }

    public int removeLast()
    {
        int x = getLast();
        size = size -1;
        return x;
        // there are other ways:
    //int returnItem = items[size - 1];
    //items[size - 1] = 0;
    //size = size - 1;
    //return returnItem;

    }
}
