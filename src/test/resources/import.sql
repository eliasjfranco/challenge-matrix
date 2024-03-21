insert into grupoo (brand_id, brand_name) values (1, 'ZARA');
insert into PRODUCT (product_id, brand_id, product_name) values (35455, 1, 'Galletitas');
insert into PRICE_LIST (price_list, brand_id, start_date, end_date, priority) values (1, 1,'2020-06-14 00:00:00', '2020-12-31 23:59:59', 0);
insert into PRICE_LIST (price_list, brand_id, start_date, end_date, priority) values (2, 1,'2020-06-14 15:00:00', '2020-06-14 18:30:00', 1);
insert into PRICE_LIST (price_list, brand_id, start_date, end_date, priority) values (3, 1,'2020-06-15 00:00:00', '2020-06-15 11:00:00', 1);
insert into PRICE_LIST (price_list, brand_id, start_date, end_date, priority) values (4, 1,'2020-06-15 16:00:00', '2020-12-31 23:59:59', 1);
insert into product_price(price_list, product_id, brand_id, price, currency) values (1,35455,1,35.50,'EUR');
insert into product_price(price_list, product_id, brand_id, price, currency) values (2,35455,1,24.45,'EUR');
insert into product_price(price_list, product_id, brand_id, price, currency) values (3,35455,1,30.50,'EUR');
insert into product_price(price_list, product_id, brand_id, price, currency) values (4,35455,1,38.95,'EUR');

