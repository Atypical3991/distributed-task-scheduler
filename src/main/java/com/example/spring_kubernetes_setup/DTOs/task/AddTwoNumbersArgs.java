package com.example.spring_kubernetes_setup.DTOs.task;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AddTwoNumbersArgs implements TaskArgs, Serializable {
    @JsonProperty("a")
    private int a;
    @JsonProperty("b")
    private int b;
}
