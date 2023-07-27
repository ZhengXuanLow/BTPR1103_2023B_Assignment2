//4. Create DiplomaData Class:
public class DiplomaData {

    //All Private as requested
    private int bilangan;
    private String category;
    private String name;
    private int intake2014;
    private int intake2015;
    private int intake2016;
    private int intake2017;
    private int intake2018;
    private int intake2019;
    private static int min;
    private static int max;
    private static int minYear;
    private static int maxYear;
    private static int total;

    //Constructor with Parameter
    public DiplomaData(int bilangan, String category, String name, int intake2014, int intake2015, int intake2016, int intake2017, int intake2018, int intake2019) {
        this.bilangan = bilangan;
        this.category = category;
        this.name = name;
        this.intake2014 = intake2014;
        this.intake2015 = intake2015;
        this.intake2016 = intake2016;
        this.intake2017 = intake2017;
        this.intake2018 = intake2018;
        this.intake2019 = intake2019;
    }

    //toString
    @Override
    public String toString() {
        return bilangan +
                ". Category='" + category + '\'' +
                ", Name='" + name + '\'' +
                ", Intake2014=" + intake2014 +
                ", Intake2015=" + intake2015 +
                ", Intake2016=" + intake2016 +
                ", Intake2017=" + intake2017 +
                ", Intake2018=" + intake2018 +
                ", Intake2019=" + intake2019 ;
    }

//    public int findTotal(int i2014, int i2015, int i2016,int i2017, int i2018, int i2019)
//    {
//        return  i2014+i2015+i2016+i2017+i2018+i2019;
//    }

    //Getter and Setter
    public int getBilangan() {
        return bilangan;
    }


    public void setBilangan(int bilangan) {
        this.bilangan = bilangan;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIntake2014() {
        return intake2014;
    }

    public void setIntake2014(int intake2014) {
        this.intake2014 = intake2014;
    }

    public int getIntake2015() {
        return intake2015;
    }

    public void setIntake2015(int intake2015) {
        this.intake2015 = intake2015;
    }

    public int getIntake2016() {
        return intake2016;
    }

    public void setIntake2016(int intake2016) {
        this.intake2016 = intake2016;
    }

    public int getIntake2017() {
        return intake2017;
    }

    public void setIntake2017(int intake2017) {
        this.intake2017 = intake2017;
    }

    public int getIntake2018() {
        return intake2018;
    }

    public void setIntake2018(int intake2018) {
        this.intake2018 = intake2018;
    }

    public int getIntake2019() {
        return intake2019;
    }

    public void setIntake2019(int intake2019) {
        this.intake2019 = intake2019;
    }

    public static int getMin() {
        return min;
    }

    public static void setMin(int min) {
        DiplomaData.min = min;
    }

    public static int getMax() {
        return max;
    }

    public static void setMax(int max) {
        DiplomaData.max = max;
    }

    public static int getMinYear() {
        return minYear;
    }

    public static void setMinYear(int minYear) {
        DiplomaData.minYear = minYear;
    }

    public static int getMaxYear() {
        return maxYear;
    }

    public static void setMaxYear(int maxYear) {
        DiplomaData.maxYear = maxYear;
    }

    public static int getTotal() {
        return total;
    }

    public static void setTotal(int total) {
        DiplomaData.total = total;
    }

    //findMin and findMax function
    public static void findMin(int total2014, int total2015, int total2016, int total2017, int total2018, int total2019)
    {
        min = total2014;
        minYear = 2014;

        if (total2015<min)
        {
            min = total2015;
            minYear = 2015;

        }  if (total2016<min) {
        min = total2016;
        minYear = 2016;

    } if (total2017<min) {
        min = total2017;
        minYear = 2017;

    } if (total2018<min) {
        min = total2018;
        minYear = 2018;

    } if (total2019<min) {
        min = total2019;
        minYear = 2019;
    }
    }

    public static void findMax(int total2014, int total2015, int total2016, int total2017, int total2018, int total2019)
    {
        max = total2014;
        maxYear = 2014;

        if (total2015>max)
        {
            max = total2015;
            maxYear = 2015;

        }  if (total2016>max) {
        max = total2016;
        maxYear = 2016;

    } if (total2017>max) {
        max = total2017;
        maxYear = 2017;

    } if (total2018>max) {
        max = total2018;
        maxYear = 2018;

    } if (total2019>max) {
        max = total2019;
        maxYear = 2019;
    }
    }

    public static void findTotal(int total2014, int total2015, int total2016, int total2017, int total2018, int total2019)
    {
        total = total2014 + total2015 + total2016 +total2017 +total2018 +total2019;
    }


}

