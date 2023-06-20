package com.example.clientapp.web.controller;

import com.example.clientapp.web.dto.RequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("web")
@RequiredArgsConstructor
public class ResourceController {

    @PostMapping
    public String getArg(@RequestBody @Valid RequestDto arg) {
        throw new RuntimeException();
        //return arg.getArg();
    }
}
