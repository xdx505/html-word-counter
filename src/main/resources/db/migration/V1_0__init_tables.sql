CREATE TABLE public.page
(
    id         BIGINT                   NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    url        VARCHAR(512)             NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE TABLE public.word
(
    id      BIGINT      NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    word    VARCHAR(32) NOT NULL,
    count   INTEGER     NOT NULL,
    page_id BIGINT      NOT NULL,
    CONSTRAINT word_page_id_fkey FOREIGN KEY (page_id) REFERENCES public.page (id)
);
