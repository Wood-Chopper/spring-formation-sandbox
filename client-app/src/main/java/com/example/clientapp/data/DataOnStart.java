package com.example.clientapp.data;

import com.example.clientapp.data.repository.ItemRepository;
import com.example.clientapp.data.service.DummyService;
import com.example.clientapp.data.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataOnStart {

    private final ItemService itemService;
    private final DummyService dummyService;

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        try {
            System.out.println("========== START ===========");
            itemService.transactionA();
            System.out.println("==========================");
            itemService.transactionB();
            System.out.println("========== END ===========");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
