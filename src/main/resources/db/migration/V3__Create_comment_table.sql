create table `comment` (
  `id` bigint(20) not null auto_increment,
  `parent_id` bigint(20) not null comment '父类id',
  `type` int(11) default null comment '父类类型',
  `commentator` bigint(11) default null comment '评论人id',
  `gmt_create` bigint(20) default null comment '创建时间',
  `gmt_modified` bigint(20) default null comment '更新时间',
  `like_count` bigint(20) default '0' comment '点赞数',
  `content` varchar(1024) default null,
  `comment_count` int(11) default '0' comment '对该评论的回复数',
  primary key (`id`)
);