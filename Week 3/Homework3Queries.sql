/* 1 */
select cus_fname, cus_lname, cus_areacode 
from customer;

/* 2 */
select inv_number, inv_date 
from invoice 
where cus_code = 10011;

/* 3 */
select line.prod_code, product.prod_quant 
from product 
natural join line where line.inv_number = 1001;

/* 4 */
select prod_desc, prod_price
from product
natural join vendor where vendor.vend_contact = "Smith";

/* 5 */
select product.prod_desc, vendor.vend_name, vendor.vend_phone
from vendor
natural join product where product.prod_price < 50;

/* 6 */