-- SEQUENCE: public.questions_id_seq

-- DROP SEQUENCE public.questions_id_seq;

CREATE SEQUENCE public.questions_all_1_id_seq;

ALTER SEQUENCE public.questions_all_1_id_seq
    OWNER TO ram;


-- Table: public.questions

-- DROP TABLE public.questions;

CREATE TABLE public.questions_all_1
(
    qid integer NOT NULL DEFAULT nextval('questions_id_seq'::regclass),
    question character varying(200) NOT NULL,
    correct_option character varying(200) NOT NULL,
    w_option_1 character varying(200) NOT NULL,
    w_option_2 character varying(200) NOT NULL,
    w_option_3 character varying(200) NOT NULL,
    CONSTRAINT questions_all_1_pkey PRIMARY KEY (qid)
)
WITH (
    OIDS = FALSE
)
--TABLESPACE pg_default;
--
--ALTER TABLE public.questions
--    OWNER to ram;
