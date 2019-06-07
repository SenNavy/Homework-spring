package homework.springthymeleaf.Service.ArticleService;
import homework.springthymeleaf.Repository.Model.Article;
import java.util.List;

public interface ArticleService {
    void add(Article article);
    List<Article>  findAll();
    Article getArticle(int id);
    void updateArticle(int id, Article article);
    boolean Remove(int id);
}
