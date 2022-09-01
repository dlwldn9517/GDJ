/*
    PL/SQL
    
    1. 오라클의 프로그래밍 처리가 가능한 SQL
    2. 프로그래밍 형식
        [DECLARE]
            [변수 선언]
        BEGIN
            수행할 PL/SQL
        END;
    3. PL/SQL의 데이터(변수, 상수)는 서버메시지로 출력
    4. 서버메시지 출력을 위해 최초 1회 설정이 필요 (디폴트 SET SERVEROUTPUT OFF)
        SET SERVEROUTPUT ON;        
*/

-- 기초 데이터 준비
-- HR 계정의 EMPLOYEES 테이블을 SCOTT 계정으로 복사해오기
CREATE TABLE EMPLOYEES
    AS (SELECT *
          FROM HR.EMPLOYEES);
          
-- 기본키 다시 생성
ALTER TABLE EMPLOYEES
    ADD CONSTRAINT PK_EMPLOYEES PRIMARY KEY(EMPLOYEE_ID);


-- 서버메시지 출력 가능 상태로 변경
-- 한 번만 실행하면 된다.
SET SERVEROUTPUT ON;


-- 서버메시지 출력
BEGIN
    DBMS_OUTPUT.PUT_LINE('Hello'); -- Hello 출력 후 줄 바꿈
END;


-- 스칼라 변수 선언
-- 스칼라 변수 : 직접 타입을 명시하는 변수
-- 대입 연산자 : 콜론등호(:=)
-- 변수 선언은 DECLARE에서 처리
DECLARE
    -- 스칼라 변수 선언
    NAME VARCHAR2(20 BYTE);
    AGE NUMBER(3);
BEGIN
    NAME := '손석구';
    AGE := 40;
    DBMS_OUTPUT.PUT_LINE('내 이름은 ' || NAME || '입니다.');
    DBMS_OUTPUT.PUT_LINE('내 나이는 ' || AGE || '살입니다.');
END;


-- 참조 변수 선언
-- 참조 변수 : 특정 칼럼의 타입을 그대로 사용하는 변수
-- 선언 방법
-- 테이블명.칼럼%TYPE

DECLARE
    -- 참조 변수 선언
    NAME EMPLOYEES.FIRST_NAME%TYPE;
BEGIN
    NAME := '손석구';
    DBMS_OUTPUT.PUT_LINE('내 이름은 ' || NAME || '입니다.');
END;

