package com.example.user8856.magic;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import java.util.LinkedList;
import java.util.List;

/**
 * 用於處理退出程序時可以退出所有的activity，而編寫的通用類
 * 每個Activity在oncreate的時候都需調用MyApplication.getInstance().addActivity(this);
 * 以便將當前Activity加入到Activity集合中
 * @author duanyr
 *
 */
public class Allactivity extends AppCompatActivity {

    private List<Activity> activityList = new LinkedList<Activity>();
    private static Allactivity instance;

    private Allactivity() {
    }

    // 單例模式中獲取唯一的Allactivity實例
    public static Allactivity getInstance() {
        if (null == instance) {
            instance = new Allactivity();
        }
        return instance;
    }

    // 添加Activity到容器中
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    // 遍曆所有Activity並finish
    public void exit() {
        for (Activity activity : activityList) {
            activity.finish();
        }

        System.exit(0);
    }
}