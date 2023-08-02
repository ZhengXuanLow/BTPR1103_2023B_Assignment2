//4. Create DiplomaData Class:
public class DiplomaData {

    //All Private as requested
    private int bilangan;
    private String category;
    private String name;
    private int min;
    private int max;
    private int total;

    //Constructor with Parameter
    public DiplomaData(int bilangan, String category, String name, int min, int max, int total) {
        this.bilangan = bilangan;
        this.category = category;
        this.name = name;
        this.min = min;
        this.max = max;
        this.total = total;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return bilangan +
                ". Category='" + category + '\'' +
                ", Name='" + name + '\'' +
                ", Min=" + min +
                ", Max=" + max +
                ", Total=" + total
                ;
    }


}

