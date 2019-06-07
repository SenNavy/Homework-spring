package homework.springthymeleaf.Repository;

import homework.springthymeleaf.Repository.ArticleRepo.ArticleRepository;
import homework.springthymeleaf.Repository.Model.Article;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ArticleRepositoryImp implements ArticleRepository {
    List<Article> articleList = new ArrayList<>();
    @Override
    public void add(Article article) {
        articleList.add(article);
    }

    @Override
    public List<Article> findAll() {
        return articleList;
    }

    @Override
    public Article getArticle(int id) {
        for (Article article : articleList){
            if(article.getId() == id){
                return  article;
            }
        }
        return null;
//        return articleList.stream().filter(x -> (id == x.getId())).findFirst().orElse(null);
    }

    @Override
    public void updateArticle(int id,Article article) {
        articleList.set(id, article);
//        for (Article article1: articleList){
//            if(article1.getId() == article.getId()){
//                article1.setAuthor(article.getAuthor());
//                article1.setName(article.getName());
//                article1.setId(article.getId());
//            }
//        }

    }

    @Override
    public boolean Remove(Article article) {
        return articleList.remove(article);
    }
}
