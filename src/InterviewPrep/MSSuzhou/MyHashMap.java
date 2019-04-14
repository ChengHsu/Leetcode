package InterviewPrep.MSSuzhou;

import java.util.Objects;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class MyHashMap<K, V> {

    /**
     * Node of Linked List
     *
     * @param <K>
     * @param <V>
     */
    static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

//        public K getKey() {
//            return key;
//        }
//
//        public V getValue() {
//            return value;
//        }
//
//        public Entry<K, V> getNext() {
//            return next;
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            if (obj == this) return true;
//
//            if (obj instanceof Entry) {
//                Entry entry = (Entry)obj;
//
//                return key.equals(entry.getKey()) && value.equals(entry.getValue());
//            }
//
//            return false;
//        }
//
//        @Override
//        public int hashCode() {
//            int hash = 13;
//            hash = 17 * hash + ((key == null) ? 0 : key.hashCode());
//            hash = 17 * hash + ((value == null) ? 0 : value.hashCode());
//            return hash;
//        }
//
//        @Override
//        public String toString() {
//            return "{" + key + "," + value + "}";
//        }
    }


    private Entry<K, V>[] buckets;
    private static final int INITIAL_CAPACITY = 1 << 4; // 16
    private int size = 0;

    public MyHashMap() {
        this.buckets = new Entry[INITIAL_CAPACITY];
    }

    public MyHashMap(int capacity) {
        this.buckets = new Entry[capacity];
    }

    public void put(K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value, null);

        int bucket = getHash(key) % getBucketSize();

        Entry<K, V> existing = buckets[bucket];
        if (existing == null) {
            buckets[bucket] = entry;
            size++;
        } else {
            // compare the keys see if key already exists
            while (existing.next != null) {
                if (existing.key.equals(key)) {
                    existing.value = value;
                    return;
                }
                existing = existing.next;
            }

            // see if the last entry of this bucket has the same key
            // if so update its value
            if (existing.key.equals(key)) {
                existing.value = value;
            }
            // Otherwise, link the new entry to this entry, update the size
            else {
                existing.next = entry;
                size++;
            }
        }
    }


    public V get(K key) {
        Entry<K, V> bucket = buckets[getHash(key) % getBucketSize()];

        while (bucket != null) {
            if (key == bucket.key)
                return bucket.value;
            bucket = bucket.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    private int getBucketSize() {
        return buckets.length;
    }

    private int getHash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entry entry : buckets) {
            sb.append("[");
            while (entry != null) {
                sb.append(entry);
                if (entry.next != null)
                    sb.append(", ");
                entry = entry.next;
            }
            sb.append("]");
        }
        return "{" + sb.toString() + "}";
    }


    public static void main(String[] args) {
        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put("USA", "Washington DC");
        myHashMap.put("Nepal", "Kathmandu");
        myHashMap.put("Australia", "Sydney");


        System.out.println(3 == myHashMap.size());
        System.out.println(myHashMap.get("Nepal").equals("Kathmandu"));
        System.out.println(myHashMap.get("Australia").equals("Kathmandu"));
    }

}


class Test{
    private  int x;
    private  int y;

    @Override
    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return x == test.x;
    }

    @Override
    public int hashCode() {
        super.hashCode();
        return Objects.hash(x, y);
    }
}