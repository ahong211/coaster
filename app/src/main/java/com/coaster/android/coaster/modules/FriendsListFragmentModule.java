package com.coaster.android.coaster.module;

import com.coaster.android.coaster.FriendsListFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class FriendsListFragmentModule {
    @Provides
    FriendsListFragment provideFriendsListFragment() {
        return new FriendsListFragment();
    }
}
