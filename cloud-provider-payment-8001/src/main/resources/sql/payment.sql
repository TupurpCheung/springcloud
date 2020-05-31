drop table if exists `payment`;
create table `payment` (
    `id` bigint NOT NULL auto_increment comment 'id',
    `serial` varchar(200) default  '',
    primary key (`id`)
) engine = innoDB AUTO_INCREMENT = 1 default  charset  = utf8