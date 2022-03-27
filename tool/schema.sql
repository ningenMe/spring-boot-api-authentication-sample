CREATE TABLE `web_user` (
  `code`  varchar(255) NOT NULL,
  `id`    varchar(255) NOT NULL,
  `mail`  varchar(255) NOT NULL,
  `encrypted_password`  varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`code`,`id`),
  UNIQUE KEY (`mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
