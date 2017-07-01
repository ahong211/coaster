package com.coaster.android.coaster.components;

import com.coaster.android.coaster.views.fragments.FriendsListFragment;
import com.coaster.android.coaster.modules.FriendsListFragmentModule;

import dagger.Component;

@Component(modules = FriendsListFragmentModule.class)
public interface FriendsListFragmentComponent {
    FriendsListFragment getFriendsListFragment();
}
