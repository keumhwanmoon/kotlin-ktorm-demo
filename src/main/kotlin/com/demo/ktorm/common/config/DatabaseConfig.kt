package com.demo.ktorm.common.config

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Bean
import org.ktorm.database.Database
import javax.sql.DataSource

@Configuration
class DatabaseConfig {

    @Bean
    fun ktormDatabase(dataSource: DataSource): Database {
        return Database.connectWithSpringSupport(dataSource)
    }

}