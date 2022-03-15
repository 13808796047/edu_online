package com.summer.service.edu;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.junit.Test;

/**
 * @author Summer
 * @date 2022/3/16 1:27
 */

public class Generator {
    private  String projectPath = System.getProperty("user.dir");
    // 数据源配置
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig.Builder("jdbc:mysql://localhost:3306/guli?serverTimezone=GMT%2B8", "root", "")
            .typeConvert(new MySqlTypeConvert());


    @Test
    public void mybatisPlusGenerator() {
        FastAutoGenerator
                .create(DATA_SOURCE_CONFIG)
                //全局配置
                .globalConfig(builder -> {
                    builder.author("Summer") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .disableOpenDir() // 执行完毕不打开文件夹
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(projectPath + "/src/main/java"); // 指定输出目录
                })
                //包配置
                .packageConfig(builder -> {
                    builder.parent("com.summer.service.edu") // 设置父包名
                            .controller("controller") //生成controller层
                            .entity("entity") //生成实体层
                            .service("service") //生成服务层
                            .mapper("mapper"); //生成mapper层
                    // .moduleName("mybatisplus");
                })
                //策略配置
                .strategyConfig(builder -> {
                    builder.addInclude("edu_teacher") // 设置需要生成的表名
                            .addTablePrefix("edu_")// 设置过滤表前缀
                            .serviceBuilder() //开启service策略配置
                            .formatServiceFileName("%sService") //取消Service前的I
                            .controllerBuilder() //开启controller策略配置
                            .enableRestStyle() //配置restful风格
                            .enableHyphenStyle() //url中驼峰转连字符
                            .entityBuilder() //开启实体类配置
                            .enableLombok() //开启lombok
                            .enableChainModel(); //开启lombok链式操作

                })
                //模板配置
                .templateEngine(new VelocityTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                //执行
                .execute();
    }
}
