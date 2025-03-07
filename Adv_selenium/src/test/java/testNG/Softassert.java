package testNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Softassert {

	// All methods are non static in nature

	// If assert fails does not stops the execution, it contionues the execution

	// AssertAll() method is mandatory--->code/method required to track the fail status.

	// If Assert fails throws AssertError Execption

	// Used for Non mandatory fields
	
	@Test
	public void m1() {
		System.out.println("step1");
		System.out.println("step2");
        
		SoftAssert sa= new SoftAssert();
		sa.assertEquals(true,true);
		
		System.out.println("step3");
		System.out.println("step4");

		sa.assertAll();
	}
	@Test
	public void m2() {
		
	
		
	
	}
}

