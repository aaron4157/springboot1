/* 
* create tables and data for springboot framework performing authentication
*/

-- user is an identity table
create table public.user (
    id serial,
    username varchar(50) not null unique,
    password varchar(72) not null, -- bcrypted password
    is_account_non_expired boolean, -- isAccountNonExpired
    is_account_non_locked boolean, -- isAccountNonLocked
    is_credentials_non_expired boolean, -- isCredentialsNonExpired
    is_enabled boolean, -- isEnabled
    date_created date,
    created_by varchar(50),
    last_updated date,
    last_updated_by varchar(50),
    
    constraint user_pk primary key (id)
);

-- role is authority table
create table public.role (
    id serial primary key,
    role_name varchar(20) not null
);

-- a junction table between user and role
create table public.user_role (
   user_id integer references public.user(id),
   role_id integer references public.role(id),
   
   constraint user_role_uk primary key(user_id,role_id)
);

-- prepare initial data for 3 tables

insert into public.user values (default, 'admin', 'password', true, true, true, true, now(), 'dbadmin', now(), 'dbadmin');
insert into public.user values (default, 'user1', 'password', true, true, true, true, now(), 'dbadmin', now(), 'dbadmin');

insert into public.role values (default,'ROLE_ADMIN');
insert into public.role values (default,'ROLE_USER');

insert into public.user_role
select a.id user_id, b.id role_id from public.user a, public.role b
where username = 'admin' and role_name in ('ADMIN','USER');

insert into public.user_role
select a.id user_id, b.id role_id from public.user a, public.role b
where username = 'user1' and role_name in ('USER');
