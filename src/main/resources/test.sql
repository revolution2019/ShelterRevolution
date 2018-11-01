CREATE TABLE `shelter_resource` (
  `id` bigint(50) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `resource_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '资源类型',
  `resource_ownership_user_role_id` bigint(50) unsigned NOT NULL DEFAULT '0' COMMENT '所属权',
  `resource_exercise_user_role_id` bigint(50) unsigned NOT NULL DEFAULT '0' COMMENT '使用权',
  `resource_location` varchar(100) DEFAULT '' COMMENT '地址',
  `resource_lable` bigint(50) unsigned NOT NULL DEFAULT '0' COMMENT '资源标签',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2322 DEFAULT CHARSET=utf8 COMMENT='资源表';

CREATE TABLE `shelter_resource_comment` (
  `id` bigint(50) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_role_id` bigint(50) unsigned NOT NULL DEFAULT '0' COMMENT '用户角色',
  `resource_comment` varchar(100) NOT NULL DEFAULT '' COMMENT '评论',
  `resource_pictires1` varchar(2000) NOT NULL DEFAULT '' COMMENT '照片',
  `resource_pictires2` varchar(2000) NOT NULL DEFAULT '' COMMENT '照片',
  `resource_pictires3` varchar(2000) NOT NULL DEFAULT '' COMMENT '照片',
  `resource_pictires4` varchar(2000) NOT NULL DEFAULT '' COMMENT '照片',
  `resource_pictires5` varchar(2000) NOT NULL DEFAULT '' COMMENT '照片',
  `resource_pictires6` varchar(2000) NOT NULL DEFAULT '' COMMENT '照片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2322 DEFAULT CHARSET=utf8 COMMENT='资源评论表';

CREATE TABLE `shelter_user` (
  `id` bigint(50) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_name` varchar(20) NOT NULL DEFAULT '' COMMENT '用户姓名',
  `user_card_no` varchar(30) NOT NULL DEFAULT '' COMMENT '身份证',
  `user_mobile` varchar(20) NOT NULL DEFAULT '' COMMENT '联系电话',
  `user_email` varchar(100) NOT NULL DEFAULT '' COMMENT '邮箱',
  `user_nation` varchar(20) NOT NULL DEFAULT '' COMMENT '名族',
  `user_gender` tinyint(4) NOT NULL DEFAULT '0' COMMENT '性别 0 - 未知的性别 1 - 男性 2 - 女性 5 - 女性改（变）为男性 6 - 男性改（变）为女性 9 - 未说明的性别',
  `user_birth` timestamp NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '出生日期',
  `user_profession` varchar(20) NOT NULL DEFAULT '' COMMENT '职业',
  `user_income` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '月收入',
  `user_educational` varchar(20) NOT NULL DEFAULT '' COMMENT '学历',
  `user_point` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户积分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2323 DEFAULT CHARSET=utf8 COMMENT='人主体表';

CREATE TABLE `shelter_user_role` (
  `id` bigint(50) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(50) unsigned NOT NULL DEFAULT '0' COMMENT '人ID',
  `user_role` tinyint(4) NOT NULL DEFAULT '0' COMMENT '角色',
  `user_role_evaluation` bigint(20) NOT NULL DEFAULT '0' COMMENT '角色评分',
  `user_role_base_lable` bigint(50) unsigned NOT NULL DEFAULT '0' COMMENT '角色基本标签',
  `user_role_resource_lable` bigint(50) unsigned NOT NULL DEFAULT '0' COMMENT '资源需求标签',
  `user_role_user_lable` bigint(50) unsigned NOT NULL DEFAULT '0' COMMENT '角色需求标签',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2322 DEFAULT CHARSET=utf8 COMMENT='用户角色表';

CREATE TABLE `shelter_wechat` (
  `id` bigint(50) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `wechat_openid` varchar(100) NOT NULL DEFAULT '0' COMMENT 'wechat_openid',
  `wechat_unionid` varchar(100) NOT NULL DEFAULT '0' COMMENT 'wechat_unionid',
  `wechat_no` varchar(100) NOT NULL DEFAULT '0' COMMENT '微信号',
  `wechat_nickname` varchar(100) NOT NULL DEFAULT '0' COMMENT '微信昵称',
  `user_mobile` varchar(20) NOT NULL DEFAULT '' COMMENT '联系电话',
  `user_email` varchar(100) NOT NULL DEFAULT '' COMMENT '邮箱',
  `user_id` bigint(50) unsigned NOT NULL DEFAULT '0' COMMENT '人ID',
  `user_card_no` varchar(30) NOT NULL DEFAULT '' COMMENT '身份证',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2322 DEFAULT CHARSET=utf8 COMMENT='微信表';