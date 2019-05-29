package com.example.dell.text.Ipersnenter;

import com.example.dell.text.Imodel.CallBack;
import com.example.dell.text.Imodel.Modelmvp;
import com.example.dell.text.Iview.Iview;
import com.example.dell.text.UserBean;

import java.util.List;

/**
 * Created by DELL on 2019/5/29.
 */

public class Persentermvp implements Ipersenter {
    private Iview iview;
    private final Modelmvp modelmvp;

    public Persentermvp(Iview iview) {
        this.iview = iview;
        modelmvp = new Modelmvp();
    }

    @Override
    public void getpersenter() {
modelmvp.getmodel(new CallBack() {
    @Override
    public void getsuccess(List<UserBean> result) {
        iview.getresult(result);
    }
});
    }
}
