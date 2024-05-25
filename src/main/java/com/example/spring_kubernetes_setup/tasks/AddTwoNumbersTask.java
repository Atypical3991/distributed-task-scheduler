package com.example.spring_kubernetes_setup.tasks;


import com.example.spring_kubernetes_setup.DTOs.task.AddTwoNumbersArgs;
import com.example.spring_kubernetes_setup.DTOs.task.TaskArgs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AddTwoNumbersTask implements Task {

    @Override
    public void execute(TaskArgs taskArgs) {
        AddTwoNumbersArgs args = (AddTwoNumbersArgs) taskArgs;
        int a = args.getA();
        int b = args.getB();
        log.info(String.format("Sum of two number a: %d and b: %d is %d ", a, b, a + b));
    }
}
