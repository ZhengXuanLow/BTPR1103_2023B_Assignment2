import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File diploma = new File("diploma.csv");
        int index = 0;

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


                //Create 3 temp Value To Store (Min,Max,Total) or else the Code in row 51 will too long.
                int tempMin = Math.min(Math.min(Math.min(Math.min(Math.min(Integer.parseInt(items[3]),
                        Integer.parseInt(items[4])), Integer.parseInt(items[5])), Integer.parseInt(items[6])), Integer.parseInt(items[7])), Integer.parseInt(items[8]));

                int tempMax = Math.max(Math.max(Math.max(Math.max(Math.max(Integer.parseInt(items[3]),
                        Integer.parseInt(items[4])), Integer.parseInt(items[5])), Integer.parseInt(items[6])), Integer.parseInt(items[7])), Integer.parseInt(items[8]));

                int tempTotal = Integer.parseInt(items[3])+Integer.parseInt(items[4])+Integer.parseInt(items[5])+Integer.parseInt(items[6])+Integer.parseInt(items[7])+Integer.parseInt(items[8]);

                //Construct
                DiplomaData data = new DiplomaData((Integer.parseInt(items[0])), items[1], items[2], tempMin,tempMax,tempTotal);

                //Add into diplomaDataArrayList
                diplomaDataArrayList.add(data);

                //Print the data
                System.out.println(data.toString());
                System.out.println();
            }

            //INDEX++
            index++;

            }

            //Get all the category
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


        }catch (FileNotFoundException exception)
        {
            System.out.println(exception.getMessage());
        }

    }


}
