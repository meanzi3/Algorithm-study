-- 코드를 입력하세요
SELECT INGREDIENT_TYPE, SUM(TOTAL_ORDER) AS TOTAL_ORDER
FROM FIRST_HALF f INNER JOIN ICECREAM_INFO i
WHERE f.FLAVOR = i.FLAVOR
GROUP BY INGREDIENT_TYPE
ORDER BY TOTAL_ORDER;