CREATE TABLE workplaces (
       id SERIAL PRIMARY KEY,
       buildingName TEXT,
       capacity INT,
       allotment_id INT REFERENCES allotments(id)
);