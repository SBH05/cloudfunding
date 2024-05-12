package com.ohgiraffers.semiproject.kakaoPayment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Controller
@RequestMapping("/kakaopay")
public class KakaoController {


    @RequestMapping("/payment")
    @ResponseBody
    public String kakaoPay() {


        try {
            URL address = new URL("https://open-api.kakaopay.com/online/v1/payment/ready");
            HttpURLConnection serverCon = (HttpURLConnection) address.openConnection();
            serverCon.setRequestMethod("POST");
            serverCon.setRequestProperty("Authorization", "KakaoAK b6edfe2ebd62161798284b8ca8ab3f1f");
            serverCon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            serverCon.setDoOutput(true);
            String param = "cid=TC0ONETIME&partner_order_id=partner_order_id&partner_user_id=partner_user_id&item_name=펀딩&quantity=1&total_amount=1000&tax_free_amount=100&approval_url=http://localhost:8080/order/buyok&cancel_url=http://localhost:8080/order/buypage&fail_url=http://localhost:8080/order/buypage";
            OutputStream out = serverCon.getOutputStream();
            DataOutputStream data = new DataOutputStream(out);
            data.writeBytes(param);
            data.close();

            int result = serverCon.getResponseCode();

            InputStream receive;
            if(result == 200) {
                receive = serverCon.getInputStream();
            }else {
                receive = serverCon.getErrorStream();
            }

            InputStreamReader reader = new InputStreamReader(receive);
            BufferedReader change = new BufferedReader(reader);
            return change.readLine();

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
