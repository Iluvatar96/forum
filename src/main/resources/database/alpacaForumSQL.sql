CREATE DATABASE  IF NOT EXISTS `alpaca`;
USE  `alpaca`;

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(255) NOT NULL,
  `is_premium` tinyint(1) NOT NULL DEFAULT '0',
  `created_at` datetime NOT NULL,
  `e_mail` varchar(30) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `description` varchar(255) NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_user_role_roleid_idx` (`role_id`),
  CONSTRAINT `fk_user_role_roleid` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_role_userid` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `tags` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `discussion_groups` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `owner_id` int(11) NOT NULL,
  `is_private` tinyint(1) NOT NULL DEFAULT '0',
  `access_password` varchar(255) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `group_info` text,
  `rules` text,
  `short_description` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`group_id`),
  KEY `discussion_groups_users_fk` (`owner_id`),
  CONSTRAINT `discussion_groups_users_fk` FOREIGN KEY (`owner_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `posts` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `topic` varchar(50) NOT NULL,
  `content` text NOT NULL,
  `group_id` int(11) NOT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`post_id`),
  KEY `posts_discussion_groups_fk` (`group_id`),
  KEY `posts_users_fk` (`user_id`),
  CONSTRAINT `posts_discussion_groups_fk` FOREIGN KEY (`group_id`) REFERENCES `discussion_groups` (`group_id`),
  CONSTRAINT `posts_users_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `comments` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `content` text NOT NULL,
  `post_id` int(11) NOT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `comments_posts_fk` (`post_id`),
  KEY `comments_users_fk` (`user_id`),
  CONSTRAINT `comments_posts_fk` FOREIGN KEY (`post_id`) REFERENCES `posts` (`post_id`),
  CONSTRAINT `comments_users_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;



CREATE TABLE IF NOT EXISTS `group_tags` (
  `group_tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  PRIMARY KEY (`group_tag_id`),
  UNIQUE KEY `group_tags_un` (`group_id`,`tag_id`),
  KEY `group_tags_tags_fk` (`tag_id`),
  CONSTRAINT `group_tags_discussion_groups_fk` FOREIGN KEY (`group_id`) REFERENCES `discussion_groups` (`group_id`),
  CONSTRAINT `group_tags_tags_fk` FOREIGN KEY (`tag_id`) REFERENCES `tags` (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `moderators` (
  `moderator_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  PRIMARY KEY (`moderator_id`),
  UNIQUE KEY `moderators_un` (`user_id`,`group_id`),
  KEY `moderators_discussion_groups_fk` (`group_id`),
  CONSTRAINT `moderators_discussion_groups_fk` FOREIGN KEY (`group_id`) REFERENCES `discussion_groups` (`group_id`),
  CONSTRAINT `moderators_users_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `notifications` (
  `notification_id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `sender_id` int(11) NOT NULL,
  `recipient_id` int(11) NOT NULL,
  `type` enum('comment','post') NOT NULL,
  `object_id` int(11) NOT NULL,
  `unread` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`notification_id`),
  KEY `notifications_users_fk` (`sender_id`),
  KEY `notifications_users_fk_1` (`recipient_id`),
  CONSTRAINT `notifications_users_fk` FOREIGN KEY (`sender_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `notifications_users_fk_1` FOREIGN KEY (`recipient_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;



CREATE TABLE IF NOT EXISTS `subscriptions` (
  `subscription_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `subscribed_at` date NOT NULL,
  PRIMARY KEY (`subscription_id`),
  UNIQUE KEY `subscribed_groups_un` (`group_id`,`user_id`),
  KEY `subscribed_groups_users_fk` (`user_id`),
  CONSTRAINT `subscribed_groups_discussion_groups_fk` FOREIGN KEY (`group_id`) REFERENCES `discussion_groups` (`group_id`),
  CONSTRAINT `subscribed_groups_users_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;



CREATE TABLE  IF NOT EXISTS `user_bans` (
  `user_ban_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`user_ban_id`),
  UNIQUE KEY `user_bans_un` (`group_id`,`user_id`),
  KEY `user_bans_users_fk` (`user_id`),
  CONSTRAINT `user_bans_discussion_groups_fk` FOREIGN KEY (`group_id`) REFERENCES `discussion_groups` (`group_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_bans_users_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE  IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(255) NOT NULL,
  `is_premium` tinyint(1) NOT NULL DEFAULT '0',
  `created_at` datetime NOT NULL,
  `e_mail` varchar(30) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;