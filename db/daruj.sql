--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4
-- Dumped by pg_dump version 9.5.4

-- Started on 2016-12-10 14:19:56

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2136 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- TOC entry 184 (class 1259 OID 17852)
-- Name: seq_gift_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE seq_gift_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE seq_gift_id OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 182 (class 1259 OID 17836)
-- Name: gift; Type: TABLE; Schema: public; Owner: daruj
--

CREATE TABLE gift (
    id integer DEFAULT nextval('seq_gift_id'::regclass) NOT NULL,
    name text NOT NULL,
    person_id integer NOT NULL
);


ALTER TABLE gift OWNER TO daruj;

--
-- TOC entry 185 (class 1259 OID 17854)
-- Name: seq_institute_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE seq_institute_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE seq_institute_id OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 17828)
-- Name: institute; Type: TABLE; Schema: public; Owner: daruj
--

CREATE TABLE institute (
    id integer DEFAULT nextval('seq_institute_id'::regclass) NOT NULL,
    name text NOT NULL
);


ALTER TABLE institute OWNER TO daruj;

--
-- TOC entry 186 (class 1259 OID 17856)
-- Name: seq_person_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE seq_person_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE seq_person_id OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 17844)
-- Name: person; Type: TABLE; Schema: public; Owner: daruj
--

CREATE TABLE person (
    id integer DEFAULT nextval('seq_person_id'::regclass) NOT NULL,
    name text NOT NULL,
    institute_id integer
);


ALTER TABLE person OWNER TO daruj;

--
-- TOC entry 2124 (class 0 OID 17836)
-- Dependencies: 182
-- Data for Name: gift; Type: TABLE DATA; Schema: public; Owner: daruj
--

COPY gift (id, name, person_id) FROM stdin;
1	Auto na vysilacku	1
2	Mobil	2
3	Panenka	3
\.


--
-- TOC entry 2123 (class 0 OID 17828)
-- Dependencies: 181
-- Data for Name: institute; Type: TABLE DATA; Schema: public; Owner: daruj
--

COPY institute (id, name) FROM stdin;
1	Detsky domov Pysely
2	Domov Jirny
3	Institut pro deti a mladez
\.


--
-- TOC entry 2125 (class 0 OID 17844)
-- Dependencies: 183
-- Data for Name: person; Type: TABLE DATA; Schema: public; Owner: daruj
--

COPY person (id, name, institute_id) FROM stdin;
1	Pavel Novak	1
2	Jirka Kubes	1
3	Norman Fidel	1
4	Lidl Frankenstein	1
5	Ota Soukar	1
\.


--
-- TOC entry 2137 (class 0 OID 0)
-- Dependencies: 184
-- Name: seq_gift_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('seq_gift_id', 3, true);


--
-- TOC entry 2138 (class 0 OID 0)
-- Dependencies: 185
-- Name: seq_institute_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('seq_institute_id', 3, true);


--
-- TOC entry 2139 (class 0 OID 0)
-- Dependencies: 186
-- Name: seq_person_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('seq_person_id', 5, true);


--
-- TOC entry 2003 (class 2606 OID 17843)
-- Name: gift_pkey; Type: CONSTRAINT; Schema: public; Owner: daruj
--

ALTER TABLE ONLY gift
    ADD CONSTRAINT gift_pkey PRIMARY KEY (id);


--
-- TOC entry 2000 (class 2606 OID 17835)
-- Name: institute_pkey; Type: CONSTRAINT; Schema: public; Owner: daruj
--

ALTER TABLE ONLY institute
    ADD CONSTRAINT institute_pkey PRIMARY KEY (id);


--
-- TOC entry 2006 (class 2606 OID 17851)
-- Name: person_pkey; Type: CONSTRAINT; Schema: public; Owner: daruj
--

ALTER TABLE ONLY person
    ADD CONSTRAINT person_pkey PRIMARY KEY (id);


--
-- TOC entry 2001 (class 1259 OID 17873)
-- Name: fki_gift_person_fkey; Type: INDEX; Schema: public; Owner: daruj
--

CREATE INDEX fki_gift_person_fkey ON gift USING btree (person_id);


--
-- TOC entry 2004 (class 1259 OID 17867)
-- Name: fki_person_institute_fkey; Type: INDEX; Schema: public; Owner: daruj
--

CREATE INDEX fki_person_institute_fkey ON person USING btree (institute_id);


--
-- TOC entry 2007 (class 2606 OID 17868)
-- Name: gift_person_fkey; Type: FK CONSTRAINT; Schema: public; Owner: daruj
--

ALTER TABLE ONLY gift
    ADD CONSTRAINT gift_person_fkey FOREIGN KEY (person_id) REFERENCES person(id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2008 (class 2606 OID 17862)
-- Name: person_institute_fkey; Type: FK CONSTRAINT; Schema: public; Owner: daruj
--

ALTER TABLE ONLY person
    ADD CONSTRAINT person_institute_fkey FOREIGN KEY (institute_id) REFERENCES institute(id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2135 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-12-10 14:19:56

--
-- PostgreSQL database dump complete
--

