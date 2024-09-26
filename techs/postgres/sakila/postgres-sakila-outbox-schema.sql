SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;



CREATE SEQUENCE actor_actor_id_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.actor_actor_outbox_id_seq OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: actor; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE actor_outbox (
    id INTEGER DEFAULT nextval('actor_actor_outbox_id_seq'::regclass) NOT NULL,
    aggregate_id INTEGER NOT NULL,
    aggregation_type character varying(255) NOT NULL,
    event_type character varying(255) NOT NULL,
    event_data jsonb NOT NULL,
    event_time timestamp with time zone NOT NULL,
    CONSTRAINT actor_outbox_pkey PRIMARY KEY (id)
);


ALTER TABLE public.actor_outbox OWNER TO postgres;
