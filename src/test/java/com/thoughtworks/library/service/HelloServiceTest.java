package com.thoughtworks.library.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HelloServiceTest {
    private HelloService helloService;

    @Before
    public void setUp() {
        helloService = new HelloService();
    }

    @Test
    public void shouldSayHello() {
        assertEquals("Hello World!", helloService.sayHello());
    }
}