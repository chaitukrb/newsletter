package com.example.newsletter.repository;

import com.example.newsletter.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findBySubId(Long id);
    Optional<News> findByIdAndSubId(Long id, Long subId);
}
