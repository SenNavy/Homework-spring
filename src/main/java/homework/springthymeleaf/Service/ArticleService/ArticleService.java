package homework.springthymeleaf.Service.ArticleService;
import homework.springthymeleaf.Repository.Model.Article;

import java.util.ArrayList;
import java.util.List;

public interface ArticleService {
    void addArticle(Article article);
    List<Article>  findAll();
    Article findArticle(Integer id);
    void updateArticle(Article article);
    int Remove(Integer id);
    public ArrayList<Article> getByPage(Integer pageNumber);
}
