package wenhao.bawie.com.fenlei1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import wenhao.bawie.com.fenlei1.adapter.FirstAdapter;
import wenhao.bawie.com.fenlei1.adapter.SenndAdapter;
import wenhao.bawie.com.fenlei1.bean.FirstBean;
import wenhao.bawie.com.fenlei1.bean.SenndBean;
import wenhao.bawie.com.fenlei1.common.ShowCommon;
import wenhao.bawie.com.fenlei1.presenter.SenndPresenter;
import wenhao.bawie.com.fenlei1.presenter.ShowPresenter;
import wenhao.bawie.com.fenlei1.view.SenndView;
import wenhao.bawie.com.fenlei1.view.ShowView;

public class MainActivity extends AppCompatActivity implements ShowView,SenndView{

    private RecyclerView first_recyclerView;
    private RecyclerView sennd_recyclerView;
    private List<FirstBean.DataBean> data;
    private FirstAdapter firstAdapter;
    private ShowPresenter showPresenter;
    private HashMap<String, String> hashMap;
    private SenndPresenter senndPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first_recyclerView = (RecyclerView) findViewById(R.id.first_recyclerView);
        sennd_recyclerView = (RecyclerView) findViewById(R.id.sennd_recyclerView);
        
        sennd_recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
        first_recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));

        hashMap = new HashMap<>();
        senndPresenter = new SenndPresenter(this);
        senndPresenter.getsenndCarts(ShowCommon.Sennd+1,hashMap);


        showPresenter = new ShowPresenter(this);
        showPresenter.getCarts(ShowCommon.First,hashMap);

    }

    @Override
    public void failure(String msg) {
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success(final FirstBean firstBean) {
        data = firstBean.getData();
        firstAdapter = new FirstAdapter(MainActivity.this, data);
        first_recyclerView.setAdapter(firstAdapter);
        firstAdapter.RequestListener(new FirstAdapter.ShowListener() {
            @Override
            public void showCid(int i) {
                senndPresenter.getsenndCarts(ShowCommon.Sennd+i,hashMap);
            }
        });
    }

    @Override
    public void senndSuccess(SenndBean senndBean) {
        List<SenndBean.DataBean> data = senndBean.getData();
        SenndAdapter senndAdapter = new SenndAdapter(MainActivity.this,data);
        sennd_recyclerView.setAdapter(senndAdapter);
    }
}
