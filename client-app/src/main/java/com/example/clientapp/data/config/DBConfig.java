package com.example.clientapp.data.config;

import com.example.clientapp.data.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configurable
@EnableJpaRepositories(basePackageClasses = ItemRepository.class)
public class DBConfig {
}
