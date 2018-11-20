package necer.ncalendardemo.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;


import com.necer.MyLog;
import com.necer.calendar.Miui9Calendar;
import com.necer.entity.NDate;
import com.necer.listener.OnCalendarChangedListener;


import necer.ncalendardemo.R;
import necer.ncalendardemo.adapter.AAAdapter;

/**
 * Created by necer on 2018/11/7.
 */
public class TestMiui9Activity extends BaseActivity {


    private Miui9Calendar miui9Calendar;

    private TextView tv_month;
    private TextView tv_year;
    private TextView tv_lunar;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_miui9;
    }

    @Override
    protected void onCreatee() {
        miui9Calendar = findViewById(R.id.miui9Calendar);
        tv_month = findViewById(R.id.tv_month);
        tv_year = findViewById(R.id.tv_year);
        tv_lunar = findViewById(R.id.tv_lunar);


        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AAAdapter aaAdapter = new AAAdapter(this);
        recyclerView.setAdapter(aaAdapter);


        miui9Calendar.setOnCalendarChangedListener(new OnCalendarChangedListener() {
            @Override
            public void onCalendarDateChanged(NDate date) {
                MyLog.d("date:::" + date.localDate);
                MyLog.d("date:::" + date.lunar.lunarYearStr);
                MyLog.d("date:::" + date.lunar.lunarMonthStr);
                MyLog.d("date:::" + date.lunar.lunarDayStr);
                MyLog.d("date:::" + date.lunar.isLeap);
                MyLog.d("date:::" + date.lunar.leapMonth);

                tv_month.setText(date.localDate.getMonthOfYear() + "月");
                tv_year.setText(date.localDate.getYear() + "年");

                tv_lunar.setText(date.lunar.lunarYearStr + date.lunar.lunarMonthStr + date.lunar.lunarDayStr);

            }

            @Override
            public void onCalendarStateChanged(boolean isMonthSate) {
                MyLog.d("OnCalendarChangedListener:::" + isMonthSate);
            }
        });

    }
}
