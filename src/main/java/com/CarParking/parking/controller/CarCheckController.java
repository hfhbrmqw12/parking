package com.CarParking.parking.controller;

import com.CarParking.parking.models.json.Wanted;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

@Controller
public class CarCheckController {

    private final String USER_AGENT = "Mozilla/5.0";

    @GetMapping("/car-check/check")
    public String carCheckCheck(@RequestParam String vin, Model model) {

        final String url = "https://api-gibdd.ru/proxy/check/auto/history?checkType=wanted&reCaptchaToken=484875ebc5f7ec377241b431e92a2bcf&vin="+vin;
        Wanted wanted = new Wanted();

        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", USER_AGENT);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            Gson gson = new Gson();
            wanted = gson.fromJson(response.toString(), wanted.getClass());

        } catch (Exception e) {
            model.addAttribute("error", true);
        } finally {
            model.addAttribute("response", wanted);
        }
        return "car-check";
    }

    @GetMapping("/car-check")
    public String carCheck(Model model) {
        return "car-check";
    }

//    {
//        "requestTime":"05.12.2021 00:25",
//            "RequestResult":
//        {
//            "records":
//				[
//            {
//                "w_rec":1,
//                    "w_reg_inic":"\u0421\u0430\u0445\u0430\u043b\u0438\u043d\u0441\u043a\u0430\u044f \u043e\u0431\u043b\u0430\u0441\u0442\u044c",
//                    "w_kuzov":"2088660KA\u0411\u0418HA",
//                    "w_model":"\u041a\u0410\u041c\u0410\u04176511",
//                    "w_data_pu":"29.05.2009",
//                    "w_vin":"XTC65111081155843",
//                    "w_god_vyp":"2008",
//                    "w_vid_uch":"\u0422",
//                    "w_un_gic":"1335035"
//            }
//				],
//            "count":1,
//                "error":0
//        },
//        "hostname":"database6",
//            "vin":"XTC65111081155843",
//            "status":200
//    }
}
