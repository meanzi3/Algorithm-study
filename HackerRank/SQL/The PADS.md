# The PADS

[문제 링크](https://www.hackerrank.com/challenges/the-pads/problem)

<br>

### 문제 요약

다음 두 가지 결과 집합을 생성합니다.

1. 알파벳 순으로 정렬된 OCCUPATIONS의 모든 이름 목록을 쿼리하고, 바로 뒤에 각 직업의 첫 글자를 괄호로 묶어(즉, 괄호 안에 묶어) 표시합니다. 예를 들어 예: 배우명(A), 의사명(D), 교수명(P), 가수명(S).
2. OCCUPATIONS에서 각 직업의 발생 횟수를 쿼리합니다. 발생 횟수를 오름차순으로 정렬하여 다음 형식으로 출력합니다:

```
There are a total of [occupation_count] [occupation]s.
```

여기서 [occupation_count]는 OCCUPATIONS에서 한 직업의 발생 횟수이고 [occupation]은 소문자 직업 이름입니다. 두 개 이상의 직종에 동일한 [occupation_count]가 있는 경우 알파벳 순으로 정렬해야 합니다.

<br>

### 풀이

```sql
SELECT CONCAT(NAME, "(", SUBSTR(OCCUPATION, 1, 1), ")")
FROM OCCUPATIONS
ORDER BY NAME;

SELECT CONCAT("There are a total of ", COUNT(NAME), " ", LOWER(OCCUPATION), "s.")
FROM OCCUPATIONS
GROUP BY OCCUPATION
ORDER BY COUNT(OCCUPATION);
```
