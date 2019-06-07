package homework.springthymeleaf.Controller;

import homework.springthymeleaf.Repository.Model.Article;
import homework.springthymeleaf.Service.ArticleService.ArticleService;
import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.java2d.pipe.AATextRenderer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@Controller
public class ArticleController {

    ArticleService articleService;
    @Autowired
    public void setArticleService(ArticleService articleService){
        this.articleService = articleService;
        for(int i = 0; i  < 3; i++){
            articleService.add(new Article(i, "The Jungle" , "John Micky","New Famous Book","aaa.png"));
        }
    }

    @GetMapping("form")
    public String form(ModelMap modelMap){
        modelMap.addAttribute("article", new Article());
        return "form";
    }

    //get image name
//    @GetMapping("form/{image}")
//    public String getImage(@PathVariable String image){
//        System.out.println(image);
//        return "form";
//    }

    @PostMapping("/postarticle")
    public String postArticle(@ModelAttribute Article article, MultipartFile image){
//      System.out.println(article);

        System.out.println(image);

        System.out.println(article.toString());

        System.out.println(image.getOriginalFilename());
        if( !image.isEmpty()){
            try {
                Files.copy(image.getInputStream(), Paths.get("src/main/resources/Image/",image.getOriginalFilename()));
                article.setImage(image.getOriginalFilename());
                articleService.add(article);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return "redirect:/viewAll";
    }

    @GetMapping("/viewAll")
    public String ViewData(ModelMap modelMap){
        modelMap.addAttribute("articles", articleService.findAll());
        return "viewAll";
    }

    @GetMapping("/view")
    public String viewData(ModelMap modelMap, @RequestParam("id") int articleId){
        modelMap.addAttribute("article",articleService.getArticle(articleId));
        return "view";
    }



    @GetMapping("/update/{id}")
    public String UpdateForm(ModelMap modelMap, @PathVariable int id){
        modelMap.addAttribute("article",articleService.getArticle(id));
        System.out.println(id);
        return "update";
    }

    @PostMapping("/updateAction")
    public String UpdateAction(@ModelAttribute Article article){
        System.out.println(article.toString());
        articleService.updateArticle(article.getId(), article);
        return "redirect:/viewAll";
    }

    @DeleteMapping("article/{id}")
    public String delete(@PathVariable int id){
        System.out.println(id);
        articleService.Remove(id);
        return "redirect:/viewAll";
    }

    @GetMapping("/fileform")
    public String fileForm(ModelMap modelMap){
        modelMap.addAttribute("article", new Article());
        return "fileForm";
    }
//
    @PostMapping("/upload")
    public String uploadFile(@RequestParam MultipartFile file){
        System.out.println(file.getOriginalFilename());
        if( !file.isEmpty()){
            try {
                Files.copy(file.getInputStream(), Paths.get("src/main/resources/Image/" , file.getOriginalFilename()));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/fileform";
    }




//    @GetMapping("/index")
//    public String getIndex(ModelMap modelMap){
//        modelMap.addAttribute("name","Navy");
//        System.out.println(articleService.findAll());
//        return "index";
//    }
//
//    @GetMapping("/add")
//    public String addArticle(){
//        Article article = new Article(111,"Asnavy","AAAA");
////        List<Article> articles = new ArrayList<>();
//        articleService.add(article);
//        return "redirect:/index";
//    }
//
//    @GetMapping("/user")
//    public String showUser(@RequestParam int id, @RequestParam String title){
//        System.out.println(id);
//        System.out.println(title);
//        return "redirect:/index";
//    }
//
//    @GetMapping("/product/{name}/{price}")
//    public String showProduct(@PathVariable String name, @PathVariable int price, @RequestParam int id){
//        System.out.println(name);
//        System.out.println(price);
//        System.out.println(id);
//        return "redirect:/index";
//    }




}
