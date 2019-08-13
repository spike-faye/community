create table `user` (
  `id` bigint(11) not null auto_increment,
  `account_id` varchar(100) default null,
  `name` varchar(50) default null,
  `token` varchar(36) default null,
  `gmt_create` bigint(20) default null,
  `gmt_modified` bigint(20) default null,
  `bio` varchar(256) default null,
  `avatar_url` varchar(100) default null,
  primary key (`id`)
);