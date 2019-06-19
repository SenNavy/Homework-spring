package homework.springthymeleaf.Service.CategoriesService;

import homework.springthymeleaf.Repository.Model.Categories;

import java.util.List;

public interface CategoriesService  {
    void add(Categories categories);
    List<Categories> findAllCategories();
    Categories findCat(Integer catId);
    void updateCatAction(Categories categories);
    int RemoveCat(Integer catId);


}
