CREATE TABLE `role` (
	`role_name` VARCHAR(255),
	`description` TEXT(65535) NOT NULL,
	PRIMARY KEY(`role_name`)
);


CREATE TABLE `user` (
	`id` INT AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL,
	`email` VARCHAR(255) NOT NULL,
	`password` VARCHAR(255) NOT NULL,
	`address` VARCHAR(255),
	`phone` VARCHAR(255),
	`profile_img` VARCHAR(255),
	`create_date` DATETIME,
	`last_modify` DATETIME,
	`isEnabled` BOOLEAN,
	`isDeleted` BOOLEAN,
	PRIMARY KEY(`id`)
);


CREATE TABLE `role_user` (
	`user_id` INT NOT NULL,
	`role_name` VARCHAR(255) NOT NULL,
	PRIMARY KEY(`user_id`, `role_name`)
);


CREATE TABLE `language` (
	`id` INT AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL,
	`status` ENUM("ACTIVE", "INACTIVE") NOT NULL,
	PRIMARY KEY(`id`)
);


CREATE TABLE `genre` (
	`id` INT AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL,
	`status` ENUM("ACTIVE", "INACTIVE") NOT NULL,
	PRIMARY KEY(`id`)
);


CREATE TABLE `country` (
	`id` INT AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL,
	`status` ENUM("ACTIVE", "INACTIVE") NOT NULL,
	PRIMARY KEY(`id`)
);


CREATE TABLE `movie` (
	`id` INT AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL,
	`access` ENUM("PAID", "FREE") NOT NULL,
	`language_id` INT NOT NULL,
	`release_date` DATE NOT NULL,
	`duration` VARCHAR(255),
	`status` ENUM("FULL", "UPDATING") NOT NULL,
	`thumbnail` TEXT(65535) NOT NULL,
	`poster` TEXT(65535) NOT NULL,
	`trailer_url` TEXT(65535) NOT NULL,
	`country_id` INT NOT NULL,
	`total_view` INT,
	`total_episode` INT NOT NULL,
	`create_date` DATETIME,
	`last_modify` DATETIME,
	PRIMARY KEY(`id`)
);


CREATE TABLE `genre_movie` (
	`genre_id` INT AUTO_INCREMENT,
	`movie_id` INT NOT NULL,
	PRIMARY KEY(`genre_id`, `movie_id`)
);


CREATE TABLE `actor` (
	`id` INT AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL,
	`bio` TEXT(65535) NOT NULL,
	`place_of_birth` DATE NOT NULL,
	`img` TEXT(65535) NOT NULL,
	PRIMARY KEY(`id`)
);


CREATE TABLE `director` (
	`id` INT AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL,
	`bio` TEXT(65535) NOT NULL,
	`place_of_birth` DATE NOT NULL,
	`img` TEXT(65535) NOT NULL,
	PRIMARY KEY(`id`)
);


CREATE TABLE `actor_movie` (
	`actor_id` INT AUTO_INCREMENT,
	`movie_id` INT NOT NULL,
	PRIMARY KEY(`actor_id`, `movie_id`)
);


CREATE TABLE `director_movie` (
	`director_id` INT AUTO_INCREMENT,
	`movie_id` INT NOT NULL,
	PRIMARY KEY(`director_id`, `movie_id`)
);


CREATE TABLE `subscription` (
	`subscription_id` INT AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL,
	`price` DOUBLE NOT NULL,
	`duration_days` INT NOT NULL,
	`device_limit` INT NOT NULL,
	`ads` BOOLEAN NOT NULL,
	`create_date` DATETIME,
	`last_modify` DATETIME,
	PRIMARY KEY(`subscription_id`)
);


CREATE TABLE `episode` (
	`id` INT AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL,
	`video_sever` TEXT(65535) NOT NULL,
	`thumbnail` TEXT(65535) NOT NULL,
	`no` INT NOT NULL,
	`movie_id` INT NOT NULL,
	`duration` VARCHAR(255) NOT NULL,
	`create_date` DATETIME NOT NULL,
	`last_modify` DATETIME NOT NULL,
	PRIMARY KEY(`id`)
);


CREATE TABLE `movie_rating` (
	`id` INT AUTO_INCREMENT,
	`user_id` INT NOT NULL,
	`movie_id` INT NOT NULL,
	`star` INT NOT NULL,
	`description` TEXT(65535),
	`create_date` DATETIME,
	`last_modify` DATETIME,
	PRIMARY KEY(`id`)
);


CREATE TABLE `permission` (
	`permission_name` VARCHAR(255) NOT NULL UNIQUE,
	`description` TEXT(65535),
	PRIMARY KEY(`permission_name`)
);


CREATE TABLE `permission_role` (
	`permission_name` VARCHAR(255) NOT NULL UNIQUE,
	`role_name` VARCHAR(255) NOT NULL,
	PRIMARY KEY(`permission_name`, `role_name`)
);


CREATE TABLE `subscription_plan` (
	`plan_id` INT NOT NULL AUTO_INCREMENT UNIQUE,
	`subscription_id` INT,
	`user_id` INT,
	`start_date` DATE,
	`expiry_date` DATE,
	`status` ENUM("ACTIVE", "INACTIVE", "CANCELED"),
	`created_at` DATETIME,
	PRIMARY KEY(`plan_id`)
);


ALTER TABLE `role_user`
ADD FOREIGN KEY(`role_name`) REFERENCES `role`(`role_name`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `role_user`
ADD FOREIGN KEY(`user_id`) REFERENCES `user`(`id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `country`
ADD FOREIGN KEY(`id`) REFERENCES `movie`(`country_id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `language`
ADD FOREIGN KEY(`id`) REFERENCES `movie`(`language_id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `actor_movie`
ADD FOREIGN KEY(`movie_id`) REFERENCES `movie`(`id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `genre_movie`
ADD FOREIGN KEY(`movie_id`) REFERENCES `movie`(`id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `director_movie`
ADD FOREIGN KEY(`movie_id`) REFERENCES `movie`(`id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `actor`
ADD FOREIGN KEY(`id`) REFERENCES `actor_movie`(`actor_id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `genre`
ADD FOREIGN KEY(`id`) REFERENCES `genre_movie`(`genre_id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `director`
ADD FOREIGN KEY(`id`) REFERENCES `director_movie`(`director_id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `episode`
ADD FOREIGN KEY(`movie_id`) REFERENCES `movie`(`id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `movie_rating`
ADD FOREIGN KEY(`user_id`) REFERENCES `user`(`id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `movie_rating`
ADD FOREIGN KEY(`movie_id`) REFERENCES `movie`(`id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `permission`
ADD FOREIGN KEY(`permission_name`) REFERENCES `permission_role`(`permission_name`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `permission_role`
ADD FOREIGN KEY(`role_name`) REFERENCES `role`(`role_name`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `subscription`
ADD FOREIGN KEY(`subscription_id`) REFERENCES `subscription_plan`(`subscription_id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `subscription_plan`
ADD FOREIGN KEY(`user_id`) REFERENCES `user`(`id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;