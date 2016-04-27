package ua.teachme.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

public class PopulatorDB {

    @Autowired
    private DataSource jdbcDataSource;

    private ResourceDatabasePopulator databasePopulator;

    public PopulatorDB(String scriptLocation){
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.setScripts(resourceLoader.getResource(scriptLocation));
    }

    public void execute(){
        DatabasePopulatorUtils.execute(databasePopulator, jdbcDataSource);
    }
}
