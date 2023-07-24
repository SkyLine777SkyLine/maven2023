package reading_file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	
	
	//.properties
	//application.properties
	//key=value
	//key2=value2
	//key3=
	
	public static void main(String[] args) {
		
		Properties prop = new Properties(); //Properties object
		FileInputStream fis;
		
		try {
			fis = new FileInputStream("src\\main\\java\\properties\\application.properties");//location of the file
			prop.load(fis);//load file 
		} catch (IOException e1) {//catch (FileNotFoundException e1) 
			// handle exception
			e1.printStackTrace();
		}
		String url = prop.getProperty("aplication.url.qa");
		System.out.println(url);
	}

}
