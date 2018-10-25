package wenhao.bawie.com.fenlei1.presenter;

import java.util.HashMap;

import wenhao.bawie.com.fenlei1.bean.FirstBean;
import wenhao.bawie.com.fenlei1.bean.SenndBean;
import wenhao.bawie.com.fenlei1.model.ShowModel;
import wenhao.bawie.com.fenlei1.view.ShowView;

/**
 * Created by HP on 2018/10/24.
 */

public class ShowPresenter {
    private ShowModel showModel;
    private ShowView showView;

    public ShowPresenter(ShowView showView) {
        this.showView = showView;
        showModel = new ShowModel();
    }

    public void getCarts(String url, HashMap<String,String> param){
        showModel.getCarts(url, param, new ShowModel.ShowCallback() {
            @Override
            public void failure(String msg) {
                showView.failure(msg);
            }

            @Override
            public void success(FirstBean firstBean) {
                showView.success(firstBean);
            }
        });
    }
}
