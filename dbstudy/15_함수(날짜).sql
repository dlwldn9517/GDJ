-- 날짜 함수


-- 1. 현재 날짜와 시간
SELECT SYSDATE, SYSTIMESTAMP FROM DUAL;


-- 2. 원하는 형식으로 날짜와 시간 조회
--    TO_CHAR 함수 : 날짜를 문자로 변환해서 조회
SELECT
       TO_CHAR(SYSDATE, 'YYYY-MM-DD HH:MI:SS')    -- 12시간
     , TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS')  -- 24시간
  FROM
       DUAL;
       

-- 3. 단위(년,월,일,시,분,초) 추출 함수
--    EXTRACT(단위 FROM 날짜)
SELECT
       EXTRACT(YEAR   FROM SYSDATE) AS 년도
     , EXTRACT(MONTH  FROM SYSDATE) AS 월
     , EXTRACT(DAY    FROM SYSDATE) AS 일
     , EXTRACT(HOUR   FROM SYSTIMESTAMP) AS 시  -- UTC 기준(세계 표준시)   
     , EXTRACT(MINUTE FROM SYSTIMESTAMP) AS 분
     , EXTRACT(SECOND FROM SYSTIMESTAMP) AS 초
     , EXTRACT(TIMEZONE_HOUR FROM SYSTIMESTAMP) AS 시    -- 우선 TIMEZONE 설정이 필요
     , FLOOR(EXTRACT(SECOND FROM SYSTIMESTAMP)) AS 초
  FROM
       DUAL;     

-- 단위(년,월,일,시,분,초) 추출은 TO_CHAR 함수로도 가능함
SELECT
       TO_CHAR(SYSDATE, 'YYYY')
     , TO_CHAR(SYSDATE, 'MM')
     , TO_CHAR(SYSDATE, 'DD')
     , TO_CHAR(SYSDATE, 'HH24')
     , TO_CHAR(SYSDATE, 'MI')
     , TO_CHAR(SYSDATE, 'SS')
  FROM
       DUAL;    
       
       
-- 4. 날짜 연산
--  1) 하루(1일)를 숫자 1로 처리
--     (12시간을 숫자 0.5로 처리)
--  2) 특정 단위 후 날짜
--     (1) 1년 후   : 12개월 후 계산, 함수 없음
--     (2) 1개월 후 : ADD_MONTHS, 함수 사용
--     (1) 1일 후   : +1, 함수 없음