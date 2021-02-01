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
@MapperScan(basePackages = "com.tt.mapper.master",sqlSessionFactoryRef = "db1SqlSessionFactory")
public class DatasourceConfig1 {

//    @Primary
    @Bean(name = "db1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.dynamic.master")
    public DataSource masterDataSource(){
        System.out.println("====================masterDataSource 创建==============================");
        return DataSourceBuilder.create().build();
    }
//    @Primary
    @Bean("db1SqlSessionFactory")
    public SqlSessionFactory db1SqlSessionFactory(@Qualifier("db1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // mapper的xml形式文件位置必须要配置，不然将报错：no statement （这种错误也可能是mapper的xml中，namespace与项目的路径不一致导致）
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
        return bean.getObject();
    }

    /**
     * 创建管理器
     * @param dataSource
     * @return
     */
    @Bean(name = "db1TransactionManager")
    public DataSourceTransactionManager db1TranscationManager(@Qualifier("db1DataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

//    @Primary
    @Bean("db1SqlSessionTemplate")
    public SqlSessionTemplate db1SqlSessionTemplate(@Qualifier("db1SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
