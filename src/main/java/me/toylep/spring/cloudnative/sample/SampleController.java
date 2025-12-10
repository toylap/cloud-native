package me.toylep.spring.cloudnative.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @GetMapping("/")
    public String getCloudNative(){
        return "안녕하세요, 실습합니다.";
    }
}
