PGDMP      (                |        
   movie-back    16.1    16.1 Y               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    79854 
   movie-back    DATABASE     n   CREATE DATABASE "movie-back" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'C';
    DROP DATABASE "movie-back";
                postgres    false            �            1259    101860    authorities    TABLE     �   CREATE TABLE public.authorities (
    authority character varying(255) NOT NULL,
    username character varying(255) NOT NULL
);
    DROP TABLE public.authorities;
       public         heap    postgres    false            �            1259    93385    genres    TABLE     X   CREATE TABLE public.genres (
    id bigint NOT NULL,
    name character varying(255)
);
    DROP TABLE public.genres;
       public         heap    postgres    false            �            1259    93384    genres_id_seq    SEQUENCE     v   CREATE SEQUENCE public.genres_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.genres_id_seq;
       public          postgres    false    216            �           0    0    genres_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.genres_id_seq OWNED BY public.genres.id;
          public          postgres    false    215            �            1259    93391    movie    TABLE     �   CREATE TABLE public.movie (
    id bigint NOT NULL,
    description character varying(255),
    director character varying(255),
    duration integer,
    image_url character varying(255),
    release_date date,
    title character varying(255)
);
    DROP TABLE public.movie;
       public         heap    postgres    false            �            1259    93398    movie_genres    TABLE     a   CREATE TABLE public.movie_genres (
    movie_id bigint NOT NULL,
    genre_id bigint NOT NULL
);
     DROP TABLE public.movie_genres;
       public         heap    postgres    false            �            1259    93403    movie_ratings    TABLE     d   CREATE TABLE public.movie_ratings (
    movie_id bigint NOT NULL,
    ratings_id bigint NOT NULL
);
 !   DROP TABLE public.movie_ratings;
       public         heap    postgres    false            �            1259    93447 	   movie_seq    SEQUENCE     s   CREATE SEQUENCE public.movie_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.movie_seq;
       public          postgres    false            �            1259    93409    rating    TABLE     �   CREATE TABLE public.rating (
    id bigint NOT NULL,
    rating double precision,
    movie_id bigint,
    user_username character varying(255)
);
    DROP TABLE public.rating;
       public         heap    postgres    false            �            1259    93408    rating_id_seq    SEQUENCE     v   CREATE SEQUENCE public.rating_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.rating_id_seq;
       public          postgres    false    221            �           0    0    rating_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.rating_id_seq OWNED BY public.rating.id;
          public          postgres    false    220            �            1259    93415    users    TABLE     )  CREATE TABLE public.users (
    username character varying(255) NOT NULL,
    address character varying(255),
    apikey character varying(255),
    email character varying(255),
    enabled boolean NOT NULL,
    password character varying(255) NOT NULL,
    profile_url character varying(255)
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    93422    users_favorite_movie    TABLE     �   CREATE TABLE public.users_favorite_movie (
    user_username character varying(255) NOT NULL,
    favorite_movie_id bigint NOT NULL
);
 (   DROP TABLE public.users_favorite_movie;
       public         heap    postgres    false            �            1259    93427    users_movies_rated    TABLE     �   CREATE TABLE public.users_movies_rated (
    user_username character varying(255) NOT NULL,
    movies_rated_id bigint NOT NULL
);
 &   DROP TABLE public.users_movies_rated;
       public         heap    postgres    false            �            1259    93432    users_movies_seen    TABLE     �   CREATE TABLE public.users_movies_seen (
    user_username character varying(255) NOT NULL,
    movies_seen_id bigint NOT NULL
);
 %   DROP TABLE public.users_movies_seen;
       public         heap    postgres    false            �           2604    93388 	   genres id    DEFAULT     f   ALTER TABLE ONLY public.genres ALTER COLUMN id SET DEFAULT nextval('public.genres_id_seq'::regclass);
 8   ALTER TABLE public.genres ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    215    216            �           2604    93412 	   rating id    DEFAULT     f   ALTER TABLE ONLY public.rating ALTER COLUMN id SET DEFAULT nextval('public.rating_id_seq'::regclass);
 8   ALTER TABLE public.rating ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    220    221    221            t           2613    101196    101196    BLOB     '   SELECT pg_catalog.lo_create('101196');
 '   SELECT pg_catalog.lo_unlink('101196');
                postgres    false            u           2613    101197    101197    BLOB     '   SELECT pg_catalog.lo_create('101197');
 '   SELECT pg_catalog.lo_unlink('101197');
                postgres    false            v           2613    101198    101198    BLOB     '   SELECT pg_catalog.lo_create('101198');
 '   SELECT pg_catalog.lo_unlink('101198');
                postgres    false            w           2613    101199    101199    BLOB     '   SELECT pg_catalog.lo_create('101199');
 '   SELECT pg_catalog.lo_unlink('101199');
                postgres    false            x           2613    101200    101200    BLOB     '   SELECT pg_catalog.lo_create('101200');
 '   SELECT pg_catalog.lo_unlink('101200');
                postgres    false            y           2613    101867    101867    BLOB     '   SELECT pg_catalog.lo_create('101867');
 '   SELECT pg_catalog.lo_unlink('101867');
                postgres    false            z           2613    101868    101868    BLOB     '   SELECT pg_catalog.lo_create('101868');
 '   SELECT pg_catalog.lo_unlink('101868');
                postgres    false            {           2613    110059    110059    BLOB     '   SELECT pg_catalog.lo_create('110059');
 '   SELECT pg_catalog.lo_unlink('110059');
                postgres    false            a           2613    93370    93370    BLOB     &   SELECT pg_catalog.lo_create('93370');
 &   SELECT pg_catalog.lo_unlink('93370');
                postgres    false            b           2613    93372    93372    BLOB     &   SELECT pg_catalog.lo_create('93372');
 &   SELECT pg_catalog.lo_unlink('93372');
                postgres    false            c           2613    93373    93373    BLOB     &   SELECT pg_catalog.lo_create('93373');
 &   SELECT pg_catalog.lo_unlink('93373');
                postgres    false            d           2613    93374    93374    BLOB     &   SELECT pg_catalog.lo_create('93374');
 &   SELECT pg_catalog.lo_unlink('93374');
                postgres    false            e           2613    93375    93375    BLOB     &   SELECT pg_catalog.lo_create('93375');
 &   SELECT pg_catalog.lo_unlink('93375');
                postgres    false            f           2613    93376    93376    BLOB     &   SELECT pg_catalog.lo_create('93376');
 &   SELECT pg_catalog.lo_unlink('93376');
                postgres    false            g           2613    93508    93508    BLOB     &   SELECT pg_catalog.lo_create('93508');
 &   SELECT pg_catalog.lo_unlink('93508');
                postgres    false            h           2613    93509    93509    BLOB     &   SELECT pg_catalog.lo_create('93509');
 &   SELECT pg_catalog.lo_unlink('93509');
                postgres    false            i           2613    93510    93510    BLOB     &   SELECT pg_catalog.lo_create('93510');
 &   SELECT pg_catalog.lo_unlink('93510');
                postgres    false            j           2613    93511    93511    BLOB     &   SELECT pg_catalog.lo_create('93511');
 &   SELECT pg_catalog.lo_unlink('93511');
                postgres    false            k           2613    93512    93512    BLOB     &   SELECT pg_catalog.lo_create('93512');
 &   SELECT pg_catalog.lo_unlink('93512');
                postgres    false            l           2613    93513    93513    BLOB     &   SELECT pg_catalog.lo_create('93513');
 &   SELECT pg_catalog.lo_unlink('93513');
                postgres    false            m           2613    93514    93514    BLOB     &   SELECT pg_catalog.lo_create('93514');
 &   SELECT pg_catalog.lo_unlink('93514');
                postgres    false            n           2613    93515    93515    BLOB     &   SELECT pg_catalog.lo_create('93515');
 &   SELECT pg_catalog.lo_unlink('93515');
                postgres    false            o           2613    93516    93516    BLOB     &   SELECT pg_catalog.lo_create('93516');
 &   SELECT pg_catalog.lo_unlink('93516');
                postgres    false            p           2613    93517    93517    BLOB     &   SELECT pg_catalog.lo_create('93517');
 &   SELECT pg_catalog.lo_unlink('93517');
                postgres    false            q           2613    93518    93518    BLOB     &   SELECT pg_catalog.lo_create('93518');
 &   SELECT pg_catalog.lo_unlink('93518');
                postgres    false            r           2613    93519    93519    BLOB     &   SELECT pg_catalog.lo_create('93519');
 &   SELECT pg_catalog.lo_unlink('93519');
                postgres    false            s           2613    93520    93520    BLOB     &   SELECT pg_catalog.lo_create('93520');
 &   SELECT pg_catalog.lo_unlink('93520');
                postgres    false            `          0    101860    authorities 
   TABLE DATA           :   COPY public.authorities (authority, username) FROM stdin;
    public          postgres    false    227   �_       U          0    93385    genres 
   TABLE DATA           *   COPY public.genres (id, name) FROM stdin;
    public          postgres    false    216   ;`       V          0    93391    movie 
   TABLE DATA           d   COPY public.movie (id, description, director, duration, image_url, release_date, title) FROM stdin;
    public          postgres    false    217   r`       W          0    93398    movie_genres 
   TABLE DATA           :   COPY public.movie_genres (movie_id, genre_id) FROM stdin;
    public          postgres    false    218   �c       X          0    93403    movie_ratings 
   TABLE DATA           =   COPY public.movie_ratings (movie_id, ratings_id) FROM stdin;
    public          postgres    false    219   �c       Z          0    93409    rating 
   TABLE DATA           E   COPY public.rating (id, rating, movie_id, user_username) FROM stdin;
    public          postgres    false    221   �c       [          0    93415    users 
   TABLE DATA           a   COPY public.users (username, address, apikey, email, enabled, password, profile_url) FROM stdin;
    public          postgres    false    222   �d       \          0    93422    users_favorite_movie 
   TABLE DATA           P   COPY public.users_favorite_movie (user_username, favorite_movie_id) FROM stdin;
    public          postgres    false    223   �f       ]          0    93427    users_movies_rated 
   TABLE DATA           L   COPY public.users_movies_rated (user_username, movies_rated_id) FROM stdin;
    public          postgres    false    224   �f       ^          0    93432    users_movies_seen 
   TABLE DATA           J   COPY public.users_movies_seen (user_username, movies_seen_id) FROM stdin;
    public          postgres    false    225   g       �           0    0    genres_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.genres_id_seq', 9, true);
          public          postgres    false    215            �           0    0 	   movie_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.movie_seq', 301, true);
          public          postgres    false    226            �           0    0    rating_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.rating_id_seq', 90, true);
          public          postgres    false    220            |          0    0    BLOBS    BLOBS                             false   .g       �           2606    101866    authorities authorities_pkey 
   CONSTRAINT     k   ALTER TABLE ONLY public.authorities
    ADD CONSTRAINT authorities_pkey PRIMARY KEY (authority, username);
 F   ALTER TABLE ONLY public.authorities DROP CONSTRAINT authorities_pkey;
       public            postgres    false    227    227            �           2606    93390    genres genres_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.genres
    ADD CONSTRAINT genres_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.genres DROP CONSTRAINT genres_pkey;
       public            postgres    false    216            �           2606    93402    movie_genres movie_genres_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.movie_genres
    ADD CONSTRAINT movie_genres_pkey PRIMARY KEY (movie_id, genre_id);
 H   ALTER TABLE ONLY public.movie_genres DROP CONSTRAINT movie_genres_pkey;
       public            postgres    false    218    218            �           2606    93397    movie movie_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.movie
    ADD CONSTRAINT movie_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.movie DROP CONSTRAINT movie_pkey;
       public            postgres    false    217            �           2606    93407     movie_ratings movie_ratings_pkey 
   CONSTRAINT     p   ALTER TABLE ONLY public.movie_ratings
    ADD CONSTRAINT movie_ratings_pkey PRIMARY KEY (movie_id, ratings_id);
 J   ALTER TABLE ONLY public.movie_ratings DROP CONSTRAINT movie_ratings_pkey;
       public            postgres    false    219    219            �           2606    93414    rating rating_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.rating
    ADD CONSTRAINT rating_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.rating DROP CONSTRAINT rating_pkey;
       public            postgres    false    221            �           2606    93440 )   movie_ratings uk_1hdjkycv2u1f0oyhgtmktv3l 
   CONSTRAINT     j   ALTER TABLE ONLY public.movie_ratings
    ADD CONSTRAINT uk_1hdjkycv2u1f0oyhgtmktv3l UNIQUE (ratings_id);
 S   ALTER TABLE ONLY public.movie_ratings DROP CONSTRAINT uk_1hdjkycv2u1f0oyhgtmktv3l;
       public            postgres    false    219            �           2606    93446 .   users_movies_seen uk_3edntdo3db1gmg0smv0uwlnj8 
   CONSTRAINT     s   ALTER TABLE ONLY public.users_movies_seen
    ADD CONSTRAINT uk_3edntdo3db1gmg0smv0uwlnj8 UNIQUE (movies_seen_id);
 X   ALTER TABLE ONLY public.users_movies_seen DROP CONSTRAINT uk_3edntdo3db1gmg0smv0uwlnj8;
       public            postgres    false    225            �           2606    93444 /   users_movies_rated uk_a5ru6mrjg5vprlt5atftax0mx 
   CONSTRAINT     u   ALTER TABLE ONLY public.users_movies_rated
    ADD CONSTRAINT uk_a5ru6mrjg5vprlt5atftax0mx UNIQUE (movies_rated_id);
 Y   ALTER TABLE ONLY public.users_movies_rated DROP CONSTRAINT uk_a5ru6mrjg5vprlt5atftax0mx;
       public            postgres    false    224            �           2606    93442 1   users_favorite_movie uk_dtscldnygsiab1ijfjqj44lsj 
   CONSTRAINT     y   ALTER TABLE ONLY public.users_favorite_movie
    ADD CONSTRAINT uk_dtscldnygsiab1ijfjqj44lsj UNIQUE (favorite_movie_id);
 [   ALTER TABLE ONLY public.users_favorite_movie DROP CONSTRAINT uk_dtscldnygsiab1ijfjqj44lsj;
       public            postgres    false    223            �           2606    93438 #   genres uk_pe1a9woik1k97l87cieguyhh4 
   CONSTRAINT     ^   ALTER TABLE ONLY public.genres
    ADD CONSTRAINT uk_pe1a9woik1k97l87cieguyhh4 UNIQUE (name);
 M   ALTER TABLE ONLY public.genres DROP CONSTRAINT uk_pe1a9woik1k97l87cieguyhh4;
       public            postgres    false    216            �           2606    93426 .   users_favorite_movie users_favorite_movie_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.users_favorite_movie
    ADD CONSTRAINT users_favorite_movie_pkey PRIMARY KEY (user_username, favorite_movie_id);
 X   ALTER TABLE ONLY public.users_favorite_movie DROP CONSTRAINT users_favorite_movie_pkey;
       public            postgres    false    223    223            �           2606    93431 *   users_movies_rated users_movies_rated_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.users_movies_rated
    ADD CONSTRAINT users_movies_rated_pkey PRIMARY KEY (user_username, movies_rated_id);
 T   ALTER TABLE ONLY public.users_movies_rated DROP CONSTRAINT users_movies_rated_pkey;
       public            postgres    false    224    224            �           2606    93436 (   users_movies_seen users_movies_seen_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.users_movies_seen
    ADD CONSTRAINT users_movies_seen_pkey PRIMARY KEY (user_username, movies_seen_id);
 R   ALTER TABLE ONLY public.users_movies_seen DROP CONSTRAINT users_movies_seen_pkey;
       public            postgres    false    225    225            �           2606    93421    users users_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (username);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    222            �           2606    93473 "   rating fk1rmll6orhvtv0u65y0xhalcgd    FK CONSTRAINT     �   ALTER TABLE ONLY public.rating
    ADD CONSTRAINT fk1rmll6orhvtv0u65y0xhalcgd FOREIGN KEY (user_username) REFERENCES public.users(username);
 L   ALTER TABLE ONLY public.rating DROP CONSTRAINT fk1rmll6orhvtv0u65y0xhalcgd;
       public          postgres    false    221    222    3498            �           2606    93503 -   users_movies_seen fk231u9ve9qe4a7plv96fh1g3n2    FK CONSTRAINT     �   ALTER TABLE ONLY public.users_movies_seen
    ADD CONSTRAINT fk231u9ve9qe4a7plv96fh1g3n2 FOREIGN KEY (user_username) REFERENCES public.users(username);
 W   ALTER TABLE ONLY public.users_movies_seen DROP CONSTRAINT fk231u9ve9qe4a7plv96fh1g3n2;
       public          postgres    false    225    3498    222            �           2606    93478 0   users_favorite_movie fk29dykslcd5hh7st89769sk1p4    FK CONSTRAINT     �   ALTER TABLE ONLY public.users_favorite_movie
    ADD CONSTRAINT fk29dykslcd5hh7st89769sk1p4 FOREIGN KEY (favorite_movie_id) REFERENCES public.movie(id);
 Z   ALTER TABLE ONLY public.users_favorite_movie DROP CONSTRAINT fk29dykslcd5hh7st89769sk1p4;
       public          postgres    false    217    3488    223            �           2606    93498 -   users_movies_seen fk3p8wtt5oec92swyfj8m3rxosr    FK CONSTRAINT     �   ALTER TABLE ONLY public.users_movies_seen
    ADD CONSTRAINT fk3p8wtt5oec92swyfj8m3rxosr FOREIGN KEY (movies_seen_id) REFERENCES public.movie(id);
 W   ALTER TABLE ONLY public.users_movies_seen DROP CONSTRAINT fk3p8wtt5oec92swyfj8m3rxosr;
       public          postgres    false    3488    225    217            �           2606    93493 .   users_movies_rated fk6i7hmiumsfe6v9b7fx7v5nsw6    FK CONSTRAINT     �   ALTER TABLE ONLY public.users_movies_rated
    ADD CONSTRAINT fk6i7hmiumsfe6v9b7fx7v5nsw6 FOREIGN KEY (user_username) REFERENCES public.users(username);
 X   ALTER TABLE ONLY public.users_movies_rated DROP CONSTRAINT fk6i7hmiumsfe6v9b7fx7v5nsw6;
       public          postgres    false    3498    224    222            �           2606    93458 )   movie_ratings fka48i0qff0dkvj72yj9spiquyn    FK CONSTRAINT     �   ALTER TABLE ONLY public.movie_ratings
    ADD CONSTRAINT fka48i0qff0dkvj72yj9spiquyn FOREIGN KEY (ratings_id) REFERENCES public.rating(id);
 S   ALTER TABLE ONLY public.movie_ratings DROP CONSTRAINT fka48i0qff0dkvj72yj9spiquyn;
       public          postgres    false    3496    219    221            �           2606    93488 .   users_movies_rated fkex45to3k9qrvdlh612kndenc0    FK CONSTRAINT     �   ALTER TABLE ONLY public.users_movies_rated
    ADD CONSTRAINT fkex45to3k9qrvdlh612kndenc0 FOREIGN KEY (movies_rated_id) REFERENCES public.movie(id);
 X   ALTER TABLE ONLY public.users_movies_rated DROP CONSTRAINT fkex45to3k9qrvdlh612kndenc0;
       public          postgres    false    3488    217    224            �           2606    93463 )   movie_ratings fkky2b7201ypwxqp3p67int4gkc    FK CONSTRAINT     �   ALTER TABLE ONLY public.movie_ratings
    ADD CONSTRAINT fkky2b7201ypwxqp3p67int4gkc FOREIGN KEY (movie_id) REFERENCES public.movie(id);
 S   ALTER TABLE ONLY public.movie_ratings DROP CONSTRAINT fkky2b7201ypwxqp3p67int4gkc;
       public          postgres    false    3488    217    219            �           2606    93468 "   rating fklqsvmdlh3ep1boo7in23xe86y    FK CONSTRAINT     �   ALTER TABLE ONLY public.rating
    ADD CONSTRAINT fklqsvmdlh3ep1boo7in23xe86y FOREIGN KEY (movie_id) REFERENCES public.movie(id);
 L   ALTER TABLE ONLY public.rating DROP CONSTRAINT fklqsvmdlh3ep1boo7in23xe86y;
       public          postgres    false    221    217    3488            �           2606    93483 0   users_favorite_movie fkn5hmj3v64y7r8hww7ukqgstv9    FK CONSTRAINT     �   ALTER TABLE ONLY public.users_favorite_movie
    ADD CONSTRAINT fkn5hmj3v64y7r8hww7ukqgstv9 FOREIGN KEY (user_username) REFERENCES public.users(username);
 Z   ALTER TABLE ONLY public.users_favorite_movie DROP CONSTRAINT fkn5hmj3v64y7r8hww7ukqgstv9;
       public          postgres    false    3498    223    222            �           2606    93448 (   movie_genres fknfpjuak0xiqpca3gjkwrixiig    FK CONSTRAINT     �   ALTER TABLE ONLY public.movie_genres
    ADD CONSTRAINT fknfpjuak0xiqpca3gjkwrixiig FOREIGN KEY (genre_id) REFERENCES public.genres(id);
 R   ALTER TABLE ONLY public.movie_genres DROP CONSTRAINT fknfpjuak0xiqpca3gjkwrixiig;
       public          postgres    false    216    218    3484            �           2606    93453 (   movie_genres fks2xl3sirbon75mjcongwhrbi3    FK CONSTRAINT     �   ALTER TABLE ONLY public.movie_genres
    ADD CONSTRAINT fks2xl3sirbon75mjcongwhrbi3 FOREIGN KEY (movie_id) REFERENCES public.movie(id);
 R   ALTER TABLE ONLY public.movie_genres DROP CONSTRAINT fks2xl3sirbon75mjcongwhrbi3;
       public          postgres    false    218    217    3488            `   I   x���q�v���H��L�
����%�"	�e'�'�!��e�'�f"�$�DJ�D��K�b���� �f"�      U   '   x�3���2�tL.�����tL)K�+)-J����� �&3      V   A  x���K��H��
V��.���T�mMo
(.x��S�qr�w���@x^x�*��"Ny-� vY#��Q,l;���|�D�eOBp�o���X'#^Q��9��MU�O3�4:�ޱS�''+`����b�غ�}�Z�ClW�2@��ۚp�1�x�/�r��M���DCƩk�S���0`�c�wǍ4��iB������&I�!槈]�
�Z� =޹"�5]qSw̕u�?ʸ���ȯ���%�Y�0��;�Q�d��ln�|����67|�q���Ĭ���6/���n4��K�H[m�p�koD�����kYGl�*� ��`M�*�:(�����6绻0;ݝ8a�a�+3�8A�5`����
��!^�� #Q���z�~��g*�@���aB�(�,�������-C�c�9���BZ���}���]l����J<U����u��B㺬�$�bxN��+N����m%�P�Enm��{�|�D�'�����´�s��3%�')ȋ�Ͻ�BLV�$.si{	��ڐT3�QAǆHC�����99��=K��*f||����݌�*�a��}�s�)*�h�zfX�Sm���.:��?6�O^��)l�"��)ʺ�_�\Ԟ	~�X�4q�%�����P�����p��)�����C��63�8���g����f$@]G���ɰ"a�Y�ݫ"M����[�"�a�����y��(eC�ݢ�9���s~����}�^Ӌ�HEM���x��qV��4��gQ B71�˦0���D�C���2�Gk �����&�`1�������4��|�b�_����      W      x������ � �      X      x������ � �      Z   �   x�]�1!D�-`s�4��-�H��,E��|V;��$m��9��י�R�����1גZ�/n��
�a�G�p�����$��4�װ�]���W�Gt?��k���$	֫��Yos�y�볟������|�����������z>����o9�/��      [   �  x�}��r�@ �5|G�Hx�@@��R��8����O���[�d�]}���P�|�Lt?`���R��015�a����*4\]1�y��+��v96m�X5v�����
��Up�6m?s�ڣV)�������A�dkD`?X?�Y[�We�n��Y6�oŠ�ܼU"���[K�E�ݥ)�nzݟU^&�\�r��1}���8��Їj;.��tb���';⢶����&�(K;m��5�6vh���,4��<B:��:�7nf�m�=�tȝH����!7�ђ��,m��]/ݍtƜ桲�Z���?�_h*!�y��e	3�{��i�Q]l	� �	�a�e ��!�O'�ЂP���R�;h����a�{��F������Ĝ�����E4��qlS��E2�L��P<5���F<1��$��	v��@�	����B1���w��]�!��S��{��b��Շ∔��M�>C���;'�� �,��h
�.�G�!a�{���X��NH��      \      x��/�LO���45�ʇ1-Ls�=... ��
�      ]      x������ � �      ^      x��/�LO���45�ʇ2�b���� s7      |   �l  �   x�=�Qn�0D����êR�{��t�0I����J�1����V;)
h��H�_�]q�e���32�7�]%�rJ�.�B���?9V(�E*Ȕ�6��q������ɴm��V��E�]��H�̫��A'ѥ�R1I��Dw�j~�d�'��a�o�SG��������p���#�.��>��(Q��9�R6G
n�      �l  �   x�=�Qn�0D����êR�{��t�0I����J�1����V;)
h��H�_�]q�e���32�7�]%�rJ�.�B���?9V(�E*Ȕ�6��q������ɴm��V��E�]��H�̫��A'ѥ�R1I��Dw�j~�d�'��a�o�SG��������p���#�.��>��(Q��9�R6G
n�      �l  ]   x��1
�0DѫLg�{h#�`m̨�$6�������|�DȎ�aO5�������5�$"؇o&�����O�I��d�pi,�����w/	{#o      �l  �   x�5�M��0F���jf7s��A�=���j�D�}Ivx�}\��J`.��,���n4Pq�7��<�Tb�v��4L�_�7�h�a�6����`��8=T2c�XaS2���&� ���ע��n�)�=E�k�kO�O�
&��ڬ��q'��삇퓜�����5���`?W^"Ak���=���8�P���!k#V�� ��s�      �l  �   x�5�K�0��P�Bl�`��4�Zu��u�z{�J���<sK���ȹf�u����l �<���)��i��O}�삓����d�$kGMh�˰Kx�Y8��|��#I'3� 7n�i�;��Y����c�f�ٷ��i�O*ԏ��hG�      �l  �   x���u�0CW� y���AK���&]����+�
�} �nc�i8�1�H1�<�U�CaM�|��;��+�C��d_^�F�\q�|��t���S����gPq�@vF��֥�����|;����R�.A_����X��6�L�Q$D߉k�e���HZ���3萼�i��S��?~{]�      Dm  �   x���u�0CW� y���AK���&]����+�
�} �nc�i8�1�H1�<�U�CaM�|��;��+�C��d_^�F�\q�|��t���S����gPq�@vF��֥�����|;����R�.A_����X��6�L�Q$D߉k�e���HZ���3萼�i��S��?~{]�      Em  �   x���u�0CW� y���AK���&]����+�
�} �nc�i8�1�H1�<�U�CaM�|��;��+�C��d_^�F�\q�|��t���S����gPq�@vF��֥�����|;����R�.A_����X��6�L�Q$D߉k�e���HZ���3萼�i��S��?~{]�      Fm  �   x���u�0CW� y���AK���&]����+�
�} �nc�i8�1�H1�<�U�CaM�|��;��+�C��d_^�F�\q�|��t���S����gPq�@vF��֥�����|;����R�.A_����X��6�L�Q$D߉k�e���HZ���3萼�i��S��?~{]�      Gm  �   x���u�0CW� y���AK���&]����+�
�} �nc�i8�1�H1�<�U�CaM�|��;��+�C��d_^�F�\q�|��t���S����gPq�@vF��֥�����|;����R�.A_����X��6�L�Q$D߉k�e���HZ���3萼�i��S��?~{]�      Hm  �   x�EO��0leH�o��AX[�/=��RIl>��H{�zb��|_oLɦ�>練*B��t�M2#�+��DV4�2E9y�ŉ�p�xKųX���]9�v y����ߖ�Դ�0l�+^f��_�B�>�'�m_R/���ΰ+���
�Z�uz� �IVI      Im  ]   x��1
�0DѫLg�{h#�`m̨�$6�������|�DȎ�aO5�������5�$"؇o&�����O�I��d�pi,�����w/	{#o      Jm  �   x�5�M��0F���jf7s��A�=���j�D�}Ivx�}\��J`.��,���n4Pq�7��<�Tb�v��4L�_�7�h�a�6����`��8=T2c�XaS2���&� ���ע��n�)�=E�k�kO�O�
&��ڬ��q'��삇퓜�����5���`?W^"Ak���=���8�P���!k#V�� ��s�      Km  �   x�5�K�0��P�Bl�`��4�Zu��u�z{�J���<sK���ȹf�u����l �<���)��i��O}�삓����d�$kGMh�˰Kx�Y8��|��#I'3� 7n�i�;��Y����c�f�ٷ��i�O*ԏ��hG�      Lm  l  x�M�QNAD��,{��!�@����x{<ӆ{�v���Ip�F��Ѹ\�\�@������3�SU6ب$]iW�L�z�ǧib,0�N�2���<T�	��mh�zl+,\�A�R�����oH4�d���w��O��$���Qx�ZX�H�B�2A�
+��U�C������^7:Q������FĊO��͜�l=q�ߗ��2���������ػyĵQ�X��,�u��V:G_�RU�h����a�A�L��@��<�K��Ѓfc�C���~�6OQ\�~�ě��oqe���BR�@֭G�ct\[�/�-s!<��Ki�枫��S�%DE���KKY�������Y      Mm  �   x�5PKn� ��;�tV]t[�����n�82f�ܾN�ـ����(�A���o��'�
���!ڱ*8��R�}��S쟒c�ؤ��icC����L�q��B~a��Z��!=P�.5��H�Ù�<|�x�t�����󙴵�%][P/��z�4��o�`5��{�3g��c�Љb��Y��HT�ǵ�s���A"������B�s;�s�t�      Nm  �   x�-�Q
�@D�2(�"@�<A�Mm��Hv���7�� 3/�#:��<�3��,sA�\���$Z�v.2�V،)�s���<�6�!-���x1D�\��Ŷ�~M9�,���:nNg���z�Lk|�2��q��*���]/BQ      Om  �   x����0Wyb���nb��X$v�"�o�����j?���	G�)Q���NRk���_�a˧Ҷ/��G��#�Bg�Rc��<��l�YzJ���H��T��4�Q�n��@��()��[%i~g�x���?s;E�      Pm  �   x�m��n�0Den���?���г	�z�V��k��S�8�f<�+g���iie�qҽ�������z���o��&%��������Z1�"+x���|d�E�O�@zW�u;Ql�,?n�ޅ��,y����<��)r���g����6g����ʆ�AgqE�0�Ď�x��*�")�o�nF��*Y��s_�t�Ej#�=h��2M�_ �]�)ۋ��ʺ��&�E��+�a5�n�_����      L�  �   x�%��m�@D[�����B*`ıM`�v���������Sɉ<��t6�Cf�5��l�T�|Ri^ݟ=��h2�UG��6S-�����aq���M5w��D�-��Z64���������Tݗ��4zv�|��P�X���7�Z1K� DG����ܡ���1��W|'΁c)|oX�      M�  �   x�=�K1�����ø3nL<�4C�i���������b��0�������a+Tq��ǆ
�7�j{�W�̋�)
��t��ZaGIp`U�8	+Ӗz���[eL��w��_�6�g[�����s��.�6��c�C-!��_�=2�I�S~      N�  �   x�U�AK�@�������=xO<	zN�i7�4)�m��z�<%0�L���d&6�f��O�=����)��$e�t�M����ⵒ
��y�D�e7F
Y��������L�y�'b�B�r�i�7�l���-�j�e�pC�����v�f3�����MR&V��k��IS�֮j��_��x7Q�(�6K�|F��e%��t�>޹�\ [�m�      O�  �   x�=�11���4P]��ŹD����}r)h,k��Y_�6sE8��(��put�;�ZY;��[��g�II�4M6��q{�,O�鶳"��}����{ۄ���n�̑��v�S ��,L�-U��l���i�I��	�X�na�~4X�G�y��|��t�J�.?�ZF      P�  w   x���� Wyd���(N@�&���	;IQ��n��.7�x�9"1����{���_�\��4lKP8=�P+'(0��}@r��w�5Z�T�,\'��xhkyE�\�!�5\      �     x�.�LI-�M�S(��� a��      �     x�.�LI-�M�S(��� a��      �     x�.�LI-�M�S(��� a��          