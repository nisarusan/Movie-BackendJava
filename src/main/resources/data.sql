
-- TOC entry 215 (class 1259 OID 93377)
-- Name: authorities; Type: TABLE; Schema: public; Owner: postgres


CREATE TABLE public.authorities (
    authority character varying(255) NOT NULL,
    username character varying(255) NOT NULL
);


ALTER TABLE public.authorities OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 93385)
-- Name: genres; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.genres (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.genres OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 93384)
-- Name: genres_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.genres_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.genres_id_seq OWNER TO postgres;

--
-- TOC entry 3711 (class 0 OID 0)
-- Dependencies: 216
-- Name: genres_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.genres_id_seq OWNED BY public.genres.id;


--
-- TOC entry 218 (class 1259 OID 93391)
-- Name: movie; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.movie (
    id bigint NOT NULL,
    description oid,
    director character varying(255),
    duration integer,
    image_url character varying(255),
    release_date date,
    title character varying(255)
);


ALTER TABLE public.movie OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 93398)
-- Name: movie_genres; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.movie_genres (
    movie_id bigint NOT NULL,
    genre_id bigint NOT NULL
);


ALTER TABLE public.movie_genres OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 93403)
-- Name: movie_ratings; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.movie_ratings (
    movie_id bigint NOT NULL,
    ratings_id bigint NOT NULL
);


ALTER TABLE public.movie_ratings OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 93447)
-- Name: movie_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.movie_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.movie_seq OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 93409)
-- Name: rating; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rating (
    id bigint NOT NULL,
    rating double precision,
    movie_id bigint,
    user_username character varying(255)
);


ALTER TABLE public.rating OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 93408)
-- Name: rating_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.rating_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.rating_id_seq OWNER TO postgres;

--
-- TOC entry 3712 (class 0 OID 0)
-- Dependencies: 221
-- Name: rating_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.rating_id_seq OWNED BY public.rating.id;


--
-- TOC entry 223 (class 1259 OID 93415)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    username character varying(255) NOT NULL,
    address character varying(255),
    apikey character varying(255),
    email character varying(255),
    enabled boolean NOT NULL,
    password character varying(255) NOT NULL,
    profile_url character varying(255)
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 93422)
-- Name: users_favorite_movie; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users_favorite_movie (
    user_username character varying(255) NOT NULL,
    favorite_movie_id bigint NOT NULL
);


ALTER TABLE public.users_favorite_movie OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 93427)
-- Name: users_movies_rated; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users_movies_rated (
    user_username character varying(255) NOT NULL,
    movies_rated_id bigint NOT NULL
);


ALTER TABLE public.users_movies_rated OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 93432)
-- Name: users_movies_seen; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users_movies_seen (
    user_username character varying(255) NOT NULL,
    movies_seen_id bigint NOT NULL
);


ALTER TABLE public.users_movies_seen OWNER TO postgres;

--
-- TOC entry 3481 (class 2604 OID 93388)
-- Name: genres id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genres ALTER COLUMN id SET DEFAULT nextval('public.genres_id_seq'::regclass);


--
-- TOC entry 3482 (class 2604 OID 93412)
-- Name: rating id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rating ALTER COLUMN id SET DEFAULT nextval('public.rating_id_seq'::regclass);


--
-- TOC entry 3700 (class 2613 OID 101196)
-- Name: 101196; Type: BLOB; Schema: -; Owner: postgres
--

SELECT pg_catalog.lo_create('101196');


ALTER LARGE OBJECT 101196 OWNER TO postgres;

--
-- TOC entry 3701 (class 2613 OID 101197)
-- Name: 101197; Type: BLOB; Schema: -; Owner: postgres
--

SELECT pg_catalog.lo_create('101197');


ALTER LARGE OBJECT 101197 OWNER TO postgres;

--
-- TOC entry 3702 (class 2613 OID 101198)
-- Name: 101198; Type: BLOB; Schema: -; Owner: postgres
--

SELECT pg_catalog.lo_create('101198');


ALTER LARGE OBJECT 101198 OWNER TO postgres;

--
-- TOC entry 3703 (class 2613 OID 101199)
-- Name: 101199; Type: BLOB; Schema: -; Owner: postgres
--

SELECT pg_catalog.lo_create('101199');


ALTER LARGE OBJECT 101199 OWNER TO postgres;

--
-- TOC entry 3704 (class 2613 OID 101200)
-- Name: 101200; Type: BLOB; Schema: -; Owner: postgres
--

SELECT pg_catalog.lo_create('101200');


ALTER LARGE OBJECT 101200 OWNER TO postgres;

--
-- TOC entry 3681 (class 2613 OID 93370)
-- Name: 93370; Type: BLOB; Schema: -; Owner: postgres
--

SELECT pg_catalog.lo_create('93370');


ALTER LARGE OBJECT 93370 OWNER TO postgres;

--
-- TOC entry 3682 (class 2613 OID 93372)
-- Name: 93372; Type: BLOB; Schema: -; Owner: postgres
--

