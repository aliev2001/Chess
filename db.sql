--
-- PostgreSQL database dump
--

-- Dumped from database version 12.4
-- Dumped by pg_dump version 12.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
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
-- Name: club; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.club (
    id bigint NOT NULL,
    title character varying(255),
    description text,
    image character varying(255)
);


ALTER TABLE public.club OWNER TO postgres;

--
-- Name: club_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.club_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.club_id_seq OWNER TO postgres;

--
-- Name: club_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.club_id_seq OWNED BY public.club.id;


--
-- Name: event; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.event (
    id bigint NOT NULL,
    title character varying(255),
    text text,
    date date DEFAULT CURRENT_DATE
);


ALTER TABLE public.event OWNER TO postgres;

--
-- Name: event_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.event_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.event_id_seq OWNER TO postgres;

--
-- Name: event_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.event_id_seq OWNED BY public.event.id;


--
-- Name: news; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.news (
    id bigint NOT NULL,
    title character varying(255),
    text text,
    date date DEFAULT CURRENT_DATE
);


ALTER TABLE public.news OWNER TO postgres;

--
-- Name: news_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.news_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.news_id_seq OWNER TO postgres;

--
-- Name: news_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.news_id_seq OWNED BY public.news.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    name character varying,
    surname character varying,
    username character varying,
    password character varying,
    "isAdmin" boolean DEFAULT false,
    year integer,
    major character varying(255),
    "uGroup" character varying(255)
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: users_clubs_mapping; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users_clubs_mapping (
    "userId" bigint,
    "clubId" bigint
);


ALTER TABLE public.users_clubs_mapping OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: club id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.club ALTER COLUMN id SET DEFAULT nextval('public.club_id_seq'::regclass);


--
-- Name: event id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.event ALTER COLUMN id SET DEFAULT nextval('public.event_id_seq'::regclass);


--
-- Name: news id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.news ALTER COLUMN id SET DEFAULT nextval('public.news_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Data for Name: club; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.club (id, title, description, image) FROM stdin;
10	AITU Music Club	Something	https://astanait.edu.kz/wp-content/uploads/2020/04/music-club.jpg
11	Cybersport	Sport sport sport is not about us	https://astanait.edu.kz/wp-content/uploads/2020/04/cybersport-club.png
12	Sport Club	Sport club	https://scontent.fala6-1.fna.fbcdn.net/v/t1.0-9/26906981_1662267147153566_7537226406176992276_n.jpg?_nc_cat=102&ccb=2&_nc_sid=110474&_nc_ohc=_PFESAf4xFsAX_5pxXx&_nc_ht=scontent.fala6-1.fna&oh=e73a64b9ad205cae8c1a49598c7ff854&oe=5FD81402
13	Science Club	Science	https://scontent.fala6-1.fna.fbcdn.net/v/t1.0-9/79210225_3051062824948756_6976374006976638144_o.png?_nc_cat=106&ccb=2&_nc_sid=730e14&_nc_ohc=_3DfTPk6GgcAX_zmb1X&_nc_ht=scontent.fala6-1.fna&oh=9bb9121e5d4784ce9a039f8377518369&oe=5FD81A34
\.


--
-- Data for Name: event; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.event (id, title, text, date) FROM stdin;
5	Skilling Open	The first part of the new Champions Chess Tour, a series of 10 tournaments that run until September 2021 for a $1.5 million prize fund.	2020-11-22
\.


--
-- Data for Name: news; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.news (id, title, text, date) FROM stdin;
4	NU student developed a special algorithm step to PhD to improve 5G schema	Another NU doctoral student who has successfully defended this year, Talgat Manglaev, also devoted his research to the development of the fifth generation of mobile networks, developing a special algorithm to improve the 5G scheme.	2020-11-15
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, name, surname, username, password, "isAdmin", year, major, "uGroup") FROM stdin;
38	Angelina	Jolie	a.jolie	jolie	t	2020	Acting	A-2020
42	Margot	Robbie	m.robbie	robbie	f	2019	Acting	A-1909
43	Will	Smith	w.smith	smith	f	2020	Computer Science	CS-1909
39	John	Depp	j.depp	depp	t	2020	Acting	A-2019
47	Nursultan	Haimuldin	n.haimuldin	123	t	2020	Computer Science	CS-1909
\.


--
-- Data for Name: users_clubs_mapping; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users_clubs_mapping ("userId", "clubId") FROM stdin;
42	10
\.


--
-- Name: club_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.club_id_seq', 14, true);


--
-- Name: event_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.event_id_seq', 5, true);


--
-- Name: news_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.news_id_seq', 6, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 47, true);


--
-- Name: club club_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.club
    ADD CONSTRAINT club_pkey PRIMARY KEY (id);


--
-- Name: event event_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.event
    ADD CONSTRAINT event_pkey PRIMARY KEY (id);


--
-- Name: news news_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.news
    ADD CONSTRAINT news_pkey PRIMARY KEY (id);


--
-- Name: users_clubs_mapping users_clubs_mapping_userId_clubId_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_clubs_mapping
    ADD CONSTRAINT "users_clubs_mapping_userId_clubId_key" UNIQUE ("userId", "clubId");


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: users users_username_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_username_key UNIQUE (username);


--
-- Name: users_clubs_mapping users_clubs_mapping_clubId_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_clubs_mapping
    ADD CONSTRAINT "users_clubs_mapping_clubId_fkey" FOREIGN KEY ("clubId") REFERENCES public.club(id);


--
-- Name: users_clubs_mapping users_clubs_mapping_userId_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_clubs_mapping
    ADD CONSTRAINT "users_clubs_mapping_userId_fkey" FOREIGN KEY ("userId") REFERENCES public.users(id);


--
-- PostgreSQL database dump complete
--

