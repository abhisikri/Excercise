package org.map.excercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class EMap<K,V> { 
     private int size; 
     private ArrayList<LinkedList<MapEntry>> array; 
 
 
     public EMap() { 
         this.size = 0; 
         this.array = new ArrayList<LinkedList<MapEntry>>(128); 
 
 
         for (int i = 0; i < 128; i++) { 
             this.array.add(new LinkedList<MapEntry>()); 
         } 
     } 
 
 
     public boolean isEmpty() { 
         return size() == 0; 
     } 
 
 
     public void add(String key, Object value) { 
         this.remove(key); 
 
 
         array.get(hash(key)).add(new MapEntry(key, value)); 
         size++; 
     } 
      
     public boolean containsKey(String key) { 
         for (MapEntry ele : this.array.get(hash(key))) { 
             if (ele.key.equals(key)) { 
                 return true; 
             } 
         } 
 
 
         return false; 
     } 
 
 
     public int size() { 
         return size; 
     } 
 
 
     public Object get(String key) { 
         for (MapEntry met : this.array.get(hash(key))) { 
             if (met.key.equals(key)) { 
                 return met.value; 
             } 
         } 
 

         throw new NoSuchElementException(); 
     } 
      
     private int hash(String key) { 
         return key.hashCode() % 128; 
     } 
 
     public void remove(String key) { 
         for (MapEntry ele : this.array.get(hash(key))) { 
             if (ele.key.equals(key)) { 
                 this.array.get(hash(key)).remove(ele); 
                 size--; 
                 break; 
             } 
         } 
     } 
 
     private class MapEntry { 
         public final String key; 
         public final Object value; 
          
         public MapEntry(String key, Object value) { 
            this.key = key; 
             this.value = value; 
         } 
     } 
 } 
