package com.example.amir.mahem.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.amir.mahem.Fragments.AddFragment;
import com.example.amir.mahem.Fragments.CategoriesFragment;
import com.example.amir.mahem.Fragments.HomeFragment;
import com.example.amir.mahem.Fragments.MenuFragment;
import com.example.amir.mahem.Fragments.SearchFragment;
import com.example.amir.mahem.R;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
//    SpaceNavigationView spaceNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SpaceNavigationView spaceNavigationView = (SpaceNavigationView) findViewById(R.id.space_navigation_view);
//        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
//        spaceNavigationView.addSpaceItem(new SpaceItem(null, R.drawable.ic_menu));
//        spaceNavigationView.addSpaceItem(new SpaceItem(null, R.drawable.ic_home));
//        spaceNavigationView.addSpaceItem(new SpaceItem(null, R.drawable.ic_search));
//        spaceNavigationView.addSpaceItem(new SpaceItem(null, R.drawable.ic_categories));
//        spaceNavigationView.setCentreButtonIcon(R.drawable.ic_add);

        init();

    }

    void init() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout_content, new HomeFragment()).commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            final FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (item.getItemId()) {
                case R.id.navigation_menu:
                    transaction.replace(R.id.frameLayout_content, new MenuFragment()).commit();
                    return true;
                case R.id.navigation_home:
                    transaction.replace(R.id.frameLayout_content, new HomeFragment()).commit();
                    return true;
                case R.id.navigation_add:
                    transaction.replace(R.id.frameLayout_content, new AddFragment()).commit();
                    return true;
                case R.id.navigation_search:
                    transaction.replace(R.id.frameLayout_content, new SearchFragment()).commit();
                    return true;
                case R.id.navigation_categories:
                    transaction.replace(R.id.frameLayout_content, new CategoriesFragment()).commit();
                    return true;
            }
            return false;
        }
    };

}
