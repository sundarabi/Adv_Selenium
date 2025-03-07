package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_provide_1 {

	@Test(dataProvider="getData")
	public void bookTickets (String src, String dest,int people)

	{
	  System.out.println("Book tickets from "+src+" to "+dest+" ^ number of person: "+people);
	
	}

	@DataProvider
	public Object[][] getData()

	{
		Object[][] objArr = new Object[3][3];

		objArr[0][0]="Goa";

		objArr[0][1]="Banglore";
		
		objArr[0][2]=23;

		objArr[1][0]="Goa";

		objArr[1][1]="mangalore";
		
		objArr[1][2]=31;

		objArr[2][0]="Goa";

		objArr[2][1]="mysuru";
		
		objArr[2][2]=45;

		return objArr;
	}
}
