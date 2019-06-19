package homework.springthymeleaf.Service;
import homework.springthymeleaf.Repository.CategoriesRepo.CategoriesRepository;
import homework.springthymeleaf.Repository.Model.Categories;
import homework.springthymeleaf.Service.CategoriesService.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoriesServiceImp  implements CategoriesService
{
    @Autowired
    CategoriesRepository categoriesRepository;

    @Override
    public void add(Categories categories) {
        categoriesRepository.add(categories);
    }

    @Override
    public List<Categories> findAllCategories() {
        return categoriesRepository.findAllCategories();
    }

    @Override
    public Categories findCat(Integer catId) {
        return categoriesRepository.findCat(catId);
    }
    @Override
    public void updateCatAction(Categories categories) {
        categoriesRepository.updateCatAction(categories);
    }
    @Override
    public int RemoveCat(Integer catId) {
        return categoriesRepository.RemoveCat(catId);
    }
}
