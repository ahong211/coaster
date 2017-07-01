package com.coaster.android.coaster.modules;

import com.coaster.android.coaster.models.User;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {
    @Provides
    User provideUser() {
        return new User();
    }
}
