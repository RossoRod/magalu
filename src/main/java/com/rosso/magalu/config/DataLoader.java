package com.rosso.magalu.config;

import com.rosso.magalu.enums.ChannelEnum;
import com.rosso.magalu.enums.StatusEnum;
import com.rosso.magalu.repository.ChannelRepository;
import com.rosso.magalu.repository.StatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final ChannelRepository channelRepository;
    private final StatusRepository statusRepository;

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(ChannelEnum.values())
                .map(ChannelEnum::toChannel)
                .forEach(channelRepository::save);

        Arrays.stream(StatusEnum.values())
                .map(StatusEnum::toStatus)
                .forEach(statusRepository::save);
    }
}
