package dbtools;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class PasswordHashTest {

	String[][] testHashStrings = {
			{"testString", "hello world","anotherOne"},
			{"4ACF0B39D9C4766709A3689F553AC01AB550545FFA4544DFC0B2CEA82FBA02A3","B94D27B9934D3E08A52E52D7DA7DABFAC484EFE37A5380EE9088F7ACE2EFCDE9", 
			 "EFB94AA4FD0EE88A727CC52515E4410A18F2F59BB5464E7C3114B6290B89A775"}
			
	};
	
	@Test
	void createHash_HashMatchesExpectedValues() {
		ArrayList<String> resultHashStrings = new ArrayList<String>();
		for(String testInput:testHashStrings[0]) {
			resultHashStrings.add(PasswordHash.createHash(testInput));
		}
		assertArrayEquals(testHashStrings[1], resultHashStrings.toArray());
	}

}
