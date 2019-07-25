CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NOT NULL COMMENT '父类ID',
  `type` int(11) DEFAULT NULL COMMENT '父类类型',
  `commentator` int(11) DEFAULT NULL COMMENT '评论人ID',
  `gmt_create` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `like_count` bigint(20) DEFAULT '0' COMMENT '点赞数',
  PRIMARY KEY (`id`)
);