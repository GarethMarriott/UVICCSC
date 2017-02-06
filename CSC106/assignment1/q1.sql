-- *******Write your queries in this file! *******
-- A)	Write a query that returns the maximum number of pages in any of the books.
    select MAX(pages) from books;
-- B)	Write a query that returns the total number of human characters in the book “The Cat in the Hat”.
    select COUNT(human) from characters where title="The Cat in the Hat" and Human=1;
-- C)	Write a query that returns the title of all books with more than 50 pages.
    select title from books where pages>50;
-- D)	Write a query that returns the title of every book and the year it was published, ordered by the year it was published (ascending).
    select title , year from books order by year asc
