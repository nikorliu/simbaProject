/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016-09-23  星期五 14:26:00                     */
/*==============================================================*/


drop table if exists buss;

drop table if exists capability;

drop table if exists chatRecord;

drop table if exists installPackage;

drop table if exists job;

drop table if exists menu;

drop table if exists org;

drop table if exists orgExt;

drop table if exists permission;

drop table if exists processAgencySet;

drop table if exists processSet;

drop table if exists registryTable;

drop table if exists registryType;

drop table if exists role;

drop table if exists rolePermission;

drop table if exists systemUser;

drop table if exists userExt;

drop table if exists userOrg;

drop table if exists userRole;

/*==============================================================*/
/* Table: buss                                                  */
/*==============================================================*/
create table buss
(
   name                 varchar(64) not null,
   description          varchar(128),
   script               text not null,
   primary key (name)
);

/*==============================================================*/
/* Table: capability                                            */
/*==============================================================*/
create table capability
(
   id                   bigint not null auto_increment,
   ip                   varchar(64) not null,
   type                 varchar(16) not null,
   subType              varchar(64),
   dateTime             varchar(64) not null,
   value                double not null,
   primary key (id),
   key AK_Key_DateTime (dateTime),
   key AK_Key_IP (ip),
   key AK_Key_Type (type),
   key AK_Key_SubType (subType)
);

alter table capability comment '性能';

/*==============================================================*/
/* Table: chatRecord                                            */
/*==============================================================*/
create table chatRecord
(
   id                   int not null auto_increment,
   fromAccount          varchar(128) not null,
   fromName             varchar(128) not null,
   toAccount            varchar(128) not null,
   toName               varchar(128) not null,
   content              varchar(512) not null,
   sendTime             datetime not null,
   primary key (id)
);

/*==============================================================*/
/* Table: installPackage                                        */
/*==============================================================*/
create table installPackage
(
   installVersion       varchar(32) not null,
   detail               varchar(512) not null,
   fileName             varchar(64) not null,
   newest               tinyint not null,
   publishDate          varchar(32) not null,
   primary key (installVersion)
);

/*==============================================================*/
/* Table: job                                                   */
/*==============================================================*/
create table job
(
   id                   int not null auto_increment,
   name                 varchar(64) not null comment '名称',
   description          varchar(256) comment '描述',
   cronExpression       varchar(128) comment 'cron表达式',
   startTime            varchar(64) comment '开始执行时间',
   endTime              varchar(64) comment '结束执行时间',
   exeCount             int comment '执行次数',
   maxExeCount          int comment '最大执行次数',
   status               varchar(16) comment '状态',
   className            varchar(256) not null comment '完整类路径',
   methodName           varchar(128) not null comment '执行类方法名',
   delayTime            int comment '延迟时间',
   intervalTime         int comment '间隔时间',
   primary key (id)
);

alter table job comment '任务';

/*==============================================================*/
/* Table: menu                                                  */
/*==============================================================*/
create table menu
(
   id                   int not null auto_increment,
   text                 varchar(64) not null,
   parentID             int not null,
   url                  varchar(256),
   orderNo              int,
   primary key (id)
);

alter table menu comment '菜单';

/*==============================================================*/
/* Table: org                                                   */
/*==============================================================*/
create table org
(
   id                   int not null auto_increment comment '机构ID',
   text                 varchar(128) not null comment '名称',
   parentID             int not null comment '父机构ID',
   orderNo              int comment '排序',
   primary key (id)
);

alter table org comment '机构';

/*==============================================================*/
/* Table: orgExt                                                */
/*==============================================================*/
create table orgExt
(
   id                   int not null comment '机构ID',
   primary key (id)
);

alter table orgExt comment '机构扩展';

/*==============================================================*/
/* Table: permission                                            */
/*==============================================================*/
create table permission
(
   id                   int not null auto_increment,
   text                 varchar(64) not null,
   url                  varchar(512),
   parentID             int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: processAgencySet                                      */
/*==============================================================*/
create table processAgencySet
(
   id                   int not null auto_increment,
   startTime            varchar(32) not null comment '开始时间',
   endTime              varchar(32) not null comment '结束时间',
   account              varchar(64) not null comment '设置人',
   agencyAccount        varchar(64) not null comment '代理人',
   primary key (id)
);

alter table processAgencySet comment '流程代办设置';

/*==============================================================*/
/* Table: processSet                                            */
/*==============================================================*/
create table processSet
(
   id                   varchar(16) not null comment '流程ID',
   sendType             varchar(32) binary not null comment '发送类型',
   allStart             tinyint not null comment '是否所有人员都可以启动流程',
   primary key (id)
);

alter table processSet comment '流程设置';

/*==============================================================*/
/* Table: registryTable                                         */
/*==============================================================*/
create table registryTable
(
   id                   int not null auto_increment,
   code                 varchar(64) not null comment '编码',
   value                varchar(128) not null comment '值',
   typeID               int not null comment '类型ID',
   description          varchar(128) comment '描述',
   primary key (id)
);

alter table registryTable comment '注册表';

/*==============================================================*/
/* Table: registryType                                          */
/*==============================================================*/
create table registryType
(
   id                   int not null auto_increment,
   text                 varchar(128) not null comment '名称',
   parentID             int not null comment '父ID',
   primary key (id)
);

alter table registryType comment '注册类型';

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   name                 varchar(64) not null,
   description          varchar(64),
   primary key (name)
);

/*==============================================================*/
/* Table: rolePermission                                        */
/*==============================================================*/
create table rolePermission
(
   id                   int not null auto_increment,
   roleName             varchar(64) not null,
   permissionID         int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: systemUser                                            */
/*==============================================================*/
create table systemUser
(
   account              varchar(64) not null,
   name                 varchar(64) not null,
   pwd                  varchar(256) not null,
   primary key (account)
);

/*==============================================================*/
/* Table: userExt                                               */
/*==============================================================*/
create table userExt
(
   userAccount          varchar(64) not null comment '用户账号',
   primary key (userAccount)
);

alter table userExt comment '用户扩展';

/*==============================================================*/
/* Table: userOrg                                               */
/*==============================================================*/
create table userOrg
(
   id                   int not null auto_increment,
   userAccount          varchar(64) not null comment '用户账号',
   orgID                int not null comment '机构ID',
   primary key (id)
);

alter table userOrg comment '用户机构';

/*==============================================================*/
/* Table: userRole                                              */
/*==============================================================*/
create table userRole
(
   userAccount          varchar(64) not null,
   roleName             varchar(64) not null,
   primary key (userAccount, roleName)
);

