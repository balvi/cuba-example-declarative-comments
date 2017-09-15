-- begin DBCEDC_CUSTOMER
create table DBCEDC_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    FIRST_NAME varchar(255),
    --
    primary key (ID)
)^
-- end DBCEDC_CUSTOMER
-- begin DBCEDC_PRODUCT
create table DBCEDC_PRODUCT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    DESCRIPTION longvarchar,
    PRODUCER varchar(255),
    PRICE decimal(19, 2) not null,
    --
    primary key (ID)
)^
-- end DBCEDC_PRODUCT
-- begin DBCEDC_COMMENT
create table DBCEDC_COMMENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TEXT longvarchar not null,
    USER_ID varchar(36) not null,
    COMMENTED_AT timestamp not null,
    ENTITY_ID varchar(36) not null,
    ENTITY_CLASS varchar(255) not null,
    --
    primary key (ID)
)^
-- end DBCEDC_COMMENT
