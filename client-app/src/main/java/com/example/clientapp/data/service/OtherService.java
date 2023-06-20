package com.example.clientapp.data.service;

import com.example.clientapp.data.entity.ItemEntity;
import com.example.clientapp.data.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OtherService {
    private final ItemRepository itemRepository;

    public void aMethod() {
        ItemEntity itemEntity = itemRepository.findById(1L).get();
        itemEntity.setName("xx new");
        //throw new RuntimeException("error");
    }
}
