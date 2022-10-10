drop table if exists board;

create table board(
                      id bigint not null auto_increment primary key,
                      title varchar(50) not null,
                      content varchar(4000) not null,
                      created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                      modified_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                      user_id bigint not null,
                      FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

drop table if exists comment;

create table comment(
                        id bigint not null auto_increment primary key,
                        content varchar(255) not null,
                        created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        modified_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        board_id bigint not null,
                        user_id bigint not null,
                        FOREIGN KEY (board_id) REFERENCES board (id) ON DELETE CASCADE ON UPDATE CASCADE,
                        FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE
);

