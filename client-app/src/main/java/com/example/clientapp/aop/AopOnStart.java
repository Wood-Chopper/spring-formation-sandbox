package com.example.clientapp.aop;

import com.example.clientapp.aop.service.SomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AopOnStart {

    private final SomeService someService;

    //@EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        try {
            System.out.println("========== START ===========");
            someService.addition(2, 3);
            System.out.println("========== END ===========");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}