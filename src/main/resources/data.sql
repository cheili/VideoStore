
-- USER --
INSERT INTO `USER` (id, user_name, password, first_name, last_name, email, enabled, last_password_reset_date) VALUES (1, 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin', 'admin', 'admin@admin.com', 1, '01-01-2016');
INSERT INTO `USER` (id, user_name, password, first_name, last_name, email, enabled, last_password_reset_date) VALUES (2, 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'enabled@user.com', 1, '01-01-2016');
INSERT INTO `USER` (id, user_name, password, first_name, last_name, email, enabled, last_password_reset_date) VALUES (3, 'disabled', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'disabled@user.com', 0, '01-01-2016');
 
-- AUTHORITY --
INSERT INTO `AUTHORITY` (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO `AUTHORITY` (id, name) VALUES (2, 'ROLE_ADMIN');
 
-- USER_AUTHORITY --
INSERT INTO `USER_AUTHORITY` (user_id, authority_id) VALUES (1, 1);
INSERT INTO `USER_AUTHORITY` (user_id, authority_id) VALUES (1, 2);
INSERT INTO `USER_AUTHORITY` (user_id, authority_id) VALUES (2, 1);
INSERT INTO `USER_AUTHORITY` (user_id, authority_id) VALUES (3, 1);

-- ROLE --
INSERT INTO `ROLE` (name) VALUES ('Administrator');
INSERT INTO `ROLE` (name) VALUES ('Visitor');

-- PRIVILEGE -- 
INSERT INTO `PRIVILEGE` (name) VALUES ('create');
INSERT INTO `PRIVILEGE` (name) VALUES ('read');
INSERT INTO `PRIVILEGE` (name) VALUES ('update');
INSERT INTO `PRIVILEGE` (name) VALUES ('delete');

-- LIMITED_PRIVILEGE -- 
INSERT INTO `LIMITED_PRIVILEGE` (privilege_id) VALUES ('2');

-- ADMINISTRATIVE_PRIVILEGE -- 
INSERT INTO `ADMINISTRATIVE_PRIVILEGE` (privilege_id) VALUES ('1');
INSERT INTO `ADMINISTRATIVE_PRIVILEGE` (privilege_id) VALUES ('3');
INSERT INTO `ADMINISTRATIVE_PRIVILEGE` (privilege_id) VALUES ('4');

-- VISITOR -- 
INSERT INTO `VISITOR` (role_id) VALUES ('2');

-- ADMINISTRATOR -- 
INSERT INTO `ADMINISTRATOR` (visitor_id) VALUES ('1');

-- PERSON --
INSERT INTO `PERSON` (first_name, last_name) VALUES ('Jean', 'Muller');
INSERT INTO `PERSON` (first_name, last_name) VALUES ('Natalie', 'HERSHLAG');
INSERT INTO `PERSON` (first_name, last_name) VALUES ('Thomas Sean', 'CONNERY');
INSERT INTO `PERSON` (first_name, last_name) VALUES ('Anne', 'Dupont');

-- ACTOR -- 
INSERT INTO `ACTOR` (stage_name, person_id) VALUES ('Natalie Portman', 2);
INSERT INTO `ACTOR` (stage_name, person_id) VALUES ('Sean Connery', 3);

-- APPLICATION_USER -- 
INSERT INTO `APPLICATION_USER` (email, person_id) VALUES ('claude.heili@gmail.com', 1);
INSERT INTO `APPLICATION_USER` (email, person_id) VALUES ('laetitia.krieger@gmail.com', 4);

-- APPLICATIONUSER_ROLE --
INSERT INTO `APPLICATIONUSER_ROLE` (application_user_id, role_id) VALUES (1, 1);

-- MOVIE -- 
INSERT INTO `MOVIE` (title) VALUES ('Léon');
INSERT INTO `MOVIE` (title) VALUES ('James Bond 007 contre Dr No');

-- ACTOR_MOVIE -- 
INSERT INTO `ACTOR_MOVIE` (actor_id, movie_id) VALUES (2, 1);
INSERT INTO `ACTOR_MOVIE` (actor_id, movie_id) VALUES (3, 2);





