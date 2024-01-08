create table users (
    id bigserial primary key ,
    username varchar unique not null ,
    password varchar not null ,
    email varchar,
    phone varchar,
    role varchar(20) not null ,
    created_at timestamp not null ,
    updated_at timestamp ,
    deleted_at timestamp
);

create table codes (
    id bigserial primary key ,
    code integer not null ,
    user_id bigserial not null references users(id),
    created_at timestamp not null ,
    expired_at timestamp not null ,
    confirmed_at timestamp,
    type varchar(10) not null
);