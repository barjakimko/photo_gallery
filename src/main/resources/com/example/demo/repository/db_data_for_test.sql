INSERT INTO public.account_type (id, account_type) VALUES (1, 'customer');
INSERT INTO public.account_type (id, account_type) VALUES (2, 'photographer');

INSERT INTO public.application_user (id, login, password, account_type_id) VALUES (1, 'bj', '123', 1);
INSERT INTO public.application_user (id, login, password, account_type_id) VALUES (2, 'kcr', '123', 1);
INSERT INTO public.application_user (id, login, password, account_type_id) VALUES (3, 'kch', '123', 2);

INSERT INTO public.gallery (id, name, password, user_id) VALUES (1, 'first-gallery', '123', 1);
INSERT INTO public.gallery (id, name, password, user_id) VALUES (2, 'second-gallery', '123', 2);
INSERT INTO public.gallery (id, name, password, user_id) VALUES (3, 'third-gallery', '123', 2);
INSERT INTO public.gallery (id, name, password, user_id) VALUES (4, 'fourth-gallery', '123', 1);

INSERT INTO public.photo (id, url, gallery_id) VALUES (1, '/photos/stars.jpg', 1);
INSERT INTO public.photo (id, url, gallery_id) VALUES (4, '/photos/stars-four.jpeg', 2);
INSERT INTO public.photo (id, url, gallery_id) VALUES (3, '/photos/stars-tree.jpeg', 2);
INSERT INTO public.photo (id, url, gallery_id) VALUES (2, '/photos/stars-two.jpeg', 1);