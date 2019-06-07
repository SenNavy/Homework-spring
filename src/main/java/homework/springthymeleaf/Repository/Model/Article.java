package homework.springthymeleaf.Repository.Model;

public class Article {
    int id;
    String name;
    String author;
    String description;
    String image;

    public Article(){

    }
    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", image ='" + image + '\'' +
                '}';
    }

    public Article(int id, String name, String author, String description, String image) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.image = image;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}

