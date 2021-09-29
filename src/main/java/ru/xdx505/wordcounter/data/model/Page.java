package ru.xdx505.wordcounter.data.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@Table(name = "page", schema = "public")
@EntityListeners(AuditingEntityListener.class)
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;

    @OneToMany(mappedBy = "page", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Word> words = new ArrayList<>();

    @CreatedDate
    @Column(updatable = false)
    private ZonedDateTime createdAt;
}
