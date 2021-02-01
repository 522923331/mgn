package com.tt.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author dangwu
 * @since 2021/1/29 3:00 下午
 */
@Configuration
@MapperScan(basePackages = "com.tt.mapper.attr", sqlSessionFactoryRef = "userSqlSessionFactory")
public class DatasourceConfig2 {

    @Bean(name = "userDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.dynamic.user")
    public DataSource userDataSource(){
        System.out.println("====================userDataSource 创建==============================");
        return DataSourceBuilder.create().build();
    }
    /**
     * 创建SqlSessionFactory
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "userSqlSessionFactory")
    public SqlSessionFactory userSqlSessionFactory(@Qualifier("userDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(userDataSource());
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
    /**
     * 创建管理器
     * @param dataSource
     * @return
     */
    @Bean(name = "userTransactionManager")
    public DataSourceTransactionManager userTranscationManager(@Qualifier("userDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 创建模板
     * @param sqlSessionFactory
     * @return
     * @throws Exception
     */
    @Bean(name = "userSqlSessionTemplate")
    public SqlSessionTemplate userSqlSessionTemplate(@Qualifier("userSqlSessionFactory")SqlSessionFactory sqlSessionFactory) throws Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
