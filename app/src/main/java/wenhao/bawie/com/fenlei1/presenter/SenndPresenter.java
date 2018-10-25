package wenhao.bawie.com.fenlei1.presenter;

import java.util.HashMap;

import wenhao.bawie.com.fenlei1.bean.SenndBean;
import wenhao.bawie.com.fenlei1.model.ShowModel;
import wenhao.bawie.com.fenlei1.view.SenndView;

/**
 * Created by HP on 2018/10/25.
 */

public class SenndPresenter {
    private ShowModel showModel;
    private SenndView senndView;

    public SenndPresenter(SenndView senndView) {
        this.senndView = senndView;
        showModel = new ShowModel();
    }
    public void getsenndCarts(String url, HashMap<String,String> param){
        showModel.getsenndCarts(url, param, new ShowModel.SenndCallBack() {
            @Override
            public void failure(String msg) {
                senndView.failure(msg);
            }

            @Override
            public void senndSuccess(SenndBean senndBean) {
                senndView.senndSuccess(senndBean);
            }
        });
    }
}
