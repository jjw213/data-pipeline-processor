# 데이터 파이프라인 프로세서

입력 데이터를 변환하고 필터링하여 출력하는 간단한 데이터 파이프라인 시스템

## 기능 목록
- 데이터 변환
- 데이터 필터링
- HTML 태그 제거
- 대소문자 변환

## 실행 방법

1. 환경변수 설정
   - `DB_URL`
   - `DB_USER`
   - `DB_PASSWORD`

2. Maven 프로젝트 빌드
   ```bash
   mvn clean install
   ```

3. Spring Boot 애플리케이션 실행
   ```bash
   mvn spring-boot:run
   ```

4. API 호출 예시
   ```bash
   POST http://localhost:8080/process
   {
     "data": ["<p>Hello World</p>", "<div>Test</div>"],
     "transformations": [
       {"type": "strip-html"},
       {"type": "uppercase"}
     ]
   }
   ```