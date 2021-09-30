package ru.xdx505.wordcounter.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.xdx505.wordcounter.data.model.WebPage;

import java.util.Collection;

@Repository
public interface PageRepository extends JpaRepository<WebPage, Long> {
    Collection<WebPage> getAllByUrlOrderByCreatedAt(String url);
}
