package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class Example_8 {

	public static void main(String[] args) throws Throwable {

FileInputStream files= new FileInputStream("C:\\Users\\yhtro\\OneDrive\\Desktop\\commondata.properties");
		
		Properties pro = new Properties();
		
		pro.setProperty("browser","chrome");
		
		FileOutputStream fos= new FileOutputStream("C:\\Users\\yhtro\\OneDrive\\Desktop\\commondata.properties");
		
		pro.store(fos,"commondata");
		
		
	}

}
