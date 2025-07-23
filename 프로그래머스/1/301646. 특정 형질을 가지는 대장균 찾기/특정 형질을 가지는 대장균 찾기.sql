-- 코드를 작성해주세요 
-- 2번 형질을 보유하지 않으면서 1번이나 3번 형질을 보유하고 있는 대장균 개체의 수
SELECT COUNT(*) AS COUNT
FROM ECOLI_DATA
WHERE GENOTYPE & 2 = 0 AND ((GENOTYPE & 1) > 0 OR (GENOTYPE & 4) > 0);