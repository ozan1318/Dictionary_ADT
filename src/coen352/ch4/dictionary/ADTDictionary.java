package coen352.ch4.dictionary;

import coen352.ch4.list.InventoryRecord;
import coen352.ch4.list.Key;

/** Source code example for "A Practical Introduction to Data
Structures and Algorithm Analysis, 3rd Edition (Java)" 
by Clifford A. Shaffer
Copyright 2008-2011 by Clifford A. Shaffer
*/

/** The Dictionary abstract class. */
public interface ADTDictionary<Key, E> {

/** Reinitialize dictionary */
public void clear();

/** Insert a record
  @param k The key for the record being inserted.
  @param e The record as an object of InventoryRecord being inserted. */
public void insert(Key k, InventoryRecord e);

/** Remove and return a record.
  @param k The key of the record to be removed.
  @return A maching record. If multiple records match
  "k", remove an arbitrary one. Return null if no record
  with key "k" exists. */
public String remove(int k);

/** Remove and return an arbitrary record from dictionary.
  @return the record removed, or null if none exists. */
public String removeAny();

/** @return A record matching "k" (null if none exists).
  If multiple records match, return an arbitrary one.
  @param k The key of the record to find */
public E find(int k);



/** @return The number of records in the dictionary. */
public int size();

/** @return s the sorted position in descending order of the original
records in the Dictionary. */
public E[] createIndex(String attribute);


//public int[] createDesendingIndex();

	

};