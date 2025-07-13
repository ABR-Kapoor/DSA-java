public class DynamicArray {

    private int data[];
    private int nextIndex;

    public DynamicArray(){
        data = new int[5];
        nextIndex = 0;
    }

    public void add(int element) {
        if(data.length == nextIndex){
            restuct();
        }
        data[nextIndex] = element;
        nextIndex++;
    }

    public void set(int index, int element) {
        if (index > nextIndex){
            restuct();
        }
        if (index < nextIndex){
            data[index] = element;
        } else{
            add(element);
        }
    }

    public boolean isEmmpty() {
        if(size() == 0){
            return true;
        }
        return false;
    }

    public int size() {
        return nextIndex;
    }

    public int removeLast() {
        if(size() == 0){
            return -1;
        }
        int value = data[nextIndex - 1];
        data[nextIndex - 1] = 0;
        nextIndex--;
        return value;
    }

    public int get(int i) {
        if (i >= nextIndex){
            return -1;
        }
        return data[i];
    }

    private void restuct(){
        int[] temp = data;
        data = new int[data.length * 2];
        System.arraycopy(temp, 0, data, 0, temp.length);
    }
    
}
