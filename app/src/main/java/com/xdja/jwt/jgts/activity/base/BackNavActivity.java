package com.xdja.jwt.jgts.activity.base;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.gouhao.frame.activity.BaseDataBindingActivity;
import com.gouhao.frame.mvp.BasePresenter;
import com.xdja.jwt.jgts.R;

/**
 * Created by gouhao on 3/30/2017.
 */

public abstract class BackNavActivity<VD extends ViewDataBinding,P extends BasePresenter> extends BaseDataBindingActivity<VD, P> {
    @Override
    protected void initTitle() {
        ImageView imageView = createBackImageView();
        getTitleBar().addTitleBarLeftView(imageView);
    }

    @NonNull
    private ImageView createBackImageView() {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.mipmap.icon_back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        return imageView;
    }
}