SELECT pg_catalog.lo_create('93372');


ALTER LARGE OBJECT 93372 OWNER TO postgres;

--
-- TOC entry 3683 (class 2613 OID 93373)
-- Name: 93373; Type: BLOB; Schema: -; Owner: postgres
--

SELECT pg_catalog.lo_create('93373');


ALTER LARGE OBJECT 93373 OWNER TO postgres;

--
-- TOC entry 3684 (class 2613 OID 93374)
-- Name: 93374; Type: BLOB; Schema: -; Owner: postgres
--

SELECT pg_catalog.lo_create('93374');


ALTER LARGE OBJECT 93374 OWNER TO postgres;

--
-- TOC entry 3685 (class 2613 OID 93375)
-- Name: 93375; Type: BLOB; Schema: -; Owner: postgres
--

SELECT pg_catalog.lo_create('93375');


ALTER LARGE OBJECT 93375 OWNER TO postgres;

--
-- TOC entry 3686 (class 2613 OID 93376)
-- Name: 93376; Type: BLOB; Schema: -; Owner: postgres
--

SELECT pg_catalog.lo_create('93376');


ALTER LARGE OBJECT 93376 OWNER TO postgres;

--
-- TOC entry 3687 (class 2613 OID 93508)
-- Name: 93508; Type: BLOB; Schema: -; Owner: postgres
--

SELECT pg_catalog.lo_create('93508');


ALTER LARGE OBJECT 93508 OWNER TO postgres;

--
-- TOC entry 3688 (class 2613 OID 93509)
-- Name: 93509; Type: BLOB; Schema: -; Owner: postgres
--

SELECT pg_catalog.lo_create('93509');


ALTER LARGE OBJECT 93509 OWNER TO postgres;

--
-- TOC entry 3689 (class 2613 OID 93510)
-- Name: 93510; Type: BLOB; Schema: -; Owner: postgres
--

SELECT pg_catalog.lo_create('93510');


ALTER LARGE OBJECT 93510 OWNER TO postgres;

--
-- TOC entry 3690 (class 2613 OID 93511)
-- Name: 93511; Type: BLOB; Schema: -; Owner: postgres
--

SELECT pg_catalog.lo_create('93511');


ALTER LARGE OBJECT 93511 OWNER TO postgres;

--
-- TOC entry 3691 (class 2613 OID 93512)
-- Name: 93512; Type: BLOB; Schema: -; Owner: postgres
--

SELECT pg_catalog.lo_create('93512');


ALTER LARGE OBJECT 93512 OWNER TO postgres;

--
-- TOC entry 3692 (class 2613 OID 93513)
-- Name: 93513; Type: BLOB; Schema: -; Owner: postgres
--

SELECT pg_catalog.lo_create('93513');


ALTER LARGE OBJECT 93513 OWNER TO postgres;

--
-- TOC entry 3693 (class 2613 OID 93514)
-- Name: 93514; Type: BLOB; Schema: -; Owner: postgres
--

SELECT pg_catalog.lo_create('93514');


ALTER LARGE OBJECT 93514 OWNER TO postgres;

--
-- TOC entry 3694 (class 2613 OID 93515)
-- Name: 93515; Type: BLOB; Schema: -; Owner: postgres
--

SELECT pg_catalog.lo_create('93515');


ALTER LARGE OBJECT 93515 OWNER TO postgres;

--
-- TOC entry 3695 (class 2613 OID 93516)
-- Name: 93516; Type: BLOB; Schema: -; Owner: postgres
--

SELECT pg_catalog.lo_create('93516');


ALTER LARGE OBJECT 93516 OWNER TO postgres;

--
-- TOC entry 3696 (class 2613 OID 93517)
-- Name: 93517; Type: BLOB; Schema: -; Owner: postgres
--

SELECT pg_catalog.lo_create('93517');


ALTER LARGE OBJECT 93517 OWNER TO postgres;

--
-- TOC entry 3697 (class 2613 OID 93518)
-- Name: 93518; Type: BLOB; Schema: -; Owner: postgres
--

SELECT pg_catalog.lo_create('93518');


ALTER LARGE OBJECT 93518 OWNER TO postgres;

--
-- TOC entry 3698 (class 2613 OID 93519)
-- Name: 93519; Type: BLOB; Schema: -; Owner: postgres
--

SELECT pg_catalog.lo_create('93519');


ALTER LARGE OBJECT 93519 OWNER TO postgres;

--
-- TOC entry 3699 (class 2613 OID 93520)
-- Name: 93520; Type: BLOB; Schema: -; Owner: postgres
--

SELECT pg_catalog.lo_create('93520');


ALTER LARGE OBJECT 93520 OWNER TO postgres;

--
-- TOC entry 3668 (class 0 OID 93377)
-- Dependencies: 215
-- Data for Name: authorities; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.authorities (authority, username) FROM stdin;
\.


