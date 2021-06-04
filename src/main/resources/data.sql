insert into role(id, name) values(1L,'ROLE_ADMIN');
insert into user(id, email, first_name, last_name, password) values (1L, 'admin@admin.pl', 'admin', 'admin', '$2a$10$.0SAmgcOXVRM4NTU2OcyUe0DHn51Bs7IUkhH0m3rnKnE6DGSDPQdG');
insert into USERS_ROLES(user_id, role_id) values(1l, 1l);