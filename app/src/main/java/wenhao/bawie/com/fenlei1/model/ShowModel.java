package wenhao.bawie.com.fenlei1.model;

import android.os.Handler;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Response;
import wenhao.bawie.com.fenlei1.bean.FirstBean;
import wenhao.bawie.com.fenlei1.bean.SenndBean;
import wenhao.bawie.com.fenlei1.utils.OkHttpUtils;
import wenhao.bawie.com.fenlei1.utils.RequestCallback;

/**
 * Created by HP on 2018/10/24.
 */

public class ShowModel {
    Handler handler = new Handler();

    public void getCarts(String url, HashMap<String,String>params,final ShowCallback showCallback){
        OkHttpUtils.getInstance().postData(url, params, new RequestCallback() {
            @Override
            public void failure(Call call, IOException e) {
                showCallback.failure("网络异常");
            }

            @Override
            public void success(Call call, Response response) {
                try {
                    String string = response.body().string();
                    if (!TextUtils.isEmpty(string)){
                        postResponse(string,showCallback);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void getsenndCarts(String url, HashMap<String,String>params,final SenndCallBack senndCallBack){
        OkHttpUtils.getInstance().postData(url, params, new RequestCallback() {
            @Override
            public void failure(Call call, IOException e) {
                senndCallBack.failure("网络异常");
            }

            @Override
            public void success(Call call, Response response) {
                try {
                    String string = response.body().string();
                    if (!TextUtils.isEmpty(string)){
                        senndResponse(string,senndCallBack);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void senndResponse(String string, final SenndCallBack senndCallBack) {
        Gson gson = new Gson();
        final SenndBean senndBean = gson.fromJson(string, SenndBean.class);
        handler.post(new Runnable() {
            @Override
            public void run() {
                senndCallBack.senndSuccess(senndBean);
            }
        });
    }

    private void postResponse(String string, final ShowCallback showCallback) {
        Gson gson = new Gson();
        final FirstBean firstBean = gson.fromJson(string, FirstBean.class);
        handler.post(new Runnable() {
            @Override
            public void run() {
                showCallback.success(firstBean);
            }
        });
    }

    public interface ShowCallback {
        void failure(String msg);

        void success(FirstBean firstBean);

    }

    public interface SenndCallBack {
        void failure(String msg);

        void senndSuccess(SenndBean senndBean);
    }
}
