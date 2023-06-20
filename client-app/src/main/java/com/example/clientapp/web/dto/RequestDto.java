package com.example.clientapp.web.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestDto {
    @Size(max = 5)
    private String arg;
}
