package ft.etachott.configuration;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfig {

    @Bean
    public FlywayMigrationStrategy flywayMigrationStrategy() {
        return Flyway::migrate;
    }

    @Bean(initMethod = "migrate")
    public Flyway flyway(@Value("${spring.datasource.url}") String url,
                         @Value("${spring.datasource.username}") String user,
                         @Value("${spring.datasource.password}") String password) {
        return Flyway.configure()
                .dataSource(url, user, password)
                .load();
    }
}