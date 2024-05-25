package com.example.spring_kubernetes_setup.modules.strategy;

import org.apache.curator.framework.recipes.cache.ChildData;

import java.util.List;

public interface WorkerPickerStrategy {
    ChildData evaluate(List<ChildData> workers);
}