--
-- TOC entry 3670 (class 0 OID 93385)
-- Dependencies: 217
-- Data for Name: genres; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.genres (id, name) FROM stdin;
\.


--
-- TOC entry 3671 (class 0 OID 93391)
-- Dependencies: 218
-- Data for Name: movie; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.movie (id, description, director, duration, image_url, release_date, title) FROM stdin;
1	93508	Steve Job	90	kCGlIMHnOm8JPXq3rXM6c5wMxcT.jpg	1990-01-01	Poor Things
52	93512	Steve Job	90	qhb1qOilapbapxWQn9jtRCMwXJF.jpg	1990-01-01	Wonka
53	93513	Steve Job	90	ptpr0kGAckfQkJeJIt8st5dglvd.jpg	1990-01-01	Oppenheimer
54	93514	Steve Job	90	nfs7DCYhgrEIgxKYbITHTzKsggf.jpg	1990-01-01	The Iron Claw
55	93515	Steve Job	90	ldfCF9RhR40mppkzmftxapaHeTo.jpg	1990-01-01	Migration
56	93516	Steve Job	90	fbbj3viSUDEGT1fFFMNpHP1iUjw.jpg	1990-01-01	Mean Girls
57	93517	Steve Job	90	bIeEMMvfzgbMBtYaEWtxrFnt6Vo.jpg	1990-01-01	Land of Bad
58	93518	Steve Job	90	mBaXZ95R2OxueZhvQbcEWy2DqyO.jpg	2024-01-25	The Hunger Games: The Ballad of Songbirds & Snakes
59	93519	Steve Job	90	57MFWGHarg9jid7yfDTka4RmcMU.jpg	2024-01-25	American Fiction
60	93520	Steve Job	90	siduVKgOnABO4WH4lOwPQwaGwJp.jpg	2024-01-25	Argylle
102	101196	Steve Job	120	yRt7MGBElkLQOYRvLTT1b3B1rcp.jpg	2023-01-25	Anyone But You
103	101197	Steve Job	120	v9nGSRx5lFz6KEgfmgHJMSgaARC.jpg	2023-01-25	Binnelanders
104	101198	Steve Job	120	3bhkrj58Vtu7enYsRolD1fZdja1.jpg	2023-01-25	The Godfather
105	101199	Steve Job	120	rCzpDGLbOoPwLjy3OAm5NUPOTrC.jpg	2009-01-01	The Lord of the Rings: The Return of the King
106	101200	Steve Job	120	lzZpWEaqzP0qVA5nkCc5ASbNcSy.jpg	2024-01-01	Avatar: The Last Airbender
\.


--
-- TOC entry 3672 (class 0 OID 93398)
-- Dependencies: 219
-- Data for Name: movie_genres; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.movie_genres (movie_id, genre_id) FROM stdin;
\.


--
-- TOC entry 3673 (class 0 OID 93403)
-- Dependencies: 220
-- Data for Name: movie_ratings; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.movie_ratings (movie_id, ratings_id) FROM stdin;
\.


--
-- TOC entry 3675 (class 0 OID 93409)
-- Dependencies: 222
-- Data for Name: rating; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.rating (id, rating, movie_id, user_username) FROM stdin;
\.


--
-- TOC entry 3676 (class 0 OID 93415)
-- Dependencies: 223
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (username, address, apikey, email, enabled, password, profile_url) FROM stdin;
\.


--
-- TOC entry 3677 (class 0 OID 93422)
-- Dependencies: 224
-- Data for Name: users_favorite_movie; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users_favorite_movie (user_username, favorite_movie_id) FROM stdin;
\.


--
-- TOC entry 3678 (class 0 OID 93427)
-- Dependencies: 225
-- Data for Name: users_movies_rated; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users_movies_rated (user_username, movies_rated_id) FROM stdin;
\.


--
-- TOC entry 3679 (class 0 OID 93432)
-- Dependencies: 226
-- Data for Name: users_movies_seen; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users_movies_seen (user_username, movies_seen_id) FROM stdin;
\.


--
-- TOC entry 3713 (class 0 OID 0)
-- Dependencies: 216
-- Name: genres_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.genres_id_seq', 1, false);


--
-- TOC entry 3714 (class 0 OID 0)
-- Dependencies: 227
-- Name: movie_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.movie_seq', 151, true);


--
-- TOC entry 3715 (class 0 OID 0)
-- Dependencies: 221
-- Name: rating_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.rating_id_seq', 1, false);


--
-- TOC entry 3705 (class 0 OID 0)
-- Data for Name: BLOBS; Type: BLOBS; Schema: -; Owner: -
--

BEGIN;

SELECT pg_catalog.lo_open('93370', 131072);
SELECT pg_catalog.lowrite(0, '\x466f6c6c6f7720746865206d7974686963206a6f75726e6579206f66205061756c20417472656964657320617320686520756e697465732077697468204368616e6920616e6420746865204672656d656e207768696c65206f6e20612070617468206f6620726576656e676520616761696e73742074686520636f6e7370697261746f72732077686f2064657374726f796564206869732066616d696c792e20466163696e6720612063686f696365206265747765656e20746865206c6f7665206f6620686973206c69666520616e64207468652066617465206f6620746865206b6e6f776e20756e6976657273652c205061756c20656e646561766f727320746f2070726576656e742061207465727269626c6520667574757265206f6e6c792068652063616e20666f72657365652e');
SELECT pg_catalog.lo_close(0);

