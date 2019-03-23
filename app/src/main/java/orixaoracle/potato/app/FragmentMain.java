package orixaoracle.potato.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import orixaoracle.potato.app.ui.fragmentmain.FragmentMainFragment;

public class FragmentMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, FragmentMainFragment.newInstance())
                    .commitNow();
        }
    }
}
