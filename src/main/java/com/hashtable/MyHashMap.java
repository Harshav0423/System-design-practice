package com.hashtable;

import java.util.Map;

// hash function
// 2 hash equals means, has a list
public class MyHashMap<K, V> {
    private static int DEFAULT_SIZE=100;
    private int capacity;
    private Entry[] table;

    MyHashMap() {
        this(DEFAULT_SIZE);
    }
    public MyHashMap(int capacity) {
        this.capacity = capacity;
        this.table = new Entry[capacity];
    }

    static  class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }


    }

    private int hashFunction(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }
    public void put(K key, V value) {
        if (key == null) {
            return;
        }
        int hash = hashFunction(key);
        Entry<K, V> newentry = new Entry<>(key, value);
        if (table[hash] == null) {
            table[hash] = newentry;

        }
        else {
            Entry<K, V> cur = table[hash];
            Entry<K, V> prev = null;

            while (cur != null) {
                if (cur.key.equals(key)) {
                    cur.value = newentry.value;
                    return;
                }
                prev = cur;
                cur = cur.next;
            }
            // assign the last position
            prev.next = newentry;
        }
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }
        int hash = hashFunction(key);
        Entry<K, V> cur = table[hash];
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }
}
