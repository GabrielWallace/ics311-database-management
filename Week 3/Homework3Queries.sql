/* 1 List the First name, middle initial, last name, and area code for all customers. 
*/
SELECT customer.cus_fname, customer.cus_lname, customer.cus_areacode
FROM customer
ORDER BY customer.cus_areacode;

/* 2 List the invoice number and invoice date for all invoices of customer number 10011. 
*/
SELECT invoice.inv_number, invoice.inv_date
FROM invoice
WHERE invoice.cus_code = 10011
ORDER BY invoice.inv_number;

/* 3 List the product number and product quantity for products in invoice number 1001
*/
SELECT product.prod_code, product.prod_quant
FROM product
    JOIN line ON line.prod_code = product.prod_code
    JOIN invoice ON line.inv_number = invoice.inv_number
WHERE invoice.inv_number = 1001
ORDER BY prod_code;

/* 4 List all product description and product price supplied by vendor whose vendor
contact name is Smith
*/
SELECT product.prod_desc, product.prod_price
FROM product
    JOIN vendor ON product.vend_code = vendor.vend_code
WHERE vendor.vend_contact = "Smith"
ORDER BY prod_price;

/* 5 Produce a list of product description, vendor name, and vendor phone for all
products with price less than 50.
*/
SELECT product.prod_desc, vendor.vend_name, vendor.vend_phone
FROM product
    JOIN vendor ON vendor.vend_code = product.vend_code
WHERE product.prod_price < 50
ORDER BY vend_name;

/* 6 For each product bought by a customer, list product description and
customer’s first name and last name.
*/
SELECT prod_desc, cus_fname, cus_lname
FROM customer
    JOIN invoice ON customer.cus_code = invoice.cus_code
    JOIN line ON line.inv_number = invoice.inv_number
    JOIN product ON product.prod_code = line.prod_code
ORDER BY cus_lname;