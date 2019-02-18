package com.example.baijunling0218.present;

import com.example.baijunling0218.model.JsonBean;
import com.example.baijunling0218.model.okhttp.OkHttp;

/**
 * @Auther: 白俊岭
 * @Date: 2019/2/18 08:50:32
 * @Description:
 */
public class MainPresent extends  BasePresent implements OkHttp.getView<JsonBean> {

    private final OkHttp instance;

    public MainPresent(){
        instance = OkHttp.getInstance();
        instance.HuiDao(this);

    }

     public  void  login (String url){
        instance.doGet(url);

     }
     private  void reg(String name,String pass){

     }

    @Override
    public void chenggong(JsonBean o) {
 getView().Seccuss(o);
    }

    @Override
    public void shibai() {

    }
}
