package com.coaster.android.coaster;

import android.content.Context;

import com.coaster.android.coaster.CategoryFragment.CategoryFragment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UnitTests {

    @Mock
    Context mockContext;
    MainActivity mainActivity;
    private DrinksFragment drinksFragment = new DrinksFragment();
    private CategoryFragment categoryFragment = new CategoryFragment();

    @Test
    public void vodkaStringKeyTest() throws Exception {

    }

    @Test
    public void whiskeyStringKeyTest() throws Exception {

    }
}