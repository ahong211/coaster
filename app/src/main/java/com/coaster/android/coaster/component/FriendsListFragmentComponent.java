package com.coaster.android.coaster.component;

import com.coaster.android.coaster.FriendsListFragment;
import com.coaster.android.coaster.module.FriendsListFragmentModule;

import dagger.Component;

@Component(modules = FriendsListFragmentModule.class)
public interface FriendsListFragmentComponent {
    FriendsListFragment getFriendsListFragment();
}
