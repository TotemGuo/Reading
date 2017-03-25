package zone.totem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zone.totem.dao.TestDao;
import zone.totem.dao.model.Student;

import java.math.BigDecimal;

/**
 * Created by Holmes on 2016/7/25.
 */
@Service
public class ReadingService {
    @Autowired
    TestDao testDao;
    public String doService(){
        Student stu = new Student();
        stu.setAge(11);
        stu.setId(1);
        stu.setName("totem");
        testDao.insert(stu);
        return "index";
    }
    public static void main(String[] args){
        BigDecimal bd1 = new BigDecimal(0.00798);
        BigDecimal bd4 = BigDecimal.valueOf(0.00798);
        BigDecimal bd2  = new BigDecimal(200000);
        BigDecimal bd3 = bd1.multiply(bd2);
        BigDecimal bd5 = bd4.multiply(bd2);
    }
}

