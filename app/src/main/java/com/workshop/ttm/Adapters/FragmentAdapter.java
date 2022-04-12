package com.workshop.ttm.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.workshop.ttm.AddTask;
import com.workshop.ttm.Postponed;
import com.workshop.ttm.Profile;
import com.workshop.ttm.Status;
import com.workshop.ttm.Tasks;

public class FragmentAdapter extends FragmentStateAdapter {

    private String[] title= new String[]{"Tasks","Postponed","Add new task","Status","Settings"};
    public FragmentAdapter(FragmentActivity fragact){
        super(fragact);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new Tasks();
            case 1: return new Postponed();
            case 2: return new AddTask();
            case 3: return new Status();
            case 4: return new Profile();
        }
        return new Tasks();
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
