/**
 * Print out total number of babies born, as well as for each gender, in a given CSV file of baby name data.
 *
 * @author Samet Burç
 */

import edu.duke.*;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class AllTest {

    IBabyBirths babyBirths = new BabyBirths();

    @Before
    public void initialize() {
        System.out.println();
        babyBirths.setPath(System.getProperty("user.dir") + "\\src\\main\\resources\\testdata\\yob%%%%short.csv");
        babyBirths.setRange(2012, 2014);
    }

    @Test
    public void testTotalBirths() {
        System.out.println("totalBirths Testing...");
        FileResource fr = new FileResource(System.getProperty("user.dir") + "\\src\\main\\resources\\testdata\\yob2014short.csv");
        babyBirths.totalBirths(fr);
    }

    @Test
    public void testGetRank() {
        System.out.println("getRank Testing...");
        Integer result = babyBirths.getRank(2014, "Olivia", "F");
        System.out.println(result);
    }

    @Test
    public void testGetName() {
        System.out.println("getName Testing...");
        String result = babyBirths.getName(2014, 2, "F");
        System.out.println(result);
    }

    @Test
    public void testWhatIsNameInYear() {
        System.out.println("whatIsNameInYear Testing...");
        babyBirths.whatIsNameInYear("Olivia", 2014, 2013, "F");
    }


    @Test
    public void testYearOfHighestRank() {
        System.out.println("yearOfHighestRank Testing...");
        Integer result =  babyBirths.yearOfHighestRank("Isabella", "F");
        System.out.println(result);
    }

}
