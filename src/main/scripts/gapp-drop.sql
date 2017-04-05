
    alter table Applications 
        drop constraint FK_e0rnoh8u3yfhnjxjhaih3v50x;

    alter table Applications 
        drop constraint FK_cg33uh6971fa16133y5w9ax5x;

    alter table Applications 
        drop constraint FK_p6uafhhxri6th5h5jmq6lfunr;

    alter table Applications 
        drop constraint FK_1v78m8grhk0svoukvmtl8j6ja;

    alter table Educationbg 
        drop constraint FK_j2yxwhy3ynd4dafcfsjuvo3kw;

    alter table Others 
        drop constraint FK_k65krs5vwvhruul6b5mbqvhs3;

    alter table Others 
        drop constraint FK_4kgflrhraudueut3oenpa8s8x;

    alter table Others_value 
        drop constraint FK_qhoslowfo07qkpauk8yad3igr;

    alter table Others_value 
        drop constraint FK_s2u4mfea6rh7c61j5hi7s9taq;

    alter table logTime 
        drop constraint FK_frlnc50gqpc7mxc6yxohjxos7;

    alter table logTime 
        drop constraint FK_fiohrxvkasyxpktp5ip1yr14o;

    alter table programs 
        drop constraint FK_662esthv6ydg9x46kae1gnd7f;

    alter table user1 
        drop constraint FK_c4ne2dru4ns4f815q5gyqyofc;

    drop table if exists AppStatus cascade;

    drop table if exists Applications cascade;

    drop table if exists Department cascade;

    drop table if exists Educationbg cascade;

    drop table if exists Others cascade;

    drop table if exists Others_value cascade;

    drop table if exists Role cascade;

    drop table if exists logTime cascade;

    drop table if exists programs cascade;

    drop table if exists user1 cascade;

    drop sequence hibernate_sequence;