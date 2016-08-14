CREATE TABLE public.login
(
  id bigint NOT NULL,
  attribute1 character varying(255),
  attribute2 character varying(255),
  attribute3 character varying(255),
  attribute4 character varying(255),
  login_time timestamp without time zone,
  user_name character varying(255),
  version integer,
  CONSTRAINT login_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.login
  OWNER TO postgres;