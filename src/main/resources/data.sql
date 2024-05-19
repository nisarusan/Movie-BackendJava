

INSERT INTO public.authorities (authority, username) VALUES ('ROLE_USER', 'Khalid');
INSERT INTO public.authorities (authority, username) VALUES ('ROLE_USER', 'username');
INSERT INTO public.authorities (authority, username) VALUES ('ROLE_USER', 'nisarusan');
INSERT INTO public.authorities (authority, username) VALUES ('ROLE_USER', 'origami');
INSERT INTO public.authorities (authority, username) VALUES ('ROLE_USER', 'arigato');



INSERT INTO public.genres (id, name) VALUES (2, 'Action');
INSERT INTO public.genres (id, name) VALUES (8, 'Adventure');



INSERT INTO public.movie (id, description, director, duration, image_url, release_date, title) VALUES (1, '93508', 'Steve Job', 90, 'kCGlIMHnOm8JPXq3rXM6c5wMxcT.jpg', '1990-01-01', 'Poor Things');
INSERT INTO public.movie (id, description, director, duration, image_url, release_date, title) VALUES (52, '93512', 'Steve Job', 90, 'qhb1qOilapbapxWQn9jtRCMwXJF.jpg', '1990-01-01', 'Wonka');
INSERT INTO public.movie (id, description, director, duration, image_url, release_date, title) VALUES (53, '93513', 'Steve Job', 90, 'ptpr0kGAckfQkJeJIt8st5dglvd.jpg', '1990-01-01', 'Oppenheimer');
INSERT INTO public.movie (id, description, director, duration, image_url, release_date, title) VALUES (54, '93514', 'Steve Job', 90, 'nfs7DCYhgrEIgxKYbITHTzKsggf.jpg', '1990-01-01', 'The Iron Claw');
INSERT INTO public.movie (id, description, director, duration, image_url, release_date, title) VALUES (55, '93515', 'Steve Job', 90, 'ldfCF9RhR40mppkzmftxapaHeTo.jpg', '1990-01-01', 'Migration');
INSERT INTO public.movie (id, description, director, duration, image_url, release_date, title) VALUES (56, '93516', 'Steve Job', 90, 'fbbj3viSUDEGT1fFFMNpHP1iUjw.jpg', '1990-01-01', 'Mean Girls');
INSERT INTO public.movie (id, description, director, duration, image_url, release_date, title) VALUES (57, '93517', 'Steve Job', 90, 'bIeEMMvfzgbMBtYaEWtxrFnt6Vo.jpg', '1990-01-01', 'Land of Bad');
INSERT INTO public.movie (id, description, director, duration, image_url, release_date, title) VALUES (58, '93518', 'Steve Job', 90, 'mBaXZ95R2OxueZhvQbcEWy2DqyO.jpg', '2024-01-25', 'The Hunger Games: The Ballad of Songbirds & Snakes');
INSERT INTO public.movie (id, description, director, duration, image_url, release_date, title) VALUES (59, '93519', 'Steve Job', 90, '57MFWGHarg9jid7yfDTka4RmcMU.jpg', '2024-01-25', 'American Fiction');
INSERT INTO public.movie (id, description, director, duration, image_url, release_date, title) VALUES (60, '93520', 'Steve Job', 90, 'siduVKgOnABO4WH4lOwPQwaGwJp.jpg', '2024-01-25', 'Argylle');
INSERT INTO public.movie (id, description, director, duration, image_url, release_date, title) VALUES (102, '101196', 'Steve Job', 120, 'yRt7MGBElkLQOYRvLTT1b3B1rcp.jpg', '2023-01-25', 'Anyone But You');
INSERT INTO public.movie (id, description, director, duration, image_url, release_date, title) VALUES (103, '101197', 'Steve Job', 120, 'v9nGSRx5lFz6KEgfmgHJMSgaARC.jpg', '2023-01-25', 'Binnelanders');
INSERT INTO public.movie (id, description, director, duration, image_url, release_date, title) VALUES (104, '101198', 'Steve Job', 120, '3bhkrj58Vtu7enYsRolD1fZdja1.jpg', '2023-01-25', 'The Godfather');
INSERT INTO public.movie (id, description, director, duration, image_url, release_date, title) VALUES (105, '101199', 'Steve Job', 120, 'rCzpDGLbOoPwLjy3OAm5NUPOTrC.jpg', '2009-01-01', 'The Lord of the Rings: The Return of the King');
INSERT INTO public.movie (id, description, director, duration, image_url, release_date, title) VALUES (106, '101200', 'Steve Job', 120, 'lzZpWEaqzP0qVA5nkCc5ASbNcSy.jpg', '2024-01-01', 'Avatar: The Last Airbender');
INSERT INTO public.movie (id, description, director, duration, image_url, release_date, title) VALUES (153, '101868', 'Steve Job', 120, '24CL0ySodCF8bcm38xtBeHzHp7W.jpg', '2021-01-01', 'SpiderMan');
INSERT INTO public.movie (id, description, director, duration, image_url, release_date, title) VALUES (202, '110059', 'Steve Job', 120, '24CL0ySodCF8bcm38xtBeHzHp7W.jpg', '2021-01-01', 'SpiderMan');
INSERT INTO public.movie (id, description, director, duration, image_url, release_date, title) VALUES (252, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO public.movie (id, description, director, duration, image_url, release_date, title) VALUES (253, 'Beschrijving film', 'Steven Spielberg', 150, 'vlHJfLsduZiILN8eYdN57kHZTcQ', '1991-01-01', 'Film naar keuze hier');



INSERT INTO public.users (username, address, apikey, email, enabled, password, profile_url) VALUES ('Khalid', NULL, 'VwcuRPKUdUGdr4gQvr2y', 'nizar.abak@live.nl', true, '$2a$10$pqdmEXALJGnaOPMNZNJM8u7.ZvlOjlIprz.XBMtGg48CNQETkuO8m', 'img');
INSERT INTO public.users (username, address, apikey, email, enabled, password, profile_url) VALUES ('nisarusan', NULL, 'zABHj7TNpKp0dbbvTJM9', 'info@luisteren.nl', true, '$2a$10$n4fktiBPhogrqy1Tf805se5nDX7hl8vZFVzVgOjmVWZQNaxtHJKsq', 'empty');
INSERT INTO public.users (username, address, apikey, email, enabled, password, profile_url) VALUES ('origami', NULL, 'vmenHozRg0xHs4354PAv', 'info@luisteren.nl', true, '$2a$10$DlpWJtOCEgz2oCJ6YatuQe8yTIKbGwHiqxRyUdJV2V6/wUdDRYG5i', 'empty');








INSERT INTO public.users_favorite_movie (user_username, favorite_movie_id) VALUES ('origami', 54);
INSERT INTO public.users_favorite_movie (user_username, favorite_movie_id) VALUES ('origami', 58);




INSERT INTO public.users_movies_seen (user_username, movies_seen_id) VALUES ('origami', 52);
INSERT INTO public.users_movies_seen (user_username, movies_seen_id) VALUES ('origami', 1);


