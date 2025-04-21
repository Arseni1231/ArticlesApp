
    create table article (
        author_id bigint,
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        updated_at datetime(6) not null,
        description varchar(50) not null,
        slug varchar(50) not null,
        title varchar(50) not null,
        content varchar(1000) not null,
        primary key (id)
    ) engine=InnoDB;

    create table article_tag (
        arcicle_id bigint not null,
        tag_id bigint not null
    ) engine=InnoDB;

    create table tag (
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        name varchar(20) not null,
        primary key (id)
    ) engine=InnoDB;

    create table users (
        author_id bigint,
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        email varchar(30) not null,
        username varchar(30) not null,
        image_url varchar(200) not null,
        password varchar(200) not null,
        bio varchar(500) not null,
        primary key (id)
    ) engine=InnoDB;

    alter table article 
       add constraint FKmjgtny2i22jf4dqncmd436s0u 
       foreign key (author_id) 
       references users (id);

    alter table article_tag 
       add constraint FKdxjw0bdnwduhd570fm2e92mtu 
       foreign key (tag_id) 
       references article (id);

    alter table article_tag 
       add constraint FKeu8ljhuxa2j77cd94bsyicqle 
       foreign key (arcicle_id) 
       references tag (id);

    alter table users 
       add constraint FK2sdiasqrqjqihb6xxpwkq5k2c 
       foreign key (author_id) 
       references users (id);

    create table article (
        author_id bigint,
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        updated_at datetime(6) not null,
        description varchar(50) not null,
        slug varchar(50) not null,
        title varchar(50) not null,
        content varchar(1000) not null,
        primary key (id)
    ) engine=InnoDB;

    create table article_tag (
        arcicle_id bigint not null,
        tag_id bigint not null
    ) engine=InnoDB;

    create table tag (
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        name varchar(20) not null,
        primary key (id)
    ) engine=InnoDB;

    create table users (
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        email varchar(30) not null,
        username varchar(30) not null,
        image_url varchar(200) not null,
        password varchar(200) not null,
        bio varchar(500) not null,
        primary key (id)
    ) engine=InnoDB;

    alter table article 
       add constraint FKmjgtny2i22jf4dqncmd436s0u 
       foreign key (author_id) 
       references users (id);

    alter table article_tag 
       add constraint FKdxjw0bdnwduhd570fm2e92mtu 
       foreign key (tag_id) 
       references article (id);

    alter table article_tag 
       add constraint FKeu8ljhuxa2j77cd94bsyicqle 
       foreign key (arcicle_id) 
       references tag (id);

    create table article (
        author_id bigint,
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        updated_at datetime(6) not null,
        description varchar(50) not null,
        slug varchar(50) not null,
        title varchar(50) not null,
        content varchar(1000) not null,
        primary key (id)
    ) engine=InnoDB;

    create table article_tag (
        arcicle_id bigint not null,
        tag_id bigint not null
    ) engine=InnoDB;

    create table tag (
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        name varchar(20) not null,
        primary key (id)
    ) engine=InnoDB;

    create table users (
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        email varchar(30) not null,
        username varchar(30) not null,
        image_url varchar(200) not null,
        password varchar(200) not null,
        bio varchar(500) not null,
        primary key (id)
    ) engine=InnoDB;

    alter table article 
       add constraint FKmjgtny2i22jf4dqncmd436s0u 
       foreign key (author_id) 
       references users (id);

    alter table article_tag 
       add constraint FKdxjw0bdnwduhd570fm2e92mtu 
       foreign key (tag_id) 
       references article (id);

    alter table article_tag 
       add constraint FKeu8ljhuxa2j77cd94bsyicqle 
       foreign key (arcicle_id) 
       references tag (id);

    create table article (
        author_id bigint,
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        updated_at datetime(6) not null,
        description varchar(50) not null,
        slug varchar(50) not null,
        title varchar(50) not null,
        content varchar(1000) not null,
        primary key (id)
    ) engine=InnoDB;

    create table article_tag (
        arcicle_id bigint not null,
        tag_id bigint not null
    ) engine=InnoDB;

    create table tag (
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        name varchar(20) not null,
        primary key (id)
    ) engine=InnoDB;

    create table users (
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        email varchar(30) not null,
        username varchar(30) not null,
        image_url varchar(200) not null,
        password varchar(200) not null,
        bio varchar(500) not null,
        primary key (id)
    ) engine=InnoDB;

    alter table article 
       add constraint FKmjgtny2i22jf4dqncmd436s0u 
       foreign key (author_id) 
       references users (id);

    alter table article_tag 
       add constraint FKdxjw0bdnwduhd570fm2e92mtu 
       foreign key (tag_id) 
       references article (id);

    alter table article_tag 
       add constraint FKeu8ljhuxa2j77cd94bsyicqle 
       foreign key (arcicle_id) 
       references tag (id);

    create table article (
        author_id bigint,
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        updated_at datetime(6) not null,
        description varchar(50) not null,
        slug varchar(50) not null,
        title varchar(50) not null,
        content varchar(1000) not null,
        primary key (id)
    ) engine=InnoDB;

    create table article_tag (
        arcicle_id bigint not null,
        tag_id bigint not null
    ) engine=InnoDB;

    create table tag (
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        name varchar(20) not null,
        primary key (id)
    ) engine=InnoDB;

    create table users (
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        email varchar(30) not null,
        username varchar(30) not null,
        image_url varchar(200) not null,
        password varchar(200) not null,
        bio varchar(500) not null,
        primary key (id)
    ) engine=InnoDB;

    alter table article 
       add constraint FKmjgtny2i22jf4dqncmd436s0u 
       foreign key (author_id) 
       references users (id);

    alter table article_tag 
       add constraint FKdxjw0bdnwduhd570fm2e92mtu 
       foreign key (tag_id) 
       references article (id);

    alter table article_tag 
       add constraint FKeu8ljhuxa2j77cd94bsyicqle 
       foreign key (arcicle_id) 
       references tag (id);

    create table article (
        author_id bigint,
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        updated_at datetime(6) not null,
        description varchar(50) not null,
        slug varchar(50) not null,
        title varchar(50) not null,
        content varchar(1000) not null,
        primary key (id)
    ) engine=InnoDB;

    create table article_tag (
        arcicle_id bigint not null,
        tag_id bigint not null
    ) engine=InnoDB;

    create table tag (
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        name varchar(20) not null,
        primary key (id)
    ) engine=InnoDB;

    create table users (
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        email varchar(30) not null,
        username varchar(30) not null,
        image_url varchar(200) not null,
        password varchar(200) not null,
        bio varchar(500) not null,
        primary key (id)
    ) engine=InnoDB;

    alter table article 
       add constraint FKmjgtny2i22jf4dqncmd436s0u 
       foreign key (author_id) 
       references users (id);

    alter table article_tag 
       add constraint FKdxjw0bdnwduhd570fm2e92mtu 
       foreign key (tag_id) 
       references article (id);

    alter table article_tag 
       add constraint FKeu8ljhuxa2j77cd94bsyicqle 
       foreign key (arcicle_id) 
       references tag (id);

    create table article (
        author_id bigint,
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        updated_at datetime(6) not null,
        description varchar(50) not null,
        slug varchar(50) not null,
        title varchar(50) not null,
        content varchar(1000) not null,
        primary key (id)
    ) engine=InnoDB;

    create table article_tag (
        arcicle_id bigint not null,
        tag_id bigint not null
    ) engine=InnoDB;

    create table tag (
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        name varchar(20) not null,
        primary key (id)
    ) engine=InnoDB;

    create table users (
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        email varchar(30) not null,
        username varchar(30) not null,
        image_url varchar(200) not null,
        password varchar(200) not null,
        bio varchar(500) not null,
        primary key (id)
    ) engine=InnoDB;

    alter table article 
       add constraint FKmjgtny2i22jf4dqncmd436s0u 
       foreign key (author_id) 
       references users (id);

    alter table article_tag 
       add constraint FKdxjw0bdnwduhd570fm2e92mtu 
       foreign key (tag_id) 
       references article (id);

    alter table article_tag 
       add constraint FKeu8ljhuxa2j77cd94bsyicqle 
       foreign key (arcicle_id) 
       references tag (id);

    create table article (
        author_id bigint,
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        updated_at datetime(6) not null,
        description varchar(50) not null,
        slug varchar(50) not null,
        title varchar(50) not null,
        content varchar(1000) not null,
        primary key (id)
    ) engine=InnoDB;

    create table article_tag (
        arcicle_id bigint not null,
        tag_id bigint not null
    ) engine=InnoDB;

    create table tag (
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        name varchar(20) not null,
        primary key (id)
    ) engine=InnoDB;

    create table users (
        created_at datetime(6) not null,
        id bigint not null auto_increment,
        email varchar(30) not null,
        username varchar(30) not null,
        image_url varchar(200) not null,
        password varchar(200) not null,
        bio varchar(500) not null,
        primary key (id)
    ) engine=InnoDB;

    alter table article 
       add constraint FKmjgtny2i22jf4dqncmd436s0u 
       foreign key (author_id) 
       references users (id);

    alter table article_tag 
       add constraint FKdxjw0bdnwduhd570fm2e92mtu 
       foreign key (tag_id) 
       references article (id);

    alter table article_tag 
       add constraint FKeu8ljhuxa2j77cd94bsyicqle 
       foreign key (arcicle_id) 
       references tag (id);
