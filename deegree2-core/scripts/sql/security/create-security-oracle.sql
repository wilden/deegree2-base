drop table sec_services;
drop table sec_services_objects;

create table sec_services (id integer, address varchar2(2000), title varchar2(255), type varchar2(3));
create table sec_services_objects (serviceid integer, name varchar2(255), title varchar2(255));

create table sec_jt_roles_services (fk_roles integer, fk_services integer);

DROP TABLE SEC_GROUPS;
CREATE TABLE "SEC_GROUPS" (
"ID" NUMBER(10),
CONSTRAINT pk_groupid PRIMARY KEY (id)
)  NOCACHE NOLOGGING;

DROP TABLE SEC_JT_GROUPS_GROUPS;
CREATE TABLE "SEC_JT_GROUPS_GROUPS" (
"FK_GROUPS_MEMBER" NUMBER(10),
"FK_GROUPS" NUMBER(10)
)  NOCACHE NOLOGGING;

DROP TABLE SEC_JT_GROUPS_ROLES;
CREATE TABLE "SEC_JT_GROUPS_ROLES" (
"FK_GROUPS" NUMBER(10),
"FK_ROLES" NUMBER(10)
)  NOCACHE NOLOGGING;

DROP TABLE SEC_JT_ROLES_PRIVILEGES;
CREATE TABLE "SEC_JT_ROLES_PRIVILEGES" (
"FK_ROLES" NUMBER(10),
"FK_PRIVILEGES" NUMBER(10),
"CONSTRAINTS" CLOB
)  NOCACHE NOLOGGING;

DROP TABLE SEC_JT_ROLES_SECOBJECTS;
CREATE TABLE "SEC_JT_ROLES_SECOBJECTS" (
"FK_ROLES" NUMBER(10),
"FK_SECURABLE_OBJECTS" NUMBER(10),
"FK_RIGHTS" NUMBER(10),
"CONSTRAINTS" CLOB
)  NOCACHE NOLOGGING;

DROP TABLE SEC_JT_USERS_GROUPS;
CREATE TABLE "SEC_JT_USERS_GROUPS" (
"FK_USERS" NUMBER(10),
"FK_GROUPS" NUMBER(10)
)  NOCACHE NOLOGGING;

DROP TABLE SEC_JT_USERS_ROLES;
CREATE TABLE "SEC_JT_USERS_ROLES" (
"FK_USERS" NUMBER(10),
"FK_ROLES" NUMBER(10)
)  NOCACHE NOLOGGING;

DROP TABLE SEC_PRIVILEGES;
CREATE TABLE "SEC_PRIVILEGES" (
"ID" NUMBER(10),
"NAME" VARCHAR(50),
CONSTRAINT pk_privilegeid PRIMARY KEY (id)
)  NOCACHE NOLOGGING;

DROP TABLE SEC_RIGHTS;
CREATE TABLE "SEC_RIGHTS" (
"ID" NUMBER(10),
"NAME" VARCHAR(50),
CONSTRAINT pk_rightsid PRIMARY KEY (id)
)  NOCACHE NOLOGGING;

DROP TABLE SEC_ROLES;
CREATE TABLE "SEC_ROLES" (
"ID" NUMBER(10),
CONSTRAINT pk_rolesid PRIMARY KEY (id)
)  NOCACHE NOLOGGING;

DROP TABLE SEC_SECURABLE_OBJECTS;
CREATE TABLE "SEC_SECURABLE_OBJECTS" (
"ID" NUMBER(10),
"NAME" VARCHAR(255),
"TITLE" VARCHAR(255),
CONSTRAINT pk_securable_objectsid PRIMARY KEY (id)
) NOCACHE NOLOGGING;

DROP TABLE SEC_SECURED_OBJECT_TYPES;
CREATE TABLE "SEC_SECURED_OBJECT_TYPES" (
"ID" NUMBER(10),
"NAME" VARCHAR(50),
CONSTRAINT pk_secured_object_typessid PRIMARY KEY (id)
) NOCACHE NOLOGGING;

DROP TABLE SEC_SECURED_OBJECTS;
CREATE TABLE "SEC_SECURED_OBJECTS" (
"ID" NUMBER(10),
"FK_SECURED_OBJECT_TYPES" NUMBER(10),
CONSTRAINT pk_secured_objectsid PRIMARY KEY (id)
) NOCACHE NOLOGGING;

DROP TABLE SEC_USERS;
CREATE TABLE "SEC_USERS" (
"ID" NUMBER(10),
"PASSWORD" VARCHAR(255),
"FIRSTNAME" VARCHAR(255),
"LASTNAME" VARCHAR(255),
"EMAIL" VARCHAR(255),
CONSTRAINT pk_sec_usersidentification PRIMARY KEY (id)
) NOCACHE NOLOGGING;

