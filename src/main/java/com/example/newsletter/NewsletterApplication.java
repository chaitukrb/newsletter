package com.example.newsletter;

import com.example.newsletter.repository.SubscriptionRepository;
import com.example.newsletter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NewsletterApplication {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public static void main(String[] args) {
        SpringApplication.run(NewsletterApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        userRepository.deleteAllInBatch();
//        subscriptionRepository.deleteAllInBatch();
//    }

}
