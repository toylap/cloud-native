package me.toylep.spring.cloudnative.merchservice.demo;

import lombok.RequiredArgsConstructor;
import me.toylep.spring.cloudnative.merchservice.domain.Merch;
import me.toylep.spring.cloudnative.merchservice.domain.MerchRepository;
import me.toylep.spring.cloudnative.merchservice.web.MerchContorller;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("testdata")
@RequiredArgsConstructor
public class MerchDataLoader {

    private final MerchRepository merchRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void loadMerchTestData(){
        var merch1 = new Merch("1231231231","merch1",9.1, "minsu");
        var merch2 = new Merch("1231231232","merch2",2.1, "minsu2");

        merchRepository.save(merch1);
        merchRepository.save(merch2);
    }

}
