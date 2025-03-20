```mvn
mvn clean verify sonar:sonar \
  -Dsonar.projectKey=admin-catalog \
  -Dsonar.projectName='admin-catalog' \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.token=sqp_f9d20e0c22ad66f2916b1f403f122ec04df3e823
```
`mvn sonar:sonar`

https://www.baeldung.com/sonarqube-jacoco-code-coverage

