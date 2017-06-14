package com.coaster.android.coaster.component;

import com.coaster.android.coaster.model.User;
import com.coaster.android.coaster.module.UserModule;

import dagger.Component;

@Component(modules = UserModule.class)
public interface UserComponent {
    User getUser();
}
