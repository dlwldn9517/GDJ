/*
    DDL
    
    1. Data Query Language
    2. 데이터 질의어
    3. 테이블의 데이터를 조회/검색
    4. 데이터베이스에 변화가 없으므로 COMMIT 없다.
        (트랜잭션의 대상이 아니다.)
    5. 형식
        SELECT 칼럼1, 칼럼2, ...
          FROM 테이블
        [WHERE 조건식]
        [GROUP BY 그룹화]  -- 통계 관련 함수 뽑을 때 (합계, 평균, 최소최대값 등...)\
        [HAVING 그룹화_조건식]
        [ORDER BY 정렬]
    6. 실행 순서
        ⑤  SELECT 칼럼
        ①    FROM 테이블
        ②   WHERE 조건식
        ③   GROUP BY 그룹화
        ④  HAVING 그룹화 조건식
        ⑥   ORDER BY 정렬기준
*/