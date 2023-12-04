
INSERT INTO `roles` (`name`, `description`) VALUES
    ('ADMIN', 'admin users'),
    ('DOCTOR', 'doctors');

INSERT INTO `users` (`name`, `password`) VALUES
    ('admin', '$2a$10$PsN.qU7kNqrbas/RmxN31ekarK6F3H70ToE9UE8S9sxj2xKheMg6e'),
    ('doctor', '$2a$10$OkQrAFLyg5MMUZ87uG4Rs.Oj50HES.dSe/gMgHwBjn7f3xxhYAz4G');

INSERT INTO `users_roles` (`med_user_name`, `roles_name`) VALUES
    ('admin', 'ADMIN'),
    ('doctor', 'DOCTOR');
