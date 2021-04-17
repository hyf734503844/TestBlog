package com.lrm.web;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.lrm.po.Sms;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/sms")
public class SmsController {
    @RequestMapping("/Code")
    //RequestBody不会显示出来
    public String sms(){
        Sms sms=new Sms();
        int appid=1400477288;
        String appkey="492f334c46488a79af74767ade501e6d";
        int templateId=852107;
        String smsSign="hyfworld网";
//        sms.setPhoneNumber(phone);
        sms.setMin(5);
        sms.setCode("8899");
        System.out.println(sms.getMin());
//        sms.getMin();
        System.out.println("666");
        try{
            String[] params={sms.getCode(),Integer.toString(sms.getMin())};
            SmsSingleSender smsSingleSender=new SmsSingleSender(appid,appkey);
            SmsSingleSenderResult result=smsSingleSender.sendWithParam("86","18276466127",templateId,params,smsSign,"","");
            System.out.println("成功:"+result);
            return "redirect:/";
        }catch (HTTPException e){
            e.printStackTrace();
        }catch (JSONException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }
}
