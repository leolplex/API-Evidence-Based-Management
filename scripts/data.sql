INSERT INTO public.team (id, name, date_join) OVERRIDING SYSTEM VALUE VALUES (2, 'Increibles', '2020-01-01 00:00:00-05');



INSERT INTO public.iteration OVERRIDING SYSTEM VALUE VALUES (2, 'My goal', '2020-10-01 00:00:00-05', '2020-10-21 00:00:00-05', 'Finished');
INSERT INTO public.iteration OVERRIDING SYSTEM VALUE VALUES (3, 'Get 20% to new revenew', '2020-01-01 00:00:00-05', '2020-02-02 00:00:00-05', 'Finished');


INSERT INTO public.iteration_team VALUES (2, 2);
INSERT INTO public.iteration_team VALUES (3, 2);



INSERT INTO public.kva_ability_to_innovate OVERRIDING SYSTEM VALUE VALUES (2, NULL, NULL, NULL, NULL, NULL, '1 month', '3 times by iteration', '5 hours', '3', 2, 2);


INSERT INTO public.kva_current_value OVERRIDING SYSTEM VALUE VALUES (1, '8.500.000 COP', '500.000.000 - 100.000.000 COP', '4/5', '3/5', '50/180 min', 2, 2);




INSERT INTO public.kva_time_to_market OVERRIDING SYSTEM VALUE VALUES (1, '10 by week', 'Monthly', '3 days', '3/5', '1 month', '3 months', '1 months', 2, 2);



INSERT INTO public.kva_unrealized_value OVERRIDING SYSTEM VALUE VALUES (1, '3%', '5/10', 2, 2);

