-- begin DBCEDC_COMMENT
alter table DBCEDC_COMMENT add constraint FK_DBCEDC_COMMENT_USER foreign key (USER_ID) references SEC_USER(ID)^
create index IDX_DBCEDC_COMMENT_USER on DBCEDC_COMMENT (USER_ID)^
-- end DBCEDC_COMMENT
