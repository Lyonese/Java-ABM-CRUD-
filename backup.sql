--
-- PostgreSQL database dump
--

-- Dumped from database version 17.0
-- Dumped by pg_dump version 17.0

-- Started on 2024-12-04 19:37:20

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 218 (class 1259 OID 16392)
-- Name: asignaturas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.asignaturas (
    asignatura_codigo character varying(20) NOT NULL,
    instituto_codigo character varying(20) NOT NULL,
    asignatura_nombre character varying(50) NOT NULL,
    asignatura_descripcion character varying(50) NOT NULL,
    docente_responsable_legajo character varying(20)
);


ALTER TABLE public.asignaturas OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16412)
-- Name: cargos_docentes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cargos_docentes (
    cargo_docente_nro character varying(20) NOT NULL,
    docente_nro_legajo character varying(20) NOT NULL,
    instituto_codigo character varying(20) NOT NULL,
    cargo_docente_dedicacion_horas character varying(10) NOT NULL
);


ALTER TABLE public.cargos_docentes OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16402)
-- Name: docentes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.docentes (
    docente_nro_legajo character varying(20) NOT NULL,
    docente_nombre character varying(30) NOT NULL,
    docente_apellido character varying(30) NOT NULL,
    docente_dni character varying(8) NOT NULL,
    docente_fecha_nacimiento date NOT NULL,
    docente_contacto character varying(50) DEFAULT ''::character varying NOT NULL
);


ALTER TABLE public.docentes OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16387)
-- Name: institutos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.institutos (
    instituto_codigo character varying(20) NOT NULL,
    instituto_denominacion character varying(50) NOT NULL
);


ALTER TABLE public.institutos OWNER TO postgres;

--
-- TOC entry 4811 (class 0 OID 16392)
-- Dependencies: 218
-- Data for Name: asignaturas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.asignaturas (asignatura_codigo, instituto_codigo, asignatura_nombre, asignatura_descripcion, docente_responsable_legajo) FROM stdin;
ASIG002	INST001	Física	Introducción a la física	\N
ASIG003	INST002	Química	Curso de química aplicada	\N
ASIG006	INST004	Ciberseguridad	Conceptos y técnicas de seguridad en redes	\N
ASIG007	INST005	Bioquímica	Estudio de biomoléculas y reacciones metabólicas	\N
ASIG008	INST006	Psicología	Introducción a las teorías psicológicas	\N
123	abc1	Geofisica	Instroduccion a la geofisica	\N
ASIG005	INST004	Inteligencias artificales	Introduccion al machine learning	\N
zxcvb	abc4	Introduccion a fisicoterapia	fisico terapia	\N
zxcvbnm	abc4	Java	java	zxc
asdasdadsa	abc1	asd	asdcc	zxcv
ej1	abc1	Instroduccion a los ventiladores	asd 	DOC005
abc4	abc1	Ej asig	SUper asignatura	qwepoi
ASIG001	INST001	Matemáticas	Curso de matemáticas avanzadas	DOC005
\.


--
-- TOC entry 4813 (class 0 OID 16412)
-- Dependencies: 220
-- Data for Name: cargos_docentes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cargos_docentes (cargo_docente_nro, docente_nro_legajo, instituto_codigo, cargo_docente_dedicacion_horas) FROM stdin;
CARG002	DOC002	INST001	15 horas
CARG003	DOC003	INST002	30 horas
CARGO005	DOC005	INST004	25 horas
CARGO006	DOC006	INST004	15 horas
CARGO007	DOC007	INST005	20 horas
CARGO008	DOC008	INST006	10 horas
as1	DOC001	asd1	30 horas
12	lgjej	abc4	30 horas
20	DOC008	abc1	5 horas
DOC0010	DOC008	abc1	5 horas
\.


