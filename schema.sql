CREATE TABLE knowledge_packages
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(250) UNIQUE NOT NULL,
    description VARCHAR(2000)       NOT NULL,
    created_at  DATE DEFAULT (CURRENT_DATE)
);

CREATE TABLE knowledge_package_sets
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(250) UNIQUE NOT NULL
);

CREATE TABLE kpac_kpacsets
(
    kpac_set_id INT,
    kpac_id     INT,

    PRIMARY KEY (kpac_set_id, kpac_id),
    FOREIGN KEY (kpac_set_id) REFERENCES knowledge_package_sets (id) ON DELETE CASCADE,
    FOREIGN KEY (kpac_id) REFERENCES knowledge_packages (id) ON DELETE CASCADE
)
