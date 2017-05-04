package com.thinkgem.jeesite.modules.sys.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author Tony_Wu
 * @date 2017-5-4
 */

@Service
public class TaskService {

    @Async
    public void test() throws InterruptedException {
        for (int i = 1; i < 20; i++) {
            System.out.println("------------  " + i + "  ------------");
            Thread.sleep(1000);
        }
    }

}
