package com.coaster.android.coaster.components;

import com.coaster.android.coaster.models.User;
import com.coaster.android.coaster.modules.UserModule;

import dagger.Component;

@Component(modules = UserModule.class)
public interface UserComponent {
    User getUser();
}