SELECT pg_catalog.lo_open('93372', 131072);
SELECT pg_catalog.lowrite(0, '\x466f6c6c6f7720746865206d7974686963206a6f75726e6579206f66205061756c20417472656964657320617320686520756e697465732077697468204368616e6920616e6420746865204672656d656e207768696c65206f6e20612070617468206f6620726576656e676520616761696e73742074686520636f6e7370697261746f72732077686f2064657374726f796564206869732066616d696c792e20466163696e6720612063686f696365206265747765656e20746865206c6f7665206f6620686973206c69666520616e64207468652066617465206f6620746865206b6e6f776e20756e6976657273652c205061756c20656e646561766f727320746f2070726576656e742061207465727269626c6520667574757265206f6e6c792068652063616e20666f72657365652e');
SELECT pg_catalog.lo_close(0);

SELECT pg_catalog.lo_open('93373', 131072);
SELECT pg_catalog.lowrite(0, '\x5468652073746f7279206f66204a2e20526f62657274204f7070656e6865696d6572277320726f6c6520696e2074686520646576656c6f706d656e74206f66207468652061746f6d696320626f6d6220647572696e6720576f726c64205761722049492e');
SELECT pg_catalog.lo_close(0);

SELECT pg_catalog.lo_open('93374', 131072);
SELECT pg_catalog.lowrite(0, '\x54686520747275652073746f7279206f662074686520696e736570617261626c6520566f6e2045726963682062726f74686572732c2077686f206d61646520686973746f727920696e2074686520696e74656e73656c7920636f6d706574697469766520776f726c64206f662070726f66657373696f6e616c2077726573746c696e6720696e20746865206561726c792031393830732e205468726f756768207472616765647920616e6420747269756d70682c20756e6465722074686520736861646f77206f6620746865697220646f6d696e656572696e672066617468657220616e6420636f6163682c207468652062726f7468657273207365656b206c61726765722d7468616e2d6c69666520696d6d6f7274616c697479206f6e20746865206269676765737420737461676520696e2073706f7274732e');
SELECT pg_catalog.lo_close(0);

SELECT pg_catalog.lo_open('93375', 131072);
SELECT pg_catalog.lowrite(0, '\x41667465722061206d6967726174696e67206475636b2066616d696c7920616c6967687473206f6e20746865697220706f6e64207769746820746872696c6c696e672074616c6573206f66206661722d666c756e6720706c616365732c20746865204d616c6c6172642066616d696c7920656d6261726b73206f6e20612066616d696c7920726f616420747269702c2066726f6d204e657720456e676c616e642c20746f204e657720596f726b20436974792c20746f2074726f706963616c204a616d616963612e');
SELECT pg_catalog.lo_close(0);

SELECT pg_catalog.lo_open('93376', 131072);
SELECT pg_catalog.lowrite(0, '\x42726f75676874206261636b20746f206c69666520627920616e20756e6f7274686f646f7820736369656e746973742c206120796f756e6720776f6d616e2072756e73206f66662077697468206120646562617563686564206c6177796572206f6e206120776869726c77696e6420616476656e74757265206163726f73732074686520636f6e74696e656e74732e20467265652066726f6d20746865207072656a756469636573206f66206865722074696d65732c207368652067726f77732073746561646661737420696e2068657220707572706f736520746f207374616e6420666f7220657175616c69747920616e64206c696265726174696f6e');
SELECT pg_catalog.lo_close(0);

SELECT pg_catalog.lo_open('93508', 131072);
SELECT pg_catalog.lowrite(0, '\x42726f75676874206261636b20746f206c69666520627920616e20756e6f7274686f646f7820736369656e746973742c206120796f756e6720776f6d616e2072756e73206f66662077697468206120646562617563686564206c6177796572206f6e206120776869726c77696e6420616476656e74757265206163726f73732074686520636f6e74696e656e74732e20467265652066726f6d20746865207072656a756469636573206f66206865722074696d65732c207368652067726f77732073746561646661737420696e2068657220707572706f736520746f207374616e6420666f7220657175616c69747920616e64206c696265726174696f6e');
SELECT pg_catalog.lo_close(0);

SELECT pg_catalog.lo_open('93509', 131072);
SELECT pg_catalog.lowrite(0, '\x42726f75676874206261636b20746f206c69666520627920616e20756e6f7274686f646f7820736369656e746973742c206120796f756e6720776f6d616e2072756e73206f66662077697468206120646562617563686564206c6177796572206f6e206120776869726c77696e6420616476656e74757265206163726f73732074686520636f6e74696e656e74732e20467265652066726f6d20746865207072656a756469636573206f66206865722074696d65732c207368652067726f77732073746561646661737420696e2068657220707572706f736520746f207374616e6420666f7220657175616c69747920616e64206c696265726174696f6e');
SELECT pg_catalog.lo_close(0);

