package homework.springthymeleaf.Service;

import homework.springthymeleaf.Repository.ArticleRepo.ArticleRepository;
import homework.springthymeleaf.Repository.Model.Article;
import homework.springthymeleaf.Service.ArticleService.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArticleServiceImp implements ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    @Override
    public void add(Article article) {
        articleRepository.add(article);
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article getArticle(int id) {
        return articleRepository.getArticle(id);
    }

    @Override
    public void updateArticle(int id, Article article) {
        System.out.println(id);
        Article article1 = articleRepository.findAll().stream().filter(x -> (id == x.getId())).findAny().orElse(null);
        int index = articleRepository.findAll().indexOf(article1);
        articleRepository.updateArticle(index, article);
    }

    @Override
    public boolean Remove(int id) {
        Article article = articleRepository.findAll().stream().filter(x ->(id == x.getId())).findAny().orElse(null);
        return articleRepository.Remove(article);

    }


}
