package org.map.excercise;

import static org.junit.Assert.*;



import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class EMapTest { 
     private EMap<String,Integer> map; 
    
     // Set up an empty map before every test   
     @Before 
     public void setUp() { 
         this.map = new EMap<String, Integer>(); 
     } 
 
 
     // Test that a new HashMap returns 'true' for isEmpty 
     @Test 
     public void testIsEmptyForNewMap() { 
         assertTrue(map.isEmpty()); 
     }  
      
     // Test adding an element makes isEmpty return 'false' 
     @Test 
     public void testAddMakesIsEmptyFalse() { 
         map.add("Abhi", 5); 
         assertFalse(map.isEmpty()); 
     } 
      
     // Check that size returns 0 for new HashMaps 
     @Test 
     public void testSizeForNewMap() { 
         assertEquals(0, map.size()); 
     } 
      
     // Test size increases as elements are added 
     @Test 
     public void testSizeIncrementsWhenAddingElements() { 
         map.add("Abhi", 5); 
         assertEquals(1, map.size()); 
          
         map.add("Rocks", 5); 
         assertEquals(2, map.size()); 
     } 
      
     // Make sure get returns the values added under keys 
     @Test 
     public void testGetReturnsCorrectValue() { 
         map.add("Abhi", 5); 
         map.add("Rocks", 6); 
         assertEquals(5, map.get("Abhi")); 
         assertEquals(6, map.get("Rocks")); 
     } 
      
     // Test that an exception is thrown if a key does not exist 
     @Test(expected= NoSuchElementException.class) 
     public void testThrowsExceptionIfKeyDoesNotExist() { 
         map.get("Abhi"); 
     } 
 
 
     // Test thats an added element replaces another with the same key 
     @Test 
     public void testReplacesValueWithSameKey() { 
         map.add("Abhi", 5); 
         map.add("Abhi", 6); 
          
        assertEquals(6, map.get("Abhi")); 
     } 
      
     // Make sure that two (non-equal) keys with the same hash do not overwrite each other 
     @Test 
     public void testDoesNotOverwriteSeperateKeysWithSameHash() { 
         map.add("Ea", 5); 
         map.add("FB", 6); 
          
         assertEquals(5, map.get("Ea")); 
         assertEquals(6, map.get("FB")); 
     } 
      
     // Make sure size doesn't decrement below 0 
     @Test 
     public void testRemoveDoesNotEffectNewMap() { 
         map.remove("Abhi"); 
 
 
         assertEquals(0, map.size()); 
     } 
      
     // test that size is reduced as elements are used 
     @Test 
     public void testRemoveDecrementsSize() { 
         map.add("Abhi", 5); 
         map.add("Rocks", 6); 
          
         map.remove("Abhi"); 
          
         assertEquals(1, map.size()); 
          
         map.remove("Rocks"); 
          
         assertEquals(0, map.size()); 
     } 
 
 
     // Test elements are actually removed when remove is called 
     @Test(expected= NoSuchElementException.class) 
     public void testRemoveDeletesElement() { 
       map.add("Abhi", 5); 
        map.remove("Abhi"); 
          
         map.get("Abhi"); 
     } 
      
    // Test that contains is 'false' for the new map
     @Test 
     public void testContainsKeyForNewMap() { 
         assertFalse(map.containsKey("Abhi")); 
     } 
      
     // Test that contains returns 'false' when key does not exist 
     @Test 
     public void testContainsKeyForNonExistingKey() { 
         map.add("Abhi", 5); 
         assertFalse(map.containsKey("Rocks")); 
     } 
 
 
     // test that contains returns 'true' in the absence of key
     @Test 
     public void testContainsKeyForExistingKey() { 
         map.add("Abhi", 5); 
         assertTrue(map.containsKey("Abhi")); 
     } 
      
     // Check that contains is right about hash codes
     @Test 
     public void testContainsKeyForKeyWithEquivalentHash() { 
       map.add("Ea", 5); 
          
         assertFalse(map.containsKey("FB")); 
     } 
 } 

