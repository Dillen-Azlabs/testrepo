--
-- Table structure for table `appointment_form`
--
SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `appointment_form`;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE `appointment_form` (
                                    `uid`                 varchar(36)  NOT NULL,
                                    `booking_for`         varchar(50)  NOT NULL,
                                    `caregiver_full_name` varchar(100) DEFAULT NULL,
                                    `caregiver_cor`       varchar(50)  DEFAULT NULL,
                                    `caregiver_email`     varchar(50)  DEFAULT NULL,
                                    `caregiver_contact`   varchar(20)  DEFAULT NULL,
                                    `patient_full_name`   varchar(100) NOT NULL,
                                    `patient_dob`         date         NOT NULL,
                                    `patient_gender`      varchar(10)  NOT NULL,
                                    `patient_id_type`     varchar(36)  NOT NULL,
                                    `patient_id_value`    varchar(36)  NOT NULL,
                                    `patient_nationality` varchar(50)  NOT NULL,
                                    `patient_cor`         varchar(50)  NOT NULL,
                                    `nearest_office`      varchar(100) DEFAULT NULL,
                                    `patient_email`       varchar(50)  NOT NULL,
                                    `patient_contact`     varchar(20)  NOT NULL,
                                    `preferred_doctor`    varchar(100) DEFAULT NULL,
                                    `specialty`           varchar(200) DEFAULT NULL,
                                    `reason`              varchar(200) DEFAULT NULL,
                                    `preferred_date`      date         NOT NULL,
                                    `preferred_timeslot`  varchar(100) NOT NULL,
                                    `hospital_source`     varchar(50)  NOT NULL,
                                    `language_code`       varchar(5)   NOT NULL,
                                    `created_dt`          datetime     DEFAULT NULL,
                                    `modified_dt`         datetime     DEFAULT NULL,
                                    PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `email_template`;

CREATE TABLE email_template (
                                    `uid`           varchar(36) NOT NULL,
                                    `name`          varchar(100) NOT NULL,
                                    `sender`        varchar(100) NOT NULL,
                                    `recipients`    varchar(100) NOT NULL,
                                    `subject`       varchar(100) NOT NULL,
                                    `template`      text NOT NULL,
                                    PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;