SELECT pg_catalog.lo_open('93510', 131072);
SELECT pg_catalog.lowrite(0, '\x42726f75676874206261636b20746f206c69666520627920616e20756e6f7274686f646f7820736369656e746973742c206120796f756e6720776f6d616e2072756e73206f66662077697468206120646562617563686564206c6177796572206f6e206120776869726c77696e6420616476656e74757265206163726f73732074686520636f6e74696e656e74732e20467265652066726f6d20746865207072656a756469636573206f66206865722074696d65732c207368652067726f77732073746561646661737420696e2068657220707572706f736520746f207374616e6420666f7220657175616c69747920616e64206c696265726174696f6e');
SELECT pg_catalog.lo_close(0);

SELECT pg_catalog.lo_open('93511', 131072);
SELECT pg_catalog.lowrite(0, '\x42726f75676874206261636b20746f206c69666520627920616e20756e6f7274686f646f7820736369656e746973742c206120796f756e6720776f6d616e2072756e73206f66662077697468206120646562617563686564206c6177796572206f6e206120776869726c77696e6420616476656e74757265206163726f73732074686520636f6e74696e656e74732e20467265652066726f6d20746865207072656a756469636573206f66206865722074696d65732c207368652067726f77732073746561646661737420696e2068657220707572706f736520746f207374616e6420666f7220657175616c69747920616e64206c696265726174696f6e');
SELECT pg_catalog.lo_close(0);

SELECT pg_catalog.lo_open('93512', 131072);
SELECT pg_catalog.lowrite(0, '\x57696c6c7920576f6e6b6120e280932063686f636b2d66756c6c206f6620696465617320616e642064657465726d696e656420746f206368616e67652074686520776f726c64206f6e652064656c65637461626c65206269746520617420612074696d6520e280932069732070726f6f662074686174207468652062657374207468696e677320696e206c69666520626567696e2077697468206120647265616d2c20616e6420696620796f75e280997265206c75636b7920656e6f75676820746f206d6565742057696c6c7920576f6e6b612c20616e797468696e6720697320706f737369626c652e');
SELECT pg_catalog.lo_close(0);

SELECT pg_catalog.lo_open('93513', 131072);
SELECT pg_catalog.lowrite(0, '\x5468652073746f7279206f66204a2e20526f62657274204f7070656e6865696d6572277320726f6c6520696e2074686520646576656c6f706d656e74206f66207468652061746f6d696320626f6d6220647572696e6720576f726c64205761722049492e');
SELECT pg_catalog.lo_close(0);

SELECT pg_catalog.lo_open('93514', 131072);
SELECT pg_catalog.lowrite(0, '\x54686520747275652073746f7279206f662074686520696e736570617261626c6520566f6e2045726963682062726f74686572732c2077686f206d61646520686973746f727920696e2074686520696e74656e73656c7920636f6d706574697469766520776f726c64206f662070726f66657373696f6e616c2077726573746c696e6720696e20746865206561726c792031393830732e205468726f756768207472616765647920616e6420747269756d70682c20756e6465722074686520736861646f77206f6620746865697220646f6d696e656572696e672066617468657220616e6420636f6163682c207468652062726f7468657273207365656b206c61726765722d7468616e2d6c69666520696d6d6f7274616c697479206f6e20746865206269676765737420737461676520696e2073706f7274732e');
SELECT pg_catalog.lo_close(0);

SELECT pg_catalog.lo_open('93515', 131072);
SELECT pg_catalog.lowrite(0, '\x41667465722061206d6967726174696e67206475636b2066616d696c7920616c6967687473206f6e20746865697220706f6e64207769746820746872696c6c696e672074616c6573206f66206661722d666c756e6720706c616365732c20746865204d616c6c6172642066616d696c7920656d6261726b73206f6e20612066616d696c7920726f616420747269702c2066726f6d204e657720456e676c616e642c20746f204e657720596f726b20436974792c20746f2074726f706963616c204a616d616963612e');
SELECT pg_catalog.lo_close(0);

