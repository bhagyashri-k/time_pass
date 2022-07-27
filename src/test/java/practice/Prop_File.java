package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Prop_File {
	
	private  Prop_File()
	{
		
	}
	public static Prop_File getObj()
	{
		Prop_File ob = new Prop_File();
		return ob ;
	}
	
	public String propdataRead(String keys) throws IOException {
		
		
		FileInputStream fis = new FileInputStream("../SDET7_BHA/src/test/java/com/pack/com.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String str1 = pobj.getProperty(keys);
//		System.out.println(str1);
		return str1;
		
	}
	

}
