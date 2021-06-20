
CREATE SEQUENCE public.mst_role_role_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;
    
    
CREATE SEQUENCE public.t_role_user_mapper_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;
   
CREATE SEQUENCE public.blog_gallary_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;
CREATE TABLE public.blog_gallary
	(
			blog_gallary_id integer NOT NULL,
			blog_name character varying(500) COLLATE pg_catalog."default" NOT NULL,
			blog_title character varying(500) COLLATE pg_catalog."default" NOT NULL,
			description text COLLATE pg_catalog."default" NOT NULL,
			execution_time character varying(500) COLLATE pg_catalog."default" NOT NULL,
			original_path text COLLATE pg_catalog."default",
			original_file_name text COLLATE pg_catalog."default" NOT NULL,
			original_file_ext character varying(500) COLLATE pg_catalog."default" NOT NULL,
	        created_by character varying(500) COLLATE pg_catalog."default",
	        created_date timestamp without time zone NOT NULL DEFAULT now(),
	        folder_id character varying(100) COLLATE pg_catalog."default",
	    CONSTRAINT blog_gallary_pkey PRIMARY KEY (blog_gallary_id)
	)
	
	
	
	CREATE TABLE public.video_gallary
(
    video_gallary_id integer NOT NULL,
    video_name character varying(500) COLLATE pg_catalog."default" NOT NULL,
    video_title character varying(500) COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default" NOT NULL,
    batch character varying(500) COLLATE pg_catalog."default" NOT NULL,
    original_path text COLLATE pg_catalog."default",
    original_file_name text COLLATE pg_catalog."default" NOT NULL,
    original_file_ext character varying(500) COLLATE pg_catalog."default" NOT NULL,
    course_category character varying(500) COLLATE pg_catalog."default" NOT NULL,
    is_write boolean NOT NULL DEFAULT false,
    thumbnail_path text COLLATE pg_catalog."default",
    is_thumbnail boolean NOT NULL DEFAULT false,
    compressed_path text COLLATE pg_catalog."default",
    is_compressed boolean NOT NULL DEFAULT false,
    created_by character varying(500) COLLATE pg_catalog."default",
    created_date timestamp without time zone NOT NULL DEFAULT now(),
    thumbnail_file_name character varying(100) COLLATE pg_catalog."default",
    folder_id character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT video_gallary_pkey PRIMARY KEY (video_gallary_id)
)
    
    CREATE TABLE public.mst_role
(
    role_id integer NOT NULL DEFAULT nextval('mst_role_role_id_seq'::regclass),
    name character varying(60) COLLATE pg_catalog."default",
    enabled boolean,
    abbre_code character varying COLLATE pg_catalog."default",
    entered_ip character varying COLLATE pg_catalog."default",
    created_on timestamp without time zone,
    created_by character varying COLLATE pg_catalog."default",
    updated_by character varying COLLATE pg_catalog."default",
    updated_ip character varying COLLATE pg_catalog."default",
    updated_on timestamp without time zone,
    CONSTRAINT mst_role_pkey PRIMARY KEY (role_id)
)

INSERT INTO public.mst_role(
	role_id, name, enabled, abbre_code, entered_ip, created_on, created_by, updated_by, updated_ip, updated_on)
	VALUES (1, 'ADMIN', true, 'ADMIN', '127.0.0.0', now(), 'ADMIN', 'ADMIN', '127.0.0.0', now());
	
	INSERT INTO public.mst_role(
	role_id, name, enabled, abbre_code, entered_ip, created_on, created_by, updated_by, updated_ip, updated_on)
	VALUES (2, 'USER', true, 'USER', '127.0.0.0', now(), 'ADMIN', 'ADMIN', '127.0.0.0', now());
	
	

CREATE TABLE public.t_role_user_mapper
(
    id integer NOT NULL DEFAULT nextval('t_role_user_mapper_id_seq'::regclass),
    role_id integer,
    user_id integer,
    enabled boolean,
    created_by character varying COLLATE pg_catalog."default",
    created_on timestamp without time zone,
    updated_on timestamp without time zone,
    updated_by character varying COLLATE pg_catalog."default",
    updated_ip character varying COLLATE pg_catalog."default",
    
    CONSTRAINT t_role_user_mapper_pkey PRIMARY KEY (id),
    CONSTRAINT fk7n4s39ytg9yjfbs73pcvb39yo FOREIGN KEY (role_id)
        REFERENCES public.mst_role (role_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk7yla5dmg8lfgokc1qce48csos FOREIGN KEY (user_id)
        REFERENCES public.drn_classes_student (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)


CREATE TABLE public.drn_classes_student
(
    user_id integer  NOT NULL DEFAULT nextval('drn_classes_student_seq'::regclass),
    first_name character varying COLLATE pg_catalog."default" NOT NULL,
    middle_name character varying COLLATE pg_catalog."default" ,
    last_name character varying COLLATE pg_catalog."default" NOT NULL,
    email character varying COLLATE pg_catalog."default",
    password character varying COLLATE pg_catalog."default",
    phone character varying COLLATE pg_catalog."default",
    deactivated_reason character varying COLLATE pg_catalog."default",
    
    batch character varying COLLATE pg_catalog."default",
    correspondance_address character varying COLLATE pg_catalog."default",
    permanent_address character varying COLLATE pg_catalog."default",
    father_name character varying COLLATE pg_catalog."default",
    mother_name character varying COLLATE pg_catalog."default",
    failed_attempt integer,
    is_account_non_locked boolean,
    locktime timestamp without time zone,
    created_on date,
    created_by character varying COLLATE pg_catalog."default",
    updated_on date,
    enabled boolean NOT NULL DEFAULT true,
    updated_by character varying COLLATE pg_catalog."default",
    updated_ip character varying COLLATE pg_catalog."default",
    CONSTRAINT t_user_pkey PRIMARY KEY (user_id)
)


	
	CREATE SEQUENCE public.question_answer_entity_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;
	
	CREATE TABLE public.question_answer_entity
(
    questionanswer_id integer NOT NULL DEFAULT nextval('question_answer_entity_seq'::regclass),
    meterial_name character varying(500) COLLATE pg_catalog."default",
    meterial_title character varying(500) COLLATE pg_catalog."default",
    course_category character varying(500) COLLATE pg_catalog."default",
    description text COLLATE pg_catalog."default",
    batch character varying(500) COLLATE pg_catalog."default",
    question_folder_path text COLLATE pg_catalog."default",
    question_file_name text COLLATE pg_catalog."default",
    question_file_ext character varying(500) COLLATE pg_catalog."default",
    question_created_by character varying(500) COLLATE pg_catalog."default",
    question_created_date timestamp without time zone NOT NULL DEFAULT now(),
    question_folder_id character varying(100) COLLATE pg_catalog."default",
    answer_folder_path text COLLATE pg_catalog."default",
    answer_file_name text COLLATE pg_catalog."default",
    answer_file_ext character varying(500) COLLATE pg_catalog."default",
    answer_created_by_user_id integer,
    answer_created_by_email character varying(500) COLLATE pg_catalog."default",
    answer_created_date timestamp without time zone ,
    is_answered boolean NOT NULL DEFAULT false,
    answer_folder_id character varying(100) COLLATE pg_catalog."default",
   
    CONSTRAINT question_answer_entity_pkey PRIMARY KEY (questionanswer_id)
)
