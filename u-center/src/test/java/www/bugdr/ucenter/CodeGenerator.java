package www.bugdr.ucenter;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.LikeTable;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;

public class CodeGenerator {
    public static void main(String[] args) {
        // 全局策略配置
        GlobalConfig globalConfig = new GlobalConfig.Builder()
                // 覆盖已生成的文件
                .fileOverride()
                // 指定输出路径
                .outputDir("H:/AwebKF/fisher-man/u-center/src/main/java")
                // 开启swagger注解
                .enableSwagger()
                // 作者
                .author("bugdr")
                // 时间策略
                .dateType(DateType.TIME_PACK)
                // 注释日期格式
                .commentDate("yyyy-MM-dd")
                .build();

        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig
                .Builder("jdbc:mysql://localhost:3306/mo_yu_ucenter?useUnicode=true&useSSL=false" +
                "&characterEncoding=utf8" +
                "&serverTimezone=Asia/Shanghai"
                , "root", "123456")
                //数据库类型转换
                .typeConvert(new MySqlTypeConvert())
                //数据库关键字处理
                .keyWordsHandler(new MySqlKeyWordsHandler())
                //数据库查询
                .dbQuery(new MySqlQuery())
                //数据库部分
                // .schema("mybatis-plus")
                .build();

        //包配置
        PackageConfig packageConfig = new PackageConfig.Builder()
                //父包名
                .parent("www.bugdr")
                //父包模块名
                .moduleName("ucenter")
                //Controller 包名
                .controller("api")
                //Mapper 包名
                .mapper("mapper")
                //Service 包名
                .service("service")
                //Entity 包名
                .entity("pojo")
                .build();

        //策略配置
        StrategyConfig builder = new StrategyConfig.Builder()
                //开启大写命名
                .enableCapitalMode()
                //开启跳过视图
                .enableSkipView()
                //禁用 sql 过滤
                .disableSqlFilter()
                //模糊表匹配(sql 过滤)
                .likeTable(new LikeTable("user"))
                //增加表匹配(内存过滤)
                .addInclude("t_simple")
                //增加过滤表前缀
                .addTablePrefix("t_", "c_")
                //增加过滤表后缀
                .addFieldSuffix("_flag")

                // mapper 策略配置
                .mapperBuilder()
                //设置父类
                .superClass(BaseMapper.class)
                //启用 BaseResultMap 生成
                .enableBaseResultMap()
                //启用 BaseColumnList
                .enableBaseColumnList()
                //格式化 mapper 文件名称
                .formatMapperFileName("%sDao")
                //格式化 xml 实现类文件名称
                .formatXmlFileName("%sXml")
                .build();

        // 添加以上配置到AutoGenerator中
        AutoGenerator autoGenerator = new AutoGenerator(dataSourceConfig);
        autoGenerator.global(globalConfig); // 全局配置策略
        autoGenerator.packageInfo(packageConfig); // 包配置
        //生成代码
        autoGenerator.execute();
    }
}
