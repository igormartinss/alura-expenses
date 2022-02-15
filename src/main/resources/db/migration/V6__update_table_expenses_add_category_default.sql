update expenses set category = 'OTHERS' where category = '';
update expenses set category = 'OTHERS' where category is null;