package com.example.baijunling0218.present;

import com.example.baijunling0218.view.activity.MainActivity;

/**
 * @Auther: 白俊岭
 * @Date: 2019/2/18 08:50:12
 * @Description:
 */
public class BasePresent {

    MainActivity mainActivity;

    public  void  setView(MainActivity mainActivity){

        this.mainActivity=mainActivity;
    }

    public  MainActivity getView(){
        return  mainActivity;
    }

    public  void  dettachView(){
        mainActivity=null;
    }
}
