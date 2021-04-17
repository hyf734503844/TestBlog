package com.lrm.web;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.lrm.po.Sms;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@Controller
@RequestMapping("/phone")
public class PhoneController {
    @RequestMapping("/main")
    public String goToPhonePage(){
        return "phone";
    }

    public static String randomCode() {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();

    }

    @RequestMapping("/s")
    public String s(String phone, HttpSession session){

            //1.连接redis
        Jedis jedis=new Jedis("127.0.0.1",6379);
        System.out.println(phone);
//        System.out.println("ready:"+(jedis.ttl(phone)==-2));
        //2.操作redis
        //获取id 转String
        //调一个随机6位数字方法
            if(jedis.ttl(phone)==-2){
//                System.out.println("good ==-2");
                String code=randomCode();
                jedis.setex(phone,300, code);
                Sms sms=new Sms();
                int appid=1400477288;
                String appkey="492f334c46488a79af74767ade501e6d";
                int templateId=852107;
                String smsSign="hyfworld网";
//        sms.setPhoneNumber(phone);
                sms.setMin(5);
                sms.setCode(code);
                System.out.println(sms.getMin());
//        sms.getMin();
                System.out.println("666");
                try{
                    String[] params={sms.getCode(),Integer.toString(sms.getMin())};
                    SmsSingleSender smsSingleSender=new SmsSingleSender(appid,appkey);
                    SmsSingleSenderResult result=smsSingleSender.sendWithParam("86",phone,templateId,params,smsSign,"","");
                    System.out.println("成功:"+result);

                }catch (HTTPException e){
                    e.printStackTrace();
                }catch (JSONException e) {
                    e.printStackTrace();
                }catch (IOException e) {
                    e.printStackTrace();
                }

            }
//
        //3。关闭
        jedis.close();

        System.out.println("over");
        session.setAttribute("phone",phone);
        return "phone :: userList";

    }

    @RequestMapping("/v")
    public String v(String phone, String v, Model model,HttpSession session){
        System.out.println("come?");
        //1.连接redis
        Jedis jedis=new Jedis("127.0.0.1",6379);
        if(jedis.get(phone).toString().equals(v)){
            jedis.close();
            //注册过的用户？
            if(true){
                session.setAttribute("flag",1);
                System.out.println("跳转了2021.1.16");
                session.setAttribute("flag1",1);
                System.out.println("fllllllllllllllllllll");
            }else{
                //注册,手机号为phone
            }

            session.setAttribute("phone",phone);
            return "redirect:/";
        }else{
            jedis.close();
            model.addAttribute("pe",phone);
            return "phone";
        }

    }

}
