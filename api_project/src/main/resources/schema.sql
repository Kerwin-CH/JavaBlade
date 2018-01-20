
-- Table: t_users
CREATE TABLE t_users ( 
    uid      INTEGER     PRIMARY KEY AUTOINCREMENT
                         NOT NULL
                         UNIQUE,
    username CHAR( 20 )  NOT NULL
                         UNIQUE,
    password CHAR( 16 )  NOT NULL,
    email    CHAR        NOT NULL 
);

INSERT INTO [t_users] ([uid], [username], [password], [email]) VALUES (1, 'wanwan1', 'wanwan1', 'wanwan1');
INSERT INTO [t_users] ([uid], [username], [password], [email]) VALUES (2, 'liuwan', 'liuwan', 'liuwan');
INSERT INTO [t_users] ([uid], [username], [password], [email]) VALUES (3, 'wanzai', 'wasdwasd', '1458476478@qq.com');

-- Table: t_notes
CREATE TABLE t_notes ( 
    noteid  INTEGER PRIMARY KEY
                    NOT NULL
                    UNIQUE,
    content CHAR,
    uid     INT     NOT NULL
                    DEFAULT ( 0 ) 
);

INSERT INTO [t_notes] ([noteid], [content], [uid]) VALUES (1, '创建一个 普通 的 Maven 工程，再次提示 Blade 只需要你创建普通的工程！！！跟 Tomcat 什么的没有关系，请摆脱你只会J2EE那套', 2);
INSERT INTO [t_notes] ([noteid], [content], [uid]) VALUES (2, '创建一个 普通 的 Maven 工程，再次提示 Blade 只需要你创建普通的工程！！！跟 Tomcat 什么的没有关系，请摆脱你只会J2EE那套', 2);
INSERT INTO [t_notes] ([noteid], [content], [uid]) VALUES (3, '创建一个 普通 的 Maven 工程，再次提示 Blade 只需要你创建普通的工程！！！跟 Tomcat 什么的没有关系，请摆脱你只会J2EE那套', 2);
INSERT INTO [t_notes] ([noteid], [content], [uid]) VALUES (4, '创建一个 普通 的 Maven 工程，再次提示 Blade 只需要你创建普通的工程！！！跟 Tomcat 什么的没有关系，请摆脱你只会J2EE那套', 2);
INSERT INTO [t_notes] ([noteid], [content], [uid]) VALUES (5, '创建一个 普通 的 Maven 工程，再次提示 Blade 只需要你创建普通的工程！！！跟 Tomcat 什么的没有关系，请摆脱你只会J2EE那套', 2);
INSERT INTO [t_notes] ([noteid], [content], [uid]) VALUES (6, '创建一个 普通 的 Maven 工程，再次提示 Blade 只需要你创建普通的工程！！！跟 Tomcat 什么的没有关系，请摆脱你只会J2EE那套', 2);
INSERT INTO [t_notes] ([noteid], [content], [uid]) VALUES (7, '创建一个 普通 的 Maven 工程，再次提示 Blade 只需要你创建普通的工程！！！跟 Tomcat 什么的没有关系，请摆脱你只会J2EE那套', 2);
INSERT INTO [t_notes] ([noteid], [content], [uid]) VALUES (8, '创建一个 普通 的 Maven 工程，再次提示 Blade 只需要你创建普通的工程！！！跟 Tomcat 什么的没有关系，请摆脱你只会J2EE那套', 2);
INSERT INTO [t_notes] ([noteid], [content], [uid]) VALUES (9, '创建一个 普通 的 Maven 工程，再次提示 Blade 只需要你创建普通的工程！！！跟 Tomcat 什么的没有关系，请摆脱你只会J2EE那套', 2);
INSERT INTO [t_notes] ([noteid], [content], [uid]) VALUES (10, '创建一个 普通 的 Maven 工程，再次提示 Blade 只需要你创建普通的工程！！！跟 Tomcat 什么的没有关系，请摆脱你只会J2EE那套', 3);
INSERT INTO [t_notes] ([noteid], [content], [uid]) VALUES (11, 'adasdasdasdasdsadsad', 3);
INSERT INTO [t_notes] ([noteid], [content], [uid]) VALUES (12, 'adasdasdasdasdsadsad', 3);
INSERT INTO [t_notes] ([noteid], [content], [uid]) VALUES (13, 'adasdasdasdasdsadsad', 3);
INSERT INTO [t_notes] ([noteid], [content], [uid]) VALUES (14, 'adasdasdasdasdsadsad', 3);
INSERT INTO [t_notes] ([noteid], [content], [uid]) VALUES (15, 'adasdasdasdasdsadsad', 3);
