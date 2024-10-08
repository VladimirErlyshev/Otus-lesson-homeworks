create table questions (
	id serial primary key,
	question_text varchar(255)
);

create table answers (
	id serial primary key,
	answer_text varchar(255) not null,
	question_id int not null,
	is_true_answer bool
);

alter table answers add foreign key (id)
references questions (id);