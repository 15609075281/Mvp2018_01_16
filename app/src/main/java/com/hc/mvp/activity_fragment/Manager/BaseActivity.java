package com.hc.mvp.activity_fragment.Manager;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import com.jingewenku.abrahamcaijin.commonutil.AppDavikActivityMgr;
import com.jingewenku.abrahamcaijin.commonutil.AppKeyBoardMgr;
import com.jingewenku.abrahamcaijin.commonutil.AppToastMgr;
import com.readystatesoftware.systembartint.SystemBarTintManager;


/**
 * Created by Administrator on 2018/1/17.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private static final String LOG = "BaseActivity";
    AppDavikActivityMgr appDavikActivityMgr = null;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appDavikActivityMgr = AppDavikActivityMgr.getScreenManager();
        appDavikActivityMgr.addActivity(this);
        // 4.4及以上版本开启
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setNavigationBarTintEnabled(true);
        // 自定义颜色
        tintManager.setTintColor(Color.parseColor("#00FA9A"));
        //初始化
        setContentView(inti());
        findview();
    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);

    }

    /**
     * 加载xml
     *
     * @return
     */
    public abstract int inti();

    /**
     * 初始化view
     */
    public abstract void findview();

    /**
     * 打开软件盘
     */
    public void openKey(EditText editText) {
        AppKeyBoardMgr.toggleKeybord(editText);
    }
    /**
     *
     */

    /**
     * 当前activity从堆栈中移除
     */
    public void remove() {
        appDavikActivityMgr.removeActivity(this);
    }

    /**
     * Tost
     */
    public void toastOpen() {
        AppToastMgr.ToastLongBottomCenter(this, "什么也没有");

    }


}
