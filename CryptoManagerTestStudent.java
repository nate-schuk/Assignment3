/*
 * Class: CMSC203  
 * Instructor: Khandan Monshi
 * Description: CryptoManagerTest tests all methods from the CryptoManager class. 
 * Due: 10/25/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Nathaniel Schuknecht
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerTestStudent {

	CryptoManager cryptoManager;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("TEST"));
		assertTrue(CryptoManager.isStringInBounds("!!!ABC"));
		assertFalse(CryptoManager.isStringInBounds("out of bounds"));
	}
	
	@Test
	void testEncryptedCaesar() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("fail", 3));
		assertEquals("BCD" , CryptoManager.caesarEncryption("ABC", 1));
		assertEquals("UFTU234\"" , CryptoManager.caesarEncryption("TEST123!", 65));
		assertEquals("89:;EDG!IK" , CryptoManager.caesarEncryption("WXYZ$#&@(*", 33));
	}
	
	@Test
	void testDecryptCaesar() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarDecryption("fail", 3));
		assertEquals("ABC" , CryptoManager.caesarDecryption("BCD", 1));
		assertEquals("HOW MUCH WOOD CAN" , CryptoManager.caesarDecryption("W^&/\\$RW/&^^S/RP]", 15));
		assertEquals("TEST123!" , CryptoManager.caesarDecryption("UFTU234\"", 65));
		assertEquals("WXYZ$#&@(*" , CryptoManager.caesarDecryption("89:;EDG!IK", 33));
	}

	@Test
	void testEncryptBellaso() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.bellasoEncryption("fail", "key"));
		assertEquals("UJL", CryptoManager.bellasoEncryption("ABC", "THISISALONGKEY"));
		assertEquals("TOV", CryptoManager.bellasoEncryption("ABC", "SM"));
		assertEquals("WR&W;>:4?F$S0", CryptoManager.bellasoEncryption("TESTING123!!@", "CMSC203"));
	}
	
	@Test
	void testDecryptBellaso() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.bellasoEncryption("fail", "key"));
		assertEquals("ABC", CryptoManager.bellasoDecryption("UJL", "THISISALONGKEY"));
		assertEquals("HOW MUCH WOOD CAN" , CryptoManager.bellasoDecryption("PT#,\\]HT,&WTP,RIS", "HELLO"));
		assertEquals("ABC", CryptoManager.bellasoDecryption("TOV", "SM"));
		assertEquals("TESTING123!!@", CryptoManager.bellasoDecryption("WR&W;>:4?F$S0", "CMSC203"));
	}
}
