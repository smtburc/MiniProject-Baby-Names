import edu.duke.FileResource;

/**
 * @author Samet Burç
 */

public interface IBabyBirths {

    /**
     * Modify the method totalBirths (shown in the video for this project) to also print the number of girls names , the number of boys names and the total names in the file.
     *
     * @param fr
     */
    void totalBirths(FileResource fr);

    /**
     * Write the method named getRank that has three parameters: an integer named year, a string named name, and a string named gender (F for female and M for male). This method returns the rank of the name in the file for the given gender, where rank 1 is the name with the largest number of births. If the name is not in the file, then -1 is returned. For example, in the file "yob2012short.csv", given the name Mason, the year 2012 and the gender ‘M’, the number returned is 2, as Mason is the boys name with the second highest number of births. Given the name Mason, the year 2012 and the gender ‘F’, the number returned is -1 as Mason does not appear with an F in that file.
     *
     * @param year
     * @param name
     * @param gender
     * @return
     */
    Integer getRank(int year, String name, String gender);

    /**
     * Write the method named getName that has three parameters: an integer named year, an integer named rank, and a string named gender (F for female and M for male). This method returns the name of the person in the file at this rank, for the given gender, where rank 1 is the name with the largest number of births. If the rank does not exist in the file, then “NO NAME” is returned.
     *
     * @param year
     * @param rank
     * @param gender
     * @return
     */
    String getName(int year, int rank, String gender);

    /**
     * What would your name be if you were born in a different year? Write the void method named whatIsNameInYear that has four parameters: a string name, an integer named year representing the year that name was born, an integer named newYear and a string named gender (F for female and M for male). This method determines what name would have been named if they were born in a different year, based on the same popularity. That is, you should determine the rank of name in the year they were born, and then print the name born in newYear that is at the same rank and same gender. For example, using the files "yob2012short.csv" and "yob2014short.csv", notice that in 2012 Isabella is the third most popular girl's name. If Isabella was born in 2014 instead, she would have been named Sophia, the third most popular girl's name that year. The output might look like this:
     *
     * @param name
     * @param year
     * @param newYear
     * @param gender
     */
    void whatIsNameInYear(String name, int year, int newYear, String gender);

    /**
     * Write the method yearOfHighestRank that has two parameters: a string name, and a string named gender (F for female and M for male). This method selects a range of files to process and returns an integer, the year with the highest rank for the name and gender. If the name and gender are not in any of the selected files, it should return -1. For example, calling yearOfHighestRank with name Mason and gender ‘M’ and selecting the three test files above results in returning the year 2012. That is because Mason was ranked the 2nd most popular name in 2012, ranked 4th in 2013 and ranked 3rd in 2014. His highest ranking was in 2012.
     * @param name
     * @param gender
     * @return
     */
    Integer yearOfHighestRank(String name, String gender);

    /**
     * Write the method getAverageRank that has two parameters: a string name, and a string named gender (F for female and M for male). This method selects a range of files to process and returns a double representing the average rank of the name and gender over the selected files. It should return -1.0 if the name is not ranked in any of the selected files. For example calling getAverageRank with name Mason and gender ‘M’ and selecting the three test files above results in returning 3.0, as he is rank 2 in the year 2012, rank 4 in 2013 and rank 3 in 2014. As another example, calling getAverageRank with name Jacob and gender ‘M’ and selecting the three test files above results in returning 2.66.
     * @param name
     * @param gender
     * @return
     */
    Double getAverageRank(String name, String gender);

    /**
     * Write the method getTotalBirthsRankedHigher that has three parameters: an integer named year, a string named name, and a string named gender (F for female and M for male). This method returns an integer, the total number of births of those names with the same gender and same year who are ranked higher than name. For example, if getTotalBirthsRankedHigher accesses the "yob2012short.csv" file with name set to “Ethan”, gender set to “M”, and year set to 2012, then this method should return 15, since Jacob has 8 births and Mason has 7 births, and those are the only two ranked higher than Ethan.
     * @param year
     * @param name
     * @param gender
     * @return
     */
    Integer getTotalBirthsRankedHigher(int year, String name, String gender);


}
