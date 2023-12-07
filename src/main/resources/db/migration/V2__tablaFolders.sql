CREATE TABLE "users"
(
    "user_id"    integer PRIMARY KEY,
    "first_name" varchar(50)         NOT NULL,
    "last_name"  varchar(50)         NOT NULL,
    "mail"       varchar(50) UNIQUE  NOT NULL,
    "password"   varchar(500) UNIQUE NOT NULL,
    "created_ts" timestamp           NOT NULL,
    "update_ts"  timestamp
);
create sequence user_sequence as integer increment 1;
CREATE TABLE "folders"
(
    "folder_id"   integer PRIMARY KEY,
    "folder_name" varchar(70) NOT NULL,
    "description" varchar(150),
    "progress"    integer,
    "created_ts"  timestamp   NOT NULL,
    "update_ts"   timestamp,
    "user_id"     integer     NOT NULL
);
create sequence folder_sequence as integer increment 1;
alter table folders add constraint FK_folders_ref_User foreign key (user_id) references users (user_id) ;