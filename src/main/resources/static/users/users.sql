#
# Created: 2022-12-10
# Author: Rudolf Radlbauer
#


using medpx;

CREATE TABLE `roles` (
     `name` varchar(255) NOT NULL,
     `description` varchar(255) DEFAULT NULL
);

CREATE TABLE `users` (
     `name` varchar(255) NOT NULL,
     `password` varchar(255) DEFAULT NULL
);

CREATE TABLE `users_roles` (
       `med_user_name` varchar(255) NOT NULL,
       `roles_name` varchar(255) NOT NULL
);

ALTER TABLE `roles`
    ADD PRIMARY KEY (`name`);

ALTER TABLE `users`
    ADD PRIMARY KEY (`name`);

ALTER TABLE `users_roles`
    ADD KEY `FKmi9sfx618v14gm89cyw408hqu` (`roles_name`),
  ADD KEY `FKm1so261ijqcjnsutk7od4otby` (`med_user_name`);


INSERT INTO `roles` (`name`, `description`) VALUES
    ('ADMIN', 'admin users'),
    ('DOCTOR', 'doctors');


# admin/admin
INSERT INTO `users` (`name`, `password`) VALUES
    ('admin', '$2a$10$PsN.qU7kNqrbas/RmxN31ekarK6F3H70ToE9UE8S9sxj2xKheMg6e');


INSERT INTO `users_roles` (`med_user_name`, `roles_name`) VALUES
    ('admin', 'ADMIN');
