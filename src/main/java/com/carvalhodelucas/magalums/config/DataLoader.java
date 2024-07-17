package com.carvalhodelucas.magalums.config;

import com.carvalhodelucas.magalums.entities.Channel;
import com.carvalhodelucas.magalums.entities.Status;
import com.carvalhodelucas.magalums.repositories.ChannelRepository;
import com.carvalhodelucas.magalums.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(Channel.Values.values())
                .map(Channel.Values::toChannel)
                .forEach((channelRepository::save));

        Arrays.stream(Status.Values.values())
                .map(Status.Values::toStatus)
                .forEach(statusRepository::save);
    }

}
