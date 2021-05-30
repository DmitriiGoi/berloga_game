create table `achievement`
(
    id              int           not null primary key auto_increment,
    title           varchar(100)  not null,
    description     varchar(1000) not null,
    attribute       varchar(3)    not null,
    attribute_value int           not null
);

create table `achievement_unlocked`
(
    id             int      not null primary key auto_increment,
    user_id        int      not null,
    achievement_id int      not null,
    unlock_date    datetime not null
);

create table `quest`
(
    id              int           not null primary key auto_increment,
    main_attribute  varchar(3)    not null,
    increment_value int           not null,
    title           varchar(100)  not null,
    description     varchar(1000) not null
);

create table `quest_completed`
(
    id            int      not null primary key auto_increment,
    quest_id      int      not null,
    user_id       int      not null,
    complete_date datetime not null
);

create table `user`
(
    id            int          not null primary key auto_increment,
    user_stats_id int          not null,
    login         varchar(100) not null,
    name          varchar(100) not null,
    password      varchar(100) not null,
    is_admin      bit          not null
);

create table `user_stats`
(
    id           int not null primary key auto_increment,
    user_id      int not null,
    strength     int not null,
    intelligent  int not null,
    dexterity    int not null,
    constitution int not null
);

