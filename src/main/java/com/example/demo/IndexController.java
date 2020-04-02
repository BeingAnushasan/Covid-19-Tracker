package com.example.demo;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class IndexController {

    final DataRepo repo;

    public IndexController(DataRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/index")
    public ListOfDataModel index() throws IOException {
        OkHttpClient client = new OkHttpClient();


        //For Nepal
//        Request request = new Request.Builder()
//                .url("https://covid-19-data.p.rapidapi.com/country?format=undefined&name=nepal")
//                .get()
//                .addHeader("x-rapidapi-host", "covid-19-data.p.rapidapi.com")
//                .addHeader("x-rapidapi-key", "3dc0286f14msh3f94610389603cfp151dfejsn86d03474b279")
//                .build();


        //for all countries
        Request request = new Request.Builder()
                .url("https://covid-19-data.p.rapidapi.com/country/all?format=undefined")
                .get()
                .addHeader("x-rapidapi-host", "covid-19-data.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "3dc0286f14msh3f94610389603cfp151dfejsn86d03474b279")
                .build();


        Response response = client.newCall(request).execute();


          String data = response.body().string();
        //to remove [] from json string
        data = data.replaceAll("\\[", "").replaceAll("\\]","");


        Gson gson = new Gson(); // Or use new GsonBuilder().create();
        DataModel targetClass = gson.fromJson(data,  DataModel.class);

        //repo.save(targetClass);

        return  targetClass;


    }

//    @GetMapping("/getdata")
//    public List<DataModel> getdata(){
//        return  repo.findAll();
//
//    }


}
