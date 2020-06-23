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
		System.out.println("totalBirths Testing..." );
		FileResource fr = new FileResource(System.getProperty("user.dir")+"\\src\\main\\resources\\testdata\\yob2014short.csv");
		babyBirths.totalBirths(fr);
	}


}