SELECT pg_catalog.lo_open('93516', 131072);
SELECT pg_catalog.lowrite(0, '\x4e65772073747564656e742043616479204865726f6e2069732077656c636f6d656420696e746f2074686520746f70206f662074686520736f6369616c20666f6f6420636861696e2062792074686520656c6974652067726f7570206f6620706f70756c6172206769726c732063616c6c656420e2809854686520506c6173746963732ce280992072756c65642062792074686520636f6e6e6976696e6720717565656e2062656520526567696e612047656f72676520616e6420686572206d696e696f6e7320477265746368656e20616e64204b6172656e2e20486f77657665722c207768656e2043616479206d616b657320746865206d616a6f72206d697373746570206f662066616c6c696e6720666f7220526567696e61e28099732065782d626f79667269656e64204161726f6e2053616d75656c732c207368652066696e64732068657273656c66207072657920696e20526567696e61e28099732063726f737368616972732e2041732043616479207365747320746f2074616b6520646f776e207468652067726f7570e28099732061706578207072656461746f722077697468207468652068656c70206f6620686572206f75746361737420667269656e6473204a616e697320616e642044616d69616e2c20736865206d757374206c6561726e20686f7720746f2073746179207472756520746f2068657273656c66207768696c65206e617669676174696e6720746865206d6f7374206375747468726f6174206a756e676c65206f6620616c6c3a2068696768207363686f6f6c2e2e');
SELECT pg_catalog.lo_close(0);

SELECT pg_catalog.lo_open('93517', 131072);
SELECT pg_catalog.lowrite(0, '\x5768656e20612044656c746120466f726365207370656369616c206f7073206d697373696f6e20676f6573207465727269626c792077726f6e672c2041697220466f7263652064726f6e652070696c6f74205265617065722068617320343820686f75727320746f2072656d656479207768617420686173206465766f6c76656420696e746f20612077696c6420726573637565206f7065726174696f6e2e2057697468206e6f20776561706f6e7320616e64206e6f20636f6d6d756e69636174696f6e206f74686572207468616e207468652064726f6e652061626f76652c207468652067726f756e64206d697373696f6e2073756464656e6c79206265636f6d657320612066756c6c2d7363616c6520626174746c65207768656e20746865207465616d20697320646973636f76657265642062792074686520656e656d792e');
SELECT pg_catalog.lo_close(0);

SELECT pg_catalog.lo_open('93518', 131072);
SELECT pg_catalog.lowrite(0, '\x3634207965617273206265666f7265206865206265636f6d65732074686520747972616e6e6963616c20707265736964656e74206f662050616e656d2c20436f72696f6c616e757320536e6f7720736565732061206368616e636520666f722061206368616e676520696e20666f7274756e6573207768656e206865206d656e746f7273204c75637920477261792042616972642c207468652066656d616c6520747269627574652066726f6d2044697374726963742031322e');
SELECT pg_catalog.lo_close(0);

SELECT pg_catalog.lo_open('93519', 131072);
SELECT pg_catalog.lowrite(0, '\x41206e6f76656c697374206665642075702077697468207468652065737461626c6973686d656e742070726f666974696e672066726f6d2022426c61636b2220656e7465727461696e6d656e74207573657320612070656e206e616d6520746f207772697465206120626f6f6b20746861742070726f70656c732068696d20696e746f20746865206865617274206f66206879706f637269737920616e6420746865206d61646e65737320686520636c61696d7320746f206469736461696e2e');
SELECT pg_catalog.lo_close(0);

SELECT pg_catalog.lo_open('93520', 131072);
SELECT pg_catalog.lowrite(0, '\x5768656e2074686520706c6f7473206f66207265636c757369766520617574686f7220456c6c7920436f6e77617927732066696374696f6e616c20657370696f6e616765206e6f76656c7320626567696e20746f206d6972726f722074686520636f7665727420616374696f6e73206f662061207265616c2d6c69666520737079206f7267616e697a6174696f6e2c207175696574206576656e696e677320617420686f6d65206265636f6d652061207468696e67206f662074686520706173742e204163636f6d70616e696564206279206865722063617420416c66696520616e6420416964656e2c2061206361742d616c6c6572676963207370792c20456c6c79207261636573206163726f73732074686520776f726c6420746f2073746179206f6e652073746570206168656164206f6620746865206b696c6c65727320617320746865206c696e65206265747765656e20436f6e77617927732066696374696f6e616c20776f726c6420616e6420686572207265616c206f6e6520626567696e7320746f20626c75722e');
SELECT pg_catalog.lo_close(0);

SELECT pg_catalog.lo_open('101196', 131072);
SELECT pg_catalog.lowrite(0, '\x416674657220616e20616d617a696e6720666972737420646174652c2042656120616e642042656ee28099732066696572792061747472616374696f6e207475726e732069636520636f6c6420e2809420756e74696c20746865792066696e64207468656d73656c76657320756e65787065637465646c79207265756e6974656420617420612064657374696e6174696f6e2077656464696e6720696e204175737472616c69612e20536f207468657920646f207768617420616e792074776f206d6174757265206164756c747320776f756c6420646f3a2070726574656e6420746f206265206120636f75706c65');
SELECT pg_catalog.lo_close(0);

SELECT pg_catalog.lo_open('101197', 131072);
SELECT pg_catalog.lowrite(0, '\x4120536f757468204166726963616e20416672696b61616e7320736f6170206f706572612e2049742069732073657420696e20616e642061726f756e64207468652066696374696f6e616c207072697661746520686f73706974616c2c2042696e6e656c616e64204b6c696e69656b2c20696e20507265746f7269612c20616e64207468652073746f72796c696e6520666f6c6c6f77732074686520747269616c732c20747261756d6120616e642074726962756c6174696f6e73206f662074686520737461666620616e642070617469656e7473206f662074686520686f73706974616c2e');
SELECT pg_catalog.lo_close(0);

