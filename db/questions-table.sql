-- SEQUENCE: public.questions_id_seq

-- DROP SEQUENCE public.questions_id_seq;

CREATE SEQUENCE public.questions_id_seq;

ALTER SEQUENCE public.questions_id_seq
    OWNER TO ram;


-- Table: public.questions

-- DROP TABLE public.questions;

CREATE TABLE public.questions
(
    qid integer NOT NULL DEFAULT nextval('questions_id_seq'::regclass),
    question character varying(30) NOT NULL,
    correct_option character varying(20) NOT NULL,
    w_option_1 character varying(20) NOT NULL,
    w_option_2 character varying(20) NOT NULL,
    w_option_3 character varying(20) NOT NULL,
    CONSTRAINT questions_pkey PRIMARY KEY (qid)
)
WITH (
    OIDS = FALSE
)
--TABLESPACE pg_default;
--
--ALTER TABLE public.questions
--    OWNER to ram;
