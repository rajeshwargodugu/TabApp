package com.example.tabapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


  /*  public ViewPager mViewPager;*/
    public TabLayout mTabLayout;
    public BottomNavigationView mBottomNavigationView;
    public RecyclerView mRecyclerView;
    public RecyclerView.LayoutManager mLayoutManager;

    public String mTabTitle = "TAB 1";
    public String mBotNavTitle = "BOT NAV 1";
    public TabRecyclerAdapter adapter;
    public String adapterData;
    public ArrayList<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mTabLayout = findViewById(R.id.tab_layout);
        adapterData = mTabTitle + mBotNavTitle;
        mBottomNavigationView = findViewById(R.id.bottom_nav_bar);
        mRecyclerView = findViewById(R.id.tab_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        data.add(adapterData);
        adapter = new TabRecyclerAdapter(data);
        mRecyclerView.setAdapter(adapter);
        /* mViewPager = findViewById(R.id.view_pager);*/


        //TODO remove annonymous class and move out this class
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mTabTitle = tab.getText().toString();
                adapterData = mTabTitle +"   "+ mBotNavTitle;
                data.clear();
                data.add(adapterData);
                adapter.notifyDataSetChanged();
/*                if (mTabLayout.getSelectedTabPosition() == 0) {
                     mTabTitle = "TAB 1 ";
                     adapterData = null;
                     adapterData = mTabTitle + mBotNavTitle;
                     //displayToast();
                     data.clear();
                     data.add(adapterData);
                     adapter.notifyDataSetChanged();
                    //Toast.makeText(MainActivity.this, "Tab " + mTabLayout.getSelectedTabPosition(), Toast.LENGTH_LONG).show();
                } else if (mTabLayout.getSelectedTabPosition() == 1) {
                    mTabTitle = "TAB 2 ";
                    //displayToast();
                    adapterData = mTabTitle + mBotNavTitle;
                    data.clear();
                    data.add(adapterData);
                    adapter.notifyDataSetChanged();
                    //Toast.makeText(MainActivity.this, "Tab " + mTabLayout.getSelectedTabPosition(), Toast.LENGTH_LONG).show();
                } else if (mTabLayout.getSelectedTabPosition() == 2) {
                    mTabTitle = "TAB 3 ";
                    //displayToast();
                    adapterData = mTabTitle + mBotNavTitle;
                    data.clear();
                    data.add(adapterData);
                    adapter.notifyDataSetChanged();
                    //Toast.makeText(MainActivity.this, "Tab " + mTabLayout.getSelectedTabPosition(), Toast.LENGTH_LONG).show();
                }*/

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                mBotNavTitle = item.getTitle().toString();
                adapterData = mTabTitle +"    "+ mBotNavTitle;
                data.clear();
                data.add(adapterData);
                adapter.notifyDataSetChanged();
                return true;

/*                switch (item.getItemId()) {
                    case R.id.bottom_nav_1:
                        mBotNavTitle = "BOT NAV 1 ";
                        //displayToast();
                        adapterData = mTabTitle + mBotNavTitle;
                        data.clear();
                        data.add(adapterData);
                        adapter.notifyDataSetChanged();
                        return true;
                    case R.id.bottom_nav_2:
                        mBotNavTitle = "BOT NAV 2 ";
                        //displayToast();
                        adapterData = mTabTitle + mBotNavTitle;
                        data.clear();
                        data.add(adapterData);
                        adapter.notifyDataSetChanged();
                        return true;
                    case R.id.bottom_nav_3:
                        mBotNavTitle = "BOT NAV 3 ";
                        //displayToast();
                        adapterData = mTabTitle + mBotNavTitle;
                        data.clear();
                        data.add(adapterData);
                        adapter.notifyDataSetChanged();
                        return true;
                }
                return false;*/
            }
        });

    } // End of init

    private void displayToast() {
        Toast.makeText(MainActivity.this, mTabTitle+mBotNavTitle, Toast.LENGTH_LONG).show();
    }
}