SELECT pg_catalog.lo_open('101198', 131072);
SELECT pg_catalog.lowrite(0, '\x5370616e6e696e6720746865207965617273203139343520746f20313935352c2061206368726f6e69636c65206f66207468652066696374696f6e616c204974616c69616e2d416d65726963616e20436f726c656f6e65206372696d652066616d696c792e205768656e206f7267616e697a6564206372696d652066616d696c79207061747269617263682c205669746f20436f726c656f6e6520626172656c7920737572766976657320616e20617474656d7074206f6e20686973206c6966652c2068697320796f756e6765737420736f6e2c204d69636861656c20737465707320696e20746f2074616b652063617265206f662074686520776f756c642d6265206b696c6c6572732c206c61756e6368696e6720612063616d706169676e206f6620626c6f6f647920726576656e67652e');
SELECT pg_catalog.lo_close(0);

SELECT pg_catalog.lo_open('101199', 131072);
SELECT pg_catalog.lowrite(0, '\x417261676f726e2069732072657665616c656420617320746865206865697220746f2074686520616e6369656e74206b696e67732061732068652c2047616e64616c6620616e6420746865206f74686572206d656d62657273206f66207468652062726f6b656e2066656c6c6f7773686970207374727567676c6520746f207361766520476f6e646f722066726f6d20536175726f6e277320666f726365732e204d65616e7768696c652c2046726f646f20616e642053616d2074616b65207468652072696e6720636c6f73657220746f20746865206865617274206f66204d6f72646f722c20746865206461726b206c6f72642773207265616c6d2e');
SELECT pg_catalog.lo_close(0);

SELECT pg_catalog.lo_open('101200', 131072);
SELECT pg_catalog.lowrite(0, '\x4120796f756e6720626f79206b6e6f776e2061732074686520417661746172206d757374206d61737465722074686520666f757220656c656d656e74616c20706f7765727320746f2073617665206120776f726c642061742077617220e2809420616e64206669676874206120727574686c65737320656e656d792062656e74206f6e2073746f7070696e672068696d2e');
SELECT pg_catalog.lo_close(0);

COMMIT;

--
-- TOC entry 3484 (class 2606 OID 93383)
-- Name: authorities authorities_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.authorities
    ADD CONSTRAINT authorities_pkey PRIMARY KEY (authority, username);


--
-- TOC entry 3486 (class 2606 OID 93390)
-- Name: genres genres_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genres
    ADD CONSTRAINT genres_pkey PRIMARY KEY (id);


--
-- TOC entry 3492 (class 2606 OID 93402)
-- Name: movie_genres movie_genres_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movie_genres
    ADD CONSTRAINT movie_genres_pkey PRIMARY KEY (movie_id, genre_id);


--
-- TOC entry 3490 (class 2606 OID 93397)
-- Name: movie movie_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movie
    ADD CONSTRAINT movie_pkey PRIMARY KEY (id);


--
-- TOC entry 3494 (class 2606 OID 93407)
-- Name: movie_ratings movie_ratings_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movie_ratings
    ADD CONSTRAINT movie_ratings_pkey PRIMARY KEY (movie_id, ratings_id);


--
-- TOC entry 3498 (class 2606 OID 93414)
-- Name: rating rating_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rating
    ADD CONSTRAINT rating_pkey PRIMARY KEY (id);


--
-- TOC entry 3496 (class 2606 OID 93440)
-- Name: movie_ratings uk_1hdjkycv2u1f0oyhgtmktv3l; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movie_ratings
    ADD CONSTRAINT uk_1hdjkycv2u1f0oyhgtmktv3l UNIQUE (ratings_id);


--
-- TOC entry 3510 (class 2606 OID 93446)
-- Name: users_movies_seen uk_3edntdo3db1gmg0smv0uwlnj8; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_movies_seen
    ADD CONSTRAINT uk_3edntdo3db1gmg0smv0uwlnj8 UNIQUE (movies_seen_id);


--
-- TOC entry 3506 (class 2606 OID 93444)
-- Name: users_movies_rated uk_a5ru6mrjg5vprlt5atftax0mx; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_movies_rated
    ADD CONSTRAINT uk_a5ru6mrjg5vprlt5atftax0mx UNIQUE (movies_rated_id);


--
-- TOC entry 3502 (class 2606 OID 93442)
-- Name: users_favorite_movie uk_dtscldnygsiab1ijfjqj44lsj; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_favorite_movie
    ADD CONSTRAINT uk_dtscldnygsiab1ijfjqj44lsj UNIQUE (favorite_movie_id);


--
-- TOC entry 3488 (class 2606 OID 93438)
-- Name: genres uk_pe1a9woik1k97l87cieguyhh4; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genres
    ADD CONSTRAINT uk_pe1a9woik1k97l87cieguyhh4 UNIQUE (name);


