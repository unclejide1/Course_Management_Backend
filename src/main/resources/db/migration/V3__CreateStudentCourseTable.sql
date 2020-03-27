CREATE TABLE IF NOT EXISTS course (
    course_id UUID PRIMARY KEY NOT NULL ,
    course_name VARCHAR(255) NOT NULL UNIQUE,
    description TEXT NOT NULL,
    department VARCHAR(255) NOT NULL,
    teacher_name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS student_course (
    student_id UUID NOT NULL REFERENCES student (student_id),
    course_id UUID NOT NULL REFERENCES course (course_id),
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    grade INTEGER CHECK(grade >= 0 AND grade <= 100),
    UNIQUE (student_id, course_id)
);