-- 코드를 작성해주세요 
SELECT DISTINCT d.ID, d.EMAIL, d.FIRST_NAME, d.LAST_NAME
FROM DEVELOPERS d JOIN SKILLCODES s 
    ON s.CODE = (d.SKILL_CODE & s.CODE)
WHERE s.CATEGORY = 'Front End'
ORDER BY d.ID;

-- AND 연산으로 2진수 값을 비교할 수 있음. (비트마스크)