--
-- TOC entry 3504 (class 2606 OID 93426)
-- Name: users_favorite_movie users_favorite_movie_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_favorite_movie
    ADD CONSTRAINT users_favorite_movie_pkey PRIMARY KEY (user_username, favorite_movie_id);


--
-- TOC entry 3508 (class 2606 OID 93431)
-- Name: users_movies_rated users_movies_rated_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_movies_rated
    ADD CONSTRAINT users_movies_rated_pkey PRIMARY KEY (user_username, movies_rated_id);


--
-- TOC entry 3512 (class 2606 OID 93436)
-- Name: users_movies_seen users_movies_seen_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_movies_seen
    ADD CONSTRAINT users_movies_seen_pkey PRIMARY KEY (user_username, movies_seen_id);


--
-- TOC entry 3500 (class 2606 OID 93421)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (username);


--
-- TOC entry 3517 (class 2606 OID 93473)
-- Name: rating fk1rmll6orhvtv0u65y0xhalcgd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rating
    ADD CONSTRAINT fk1rmll6orhvtv0u65y0xhalcgd FOREIGN KEY (user_username) REFERENCES public.users(username);


--
-- TOC entry 3523 (class 2606 OID 93503)
-- Name: users_movies_seen fk231u9ve9qe4a7plv96fh1g3n2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_movies_seen
    ADD CONSTRAINT fk231u9ve9qe4a7plv96fh1g3n2 FOREIGN KEY (user_username) REFERENCES public.users(username);


--
-- TOC entry 3519 (class 2606 OID 93478)
-- Name: users_favorite_movie fk29dykslcd5hh7st89769sk1p4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_favorite_movie
    ADD CONSTRAINT fk29dykslcd5hh7st89769sk1p4 FOREIGN KEY (favorite_movie_id) REFERENCES public.movie(id);


--
-- TOC entry 3524 (class 2606 OID 93498)
-- Name: users_movies_seen fk3p8wtt5oec92swyfj8m3rxosr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_movies_seen
    ADD CONSTRAINT fk3p8wtt5oec92swyfj8m3rxosr FOREIGN KEY (movies_seen_id) REFERENCES public.movie(id);


--
-- TOC entry 3521 (class 2606 OID 93493)
-- Name: users_movies_rated fk6i7hmiumsfe6v9b7fx7v5nsw6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_movies_rated
    ADD CONSTRAINT fk6i7hmiumsfe6v9b7fx7v5nsw6 FOREIGN KEY (user_username) REFERENCES public.users(username);


--
-- TOC entry 3515 (class 2606 OID 93458)
-- Name: movie_ratings fka48i0qff0dkvj72yj9spiquyn; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movie_ratings
    ADD CONSTRAINT fka48i0qff0dkvj72yj9spiquyn FOREIGN KEY (ratings_id) REFERENCES public.rating(id);


--
-- TOC entry 3522 (class 2606 OID 93488)
-- Name: users_movies_rated fkex45to3k9qrvdlh612kndenc0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_movies_rated
    ADD CONSTRAINT fkex45to3k9qrvdlh612kndenc0 FOREIGN KEY (movies_rated_id) REFERENCES public.movie(id);


--
-- TOC entry 3516 (class 2606 OID 93463)
-- Name: movie_ratings fkky2b7201ypwxqp3p67int4gkc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movie_ratings
    ADD CONSTRAINT fkky2b7201ypwxqp3p67int4gkc FOREIGN KEY (movie_id) REFERENCES public.movie(id);


--
-- TOC entry 3518 (class 2606 OID 93468)
-- Name: rating fklqsvmdlh3ep1boo7in23xe86y; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rating
    ADD CONSTRAINT fklqsvmdlh3ep1boo7in23xe86y FOREIGN KEY (movie_id) REFERENCES public.movie(id);


--
-- TOC entry 3520 (class 2606 OID 93483)
-- Name: users_favorite_movie fkn5hmj3v64y7r8hww7ukqgstv9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_favorite_movie
    ADD CONSTRAINT fkn5hmj3v64y7r8hww7ukqgstv9 FOREIGN KEY (user_username) REFERENCES public.users(username);


--
-- TOC entry 3513 (class 2606 OID 93448)
-- Name: movie_genres fknfpjuak0xiqpca3gjkwrixiig; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movie_genres
    ADD CONSTRAINT fknfpjuak0xiqpca3gjkwrixiig FOREIGN KEY (genre_id) REFERENCES public.genres(id);


--
-- TOC entry 3514 (class 2606 OID 93453)
-- Name: movie_genres fks2xl3sirbon75mjcongwhrbi3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movie_genres
    ADD CONSTRAINT fks2xl3sirbon75mjcongwhrbi3 FOREIGN KEY (movie_id) REFERENCES public.movie(id);


-- Completed on 2024-02-25 23:12:50 CET

--
-- PostgreSQL database dump complete
--

