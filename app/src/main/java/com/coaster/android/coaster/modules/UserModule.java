package com.coaster.android.coaster.module;

import com.coaster.android.coaster.model.User;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {
    @Provides
    User provideUser() {
        return new User();
    }
}
