/*
    프로시저
    
    1. PROCEDURE
    2. 여러 개의 쿼리문을 한 번에 실행
        (이체 : UPDATE문 2개)
    3. 작성된 프로시저는 EXECUTE문으로 실행
        EXECUTE 프로시저();
    4. 형식
        CREATE [OR REPLACE] 프로시저_이름[(매개변수)]
        IS  --AS 가능
            변수선언
        BEGIN
            프로시저 본문
        [EXCEPTION
            예외처리]
        END 프로시저_이름;

*/

-- 프로시저 PROC1 정의(만들기)
CREATE OR REPLACE PROCEDURE PROC1
IS
    NAME VARCHAR2(10 BYTE);
BEGIN
    NAME := '손석구';
    DBMS_OUTPUT.PUT_LINE(NAME);
END PROC1;

-- 프로시저 PROC1 호출(실행)
EXECUTE PROC1();


-- 프로시저 PROC2 정의
-- 사원번호 = 100인 사원의 FIRST_NAME 서버메시지로 출력하기
CREATE OR REPLACE PROCEDURE PROC2
IS
    FNAME EMPLOYEES.FIRST_NAME%TYPE;    -- 변수
BEGIN
    SELECT FIRST_NAME   -- FIRST_NAME 칼럼 값을
      INTO FNAME        -- FNAME 변수에 저장
      FROM EMPLOYEES
     WHERE EMPLOYEE_ID = 100;
    DBMS_OUTPUT.PUT_LINE(FNAME);
END PROC2;

-- 프로시저 PROC2 호출
EXECUTE PROC2();



-- 프로시저 PROC3 정의
-- 사원번호를 전달하면 해당 사원의 FIRST_NAME을 서버메시지로 출력하기

-- 입력 파라미터
-- 1. 프로시저로 전달하는 값을 저장할 변수
-- 2. 형식 : 변수명 IN 타입

CREATE OR REPLACE PROCEDURE PROC3(EMP_ID IN EMPLOYEES.EMPLOYEE_ID%TYPE)
IS
    FNAME EMPLOYEES.FIRST_NAME%TYPE;
BEGIN
    SELECT FIRST_NAME
      INTO FNAME
      FROM EMPLOYEES
     WHERE EMPLOYEE_ID = EMP_ID;
    DBMS_OUTPUT.PUT_LINE(FNAME);
END PROC3;
     
-- 프로시저 PROC3 호출
EXECUTE PROC3(100);
EXECUTE PROC3(101);



-- 프로시저 PROC4 정의
-- 사원번호 = 100인 사원의 FIRST_NAME을 출력 파라미터 FNAME에 저장하기

-- 출력 파라미터
-- 1. 프로시저의 결과(반환) 값을 저장하는 변수
-- 2. 형식 : 변수명 OUT 타입

CREATE OR REPLACE PROCEDURE PROC4(FNAME OUT EMPLOYEES.FIRST_NAME%TYPE)
IS
BEGIN
    SELECT FIRST_NAME
      INTO FNAME
      FROM EMPLOYEES
     WHERE EMPLOYEE_ID = 100;
END PROC4;

-- 프로시저 PROC4 호출
DECLARE
    FNAME EMPLOYEES.FIRST_NAME%TYPE;    -- 출력 파라미터로 사용할 변수
BEGIN
    PROC4(FNAME);   -- PL/SQL(프로그래밍) 내부에서 프로시저를 호출할 땐 EXECUTE 생략
    DBMS_OUTPUT.PUT_LINE(FNAME);
END;


-- 프로시저 PROC5 정의



-- 프로시저 PROC5 호출


-- 연습 1. 입력 파라미터에 사원번호 전달, 출력 파라미터에 FIRST_NAME 반환받기
-- 프로시저 PROC6 정의
CREATE OR REPLACE PROCEDURE PROC6(EMP_ID IN EMPLOYEES.EMPLOYEE_ID%TYPE, FNAME OUT EMPLOYEES.FIRST_NAME%TYPE)
IS
BEGIN
    SELECT FIRST_NAME
      INTO FNAME
      FROM EMPLOYEES
     WHERE EMPLOYEE_ID = EMP_ID;
END PROC6;

-- 프로시저 PROC6 호출
DECLARE
    FNAME EMPLOYEES.FIRST_NAME%TYPE;
BEGIN
    PROC6(100, FNAME);
    DBMS_OUTPUT.PUT_LINE(FNAME);
    PROC6(101, FNAME);
    DBMS_OUTPUT.PUT_LINE(FNAME);
END;


