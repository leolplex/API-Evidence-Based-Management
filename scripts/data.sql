INSERT INTO public.team (id, name, date_join) OVERRIDING SYSTEM VALUE VALUES ('Increibles', '2020-01-01 00:00:00-05');



INSERT INTO public.iteration OVERRIDING SYSTEM VALUE VALUES ('My goal', '2020-10-01 00:00:00-05', '2020-10-21 00:00:00-05', 'Finished');
INSERT INTO public.iteration OVERRIDING SYSTEM VALUE VALUES ('Get 20% to new revenew', '2020-01-01 00:00:00-05', '2020-02-02 00:00:00-05', 'Finished');


INSERT INTO public.iteration_product VALUES (2, 1);
INSERT INTO public.iteration_product VALUES (3, 1);




INSERT INTO public.kva_ability_to_innovate OVERRIDING SYSTEM VALUE VALUES (NULL, NULL, NULL, NULL, NULL, '1 month', '3 times by iteration', '5 hours', '3', 2, 2);


INSERT INTO public.kva_current_value OVERRIDING SYSTEM VALUE VALUES ('8.500.000 COP', '500.000.000 - 100.000.000 COP', '4/5', '3/5', '50/180 min', 2, 2);




INSERT INTO public.kva_time_to_market OVERRIDING SYSTEM VALUE VALUES ( '10 by week', 'Monthly', '3 days', '3/5', '1 month', '3 months', '1 months', 2, 2);



INSERT INTO public.kva_unrealized_value OVERRIDING SYSTEM VALUE VALUES ('3%', '5/10', 2, 2);




INSERT INTO public.roles OVERRIDING SYSTEM VALUE VALUES ('Owner');
INSERT INTO public.roles OVERRIDING SYSTEM VALUE VALUES ('Viewer');


INSERT INTO public.users OVERRIDING SYSTEM VALUE VALUES ('vari', '$2a$10$cCRNG3rYGfjl2ZzxXp7Iz.v5hGNPxlciK6PXQtJv7yiPcBTcjCFty', 2, 'mypost@postman.com');
INSERT INTO public.users OVERRIDING SYSTEM VALUE VALUES ('vari2', '$2a$10$.Nir00VDGCodt7tZInLUHujtE341hUOdFVlHppeUKWsyvXetAOIX.', 2, 'mypost@postman.com');


INSERT INTO public.product OVERRIDING SYSTEM VALUE VALUES ('Kioskos', '2021-01-08 17:03:00-05', 2);

ALTER SEQUENCE iteration_id_seq RESTART WITH 4
SELECT c.relname FROM pg_class c WHERE c.relkind = 'S';

