package zone.totem.controllers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Enumeration;

import zone.totem.services.ReadingService;

import javax.servlet.http.HttpSession;

/**
 * Created by Holmes on 2016/7/24.
 */
@Controller
public class ReadingController {
    @Autowired
    private ReadingService readingSerivce;

    @RequestMapping("/{path}")
    public String index(@PathVariable String path) throws IOException,IllegalStateException{
        String result = readingSerivce.doService();

        return path;
    }

    @ResponseBody
    @RequestMapping(value="setSession")
    public String setSession(HttpSession session,@RequestBody String jsonStr) throws Exception{
        JSONObject jo = JSON.parseObject(jsonStr);
        Short thread = jo.getShort("thread");
        //设置session
        session.setAttribute("aa_"+thread,"aa_"+thread);
        session.setAttribute("bb_"+thread,"bb_"+thread);
        session.setAttribute("cc_" + thread, "cc_" + thread);

        //Thread.currentThread().sleep(50000);
        session.setAttribute("dd_"+thread,"dd_"+thread);
        session.setAttribute("ee_"+thread,"ee_"+thread);
        session.setAttribute("ff_"+thread,"ff_"+thread);
        session.setAttribute("gg_"+thread,"gg_"+thread);
        session.setAttribute("hh_"+thread,"hh_"+thread);

        //返回此时session的值
        Enumeration<String> enumeration = session.getAttributeNames();
        StringBuffer result = new StringBuffer();
        while(enumeration.hasMoreElements()){
            result.append(enumeration.nextElement()+"\n");
        }
        return result.toString();
    }

    @ResponseBody
    @RequestMapping("/removeSession")
    public String removeSession(HttpSession session){
        for(int i=1;i<3;i++){
            session.removeAttribute("aa_" + i);
            session.removeAttribute("bb_" + i);
            session.removeAttribute("cc_" + i);
            session.removeAttribute("dd_" + i);
            session.removeAttribute("ee_" + i);
            session.removeAttribute("ff_" + i);
            session.removeAttribute("gg_" + i);
            session.removeAttribute("hh_" + i);
        }
        //返回此时session的值
        Enumeration<String> enumeration = session.getAttributeNames();
        StringBuffer result = new StringBuffer();
        while(enumeration.hasMoreElements()){
            result.append(enumeration.nextElement()+"\n");
        }
        return result.toString();
    }


}
