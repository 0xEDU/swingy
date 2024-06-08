CREATE TABLE characters (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL,
    level INT NOT NULL,
    exp BIGINT NOT NULL,
    attack INT NOT NULL,
    defense INT NOT NULL,
    hit_points INT NOT NULL,
    weapon VARCHAR(255),
    armor VARCHAR(255),
    helm VARCHAR(255)
);