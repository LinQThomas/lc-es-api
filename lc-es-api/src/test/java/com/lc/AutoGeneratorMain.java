package com.lc;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

/**
 * 可以执行成功 生成的代码位置 在C:\_developSoftKu\ideaIU-2019.1.3.win\#CodeKu\lc-es-api\src
 * 而此项目的位置是: C:\_developSoftKu\ideaIU-2019.1.3.win\#CodeKu\lc-es-api\lc-es-api
 */
public class AutoGeneratorMain {
    public static void main(String[] args) {
        // 需要构建一个 代码自动生成器 对象
        AutoGenerator mpg = new AutoGenerator();
        // 配置策略
        // 1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir"); // D:\DevelopSoftKu\ideaIU-2019.3.win\#CodeKu\lc-es-api
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("LC");
        gc.setOpen(false);
        gc.setFileOverride(false); // 是否覆盖
        gc.setServiceName("%sService"); // 去Service的I前缀
        gc.setIdType(IdType.ID_WORKER);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(false);//设置为false吧 目前没有其相关包
        mpg.setGlobalConfig(gc);
        //2、设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        //    dsc.setUrl("jdbc:mysql://192.168.0.10:3306/test?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
        //    dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        //    dsc.setUsername("root");
        //    dsc.setPassword("root");
        //    dsc.setDbType(DbType.MYSQL);

        dsc.setUrl("jdbc:oracle:thin:@192.168.0.7:1521:LMTPlat");
        dsc.setDriverName("oracle.jdbc.driver.OracleDriver");
        dsc.setUsername("SCOTT");
        dsc.setPassword("Lmt123456");
        dsc.setDbType(DbType.ORACLE);
        mpg.setDataSource(dsc);
        //3、包的配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("sysConfig");
        pc.setParent("com.lc");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);
        //4、策略配置
        StrategyConfig strategy = new StrategyConfig();

        //strategy.setInclude("blog_tags", "course", "links", "sys_settings", "user_record", "user_say"); // 设置要映射的表名
        strategy.setInclude("SYS_CONFIG"); // 设置要映射的表名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true); // 自动lombok；
        strategy.setLogicDeleteFieldName("deleted");
        // 自动填充配置
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        strategy.setTableFillList(tableFills);
        // 乐观锁
        strategy.setVersionFieldName("version");
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true); //localhost:8080/ hello_id_2
        mpg.setStrategy(strategy);
        mpg.execute(); //执行
    }
}
