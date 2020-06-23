/**
 * Print out total number of babies born, as well as for each gender, in a given CSV file of baby name data.
 * 
 * @author Samet Burç
 */

import edu.duke.*;
import org.junit.Test;

public class AllTest {

	BabyBirths testClass=new BabyBirths();

	@Test
	public void testTotalBirths () {
		//FileResource fr = new FileResource();
		FileResource fr = new FileResource("data/yob2014.csv");
		testClass.totalBirths(fr);
	}


}
