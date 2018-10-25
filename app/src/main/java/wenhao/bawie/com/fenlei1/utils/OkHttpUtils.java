package wenhao.bawie.com.fenlei1.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by HP on 2018/10/24.
 */

public class OkHttpUtils {
    private OkHttpClient okHttpClient;
    private static OkHttpUtils okHttpUtils;

    private OkHttpUtils(){
        okHttpClient = new OkHttpClient.Builder()
                .writeTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();
    }

    public static OkHttpUtils getInstance(){
        if (okHttpUtils==null){
            synchronized (OkHttpUtils.class){
                if (okHttpUtils==null){
                    okHttpUtils = new OkHttpUtils();
                }
            }
        }
        return okHttpUtils;
    }

    public void postData(String url, HashMap<String,String> params,final RequestCallback requestCallback){
        FormBody.Builder body = new FormBody.Builder();
        for (Map.Entry<String,String>stringStringEntry : params.entrySet()){
            body.add(stringStringEntry.getKey(),stringStringEntry.getValue());
        }

        Request request = new Request.Builder()
                .url(url)
                .post(body.build())
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                requestCallback.failure(call,e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                requestCallback.success(call,response);
            }
        });
    }
}
