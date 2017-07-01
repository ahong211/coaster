package com.coaster.android.coaster.modules;

import com.coaster.android.coaster.views.fragments.FriendsListFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class FriendsListFragmentModule {
    @Provides
    FriendsListFragment provideFriendsListFragment() {
        return new FriendsListFragment();
    }
}
