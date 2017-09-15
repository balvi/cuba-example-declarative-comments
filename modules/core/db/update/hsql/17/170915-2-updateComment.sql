alter table DBCEDC_COMMENT add column COMMENTED_AT timestamp ^
update DBCEDC_COMMENT set COMMENTED_AT = current_timestamp where COMMENTED_AT is null ;
alter table DBCEDC_COMMENT alter column COMMENTED_AT set not null ;
alter table DBCEDC_COMMENT drop column COMMENT_TIMESTAMP cascade ;
