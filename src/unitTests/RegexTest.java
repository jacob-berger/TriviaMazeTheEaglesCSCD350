package unitTests;

import static org.junit.Assert.*;

import mazeUtils.Regex;

import org.junit.BeforeClass;
import org.junit.Test;

public class RegexTest {
	
	public static Regex regex ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {	
		regex = new Regex() ; 
	}
	@Test
	public void testMultChoice() {
		
		assertSame(true, regex.multChoice("a"))  ; 
		assertTrue(regex.multChoice("c")) ; 
		assertFalse(regex.multChoice("12")) ; 
		assertFalse(regex.multChoice("Short Answer")) ; 
		assertTrue(regex.multChoice("d")) ; 
		
	}

	@Test
	public void testTrueFalse() {
		assertSame(true, regex.trueFalse("t"))  ; 
		assertTrue(regex.trueFalse("f")) ; 
		assertTrue(regex.trueFalse("T")) ; 
		assertTrue(regex.trueFalse("F")) ; 
		assertFalse(regex.trueFalse("False")) ; 
		assertFalse(regex.trueFalse("True")) ; 
		assertFalse(regex.trueFalse("Neither")) ; 
		assertFalse(regex.trueFalse("1")) ; 



		
	}

	@Test
	public void testShortAnswer() {
		assertSame(true, regex.shortAnswer("Answer"))  ; 
		assertFalse(regex.shortAnswer("More than fifteen chars"))  ; 
		assertTrue(regex.shortAnswer("LessThanfifteen"))  ; 
		assertFalse(regex.shortAnswer("Has a num 12"))  ; 
		assertFalse(regex.shortAnswer("Odd Chars @#$%"))  ; 




	}

	@Test
	public void testDirection() {
		assertSame(true, regex.direction("n"))  ; 
		assertTrue(regex.direction("w"))  ; 
		assertTrue(regex.direction("s"))  ; 
		assertTrue(regex.direction("W"))  ; 
		assertTrue(regex.direction("N"))  ; 
		assertFalse(regex.direction("NSWE"))  ; 
		assertFalse(regex.direction("nesw"))  ; 
		assertFalse(regex.direction("North"))  ; 
		assertFalse(regex.direction("up"))  ; 

	}

	@Test
	public void testYesNo() {
		assertTrue(regex.yesNo("y"))  ;
		assertTrue(regex.yesNo("Yes")) ; 
		assertTrue(regex.yesNo("No")) ; 
		assertTrue(regex.yesNo("yes")) ; 
		assertTrue(regex.yesNo("no")) ; 
		assertFalse(regex.yesNo("Yep")) ; 
		assertFalse(regex.yesNo("Nope")) ; 

	}

	@Test
	public void testMenuChoice() {
		assertTrue(regex.menuChoice("1")) ;
		assertTrue(regex.menuChoice("2")) ;
		assertTrue(regex.menuChoice("4")) ;
		assertTrue(regex.menuChoice("6")) ;
		assertTrue(regex.menuChoice("9")) ;
		assertFalse(regex.menuChoice("0")) ;
		assertFalse(regex.menuChoice("10")) ;
		assertFalse(regex.menuChoice("One")) ;
	
	}

}
