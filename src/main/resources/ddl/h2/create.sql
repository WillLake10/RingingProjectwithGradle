create table method (
    methodId varchar(8) not null,
    name varchar(128),
    title varchar(128) not null,
    notation varchar(1024) not null,
    stage int not null,
    classification varchar(16),
    lengthOfLead int,
    numberOfHunts int,
    leadHead varchar(64),
    leadHeadCode varchar(4),
    symmetry varchar(64),
    notes varchar(512),
    primary key (methodId)
);