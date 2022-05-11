--
-- Table structure for table `appointment_form`
--
DROP TABLE IF EXISTS `appointment_form`;

CREATE TABLE `appointment_form` (
                                    `uid`                 varchar(36)  NOT NULL,
                                    `language_code`       varchar(5)   NOT NULL,
                                    `booking_for`         varchar(50)  NOT NULL,
                                    `caregiver_full_name` varchar(100) DEFAULT NULL,
                                    `caregiver_cor`       varchar(50)  DEFAULT NULL,
                                    `caregiver_email`     varchar(50)  DEFAULT NULL,
                                    `caregiver_contact`   varchar(20)  DEFAULT NULL,
                                    `caregiver_contact_country`   varchar(5)  DEFAULT NULL,
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
                                    `patient_contact_country`   varchar(5)  DEFAULT NULL,
                                    `preferred_doctor`    varchar(100) DEFAULT NULL,
                                    `specialty`           varchar(200) DEFAULT NULL,
                                    `reason`              varchar(200) DEFAULT NULL,
                                    `preferred_date`      date         NOT NULL,
                                    `preferred_timeslot`  varchar(100) NOT NULL,
                                    `hospital_source`     varchar(50)  NOT NULL,
                                    `source_url`          varchar(200) NOT NULL,
                                    `receive_marketing`   varchar(3)   NOT NULL,
                                    `created_dt`          datetime     DEFAULT NULL,
                                    `modified_dt`         datetime     DEFAULT NULL,
                                    PRIMARY KEY (`uid`, `language_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE fms.appointment_form ADD preferred_doctor_mcr varchar(10) NULL;

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

INSERT INTO fms.email_template (uid,name,sender,recipients,subject,template) VALUES
    ('cf4fef34-eea3-43d6-beca-d1a4dcfc72ed','${hospitalSource} Appt Request for ${preferredDate} ${preferredTimeslot} by ${patientFullName}','devops@parkwaypantai.com','devops@parkwaypantai.com','Appointment Booking','Submission Details:<br/><br/>Source URL: ${sourceUrl}<br/>Date of Submission: ${createdDate}<br/>Time of Submission: ${createdTime}<br/><br/>Appointment Details:<br/><br/>Preferred Doctor: ${preferredDoctor}<br/>Specialty: ${specialty}<br/>Preferred Hospital: ${hospitalSource}<br/>Preferred Appointment Date: ${preferredDate}<br/>Preferred Timeslot: ${preferredTimeslot}<br/>Reason For Consultation: ${reason}<br/><br/>Patient Information:<br/><br/>Name: ${patientFullName}<br/>Nationality: ${patientNationality}<br/>Country: ${patientCountry}<br/>Nearest Office: ${nearestOffice}<br/>Gender: ${patientGender}<br/>Date of birth: ${patientDob}<br/>NRIC/Passport number: ${patientIdValue}<br/>Email Address: ${patientEmail}<br/>Contact No.: ${patientContactCountry} ${patientContact}<br/><br/>Additional Information:<br/><br/>Receive Marketing Messages?: ${receiveMarketing}<br/>Requested For: ${bookingFor}<br/>Requestor: ${caregiverFullName}<br/>Requestor Email: ${caregiverEmail}<br/>Requestor Country: ${caregiverCountry}<br/>Requestor Contact No.: ${caregiverContactCountry} ${caregiverContact}');

--
-- Table structure for table `enquiry_form`
--
DROP TABLE IF EXISTS `enquiry_form`;

CREATE TABLE `enquiry_form` (
                                `uid`                 varchar(36)  NOT NULL,
                                `language_code`       varchar(5)   NOT NULL,
                                `full_name`           varchar(100) NOT NULL,
                                `email`               varchar(50)  NOT NULL,
                                `mobile_number`       varchar(20)  NOT NULL,
                                `cor`                 varchar(200) NOT NULL,
                                `nearest_office`      varchar(200) NOT NULL,
                                `enquiry`             varchar(500) NOT NULL,
                                `hospital_source`     varchar(200) NOT NULL,
                                `source_url`          varchar(400) NOT NULL,
                                `receive_marketing`   varchar(3)   NOT NULL,
                                `created_dt`          datetime     DEFAULT NULL,
                                `modified_dt`         datetime     DEFAULT NULL,
                                PRIMARY KEY (`uid`, `language_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO fms.email_template (uid,name,sender,recipients,subject,template) VALUES ('cf4fef34-eea3-43d6-beca-d1a4dcfc72ed','EnquiryPatient','devops@parkwaypantai.com','intern@azlabs.sg','Thank you for your enquiry','Submission Details:<br/><br/>Hospital Source: ${hospitalSource}<br/>Source URL: ${sourceUrl}<br/><br/>Enquiry Details:<br/><br/>Full Name: ${fullName}<br/>Email: ${email}<br/>Mobile Number: ${mobileNumber}<br/>Country of Residence: ${cor}<br/>Nearest Office: ${nearestOffice}<br/><br/>Enquiry: ${enquiry}<br/><br/>Receive Marketing Messages?: ${receiveMarketing}<br/>');

INSERT INTO fms.email_template (uid,name,sender,recipients,subject,template) VALUES ('a13155ac-59ca-4bba-8179-fefc3b5ec848','EnquiryAdministrator','devops@parkwaypantai.com','intern@azlabs.sg','New enquiry','Submission Details:<br/><br/>Hospital Source: ${hospitalSource}<br/>Source URL: ${sourceUrl}<br/><br/>Enquiry Details:<br/><br/>Full Name: ${fullName}<br/>Email: ${email}<br/>Mobile Number: ${mobileNumber}<br/>Country of Residence: ${cor}<br/>Nearest Office: ${nearestOffice}<br/><br/>Enquiry: ${enquiry}<br/><br/>Receive Marketing Messages?: ${receiveMarketing}<br/>');



