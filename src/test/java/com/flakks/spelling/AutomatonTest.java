
package com.flakks.spelling;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AutomatonTest extends TestCase {
    public AutomatonTest(String testName) {
        super(testName);
    }
  
    public static Test suite() {
        return new TestSuite(AutomatonTest.class);
    }
    
    public void testCorrectDistance() {
    	TrieNode root = new TrieNode();
    	root.insert("first", 1);
    	root.insert("second", 1);
    	
    	assertEquals("first", new Automaton("fist", "en", 1).correct(root).getToken());
    	assertEquals(1, new Automaton("fist", "en", 1).correct(root).getDistance());
    	
    	assertEquals("first", new Automaton("fitst", "en", 1).correct(root).getToken());
    	assertEquals(1, new Automaton("fist", "en", 1).correct(root).getDistance());
    	
    	assertEquals("second", new Automaton("secnod", "en", 1).correct(root).getToken());
    	assertEquals(1, new Automaton("secnod", "en", 1).correct(root).getDistance());
    	
    	assertEquals("second", new Automaton("secnd", "en", 2).correct(root).getToken());
    	assertEquals(2, new Automaton("secd", "en", 2).correct(root).getDistance());
    }
    
    public void testCorrectFrequency() {
    	TrieNode root = new TrieNode();
    	root.insert("word 1", 1);
    	root.insert("word 2", 2);
    	
    	assertEquals("word 2", new Automaton("word", "en", 2).correct(root).getToken());
    }
    
    public void testCorrectPrefixDistance() {
    	TrieNode root = new TrieNode();
    	root.insert("first", 1);
    	root.insert("second", 1);
    	
    	assertEquals("first", new Automaton("fist", "en", 2).correctPrefix(root).getToken());
    	assertEquals("second", new Automaton("secnd", "en", 2).correctPrefix(root).getToken());
    }
    
    public void testCorrectPrefixFrequency() {
    	TrieNode root = new TrieNode();
    	root.insert("wonder", 1);
    	root.insert("wonderful", 2);
    	root.insert("wondering", 3);
    	
    	assertEquals("wond", new Automaton("wont", "en", 2).correctPrefix(root).getToken());
    	assertEquals("wonder", new Automaton("wonderx", "en", 2).correctPrefix(root).getToken());
    }
}
