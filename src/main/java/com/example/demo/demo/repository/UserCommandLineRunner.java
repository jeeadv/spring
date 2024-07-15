package com.example.demo.demo.repository;

import com.example.demo.demo.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserCommandLineRunner implements CommandLineRunner
{
    @Autowired
    private UserRepository userRepository;
    private Logger logger = LoggerFactory.getLogger(UserCommandLineRunner.class);

    @Override
    public void run(String... args) throws Exception
    {
        userRepository.save(new UserEntity("Kumar", "Admin"));
        userRepository.save(new UserEntity("Gaurav", "Author"));
        userRepository.save(new UserEntity("Baba", "Agent"));
        userRepository.save(new UserEntity("Petla", "Manager"));

        for (UserEntity user: userRepository.findAll())
        {
            logger.info(user.toString());
        }

        UserEntity user = userRepository.findById(1L).get();
        logger.info("Found: {}", user.toString());

        userRepository.deleteById(1L);

        boolean empty = userRepository.findById(1L).isEmpty();
        logger.info("Found: {}", !empty);

        List<UserEntity> list = userRepository.findByRole("Admin");
        logger.info("Admins: " + list.toString());
    }
}
