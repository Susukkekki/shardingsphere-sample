\connect order_db2;

CREATE TABLE IF NOT EXISTS orders (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    product_name VARCHAR(100) NOT NULL,
    quantity INT NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 샘플 데이터 삽입
INSERT INTO orders (user_id, product_name, quantity) VALUES
(101, '키보드', 10),
(102, '마우스', 3),
(103, '모니터', 153);
