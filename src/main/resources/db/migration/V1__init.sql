drop table if exists user;

create table user(
                     id bigint not null AUTO_INCREMENT PRIMARY KEY,
                     login_id varchar(100) not null,
                     name varchar(50) not null,
                     password varchar(255) not null,
                     phone_number varchar(100) not null,
                     type varchar(50) not null,
                     created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                     modified_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);