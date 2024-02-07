package co.com.blog.jpa.config

import co.com.blog.jpa.config.DBSecret
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.orm.jpa.JpaVendorAdapter
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter

import jakarta.sql.DataSource
import java.util.Properties

@Configuration
open class JpaConfig {

    @Bean
    open fun dbSecret(env: Environment): DBSecret {
        return DBSecret(
            url = env.getProperty("spring.datasource.url"),
            username = env.getProperty("spring.datasource.username"),
            password = env.getProperty("spring.datasource.password")
        )
    }

    @Bean
    open fun datasource(
        secret: DBSecret,
        @Value("\${spring.datasource.driverClassName}") driverClass: String
    ): DataSource {
        val config: HikariConfig = HikariConfig().apply {
            jdbcUrl = secret.url
            username = secret.username
            password = secret.password
            driverClassName = driverClass
        }
        return HikariDataSource(config)
    }

    @Bean
    open fun entityManagerFactory(
        dataSource: DataSource,
        @Value("\${spring.jpa.databasePlatform}") dialect: String
    ): LocalContainerEntityManagerFactoryBean {
        val em  = LocalContainerEntityManagerFactoryBean()
        em.dataSource = dataSource
        em.setPackagesToScan("co.com.blog.jpa")

        val vendorAdapter: JpaVendorAdapter = HibernateJpaVendorAdapter()
        em.jpaVendorAdapter = vendorAdapter

        val properties = Properties()
        properties.setProperty("hibernate.dialect", dialect)
        properties.setProperty(
            "hibernate.hbm2ddl.auto",
            "update"
        ) // TODO: remove this for non auto create schema
        em.setJpaProperties(properties)

        return em
    }
}
