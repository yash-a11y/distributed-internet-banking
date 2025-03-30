CREATE TABLE `banking_core_user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) DEFAULT NULL,
  `first_name` VARCHAR(255) DEFAULT NULL,
  `identification_number` VARCHAR(255) DEFAULT NULL,
  `last_name` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `banking_core_account` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `actual_balance` DECIMAL(19,2) DEFAULT NULL,
  `available_balance` DECIMAL(19,2) DEFAULT NULL,
  `number` VARCHAR(255) DEFAULT NULL,
  `status` VARCHAR(255) DEFAULT NULL,
  `type` VARCHAR(255) DEFAULT NULL,
  `user_id` BIGINT(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user` (`user_id`),
  CONSTRAINT `FK_user` FOREIGN KEY (`user_id`) REFERENCES `banking_core_user` (`id`)
);

CREATE TABLE `banking_core_utility_account` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(255) DEFAULT NULL,
  `provider_name` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `banking_core_user` (`id`, `email`, `first_name`, `identification_number`, `last_name`)
VALUES
  (1, 'sam@gmail.com', 'Sam', '808829932V', 'Silva'),
  (2, 'guru@gmail.com', 'Guru', '901830556V', 'Darmaraj'),
  (3, 'ragu@gmail.com', 'Ragu', '348829932V', 'Sivaraj'),
  (4, 'randor@gmail.com', 'Randor', '842829932V', 'Manoon');

INSERT INTO `banking_core_account` (`actual_balance`, `available_balance`, `number`, `status`, `type`, `user_id`)
VALUES
  (100000.00, 100000.00, '100015003000', 'ACTIVE', 'SAVINGS_ACCOUNT', 1),
  (100000.00, 100000.00, '100015003001', 'ACTIVE', 'SAVINGS_ACCOUNT', 1),
  (100000.00, 100000.00, '100015003002', 'ACTIVE', 'SAVINGS_ACCOUNT', 2),
  (12000.00, 12000.00, '100015003003', 'ACTIVE', 'SAVINGS_ACCOUNT', 2),
  (365023.00, 365023.00, '100015003010', 'ACTIVE', 'SAVINGS_ACCOUNT', 4);

INSERT INTO `banking_core_utility_account` (`number`, `provider_name`)
VALUES
  ('8203232565', 'VODAFONE'),
  ('5464546545', 'VERIZON'),
  ('6546456464', 'SINGTEL');
