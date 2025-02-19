INSERT INTO users (LOGIN_ID, USER_NAME, PICTURE, PHONE_NUMBER, MOBILE_PHONE_NUMBER, EMAIL, POSITION_ID, DUTY_ID, PWD, PWD_CHANGE_YN, PWD_CHANGED_AT, LOGIN_FAIL_CNT, LOCK_YN, ENABLE_YN, EXPR_YN, CREATED_AT, LAST_UPDATED_AT)
VALUES ('admin', 'Admin User', null, '010-1111-1111', '010-1111-1111', 'admin@example.com', null, null, '$2a$10$ycBNg3Ad85VsH11PIBl2yOWodCEuo.Ezl9MiyV/HpcF8kGr2.WK9C', 'N', null, 0, 'N', 'Y', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('user02', 'Jane Smith', null, '010-3333-3333', '010-3333-3333', 'jane.smith@example.com', 'POS002', 'DUTY001', '$2a$10$ycBNg3Ad85VsH11PIBl2yOWodCEuo.Ezl9MiyV/HpcF8kGr2.WK9C', 'N', null, 0, 'N', 'Y', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('user01', 'John Doe', null, '010-2222-2222', '010-2222-2222', 'john.doe@example.com', 'POS001', 'DUTY001', '$2a$10$ycBNg3Ad85VsH11PIBl2yOWodCEuo.Ezl9MiyV/HpcF8kGr2.WK9C', 'N', null, 0, 'N', 'Y', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('user03', 'Alice Johnson', null, '010-4444-4444', '010-4444-4444', 'alice.johnson@example.com', 'POS003', 'DUTY002', '$2a$10$ycBNg3Ad85VsH11PIBl2yOWodCEuo.Ezl9MiyV/HpcF8kGr2.WK9C', 'N', null, 0, 'N', 'Y', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('user04', 'Bob Brown', null, '010-5555-5555', '010-5555-5555', 'bob.brown@example.com', 'POS001', 'DUTY003', '$2a$10$ycBNg3Ad85VsH11PIBl2yOWodCEuo.Ezl9MiyV/HpcF8kGr2.WK9C', 'N', null, 0, 'N', 'Y', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('user05', 'Charlie Green', null, '010-6666-6666', '010-6666-6666', 'charlie.green@example.com', 'POS004', 'DUTY002', '$2a$10$ycBNg3Ad85VsH11PIBl2yOWodCEuo.Ezl9MiyV/HpcF8kGr2.WK9C', 'N', null, 1, 'Y', 'N', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('user06', 'Diana Adams', null, '010-7777-7777', '010-7777-7777', 'diana.adams@example.com', 'POS003', 'DUTY002', '$2a$10$ycBNg3Ad85VsH11PIBl2yOWodCEuo.Ezl9MiyV/HpcF8kGr2.WK9C', 'N', null, 0, 'N', 'Y', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('user07', 'Eve Carter', null, '010-8888-8888', '010-8888-8888', 'eve.carter@example.com', null, 'DUTY001', '$2a$10$ycBNg3Ad85VsH11PIBl2yOWodCEuo.Ezl9MiyV/HpcF8kGr2.WK9C', 'N', null, 0, 'N', 'Y', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('user08', 'Frank White', null, '010-9999-9999', '010-9999-9999', 'frank.white@example.com', null, null, '$2a$10$ycBNg3Ad85VsH11PIBl2yOWodCEuo.Ezl9MiyV/HpcF8kGr2.WK9C', 'N', null, 2, 'Y', 'N', 'N', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('user09', 'Grace Black', null, '010-0000-0000', '010-0000-0000', 'grace.black@example.com', 'POS002', 'DUTY003', '$2a$10$ycBNg3Ad85VsH11PIBl2yOWodCEuo.Ezl9MiyV/HpcF8kGr2.WK9C', 'N', null, 0, 'N', 'Y', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('user10', 'Henry Blue', null, '010-1010-1010', '010-1010-1010', 'henry.blue@example.com', 'POS005', 'DUTY004', '$2a$10$ycBNg3Ad85VsH11PIBl2yOWodCEuo.Ezl9MiyV/HpcF8kGr2.WK9C', 'N', null, 0, 'N', 'Y', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


INSERT INTO code (CODE_ID, PAR_CODE_ID, CODE_NAME, CODE_VALUE, CODE_EXPLANATION, USE_YN, SORT_NUMBER, CREATED_AT, LAST_UPDATED_AT)
VALUES ('GENDER', NULL, 'Gender', null, null, 'Y', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('GENDER_01', 'GENDER', 'Male', 'M', 'Male', 'Y', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('GENDER_02', 'GENDER', 'Female', 'F', 'Female', 'Y', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('STATUS', NULL, 'Status', null, null, 'Y', 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('STATUS_01', 'STATUS', 'Active', 'ACTIVE', 'Active status', 'Y', 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('STATUS_02', 'STATUS', 'Inactive', 'INACTIVE', 'Inactive status', 'Y', 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('ROLE', NULL, 'Role', null, null, 'Y', 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('ROLE_01', 'ROLE', 'Administrator', 'ADMIN', 'Administrative role', 'Y', 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('ROLE_02', 'ROLE', 'User', 'USER', 'Regular user role', 'Y', 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('PRIORITY', NULL, 'Priority', null, null, 'Y', 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('PRIORITY_01', 'PRIORITY', 'High', 'HIGH', 'High priority', 'Y', 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('PRIORITY_02', 'PRIORITY', 'Medium', 'MEDIUM', 'Medium priority', 'Y', 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('PRIORITY_03', 'PRIORITY', 'Low', 'LOW', 'Low priority', 'Y', 9, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('LANGUAGE', NULL, 'Language', null, null, 'Y', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('LANGUAGE_01', 'LANGUAGE', 'English', 'EN', 'English', 'Y', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('LANGUAGE_02', 'LANGUAGE', 'Korean', 'KO', 'Korean', 'Y', 11, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
