
DROP TABLE IF EXISTS "projects";
DROP TABLE IF EXISTS "departments";
DROP TABLE IF EXISTS "employees";

CREATE TABLE "employees" (
    "employeeid" BIGINT PRIMARY KEY,
    "name" TEXT NOT NULL,
    "dob" TEXT,
    "gender" CHAR(1),
    "number" TEXT,
    "role" TEXT,
    "salary" INTEGER,
    "ismanager" BOOLEAN
);





CREATE TABLE "departments" (
    "departmentid" BIGINT PRIMARY KEY,
    "departmentname" TEXT NOT NULL,
    "managerid" BIGINT,
    FOREIGN KEY ("managerid") REFERENCES "employees" ("employeeid")
);



CREATE TABLE "projects" (
    "projectId" BIGINT PRIMARY KEY,
    "projectName" TEXT NOT NULL,
    "projectBudget" BIGINT,
    "departmentid" BIGINT,
    "employeeid" BIGINT,
    FOREIGN KEY ("departmentid") REFERENCES "departments" ("departmentid"),
    FOREIGN KEY ("employeeid") REFERENCES "employees" ("employeeid")
);

