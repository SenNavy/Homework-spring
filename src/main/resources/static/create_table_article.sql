create table tb_categories(
  cat_id int auto_increment primary key,
  cat_title varchar(150)
);

create table tb_articles(
article_id int auto_increment primary key,
article_title varchar(25),
author varchar(25),
description varchar(250),
image varchar(200),
category_id int references tb_categories(cat_id) on delete cascade on update cascade);


