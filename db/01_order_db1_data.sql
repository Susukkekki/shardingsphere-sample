\connect order_db1;

CREATE TABLE IF NOT EXISTS orders (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    product_name VARCHAR(100) NOT NULL,
    quantity INT NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 샘플 데이터 삽입
INSERT INTO orders (user_id, product_name, quantity) VALUES
(1, 'Keyboard', 2),
(2, 'Mouse', 1),
(3, 'Monitor', 1);
