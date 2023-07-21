 package jdbcTemplate;

 import org.junit.Test;
 import org.springframework.jdbc.core.BeanPropertyRowMapper;
 import org.springframework.jdbc.core.JdbcTemplate;
 import utils.druidTool;

 import java.util.List;
 import java.util.Map;

 public class jbdcTemplateDemo1 {
   JdbcTemplate jdbcTemplate = new JdbcTemplate(druidTool.getDataSource()); //默认就是private

    @Test
    public void test1(){
        //获取jdbcTemplate对象
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(druidTool.getDataSource());
        //定义sql
        String sql = "update account set balance = 1500 where id = 1";
        //执行sql
        int update = jdbcTemplate.update(sql);
        System.out.println(update);
    }
//添加一条记录
     @Test
     public void test2(){
         //获取jdbcTemplate对象
//         JdbcTemplate jdbcTemplate = new JdbcTemplate(druidTool.getDataSource());
         //定义sql
         String sql = "insert into account values (null,?,?)";
         //执行sql
         int update = jdbcTemplate.update(sql,"深红囚影",4500);
         System.out.println(update);
     }
//查询记录 用map集合包装  用于一条记录  这个方法查询的长度只能是1
     @Test
     public void test3(){
         //获取jdbcTemplate对象
//         JdbcTemplate jdbcTemplate = new JdbcTemplate(druidTool.getDataSource());
         //定义sql
         String sql = "select * from account where id = ?";
         //执行sql
         Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql, 2);
         System.out.println(stringObjectMap);
     }
  //查询所有记录 用list封装  list 中的每一个元素都是一个map集合 这个用来查询多条记录
     @Test
     public void test4(){
         //获取jdbcTemplate对象
//         JdbcTemplate jdbcTemplate = new JdbcTemplate(druidTool.getDataSource());
         //定义sql
         String sql = "select * from account ";
         //执行sql
         List<Map<String, Object>> Lists = jdbcTemplate.queryForList(sql);
         System.out.println(Lists);
     }
//查询所有记录 封装成一个自定义类 account对象
     @Test
     public void test5(){
         //获取jdbcTemplate对象
//         JdbcTemplate jdbcTemplate = new JdbcTemplate(druidTool.getDataSource());
         //定义sql
         String sql = "select * from account ";
         //执行sql 返回一个list 元素是account对象
         List<account> Lists = jdbcTemplate.query(sql,new BeanPropertyRowMapper<account>(account.class));
         System.out.println(Lists);
     }

//查询总记录数
     @Test
     public void test6(){
         //获取jdbcTemplate对象
//         JdbcTemplate jdbcTemplate = new JdbcTemplate(druidTool.getDataSource());
         //定义sql
         String sql = "select count(id) from account ";
         //执行sql   固定返回一个long 类型的数据
         Object o = jdbcTemplate.queryForObject(sql, Long.class); //参数二写返回值类型的字节码文件
         System.out.println(o) ;
     }


}
