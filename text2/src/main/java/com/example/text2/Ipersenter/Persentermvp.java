package com.example.text2.Ipersenter;

import com.example.text2.Imodel.CallBack;
import com.example.text2.Imodel.Imodelmvp;
import com.example.text2.Iview.Iview;
import com.example.text2.User;

import java.util.List;

/**
 * Created by DELL on 2019/5/29.
 */

public class Persentermvp implements Ipersenter {
    private Iview iview;
    private final Imodelmvp imodelmvp;

    public Persentermvp(Iview iview) {
        imodelmvp = new Imodelmvp();
        this.iview = iview;
    }

    @Override
    public void getpersenter() {
    imodelmvp.getmodel(new CallBack() {
        @Override
        public void getresult(List<User> result) {
            iview.getresultsuccess(result);
        }
    });
    }
}
