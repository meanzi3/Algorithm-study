-- 코드를 입력하세요
SELECT p.MEMBER_NAME, r.REVIEW_TEXT, DATE_FORMAT(r.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM MEMBER_PROFILE p JOIN REST_REVIEW r 
    ON p.MEMBER_ID = r.MEMBER_ID
WHERE r.MEMBER_ID IN (
            SELECT MEMBER_ID
            FROM REST_REVIEW
            GROUP BY MEMBER_ID
            HAVING COUNT(*) = (
                SELECT MAX(REVIEW_COUNT)
                FROM (
                    SELECT COUNT(*) AS REVIEW_COUNT
                    FROM REST_REVIEW
                    GROUP BY MEMBER_ID
                ) AS COUNT_TB
            )
        )
ORDER BY r.REVIEW_DATE, r.REVIEW_TEXT;