create table achievement
(
    id              SERIAL        not null primary key,
    title           varchar(100)  not null,
    description     varchar(1000) not null,
    attribute       varchar(3)    not null,
    attribute_value int           not null
);

create table achievement_unlocked
(
    id             SERIAL not null primary key,
    user_id        int    not null,
    achievement_id int    not null,
    unlock_date    date   not null
);

create table quest
(
    id              SERIAL        not null primary key,
    main_attribute  varchar(3)    not null,
    increment_value int           not null,
    title           varchar(100)  not null,
    description     varchar(1000) not null
);

create table quest_completed
(
    id            SERIAL not null primary key,
    quest_id      int    not null,
    user_id       int    not null,
    complete_date date   not null
);

create table users
(
    id            SERIAL       not null primary key,
    login         varchar(100) not null,
    name          varchar(100) not null,
    password      varchar(100) not null,
    is_admin boolean not null
);

create table user_stats
(
    id           SERIAL not null primary key,
    user_id      int    not null,
    strength     int    not null,
    intelligent  int    not null,
    dexterity    int    not null,
    constitution int    not null
);

