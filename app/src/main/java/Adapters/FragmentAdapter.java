package Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.workshop.ttm.addtask;
import com.workshop.ttm.postponed;
import com.workshop.ttm.settings;
import com.workshop.ttm.status;
import com.workshop.ttm.tasks;

import java.util.ArrayList;

public class FragmentAdapter extends FragmentStateAdapter {

    private String[] title= new String[]{"Tasks","Postponed","Add new task","Status","Settings"};
    public FragmentAdapter(FragmentActivity fragact){
        super(fragact);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new tasks();
            case 1: return new postponed();
            case 2: return new addtask();
            case 3: return new status();
            case 4: return new settings();
        }
        return new tasks();
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
