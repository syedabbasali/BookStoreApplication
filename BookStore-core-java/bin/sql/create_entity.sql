-- SEQUENCE: public.bookstore_tbl_seq

-- DROP SEQUENCE IF EXISTS public.bookstore_tbl_seq;

CREATE SEQUENCE IF NOT EXISTS public.bookstore_tbl_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9999999
    CACHE 1;

ALTER SEQUENCE public.bookstore_tbl_seq
    OWNER TO postgres;


-- Table: public.bookstore

-- DROP TABLE IF EXISTS public.bookstore;

CREATE TABLE IF NOT EXISTS public.bookstore
(
    book_id integer NOT NULL,
    book_name character varying(30) COLLATE pg_catalog."default",
 	item_price numeric(5,2) NOT NULL,
	available integer NOT NULL,
    CONSTRAINT bookstore_pkey PRIMARY KEY (item_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.bookstore
    OWNER to postgres;