--
-- TOC entry 4812 (class 0 OID 16402)
-- Dependencies: 219
-- Data for Name: docentes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.docentes (docente_nro_legajo, docente_nombre, docente_apellido, docente_dni, docente_fecha_nacimiento, docente_contacto) FROM stdin;
DOC006	Miguel	Ruiz	55667788	1985-09-22	
DOC007	Sofía	Ramírez	66778899	1979-07-14	
DOC008	Fernando	López	77889900	1991-11-19	
DOC002	Juan	Manolo	87654321	1975-03-22	
DOC001	María	De los Angeles	12345678	1980-05-10	
DOC003	Ana	López	11223344	1999-08-18	
lgjej1	Pedro	Escamoso	12456890	1940-03-02	
lgjej	Pedro	El escamoso	12345678	1950-02-03	
aaa1	Ho	Chi Min	03034567	1945-03-12	
zxc	Juan	Caballero	12345678	1920-02-03	juan@gmail.com
zxcv	benja	mon	12345678	1923-12-12	humo
legajo	ej	ej	12098654	1930-03-23	
qwepoi	Juan	Pedro	12098765	1920-03-21	Mail@ejemplo.com
DOC005	Leopolda	Fernandez	33445566	1982-03-12	leo@gmail.com
01923	01923	01923	12309876	1920-02-23	mail.com
asdlkj	Juan	Perez	12098876	1978-03-18	jose@gmail.com
\.


--
-- TOC entry 4810 (class 0 OID 16387)
-- Dependencies: 217
-- Data for Name: institutos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.institutos (instituto_codigo, instituto_denominacion) FROM stdin;
INST002	Instituto de Ciencias Aplicadas
INST004	Instituto de Tecnología Avanzada
INST005	Instituto de Ciencias Aplicadas
INST006	Instituto de Estudios Sociales
abc1	Super ejemplo superior
abc4	Super instituto ejemplar
INST001	Instituto superior en bellas artes
asd1	Instituto asd1
abc2	Instituto superior abc2
0	asd
\.


--
-- TOC entry 4656 (class 2606 OID 16396)
-- Name: asignaturas asignaturas_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asignaturas
    ADD CONSTRAINT asignaturas_id PRIMARY KEY (asignatura_codigo);


--
-- TOC entry 4660 (class 2606 OID 16416)
-- Name: cargos_docentes cargos_docentes_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cargos_docentes
    ADD CONSTRAINT cargos_docentes_id PRIMARY KEY (cargo_docente_nro);


--
-- TOC entry 4658 (class 2606 OID 16406)
-- Name: docentes docentes_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.docentes
    ADD CONSTRAINT docentes_id PRIMARY KEY (docente_nro_legajo);


--
-- TOC entry 4654 (class 2606 OID 16391)
-- Name: institutos institutos_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.institutos
    ADD CONSTRAINT institutos_id PRIMARY KEY (instituto_codigo);


--
-- TOC entry 4661 (class 2606 OID 16397)
-- Name: asignaturas asignaturas_institutos_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asignaturas
    ADD CONSTRAINT asignaturas_institutos_fk FOREIGN KEY (instituto_codigo) REFERENCES public.institutos(instituto_codigo);


--
-- TOC entry 4663 (class 2606 OID 16422)
-- Name: cargos_docentes docentes_cargos_docentes_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cargos_docentes
    ADD CONSTRAINT docentes_cargos_docentes_fk FOREIGN KEY (docente_nro_legajo) REFERENCES public.docentes(docente_nro_legajo);


--
-- TOC entry 4662 (class 2606 OID 16486)
-- Name: asignaturas fk_docente_responsable; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asignaturas
    ADD CONSTRAINT fk_docente_responsable FOREIGN KEY (docente_responsable_legajo) REFERENCES public.docentes(docente_nro_legajo) ON UPDATE CASCADE ON DELETE SET NULL;


--
-- TOC entry 4664 (class 2606 OID 16417)
-- Name: cargos_docentes institutos_cargos_docentes_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cargos_docentes
    ADD CONSTRAINT institutos_cargos_docentes_fk FOREIGN KEY (instituto_codigo) REFERENCES public.institutos(instituto_codigo);


-- Completed on 2024-12-04 19:37:24

--
-- PostgreSQL database dump complete
--

