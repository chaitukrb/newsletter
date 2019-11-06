package com.example.newsletter.controller;

import com.example.newsletter.model.News;
import com.example.newsletter.repository.NewsRepository;
import com.example.newsletter.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @GetMapping("/sub/{s_id}/news")
    public List<News> getAllNewsBySubId(@PathVariable (value = "s_id")
                                        Long s_id) {
        return newsRepository.findBySubId(s_id);
    }

    @PostMapping("/sub/{s_id}/news")
    public News createNews(@PathVariable (value = "s_id") Long sub_id,
                           @Valid @RequestBody News news) {
        return subscriptionRepository.findById(sub_id).map(sub -> {
            news.setSub(sub);
            return newsRepository.save(news);
        }).orElseThrow(()->new ResourceNotFoundException("No"));
    }

}
