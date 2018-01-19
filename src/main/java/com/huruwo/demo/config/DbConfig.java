package com.huruwo.demo.config;

import com.blade.Blade;
import com.blade.event.BeanProcessor;
import com.blade.ioc.annotation.Bean;
import com.blade.jdbc.Base;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.sql2o.Sql2o;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Bean
public class DbConfig implements BeanProcessor {
    @Override
    public void processor(Blade blade) {

//        /**
//         * 数据库链接
//         */
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl("jdbc:mysql://localhost:3307/app");
//        config.setUsername("root");
//        config.setPassword("wasdwasd");
//        config.addDataSourceProperty("cachePrepStmts", "true");
//        config.addDataSourceProperty("prepStmtCacheSize", "250");
//        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
//
//        HikariDataSource ds = new HikariDataSource(config);
//
//        Base.open(ds);
//        log.print("success");

        boolean devMode = true;
        if (blade.environment().hasKey("app.dev")) {
            devMode = blade.environment().getBoolean("app.dev", true);
        }
        if (blade.environment().hasKey("app.devMode")) {
            devMode = blade.environment().getBoolean("app.devMode", true);
        }

        SqliteJdbc.importSql(devMode);

        Sql2o sql2o = new Sql2o(SqliteJdbc.DB_SRC, null, null);
        Base.open(sql2o);

    }
}
