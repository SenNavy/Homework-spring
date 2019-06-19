package homework.springthymeleaf.Repository.ArticleRepo;

import homework.springthymeleaf.Repository.Model.Article;
import homework.springthymeleaf.Repository.Model.Categories;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ArticleRepository {
    //    A inner join tb_categories C on C.cat_id = A.category_id
    @Select("select * from tb_articles A inner join tb_categories C on C.cat_id = A.category_id")
    @Results({
            @Result(property = "id", column = "article_id"),
            @Result(property = "name", column = "article_title"),
            @Result(property = "categories.catId", column = "cat_id"),
            @Result(property = "categories.catTitle", column = "cat_title"),
            @Result(property = "author", column = "author"),
            @Result(property = "description", column = "description"),
            @Result(property = "image", column = "image")
    })
    List<Article> findAll();

    @Insert("insert into tb_articles ( article_title, author, description, image,category_id) values (#{name},#{author},#{description},#{image},#{categories.catId})")
    void addArticle(Article article);


    @Select("select * from tb_articles A inner join tb_categories C on C.cat_id = A.category_id where article_id = #{id}")
    @Results({
            @Result(property = "id", column = "article_id"),
            @Result(property = "name", column = "article_title"),
            @Result(property = "categories.catId", column = "cat_id"),
            @Result(property = "categories.catTitle", column = "cat_title"),
            @Result(property = "author", column = "author"),
            @Result(property = "description", column = "description"),
            @Result(property = "image", column = "image")
    })
    Article findArticle(Integer id);

    @Update("update tb_articles set article_title = #{name},author = #{author},description = #{description}, image=#{image},category_id = #{categories.catId}" +
            "  where article_id = #{id} ")
    void updateArticle(Article article);

    @Delete("delete from tb_articles where article_id = #{id}")
    int Remove(Integer id);

    @Select("select * from tb_articles as a join tb_categories as c on a.category_id=c.cat_id  order by a.article_id LIMIT 10 OFFSET 10*(#{pageNumber}-1)")
    @Results({
            @Result(property = "id", column = "article_id"),
            @Result(property = "name", column = "article_title"),
            @Result(property = "categories.catId", column = "cat_id"),
            @Result(property = "categories.catTitle", column = "cat_title"),
            @Result(property = "author", column = "author"),
            @Result(property = "description", column = "description"),
            @Result(property = "image", column = "image")
    })
    public ArrayList<Article> getByPage(Integer pageNumber);

}
