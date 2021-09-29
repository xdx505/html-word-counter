package ru.xdx505.wordcounter.data.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "word", schema = "public")
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String word;
    private int count;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "page_id", updatable = false)
    private Page page;
}
