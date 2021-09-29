package ru.xdx505.wordcounter.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.xdx505.wordcounter.data.model.Page;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {
}
