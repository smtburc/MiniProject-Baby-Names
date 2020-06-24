/**
 * Print out total number of babies born, as well as for each gender, in a given CSV file of baby name data.
 *
 * @author Samet Burç
 */

import edu.duke.*;
import org.apache.commons.csv.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BabyBirths implements IBabyBirths {

    private String path = System.getProperty("user.dir") + "\\src\\main\\resources\\data\\yob%%%%.csv";

    public void totalBirths(FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
            } else {
                totalGirls += numBorn;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("female girls = " + totalGirls);
        System.out.println("male boys = " + totalBoys);
    }

    public Integer getRank(int year, String name, String gender) {
        try {
            FileResource fr=getFileResources(year);
            List<CSVRecord> list=fr.getCSVParser(false).getRecords().stream().filter(x->getGenderFromCSVRecord(x).equals(gender)).sorted((o1, o2) -> getCountFromCSVRecord(o2).compareTo(getCountFromCSVRecord(o1))).collect(Collectors.toList());
            Optional<CSVRecord> record= list.stream().filter(x->getNameFromCSVRecord(x).equalsIgnoreCase(name)).findFirst();
            if(record.isPresent()){
                return list.indexOf(record.get())+1;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

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

    public void setPath(String path) {
        this.path = path;
    }

    private FileResource getFileResources(int year) {
        String path = this.path.replace("%%%%", String.valueOf(year));
        return new FileResource(path);
    }

    private String getNameFromCSVRecord(CSVRecord rec){
        return rec.get(0);
    }

    private String getGenderFromCSVRecord(CSVRecord rec){
        return rec.get(1);
    }

    private Integer getCountFromCSVRecord(CSVRecord rec){
        return Integer.parseInt(rec.get(2));
    }


}
