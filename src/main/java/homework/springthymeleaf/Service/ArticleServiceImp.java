package homework.springthymeleaf.Service;

import homework.springthymeleaf.Repository.ArticleRepo.ArticleRepository;
import homework.springthymeleaf.Repository.Model.Article;
import homework.springthymeleaf.Repository.Model.Categories;
import homework.springthymeleaf.Service.ArticleService.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImp  implements ArticleService{

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public void addArticle(Article article) {
        articleRepository.addArticle(article);
    }

    @Override
    public List<Article> findAll() {
            return articleRepository.findAll();
    }

    @Override
    public Article findArticle(Integer id) {
        return articleRepository.findArticle(id);
    }

    @Override
    public void updateArticle(Article article) {
        articleRepository.updateArticle(article);
    }

    @Override
    public int Remove(Integer id) {
        return articleRepository.Remove(id);

    }





    @Override
    public ArrayList<Article> getByPage(Integer pageNumber) {
        return articleRepository.getByPage(pageNumber);
    }

}
