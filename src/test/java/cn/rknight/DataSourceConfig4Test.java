package cn.rknight;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DataSourceConfig4Test {
    DataSource dataSourceUtils() throws SQLException {
        return new EmbeddedDatabaseBuilder()
                .setScriptEncoding("utf8")
                .setName("test")
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:db/H2_TYPE.sql")
                .addScript("classpath:db/schema-h2.sql")
                .addScript("classpath:db/data-h2.sql")
                .build();
    }
}
