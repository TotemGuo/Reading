package zone.totem.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import zone.totem.dao.model.Student;

import java.util.logging.Logger;

/**
 * Created by Holmes on 2016/12/12.
 */
@Repository
public class TestDao extends JdbcDaoSupport{
    private Logger logger = Logger.getGlobal();
    public void insert(Student student){
        String sql = "insert into student values ('"+student.getId()+"','"+student.getName()+"','"+student.getAge()+"')";
        logger.info("insert sql:"+sql);

        super.getJdbcTemplate().execute(sql);
    }
}
