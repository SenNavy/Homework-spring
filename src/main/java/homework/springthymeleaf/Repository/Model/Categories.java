package homework.springthymeleaf.Repository.Model;

public class Categories {
    int catId;
    String catTitle;

    public Categories(){}

    public Categories(int catId, String catTitle) {
        this.catId = catId;
        this.catTitle = catTitle;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCatTitle() {
        return catTitle;
    }

    public void setCatTitle(String catTitle) {
        this.catTitle = catTitle;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "catId=" + catId +
                ", catTitle='" + catTitle + '\'' +
                '}';
    }
}
