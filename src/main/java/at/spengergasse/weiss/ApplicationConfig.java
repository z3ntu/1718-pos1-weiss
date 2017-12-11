package at.spengergasse.weiss;

import at.spengergasse.weiss.converters.UserConverter;
import at.spengergasse.weiss.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.sql2o.Sql2o;
import org.sql2o.converters.Converter;
import org.sql2o.quirks.NoQuirks;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Written by Luca Weiss (z3ntu)
 * https://github.com/z3ntu
 */
@Configuration
@PropertySource(value = {"classpath:database.properties"})
public class ApplicationConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("db.driverClassName"));
        dataSource.setUrl(env.getRequiredProperty("db.url"));
        dataSource.setUsername(env.getRequiredProperty("db.username"));
        dataSource.setPassword(env.getRequiredProperty("db.password"));
        return dataSource;
    }

    @Bean
    public Sql2o getSql2o(UserConverter userConverter) {
        final Map<Class, Converter> mappers = new HashMap<>();
        mappers.put(User.class, userConverter);
        return new Sql2o(dataSource(),
                new NoQuirks(mappers));
    }
}