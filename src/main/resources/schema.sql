CREATE TABLE IF NOT EXISTS USERS
(
    ID                   BIGINT PRIMARY KEY AUTO_INCREMENT,
    LOGIN_ID             VARCHAR(255) NOT NULL UNIQUE,
    USER_NAME            VARCHAR(255),
    PICTURE              VARCHAR(100),
    PHONE_NUMBER         VARCHAR(100),
    MOBILE_PHONE_NUMBER  VARCHAR(100),
    EMAIL                VARCHAR(100),
    POSITION_ID          VARCHAR(32),
    DUTY_ID              VARCHAR(32),
    PWD                  VARCHAR(60),
    PWD_CHANGE_YN        CHAR(1)               DEFAULT 'Y',
    PWD_CHANGED_AT       TIMESTAMP             DEFAULT CURRENT_TIMESTAMP,
    LOGIN_FAIL_CNT       INT                   DEFAULT 0,
    LOCK_YN              CHAR(1)      NOT NULL DEFAULT 'N',
    ENABLE_YN            CHAR(1)      NOT NULL DEFAULT 'Y',
    EXPR_YN              CHAR(1)      NOT NULL DEFAULT 'N',
    CREATED_AT           TIMESTAMP,
    LAST_UPDATED_AT      TIMESTAMP
);

CREATE TABLE IF NOT EXISTS CODE
(
    SEQ                  BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    CODE_ID              VARCHAR(32)        NOT NULL UNIQUE,
    PAR_CODE_ID          VARCHAR(32)        NULL,
    CODE_NAME            VARCHAR(100)       NULL,
    CODE_VALUE           VARCHAR(20)        NULL,
    CODE_EXPLANATION     VARCHAR(4000)      NULL,
    USE_YN               CHAR(1)            NULL DEFAULT 'Y',
    SORT_NUMBER          INT                NULL,
    CREATED_AT           TIMESTAMP               DEFAULT CURRENT_TIMESTAMP,
    LAST_UPDATED_AT      TIMESTAMP               DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
