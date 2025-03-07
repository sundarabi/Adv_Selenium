package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class File_Utility {

	
	public String getKeyAndValueData(String key) throws Throwable {

	 FileInputStream fis =new FileInputStream(Paths.filepath);

	 Properties pro = new Properties();
	 
	 pro.load(fis);
	 
	 return pro.getProperty(key);


	}

	
	}
