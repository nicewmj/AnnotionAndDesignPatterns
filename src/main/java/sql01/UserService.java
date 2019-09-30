package sql01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    //引入模板JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String regit(String name, String pwd) {

        // 1.先获取到 自定增长ID
        String idIndexSQL = "INSERT INTO UUID VALUE (NULL)";

        int update = jdbcTemplate.update(idIndexSQL);
        Long insertId = jdbcTemplate.queryForObject("select last_insert_id()", Long.class);

        // 2.判断存储表名称
        String tableName = "user" + insertId % 3;

        // 3.注册数据  "INSERT INTO user VALUES (name,pwd)";
        String insertUserSql = "INSERT INTO " + tableName + " VALUES ('" + insertId + "','" + name + "','" + pwd+ "');";

        System.out.println("insertUserSql  " + insertUserSql);

        jdbcTemplate.update(insertUserSql);

        return "seccess";

    }

    public String get(Long id){

        String tableName = "user"+id % 3;

        String sql ="select name  from " + tableName +"  where id="+id;

        System.out.println("SQL "+sql);

        String name = jdbcTemplate.queryForObject(sql,String.class);

        return name;
    }
}
