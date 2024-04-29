package org.adactin.hotel.utils;

import org.adactin.hotel.base.BaseClass;
import org.adactin.hotel.pages.PageObjectManager;

import java.io.IOException;

public class TestContextSetUp {

    public PageObjectManager pageObjectManager;
    public BaseClass baseTest;

    public TestContextSetUp() throws IOException {
        baseTest = new BaseClass();
        pageObjectManager = new PageObjectManager(baseTest.webDriverManager());
    }
}
