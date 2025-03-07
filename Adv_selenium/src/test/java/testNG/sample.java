package testNG;

import org.testng.annotations.Test;

public class sample {
	

	@Test(invocationCount=2)
	public void createpro() {
		
		System.out.println("craete product");
	}
	

	@Test(dependsOnMethods="createpro",priority=1)
	public void updatepro() {
		
		System.out.println("update product");
	}
	
	@Test(dependsOnMethods="createpro",priority=2)
	public void deletepro() {
		System.out.println("delete product");
	}
	
	@Test(enabled=false)
	public void modify() {
		System.out.println("modified");
	}

}
