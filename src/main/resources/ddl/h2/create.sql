create table method (
    method_id varchar(8) not null,
    name varchar(32),
    title varchar(32) not null,
    notation varchar(128) not null,
    stage int not null,
    classification varchar(16),
    lengthOfLead int,
    numberOfHunts int,
    leadHead varchar(64),
    leadHeadCode varchar(4),
    symmetry varchar(16),
    notes varchar(512),
    primary key (method_id)
);