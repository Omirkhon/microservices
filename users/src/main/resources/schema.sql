CREATE TABLE IF NOT EXISTS users (
    id serial primary key,
    login varchar(255) not null,
    created_at timestamp not null
);

CREATE TABLE IF NOT EXISTS posts (
    id serial primary key,
    description varchar(255) not null,
    created_at timestamp not null,
    author_id int references USERS (id)
);