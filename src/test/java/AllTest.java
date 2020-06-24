/**
 * Print out total number of babies born, as well as for each gender, in a given CSV file of baby name data.
 * 
 * @author Samet Burç
 */

import edu.duke.*;
import org.junit.Test;

import java.io.File;

public class AllTest {

	IBabyBirths babyBirths=new BabyBirths();

	@Test
	public void testTotalBirths ()  {
		System.out.println();
		System.out.println("totalBirths Testing..." );
		FileResource fr = new FileResource(System.getProperty("user.dir")+"\\src\\main\\resources\\testdata\\yob2014short.csv");
		babyBirths.totalBirths(fr);
	}

	@Test
	public void testGetRank ()  {
		System.out.println();
		System.out.println("getRank Testing..." );
		babyBirths.setPath(System.getProperty("user.dir")+"\\src\\main\\resources\\testdata\\yob%%%%short.csv");
		Integer result=babyBirths.getRank(2014,"Olivia","F");
		System.out.println(result);
	}


	@Test
	public void testGetName ()  {
		System.out.println();
		System.out.println("getName Testing..." );
		babyBirths.setPath(System.getProperty("user.dir")+"\\src\\main\\resources\\testdata\\yob%%%%short.csv");
		String result=babyBirths.getName(2014,2,"F");
		System.out.println(result);
	}

}
