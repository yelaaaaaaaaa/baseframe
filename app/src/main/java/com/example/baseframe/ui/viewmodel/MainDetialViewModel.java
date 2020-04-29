package com.example.baseframe.ui.viewmodel;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import com.blankj.ALog;

import com.example.baseframe.base.BaseViewModel;
import com.example.baseframe.bean.WanAndroidBannerBean;
import com.example.baseframe.bus.event.SingleLiveEvent;
import com.example.baseframe.listener.ClickListener;
import com.example.baseframe.ui.TestDetailFragment;
import com.example.baseframe.ui.TestWeightActivity;
import com.example.baseframe.webview.WebViewActivity;


/**
 * Anthor yzh Date 2019/12/6 11:32
 */
public class MainDetialViewModel extends BaseViewModel {
    private Bundle bundle;
    public WanAndroidBannerBean mBannerBean;

    //权限点击事件 在onBindingClick里调用了call，
    public SingleLiveEvent<Void> permissionsEvent = new SingleLiveEvent<>();

    public SingleLiveEvent<String> downLoadEvent = new SingleLiveEvent<>();
    public SingleLiveEvent<String> errorEvent = new SingleLiveEvent<>();


    public ObservableField<String> downBtnName = new ObservableField<>("点击体验下载的乐趣");
    public MainDetialViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public void onBundle(Bundle bundle) {
        this.bundle=bundle;
        if(bundle!=null){
            mBannerBean= (WanAndroidBannerBean) bundle.getSerializable("bannerBean");
            ALog.w("示例ViewModel获取acitivty的传值:"+mBannerBean.toString());
        }


    }

    //闪退点击事件
    public ClickListener errorClick=(v) -> errorEvent.setValue("哟哟哟，项目又报空指针了呢");

    //下载
    public ClickListener downloadClick=(v) -> downLoadEvent.setValue("http://s.duapps.com/apks/own/ESFileExplorer-V4.2.1.7.apk");

    //跳转测试Fragment
    public ClickListener fragmentClick=(v) -> startContainerActivity(TestDetailFragment.class.getCanonicalName(), bundle);

    //跳转网页
    public void toWebView(){
       // WebViewActivity.loadUrl("http://www.baidu.com",null);
        WebViewActivity.loadUrl("http://www.baidu.commmmmmmm",null);
    }

    //跳转
    public void toTestWeight(){
        startActivity(TestWeightActivity.class);
    }
}
