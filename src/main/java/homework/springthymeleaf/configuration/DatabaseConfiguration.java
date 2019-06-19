package homework.springthymeleaf.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@MapperScan({"homework.springthymeleaf.Repository.ArticleRepo","homework.springthymeleaf.Repository.CategoriesRepo"})
public class DatabaseConfiguration {
    @Bean
    @Profile("local") // to identify the bean
    public DriverManagerDataSource localDB() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/article");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("asnavy123");
        return driverManagerDataSource;
    }


    @Bean
    @Profile("memory")
    public DataSource memory(){
        EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
        embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2);
        embeddedDatabaseBuilder.addScripts("ClassPath:/static/create_table_article.sql","ClassPath:/static/insert_data.sql");
        return embeddedDatabaseBuilder.build();
    }


}
