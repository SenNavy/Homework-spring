package homework.springthymeleaf.Controller;

import homework.springthymeleaf.Repository.Model.Article;
import homework.springthymeleaf.Repository.Model.Categories;
import homework.springthymeleaf.Service.ArticleService.ArticleService;
import homework.springthymeleaf.Service.CategoriesService.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Controller
public class ArticleController {

   static int currentPage=1;

   //********************* Initialize article object *******************
    @Autowired
    private CategoriesService categoriesService;
    ArticleService articleService;
    @Autowired
    public void setArticleService(ArticleService articleService){
        this.articleService = articleService;
    }

    //************************* View all Article ************************
    @GetMapping("/viewAll")
    public String ViewData(ModelMap modelMap){
        showBypage(1,modelMap);
        return "viewAll";
    }

    //******************************* View Single Record ****************
    @GetMapping("/view")
    public String viewData(ModelMap modelMap, @RequestParam("id") int articleId){
        System.out.println(articleService.findArticle(articleId));
        modelMap.addAttribute("article",articleService.findArticle(articleId));
        return "view";
    }

    //*************************** Update ********************************
    @GetMapping("/update/{id}")
    public String UpdateArticle(ModelMap modelMap, @PathVariable int id){
        modelMap.addAttribute("article",articleService.findArticle(id));
        System.out.println(articleService.findArticle(id));
        modelMap.addAttribute("categories1", categoriesService.findAllCategories());
        return "update";
    }
    @PostMapping("/updateAction")
    public String UpdateAction(@ModelAttribute Article article,MultipartFile file){
        String imageName = UUID.randomUUID().toString();
        String currentImage = articleService.findArticle(article.getId()).getImage();
        String extension;
        if (!file.isEmpty()){
            extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
            imageName += extension;
            try {
                Files.copy(file.getInputStream(), Paths.get("src/main/resources/Image/" + imageName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            article.setImage(imageName);
        }else{
            article.setImage(currentImage);
        }
        articleService.updateArticle(article);
        return "redirect:/viewAll";
    }

    //*************************** Delete *******************************
    @DeleteMapping("deleteArticle/{id}")
    public String delete(@PathVariable Integer id){
        System.out.println(id);
        articleService.Remove(id);
        return "redirect:/viewAll";
    }


    //********************** Add article *******************************
    @GetMapping("/addArticle")
    public String addCat(ModelMap modelMap){
        modelMap.addAttribute("article", new Article());
        List<Categories> categoriesList = categoriesService.findAllCategories();
        System.out.println(categoriesList);
        modelMap.addAttribute("categories1", categoriesService.findAllCategories());
        return "form";
    }

    @PostMapping("/postArticle")
    public String postArticle(@ModelAttribute Article article, MultipartFile file) {
        System.out.println(article.toString());
        String imageName = UUID.randomUUID().toString();
        String extension;
        if (!file.isEmpty()){
            extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
            imageName += extension;
            try {
                Files.copy(file.getInputStream(), Paths.get("src/main/resources/Image/" + imageName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            article.setImage(imageName);
            articleService.addArticle(article);
        }
        return "redirect:/viewAll";
    }

    //************************* Pagination **********************

    ArrayList getPagenation() {
        ArrayList arr = new ArrayList();
        int n = articleService.findAll().size() / 10;
        if (articleService.findAll().size() % 10 != 0) {
            n++;
        }
        for (int i = 1; i < n + 1; i++) {
            arr.add(i);
        }
        return arr;
    }

    @GetMapping("/pageNum")
    public String showBypage(@RequestParam(name = "page") int page, ModelMap modelMap) {
        modelMap.addAttribute("currentPage" ,page);
        if (page == -2) {
            currentPage = 1;
        }
        if(page==-3){
            currentPage--;
         }
        if(page==-3){
            ++currentPage;
        }
        if (page == -1) {
           currentPage=getPagenation().size();
        }
        if (page == -5) {
            currentPage--;
        }
        if (page == -4) {
            currentPage++;
        }
        if(page>0){
            currentPage=page;
        }

        int size = articleService.findAll().size();
        page=currentPage;
        modelMap.addAttribute("articles", articleService.getByPage(page));
        modelMap.addAttribute("pages",getPagenation());
        System.out.println("Total record:" +size);
        return "viewAll";
    }
}
