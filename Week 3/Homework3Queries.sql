select cus_fname, cus_lname, cus_areacode from customer;

select inv_number, inv_date from invoice where cus_code = 10011;

select prod_code, prod_quant from customer where inv_number = 10011;