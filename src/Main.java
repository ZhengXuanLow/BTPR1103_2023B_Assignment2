import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int total = 0;


    public static void main(String[] args) {
        File diploma = new File("diploma.csv");
        int index = 0;

        int total2014 = 0;
        int total2015 = 0;
        int total2016 = 0;
        int total2017 = 0;
        int total2018 = 0;
        int total2019 = 0;

        ArrayList<DiplomaData> diplomaDataArrayList = new ArrayList<>();
        ArrayList<String> categoryArrayList = new ArrayList<>();
        ArrayList<String> nameArrayList = new ArrayList<>();

        ArrayList<String> categoryNameArrayList = new ArrayList<>();

        //1. File Existence Check:
        if (diploma.exists())
            System.out.println("File exists");
        else System.out.println("File dose not exists");

        //2. File Readability Check:
        if (diploma.canRead())
            System.out.println("File is readable");
        else System.out.println("File is unreadable");

        //3. Using try-with-resources:
        try(Scanner reader = new Scanner(diploma))
        {
            while (reader.hasNext())
            {
            String line = reader.nextLine();

            if(index>0) {
                String[] items = line.split(",");

                DiplomaData data = new DiplomaData((Integer.parseInt(items[0])), items[1], items[2], Integer.parseInt(items[3]), Integer.parseInt(items[4]), Integer.parseInt(items[5]), Integer.parseInt(items[6]), Integer.parseInt(items[7]), Integer.parseInt(items[8]));

                //Sum the total for each year
                total2014 += Integer.parseInt(items[3]);
                total2015 += Integer.parseInt(items[4]);
                total2016 += Integer.parseInt(items[5]);
                total2017 += Integer.parseInt(items[6]);
                total2018 += Integer.parseInt(items[7]);
                total2019 += Integer.parseInt(items[8]);

                //FindTotal
                total = total2014 + total2015 + total2016 +total2017 +total2018 +total2019;

                //Add into diplomaDataArrayList
                diplomaDataArrayList.add(data);

                //Print the data
                System.out.println(data.toString());
                System.out.println();
            }

            index++;

            }

            for (DiplomaData row : diplomaDataArrayList) {
                if (!(diplomaDataArrayList.contains(row.getCategory()))) {
                    categoryNameArrayList.add(row.getCategory());
                }
            }

            //5. Store Data in ArrayList:
            for (DiplomaData row : diplomaDataArrayList) {
                if (row.getCategory().equals(" Diploma Lanjutan"))
                {
                    categoryArrayList.add(row.getName());
                }
                else if (row.getCategory().equals("Kursus Pengkhususan"))
                {
                    nameArrayList.add(row.getName());
                }
            }

            for (String categoryName : categoryNameArrayList)
            {
                try(PrintWriter writter = new PrintWriter(new File(categoryName+".txt")))
                {
                    for(DiplomaData row:diplomaDataArrayList)
                    {
                        if(categoryName.equals(row.getCategory()))
                        {
                            writter.println(row);
                        }
                    }

                }catch(FileNotFoundException exception)
                {
                    System.out.println(exception.getMessage());
                }
            }

            //findMax
            DiplomaData.findMax(total2014,total2015,total2016,total2017,total2018,total2019);
            //findMin
            DiplomaData.findMin(total2014,total2015,total2016,total2017,total2018,total2019);

            System.out.println("The maximum number of intakes between 2014 to 2019 is "+ DiplomaData.getMaxYear()+" with " + DiplomaData.getMax()+" intakes.");
            System.out.println("The maximum number of intakes between 2014 to 2019 is "+ DiplomaData.getMinYear()+" with " + DiplomaData.getMin()+" intakes.");
            System.out.println("The total number of intakes between 2014 to 2019 is "+total +" .");

        }catch (FileNotFoundException exception)
        {
            System.out.println(exception.getMessage());
        }

    }


}
