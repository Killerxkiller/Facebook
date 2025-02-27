package vn.edu.usth.facebook.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vn.edu.usth.facebook.fragment.FbMenuFragment;
import vn.edu.usth.facebook.fragment.FriendsFragment;
import vn.edu.usth.facebook.fragment.HomeFragment;
import vn.edu.usth.facebook.fragment.NotificationFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new FriendsFragment();
            case 2:
                return new NotificationFragment();
            case 3:
                return new FbMenuFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
