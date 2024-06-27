package arrays;

import java.util.ArrayList;
import java.util.Iterator;

public class MyHashMap<K, V> {
    ArrayList<Pair<K, V>>[] values;
    int numberOfPairs;

    public MyHashMap() {
        this.values = new ArrayList[32];
        this.numberOfPairs = 0;
    }

    public V get(K key) {
        // Compute the hashValue modulo the size of the array
        int hashvalue = Math.abs(key.hashCode() % this.values.length);

        // if the Arraylist is null, return null
        if (this.values[hashvalue] == null) {
            return null;
        }

        // retrieve the corresponding ArryList
        ArrayList<Pair<K, V>> list = this.values[hashvalue];

        // loop over the ArraYlisy and find the Pair with the same Key.
        // for that pair, return the value
        // if nothing is found return null
        for (Pair<K,V> pair: list) {
            if (pair.getKey().equals(key)) {
                return pair.getValue();
            }
        }
        return null;
    }

    public void add(K key, V value) {

        // Compute the hashValue modulo the size of the array
        int hashValue = Math.abs(key.hashCode() % this.values.length);
        // if there is not Arraylist at position hashValue, we create one
        if (this.values[hashValue] == null) {
            this.values[hashValue] = new ArrayList<>();
        }
        //if there is already a Pair with the same key, we change the value
        for (Pair<K,V> pair: this.values[hashValue]) {
            if (pair.getKey().equals(key)) {
                pair.setValue(value);
                return;
            }
        }
        // if there is not already a Pair with the same key, we add the new Pair
        this.values[hashValue].add(new Pair(key, value));

        // Increase the number of Pairs
        this.numberOfPairs++;
        // Grow the array if necessary
        if (this.numberOfPairs / this.values.length > 0.75) {
            this.grow();
        }

    }

    public void grow() {
        // create a new array double the size of the original array
        ArrayList<Pair<K,V>>[] newValues = new ArrayList[this.values.length * 2];
        // copy the elements of the old array into the newArray.
        for (int i=0; i<this.values.length; i++) {
            if (!(this.values[i].isEmpty())) {
                for (Pair pair: this.values[i]) {
                    int hashCode = pair.getKey().hashCode() % newValues.length;
                    if (newValues[hashCode] == null) {
                        newValues[hashCode] = new ArrayList<>();
                    }
                    newValues[hashCode].add(pair);
                }
            }
        }
        // replace the old array with the new array
        this.values = newValues;
    }

    public void remove(K key) {
        // Find the index in the array where the pair lives
        int hashCode = Math.abs(key.hashCode() % this.values.length);
        // Find the pair in the List at that sits at index hashCode of the array and remove it
        Iterator<Pair<K,V>> iterator = this.values[hashCode].iterator();
        while(iterator.hasNext()) {
            Pair<K,V> pair = iterator.next();
            if (pair.getKey().equals(key)) {
                iterator.remove();
            }
        }
    }
}

