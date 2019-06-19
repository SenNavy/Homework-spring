package homework.springthymeleaf.Controller;

import homework.springthymeleaf.Repository.Model.Categories;
import homework.springthymeleaf.Service.CategoriesService.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoriesController {





    //***************************** Initialize Categories ***************************
    CategoriesService categoriesService;
    @Autowired
    public void setCategoriesService(CategoriesService categoriesService){
        this.categoriesService= categoriesService;
    }


    //***************************** View all categories *****************************
    @GetMapping("/viewCat")
    public String ViewCat(ModelMap modelMap){
        modelMap.addAttribute("categories",categoriesService.findAllCategories());
        System.out.println(categoriesService.findAllCategories());
        return "categories";
    }


    //****************************** UPDATE CATEGORY *********************************
    @GetMapping("/updateCat/{catId}")
    public String updateCat(ModelMap modelMap, @PathVariable Integer catId){
        System.out.println(catId);
        Categories categories = categoriesService.findCat(catId);
        System.out.println(categories.toString());
        modelMap.addAttribute("categories",categories);
        return "categoriesUpdate";
    }

    @PostMapping("/updateCatAction")
    public String UpdateCatAction(@ModelAttribute Categories categories){
        categoriesService.updateCatAction(categories);
        return "redirect:/viewCat";
    }


    //************************ DELETE CATEGORY*************************************
    @DeleteMapping("deleteCat/{catId}")
    public String deleteCat(@PathVariable Integer catId){
        System.out.println(catId);
        categoriesService.RemoveCat(catId);
        return "redirect:/viewCat";
    }


    //************************ Add Category *************************************
    @GetMapping("/addCat")
    public String addCat(ModelMap modelMap){
        modelMap.addAttribute("categories", new Categories());
        return "categoryAddForm";
    }

    @PostMapping("/postCat")
    public String postArticle(@ModelAttribute Categories categories) {
        System.out.println(categories.toString());
        categoriesService.add(categories);
        System.out.println(categories.toString());
        return "redirect:/viewCat";
    }}
