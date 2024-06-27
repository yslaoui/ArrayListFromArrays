package arrays;
import java.util.Arrays;

public class List<T> {
    T[] values;
    int firstFreeIndex;

    public List() {
        this.values = (T[]) new Object[10];
        this.firstFreeIndex = 0;
    }

    public void add(T value) {
        if (this.firstFreeIndex == this.values.length) {
            this.grow();
        }
        this.values[firstFreeIndex] = value;
        this.firstFreeIndex ++;
    }

    public void grow() {
        int newSize = this.values.length + this.values.length / 2;
        T[] newArray = (T[]) new Object[newSize];
        for (int i=0; i<this.values.length; i++) {
            newArray[i] = this.values[i];
        }
        this.values= newArray;
    }

    public boolean contains(T value) {
        for (int i=0; i< this.firstFreeIndex; i++) {
            if (this.values[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    private int indexOfValue(T value) {
        int defaultValue = -1;
        for (int i=0; i<this.firstFreeIndex; i++) {
            if (this.values[i].equals(value)) {
                defaultValue = i;
            }
        }
        return defaultValue;
    }

    private void moveToTheLeft(int fromIndex) {
        for (int i=fromIndex; i< this.firstFreeIndex-1; i++) {
            this.values[i] = this.values[i+1];
        }
        this.values[firstFreeIndex - 1] = null;
        this.firstFreeIndex--;
    }

    public void remove(T value) {
        int indexOfValue = indexOfValue(value);
        if (indexOfValue == -1) {
            System.out.println("The value is not present in the array");
            return;
        }
        this.moveToTheLeft(indexOfValue);
    }

    public int getFirstFreeIndex() {
        return this.firstFreeIndex;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.values);
    }
}



//Q. Let's implement the method public void remove(Type value), which removes one value type value.
// Do this in two steps
//implement the method private int indexOfValue(Type value), which searches for the index of the given value. The method returns -1 if the value is not found.
//implement the method private void moveToTheLeft(int fromIndex), which moves values from the given index one place to the left.
//implement the method remove using these two methods.

