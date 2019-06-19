package homework.springthymeleaf.Repository.CategoriesRepo;
import homework.springthymeleaf.Repository.Model.Categories;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface CategoriesRepository {
    @Select("select * from tb_categories")
    @Results({
            @Result(property = "catId", column = "cat_id"),
            @Result(property = "catTitle", column = "cat_title")
    })
    List<Categories> findAllCategories();


    @Select("select * from tb_categories where cat_id = #{catId}")
    @Results({
            @Result(property = "catId", column = "cat_id"),
            @Result(property = "catTitle", column = "cat_title")
    })

    Categories findCat(Integer catId);

    @Update("update tb_categories set cat_title = #{catTitle} where cat_id = #{catId}")
    void updateCatAction(Categories categories);

    @Delete("delete from tb_categories where cat_id = #{catId}")
    int RemoveCat(Integer catId);

    @Insert(" insert into tb_categories (cat_id,cat_title) values (#{catId},#{catTitle})")
    void add(Categories categories);






    @Select("select count(*) from tb_categories")
    int countCategory();



    void updateCategories(int catId,Categories categories);
    boolean RemoveCat(Categories categories);

}
