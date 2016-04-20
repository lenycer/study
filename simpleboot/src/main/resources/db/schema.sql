CREATE TABLE SIMPLE 
(
	id				int,
	name			varchar(255)
);

insert into simple (id, name) values (1, 'lenycer');


CREATE TABLE USERS 
(
	username			varchar(255),
	password			varchar(255),
	enabled				boolean,
	nick			varchar(255)
);

insert into users (username, password, enabled, nick) values ('cvic', 'asdf', true, 'aacc');
insert into users (username, password, enabled, nick) values ('test', 'asdf', true, 'bbdd');

CREATE TABLE AUTHORITIES
(
	username			varchar(255),
	authority			varchar(255)
);

insert into authorities (username, authority) values ('cvic', 'ROLE_ADMIN');
insert into authorities (username, authority) values ('test', 'ROLE_USER');

