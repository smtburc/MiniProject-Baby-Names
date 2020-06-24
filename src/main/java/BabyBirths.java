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
    private Integer minRange = 1880;
    private Integer maxRange = 2014;

    @Override
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

    @Override
    public Integer getRank(int year, String name, String gender) {
        try {
            List<CSVRecord> list = getSortedRecordList(year, gender);
            Optional<CSVRecord> record = list.stream().filter(x -> getNameFromCSVRecord(x).equalsIgnoreCase(name)).findFirst();
            if (record.isPresent()) {
                return list.indexOf(record.get()) + 1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String getName(int year, int rank, String gender) {
        try {
            List<CSVRecord> list = getSortedRecordList(year, gender);
            return getNameFromCSVRecord(list.get(rank - 1));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void whatIsNameInYear(String name, int year, int newYear, String gender) {
        Integer rank = getRank(year, name, gender);
        String newName = getName(newYear, rank, gender);
        System.out.println(name + " born in " + year + " would be " + newName + " if she was born in " + newYear + ".");
    }

    @Override
    public Integer yearOfHighestRank(String name, String gender) {
        Integer highestRank = null;
        Integer highestYear = null;
        for (int i = minRange; i <= maxRange; i++) {
            Integer rank = getRank(i, name, gender);
            if (rank != null) {
                if (highestYear == null || (highestYear != null && rank < highestRank)) {
                    highestYear = i;
                    highestRank = rank;
                }
            }
        }
        return highestYear;
    }

    @Override
    public Double getAverageRank(String name, String gender) {
        int totalRank = 0;
        int count = 0;
        for (int i = minRange; i <= maxRange; i++) {
            Integer rank = getRank(i, name, gender);
            if (rank != null) {
                totalRank += rank;
                count++;
            }
        }
        return ((double) totalRank / count);
    }

    @Override
    public Integer getTotalBirthsRankedHigher(int year, String name, String gender) {

        int totalBirthsRankedHigher = 0;

        Integer rank = getRank(year, name, gender);
        try {

            List<CSVRecord> list = getSortedRecordList(year, gender);
            for (int i = 0; i < rank - 1; i++) {
                totalBirthsRankedHigher += getCountFromCSVRecord(list.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalBirthsRankedHigher;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void setRange(int minRange, int maxRange) {
        this.minRange = minRange;
        this.maxRange = maxRange;
    }


    //Utily Methods -----------------------------------------------------

    private FileResource getFileResources(int year) {
        String path = this.path.replace("%%%%", String.valueOf(year));
        return new FileResource(path);
    }

    private String getNameFromCSVRecord(CSVRecord rec) {
        return rec.get(0);
    }

    private String getGenderFromCSVRecord(CSVRecord rec) {
        return rec.get(1);
    }

    private Integer getCountFromCSVRecord(CSVRecord rec) {
        return Integer.parseInt(rec.get(2));
    }

    private List<CSVRecord> getSortedRecordList(int year, String gender) {
        try {
            FileResource fr = getFileResources(year);
            return fr.getCSVParser(false).getRecords().stream().filter(x -> getGenderFromCSVRecord(x).equals(gender)).sorted((o1, o2) -> getCountFromCSVRecord(o2).compareTo(getCountFromCSVRecord(o1))).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
