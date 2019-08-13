create table `question` (
  `id` bigint(11) not null auto_increment,
  `title` varchar(50) default null,
  `description` text character set utf8mb4 collate utf8mb4_0900_ai_ci,
  `gmt_create` bigint(20) default null,
  `gmt_modified` bigint(20) default null,
  `creator` bigint(11) default null,
  `comment_count` int(11) default '0',
  `view_count` int(11) default '0',
  `like_count` int(11) default '0',
  `tag` varchar(256) default null,
  primary key (`id`)
);