/**
 * Print out total number of babies born, as well as for each gender, in a given CSV file of baby name data.
 * 
 * @author Samet Burç
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class BabyBirths implements IBabyBirths{

	public static void main(String[] args) {
		BabyBirths b=new BabyBirths();
		FileResource fr = new FileResource("data/yob2014shorts.csv");
		b.totalBirths(fr);
	}

	public void totalBirths (FileResource fr) {
		int totalBirths = 0;
		int totalBoys = 0;
		int totalGirls = 0;
		for (CSVRecord rec : fr.getCSVParser(false)) {
			int numBorn = Integer.parseInt(rec.get(2));
			totalBirths += numBorn;
			if (rec.get(1).equals("M")) {
				totalBoys += numBorn;
			}
			else {
				totalGirls += numBorn;
			}
		}
		System.out.println("total births = " + totalBirths);
		System.out.println("female girls = " + totalGirls);
		System.out.println("male boys = " + totalBoys);
	}

	public Integer getRank(int year, String name, String gender) {
		return null;
	}

	public String getName(int year, int rank, String gender) {
		return null;
	}

	public void whatIsNameInYear(String name, int year, int newYear, String gender) {

	}

	public Integer yearOfHighestRank(String name, String gender) {
		return null;
	}

	public Double getAverageRank(String name, String gender) {
		return null;
	}

	public Integer getTotalBirthsRankedHigher(int year, String name, String gender) {
		return null;
	}


}
