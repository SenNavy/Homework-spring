package homework.springthymeleaf.Repository.ArticleRepo;

import homework.springthymeleaf.Repository.Model.Article;

import java.util.List;

public interface ArticleRepository {
    void add(Article article);
    List<Article> findAll();
    Article getArticle(int id);
    void updateArticle(int id, Article article);
    boolean Remove(Article article);
}