DELETE FROM SEC_JT_GROUPS_GROUPS;
DELETE FROM SEC_JT_GROUPS_ROLES;
DELETE FROM SEC_JT_ROLES_PRIVILEGES;
DELETE FROM SEC_JT_ROLES_SECOBJECTS;
DELETE FROM SEC_JT_USERS_GROUPS;
DELETE FROM SEC_JT_USERS_ROLES;
DELETE FROM SEC_PRIVILEGES;
DELETE FROM SEC_RIGHTS;
DELETE FROM SEC_ROLES;
DELETE FROM SEC_USERS;
DELETE FROM SEC_GROUPS;
DELETE FROM SEC_SECURED_OBJECT_TYPES;
DELETE FROM SEC_SECURED_OBJECTS;
DELETE FROM SEC_SECURABLE_OBJECTS;

INSERT INTO "SEC_PRIVILEGES" ("ID", "NAME") VALUES (1, 'write');
INSERT INTO "SEC_PRIVILEGES" ("ID", "NAME") VALUES (2, 'adduser');
INSERT INTO "SEC_PRIVILEGES" ("ID", "NAME") VALUES (3, 'addgroup');
INSERT INTO "SEC_PRIVILEGES" ("ID", "NAME") VALUES (4, 'addrole');
INSERT INTO "SEC_PRIVILEGES" ("ID", "NAME") VALUES (5, 'addobject');

INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (1, 'access');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (2, 'query');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (3, 'delete');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (1003, 'delete_Response');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (4, 'insert');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (1004, 'insert_Response');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (5, 'execute');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (6, 'update');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (1006, 'update_Response');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (7, 'view');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (8, 'grant');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (9, 'GetMap');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (1009, 'GetMap_Response');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (10, 'GetFeatureInfo');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (1010, 'GetFeatureInfo_Response');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (11, 'GetLegendGraphic');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (1011, 'GetLegendGraphic_Response');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (13, 'GetFeature');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (1013, 'GetFeature_Response');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (14, 'DescribeFeatureType');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (1014, 'DescribeFeatureType_Response');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (15, 'GetCoverage');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (1015, 'GetCoverage_Response');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (16, 'DescribeCoverage');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (1016, 'DescribeCoverage_Response');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (17, 'GetRecords');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (1017, 'GetRecords_Response');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (18, 'GetRecordById');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (1018, 'GetRecordById_Response');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (19, 'DescribeRecordType');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (1019, 'DescribeRecordType_Response');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (20, 'GetRepositoryItem');
INSERT INTO "SEC_RIGHTS" ("ID", "NAME") VALUES (1020, 'GetRepositoryItem_Response');

INSERT INTO "SEC_SECURABLE_OBJECTS" ("ID", "NAME", "TITLE") VALUES (1, 'SEC_ADMIN', 'Security Admin User');
INSERT INTO "SEC_USERS" ("ID", "PASSWORD", "FIRSTNAME", "LASTNAME", "EMAIL") VALUES (1, 'JOSE67', 'SEC_ADMIN', 'SEC_ADMIN', NULL);

INSERT INTO "SEC_SECURABLE_OBJECTS" ("ID", "NAME", "TITLE") VALUES (2, 'SEC_ADMIN', 'Security Admin Group');
INSERT INTO "SEC_GROUPS" ("ID") VALUES (2);

INSERT INTO "SEC_SECURABLE_OBJECTS" ("ID", "NAME", "TITLE") VALUES (3, 'SEC_ADMIN', 'Security Admin Role');
INSERT INTO "SEC_ROLES" ("ID") VALUES (3);

INSERT INTO "SEC_JT_GROUPS_ROLES" ("FK_GROUPS", "FK_ROLES") VALUES (2, 3);
INSERT INTO "SEC_JT_ROLES_PRIVILEGES" ("FK_ROLES", "FK_PRIVILEGES") VALUES (3, 1);
INSERT INTO "SEC_JT_ROLES_PRIVILEGES" ("FK_ROLES", "FK_PRIVILEGES") VALUES (3, 2);
INSERT INTO "SEC_JT_ROLES_PRIVILEGES" ("FK_ROLES", "FK_PRIVILEGES") VALUES (3, 3);
INSERT INTO "SEC_JT_ROLES_PRIVILEGES" ("FK_ROLES", "FK_PRIVILEGES") VALUES (3, 4);
INSERT INTO "SEC_JT_ROLES_PRIVILEGES" ("FK_ROLES", "FK_PRIVILEGES") VALUES (3, 5);

INSERT INTO "SEC_JT_ROLES_SECOBJECTS" ("FK_ROLES", "FK_SECURABLE_OBJECTS", "FK_RIGHTS") VALUES (3, 2, 8);
INSERT INTO "SEC_JT_USERS_GROUPS" ("FK_USERS", "FK_GROUPS") VALUES (1, 2);





