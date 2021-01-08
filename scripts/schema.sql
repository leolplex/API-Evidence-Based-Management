
CREATE TABLE iteration
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    goal character varying COLLATE pg_catalog."default" NOT NULL,
    start_date timestamp with time zone NOT NULL,
    end_date timestamp with time zone NOT NULL,
    state character varying COLLATE pg_catalog."default",
    CONSTRAINT iteration_pkey PRIMARY KEY (id)
)


CREATE TABLE team
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying COLLATE pg_catalog."default" NOT NULL,
    date_join timestamp with time zone,
    id_user integer,
    CONSTRAINT team_pkey PRIMARY KEY (id),
    CONSTRAINT team_user FOREIGN KEY (id_user)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)



CREATE TABLE iteration_team
(
    id_iteration integer NOT NULL,
    id_team integer NOT NULL,
    CONSTRAINT iteration_team_pkey PRIMARY KEY (id_iteration, id_team),
    CONSTRAINT fk_iteration FOREIGN KEY (id_iteration)
        REFERENCES public.iteration (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_team FOREIGN KEY (id_team)
        REFERENCES team (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)



CREATE TABLE kva_ability_to_innovate
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    feature_usage_index character varying COLLATE pg_catalog."default",
    innovation_rate character varying COLLATE pg_catalog."default",
    defect_trends character varying COLLATE pg_catalog."default",
    on_product_index character varying COLLATE pg_catalog."default",
    installed_version_index character varying COLLATE pg_catalog."default",
    technical_debt character varying COLLATE pg_catalog."default",
    production_incident_trends character varying COLLATE pg_catalog."default",
    active_code_branches_time_spent_merging_code_between_branches character varying COLLATE pg_catalog."default",
    time_spent_context_switching character varying COLLATE pg_catalog."default",
    id_iteration integer NOT NULL,
    id_team integer NOT NULL,
    CONSTRAINT kvm_ability_to_innovate_pkey PRIMARY KEY (id),
    CONSTRAINT fk_iteration FOREIGN KEY (id_iteration)
        REFERENCES iteration (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_team FOREIGN KEY (id_team)
        REFERENCES team (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)


CREATE TABLE public.kva_current_value
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    revenue_per_employee character varying COLLATE pg_catalog."default",
    product_cost_ratio character varying COLLATE pg_catalog."default",
    employee_satisfaction character varying COLLATE pg_catalog."default",
    customer_satisfaction character varying COLLATE pg_catalog."default",
    customer_usage_index character varying COLLATE pg_catalog."default",
    id_iteration integer NOT NULL,
    id_team integer NOT NULL,
    CONSTRAINT kvm_current_value_pkey PRIMARY KEY (id),
    CONSTRAINT fk_iteration FOREIGN KEY (id_iteration)
        REFERENCES public.iteration (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_team FOREIGN KEY (id_team)
        REFERENCES public.team (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)



CREATE TABLE kva_time_to_market
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    build_and_integration_frequency character varying COLLATE pg_catalog."default",
    release_frequency character varying COLLATE pg_catalog."default",
    release_stabilization_period character varying COLLATE pg_catalog."default",
    mean_time_to_repair character varying COLLATE pg_catalog."default",
    cycle_time character varying COLLATE pg_catalog."default",
    lead_time character varying COLLATE pg_catalog."default",
    time_to_learn character varying COLLATE pg_catalog."default",
    id_team integer NOT NULL,
    id_iteration integer NOT NULL,
    CONSTRAINT kvm_time_to_market_pkey PRIMARY KEY (id),
    CONSTRAINT fk_iteration FOREIGN KEY (id_iteration)
        REFERENCES iteration (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_team FOREIGN KEY (id_team)
        REFERENCES team (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

CREATE TABLE kva_unrealized_value
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    market_share character varying COLLATE pg_catalog."default",
    customer_or_user_satisfaction_gap character varying COLLATE pg_catalog."default",
    id_team integer NOT NULL,
    id_iteration integer NOT NULL,
    CONSTRAINT kvm_unrealized_value_pkey PRIMARY KEY (id),
    CONSTRAINT fk_iteration FOREIGN KEY (id_iteration)
        REFERENCES iteration (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_team FOREIGN KEY (id_team)
        REFERENCES team (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

CREATE TABLE roles
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "Name" character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT roles_pkey PRIMARY KEY (id)
)



CREATE TABLE users
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    username character varying COLLATE pg_catalog."default" NOT NULL,
    password character varying COLLATE pg_catalog."default" NOT NULL,
    id_rol integer NOT NULL,
    email character varying COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT users_username_key UNIQUE (username),
    CONSTRAINT user_rol FOREIGN KEY (id_rol)
        REFERENCES public.roles (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)
