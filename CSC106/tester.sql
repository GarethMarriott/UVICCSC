-- Seuss_Data.sql
-- CSC 106 - Spring 2017
--
-- Use the command '.read Seuss_Data.sql' in sqlite3 to import the
-- schema and data below. It is normal for errors to be reported on lines 10, 11, and 12.
--
-- Ariel Webster - 03/02/2016

-- If the tables already exist, delete them --
drop table characters;
drop table books;

-----------------------
-- Create the tables --
-----------------------
create table characters( name text, title text, human int, year int);
create table books( title text, year int, pages int);
---------------------------------
-- Insert data into each table --
---------------------------------
insert into characters values('Cat in the Hat', 'The Cat in the Hat', 0, 1958);
insert into characters values('Sally', 'The Cat in the Hat', 1, 1958);
insert into characters values('Thing One', 'The Cat in the Hat', 0, 1958);
insert into characters values('Thing Two', 'The Cat in the Hat', 0, 1958);
insert into characters values('Fish', 'The Cat in the Hat', 0, 1958);
insert into characters values('Sallys Brother', 'The Cat in the Hat', 1, 1958);

insert into characters values('Sam-I-Am', 'Green Eggs and Ham', 0, 1960);

insert into characters values('Once-ler', 'The Lorax', 1, 1971);
insert into characters values('Ted', 'The Lorax', 1, 1971);
insert into characters values('OHare', 'The Lorax', 1, 1971);
insert into characters values('Once-ler', 'The Lorax', 1, 1971);

insert into characters values('The Grinch', 'How the Grinch Stole Christmas', 0, 1957);
insert into characters values('Cindy-Lou Who', 'How the Grinch Stole Christmas', 1, 1957);
insert into characters values('Max', 'How the Grinch Stole Christmas', 0, 1971);

insert into characters values('Mr. Brown', 'Mr. Brown Can Moo! Can You?', 1, 1970);

insert into characters values('Horton', 'Horton Hears a Who', 0, 1954);
insert into characters values('Jo-Jo', 'Horton Hears a Who', 0, 1954);
insert into characters values('Mayor of Who-ville', 'Horton Hears a Who', 0, 1954);
insert into characters values('Wickersham Brothers ', 'Horton Hears a Who', 0, 1954);
insert into characters values('Kangaroos', 'Horton Hears a Who', 0, 1954);

insert into characters values('Horton', 'Horton Hatches the Egg', 0, 1940);
insert into characters values('Mayzie', 'Horton Hatches the Egg', 0, 1940);


insert into books values('The Cat in the Hat', 1958, 61);
insert into books values('Green Eggs and Ham', 1960, 62);
insert into books values('The Lorax', 1971, 72);
insert into books values('How the Grinch Stole Christmas', 1957, 64);
insert into books values('Mr. Brown Can Moo! Can You?', 1970, 32);
insert into books values('Horton Hears a Who', 1954, 64);
insert into books values('Horton Hatches the Egg', 1940, 64);


.mode column
.header on
