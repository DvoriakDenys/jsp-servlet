CREATE TABLE `reports` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `comment` varchar(255) DEFAULT NULL,
                           `created_date` datetime DEFAULT NULL,
                           `name_of_report` varchar(255) DEFAULT NULL,
                           `report` varchar(255) DEFAULT NULL,
                           `status_id` bigint DEFAULT NULL,
                           `user_id` bigint DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           KEY `FK1x8mgsplywnin33xj7j6m298n` (`status_id`),
                           KEY `FK2o32rer9hfweeylg7x8ut8rj2` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `role` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `role` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `status` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `name` varchar(255) NOT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `users` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `email` varchar(50) NOT NULL,
                         `first_name` varchar(255) NOT NULL,
                         `last_name` varchar(255) NOT NULL,
                         `middle_name` varchar(255) NOT NULL,
                         `password` varchar(255) NOT NULL,
                         `role_id` bigint DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `email_UNIQUE` (`email`),
                         KEY `FK4qu1gr772nnf6ve5af002rwya` (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci