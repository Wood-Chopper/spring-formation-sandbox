package com.example.clientapp.data.service;

import com.example.clientapp.data.entity.ItemEntity;
import com.example.clientapp.data.repository.ItemRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final OtherService otherService;
    private final EntityManager entityManager;

    @Transactional
    public void transactionA() {
        itemRepository.save(new ItemEntity("Some name"));
        ItemEntity itemEntity = itemRepository.findById(1L).get();
    }

    @Transactional
    public void transactionB() {
        ItemEntity itemEntity = itemRepository.findById(1L).get();
        System.out.println(itemEntity);
    }
}
