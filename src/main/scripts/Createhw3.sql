create sequence hibernate_sequence2 minvalue 1;

 create table Role (
        Roleid int4 not null,
        RoleName varchar(255),
        primary key (Roleid)
    );
    insert into Role values(1,'student');
    insert into Role values(2,'student');
    insert into Role values(3,'admnistrator');
    insert into Role values(4,'staff');
    
     create table Role_user1 (
        Role_Roleid int4 not null,
        CIN_userid int4 not null
    );
    insert into Role_user1 values(1,4);
    insert into Role_user1 values(2,5);
    
     create table user1 (
        userid int4 not null,
        Fname varchar(255),
        Lname varchar(255),
        email varchar(255),
        password varchar(255),
        rolename_Roleid int4,
        primary key (userid)
    );
insert into user1 values (4, 'sabhya', 'gupta', 'sabhya@localhost.localdomain','abcd',1);
insert into user1 values (5, 'neha', 'sharma', 'neha@localhost.localdomain','abcd',2);

create table Department (
        dptid int4 not null,
        dptname varchar(255),
        prgname varchar(255),
        primary key (dptid)
    );

    insert into Department values (1, 'Accounting', 'Ms Accounting');
    insert into Department values (2, 'ComputerScience', 'Ms ComputerScience');

    create table Applications (
        Aid int4 not null,
        CIN int4,
        DoB int4,
        Phnumber int4,
        Term varchar(255),
        citizen varchar(255),
        fName varchar(255),
        gender varchar(255),
        gpa int4,
        lName varchar(255),
        transcript bytea,
        NameField_NameField varchar(255),
        comment_Lid int4,
        department_dptid int4,
        status_Appid int4,
        user_userid int4,
        primary key (Aid)
    );

    insert into Applications values (1, 1, 06/09/92,111111111,'fall 2016','indian', 'sabhya','Female',4,'gupta','\\000\\001\\002\\003\\004','Gmat',1,1,1,1);

create table logTime (
        Lid int4 not null,
        Comment varchar(255),
        Ldate date,
        Aid_Aid int4,
        AppStatus_Appid int4,
        primary key (Lid)
    );

     insert into logTime values (1, 'Gmatrequired', '1/1/2016',1,1);


      create table AppStatus (
        Appid int4 not null,
        Status varchar(255),
        Aid_Aid int4,
        comments_Lid int4,
        primary key (Appid)
    );
     
  insert into AppStatus values (1, 'review', 1,1);
  
   create table Educationbg (
        eid varchar(255) not null,
        Major varchar(255),
        YoP varchar(255),
        clgName varchar(255),
        degree varchar(255),
        degreename varchar(255),
        Aid_Aid int4,
        primary key (eid)
    );
    insert into Educationbg values (1, 'Commerce', 2015,'cal state la','Ms','Accounting',1);

   create table Applications_Educationbg (
        Applications_Aid int4 not null,
        education_eid varchar(255) not null
    );
    
    insert into Applications_Educationbg values (1,  1);

    create table Others (
        NameField varchar(255) not null,
        TypeField varchar(255),
        required boolean,
        Aid_Aid int4,
        primary key (NameField)
    );
    
   insert into Others values ('Gmat', 'Int', 'True','1');
    
 create table Department_Applications (
        Department_dptid int4 not null,
        Aid_Aid int4 not null
    );
   insert into Department_Applications values ('1','1');
    create table Department_Others (
        Department_dptid int4 not null,
        NameField_NameField varchar(255) not null
    );
    insert into Department_Others values ('1','Gmat');

    create table Others_Department (
        Others_NameField varchar(255) not null,
        department_dptid int4 not null
    );
    
   insert into Others_Department values ('Gmat',1); 
  
select * from Applications;


 delete FROM Applications;   
    
    
    alter table Applications_Educationbg 
        add constraint UK_o6fcst8cjex09pmmvjw0wu2o3 unique (education_eid);

    alter table Department_Applications 
        add constraint UK_c1m3yu1noa4gpgx34j6597mnu unique (Aid_Aid);

    alter table Role_user1 
        add constraint UK_gl6o2t65fcmyvtc9g82d4vd5x unique (CIN_userid);

    alter table AppStatus 
        add constraint FK_3j5ejp1sdeicuurgq1dh2ketd 
        foreign key (Aid_Aid) 
        references Applications;

    alter table AppStatus 
        add constraint FK_lr602axtoeclcv7oepi75xx4f 
        foreign key (comments_Lid) 
        references logTime;

    alter table Applications 
        add constraint FK_npobmsyyuluswbav2bfn1pcdk 
        foreign key (NameField_NameField) 
        references Others;

    alter table Applications 
        add constraint FK_74lj2ptet597fqwos9kihksht 
        foreign key (comment_Lid) 
        references logTime;

    alter table Applications 
        add constraint FK_mr7vyy75xdalsm4y5djjf3p0n 
        foreign key (department_dptid) 
        references Department;

    alter table Applications 
        add constraint FK_p6uafhhxri6th5h5jmq6lfunr 
        foreign key (status_Appid) 
        references AppStatus;

    alter table Applications 
        add constraint FK_1v78m8grhk0svoukvmtl8j6ja 
        foreign key (user_userid) 
        references user1;

    alter table Applications_Educationbg 
        add constraint FK_o6fcst8cjex09pmmvjw0wu2o3 
        foreign key (education_eid) 
        references Educationbg;

    alter table Applications_Educationbg 
        add constraint FK_nksn09cefk8n4r361m77tg4db 
        foreign key (Applications_Aid) 
        references Applications;

    alter table Department_Applications 
        add constraint FK_c1m3yu1noa4gpgx34j6597mnu 
        foreign key (Aid_Aid) 
        references Applications;

    alter table Department_Applications 
        add constraint FK_fwepso8r45jaxo3op1w9tye9y 
        foreign key (Department_dptid) 
        references Department;

    alter table Department_Others 
        add constraint FK_j7xqb43rr35olkwtj9nrp6uli 
        foreign key (NameField_NameField) 
        references Others;

    alter table Department_Others 
        add constraint FK_k05vr7svqa3speto07jealaxl 
        foreign key (Department_dptid) 
        references Department;

    alter table Educationbg 
        add constraint FK_87x41cnsts33sgdvaf33caits 
        foreign key (Aid_Aid) 
        references Applications;

    alter table Others 
        add constraint FK_nn3d2ds42w8yv9bboptkrmev0 
        foreign key (Aid_Aid) 
        references Applications;

    alter table Others_Department 
        add constraint FK_orreupc6vrt91jlv1x0g2gdvg 
        foreign key (department_dptid) 
        references Department;

    alter table Others_Department 
        add constraint FK_co2rq2mfcqkf5a0x0l9x25djx 
        foreign key (Others_NameField) 
        references Others;

    alter table Role_user1 
        add constraint FK_gl6o2t65fcmyvtc9g82d4vd5x 
        foreign key (CIN_userid) 
        references user1;

    alter table Role_user1 
        add constraint FK_7csww51lacsyl97k6agwqufqm 
        foreign key (Role_Roleid) 
        references Role;

    alter table logTime 
        add constraint FK_kx2ekgh5hq7y480ekumjlay63 
        foreign key (Aid_Aid) 
        references Applications;

    alter table logTime 
        add constraint FK_fiohrxvkasyxpktp5ip1yr14o 
        foreign key (AppStatus_Appid) 
        references AppStatus;

    alter table user1 
        add constraint FK_c4ne2dru4ns4f815q5gyqyofc 
        foreign key (rolename_Roleid) 
        references Role;

    delete from Applications;

