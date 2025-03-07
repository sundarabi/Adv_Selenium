package generic_utility;

import java.util.Random;

public class Java_Utility {

	// method used to avoid duplicate
	public int getRandomValue()
{

		Random ran =new Random();
		
		int ranNum=ran.nextInt(1000);
		return ranNum;

}
	
}
