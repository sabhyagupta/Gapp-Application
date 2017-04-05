
    create table AppStatus (
        Appid int4 not null,
        Status varchar(255),
        primary key (Appid)
    );

    create table Applications (
        aid int4 not null,
        CIN int4,
        citizen varchar(255),
        dateofsubmission timestamp,
        doB timestamp,
        fname varchar(255),
        gender varchar(255),
        gpa float4 not null,
        lname varchar(255),
        phnumber int4,
        term varchar(255),
        transcript varchar(255),
        dept_dptid int4,
        pid_pid int4,
        status_Appid int4,
        user_userid int4,
        primary key (aid)
    );

    create table Department (
        dptid int4 not null,
        dptname varchar(255),
        primary key (dptid)
    );

    create table Educationbg (
        eid int4 not null,
        clgName varchar(255),
        degree varchar(255),
        degreename varchar(255),
        major varchar(255),
        yoP varchar(255),
        Aid_aid int4,
        primary key (eid)
    );

    create table Others (
        id int4 not null,
        nameField varchar(255),
        required boolean,
        typeField varchar(255),
        Aid_aid int4,
        department_dptid int4,
        primary key (id)
    );

    create table Others_value (
        ftid int4 not null,
        otherValue varchar(255),
        Aid_aid int4,
        otherId_id int4,
        primary key (ftid)
    );

    create table Role (
        Roleid int4 not null,
        RoleName varchar(255),
        primary key (Roleid)
    );

    create table logTime (
        Lid int4 not null,
        Comment varchar(255),
        Ldate date,
        Aid_aid int4,
        AppStatus_Appid int4,
        primary key (Lid)
    );

    create table programs (
        pid int4 not null,
        prgname varchar(255),
        dptid_dptid int4,
        primary key (pid)
    );

    create table user1 (
        userid int4 not null,
        Fname varchar(255),
        Lname varchar(255),
        email varchar(255),
        password varchar(255),
        rolename_Roleid int4,
        primary key (userid)
    );

    alter table Applications 
        add constraint FK_e0rnoh8u3yfhnjxjhaih3v50x 
        foreign key (dept_dptid) 
        references Department;

    alter table Applications 
        add constraint FK_cg33uh6971fa16133y5w9ax5x 
        foreign key (pid_pid) 
        references programs;

    alter table Applications 
        add constraint FK_p6uafhhxri6th5h5jmq6lfunr 
        foreign key (status_Appid) 
        references AppStatus;

    alter table Applications 
        add constraint FK_1v78m8grhk0svoukvmtl8j6ja 
        foreign key (user_userid) 
        references user1;

    alter table Educationbg 
        add constraint FK_j2yxwhy3ynd4dafcfsjuvo3kw 
        foreign key (Aid_aid) 
        references Applications;

    alter table Others 
        add constraint FK_k65krs5vwvhruul6b5mbqvhs3 
        foreign key (Aid_aid) 
        references Applications;

    alter table Others 
        add constraint FK_4kgflrhraudueut3oenpa8s8x 
        foreign key (department_dptid) 
        references Department;

    alter table Others_value 
        add constraint FK_qhoslowfo07qkpauk8yad3igr 
        foreign key (Aid_aid) 
        references Applications;

    alter table Others_value 
        add constraint FK_s2u4mfea6rh7c61j5hi7s9taq 
        foreign key (otherId_id) 
        references Others;

    alter table logTime 
        add constraint FK_frlnc50gqpc7mxc6yxohjxos7 
        foreign key (Aid_aid) 
        references Applications;

    alter table logTime 
        add constraint FK_fiohrxvkasyxpktp5ip1yr14o 
        foreign key (AppStatus_Appid) 
        references AppStatus;

    alter table programs 
        add constraint FK_662esthv6ydg9x46kae1gnd7f 
        foreign key (dptid_dptid) 
        references Department;

    alter table user1 
        add constraint FK_c4ne2dru4ns4f815q5gyqyofc 
        foreign key (rolename_Roleid) 
        references Role;

    create sequence hibernate_sequence;
