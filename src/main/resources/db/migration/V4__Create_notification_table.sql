create table `notification` (
  `id` bigint(20) not null auto_increment,
  `notifier` bigint(20) not null comment '发送消息的人',
  `notifier_name` varchar(100) default null,
  `receiver` bigint(20) not null comment '接收消息的人',
  `outer_id` bigint(20) not null comment '外键id',
  `outer_title` varchar(256) default null,
  `type` int(11) not null comment '回复类型',
  `gmt_create` bigint(20) not null,
  `status` int(11) not null default '0' comment '未读为0，已读为1',
  primary key (`id`)
);