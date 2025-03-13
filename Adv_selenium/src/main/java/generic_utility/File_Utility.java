package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class File_Utility {

	
	public String getCommonData(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(Paths.filepath);

		// step2:- load all the keys from properties file
		Properties pro = new Properties();
		pro.load(fis);

		// step3:- get keys from properties file
		String Value = pro.getProperty(key);
		return Value;
		
	}

	
	}
