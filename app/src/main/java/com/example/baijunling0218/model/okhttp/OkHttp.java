package com.example.baijunling0218.model.okhttp;

import android.os.Handler;
import android.os.Message;

import com.example.baijunling0218.model.JsonBean;
import com.google.gson.Gson;

import java.io.IOException;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Auther: 白俊岭
 * @Date: 2019/2/18 09:24:17
 * @Description:
 */
public class OkHttp<T> {
     public  static  OkHttp instance;
     JsonBean jsonBean;
     public  OkHttp(){

     }
     public  static  OkHttp getInstance(){
         if (instance ==null){
             return  new OkHttp();

         }else {
             return  instance;
         }
     }

    Handler handler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            T obj = (T)msg.obj;


              gv.chenggong(obj);
        }
    };
     public  void   doGet(final String path){
         OkHttpClient httpClient = new OkHttpClient();
         Request request = new Request.Builder().url(path).get().build();

         Call call = httpClient.newCall(request);
         call.enqueue(new Callback() {
             @Override
             public void onFailure(Call call, IOException e) {

             }

             @Override
             public void onResponse(Call call, Response response) throws IOException {
                 String string = response.body().string();
                 Gson gson = new Gson();
                 T t= (T)gson.fromJson(string,JsonBean.class);
                 Message message = handler.obtainMessage();
                 message.obj=t;
                        handler.sendMessage(message);

             }
         });
     }

      public  void  doPost(String url, String name,String page,String count){
          OkHttpClient build = new OkHttpClient.Builder()
                  .readTimeout(3, TimeUnit.SECONDS)
                  .connectTimeout(3, TimeUnit.SECONDS)
                  .build();

          FormBody formBody = new FormBody.Builder()
                  .add("keyword", name)
                  .add("count", page)
                  .add("count", count)
                  .build();
          final Request request = new Request.Builder()
                  .url(url)
                  .post(formBody)
                  .build();
          Call call = build.newCall(request);
          call.enqueue(new Callback() {
              @Override
              public void onFailure(Call call, IOException e) {
                      gv.shibai();
              }

              @Override
              public void onResponse(Call call, Response response) throws IOException {
                  String string = response.body().string();
                  Gson gson = new Gson();
                  T t= (T)gson.fromJson(string,JsonBean.class);
                  Message message = handler.obtainMessage();
                  message.obj=t;
                  handler.sendMessage(message);

              }
          });
      }
      public    interface getView<D>{
          public void chenggong(D d);
          public void shibai();

    }
    getView gv;
     public   void  HuiDao(getView gv){
         this.gv=gv;
     }

}
