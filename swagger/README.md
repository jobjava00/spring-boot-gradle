# swagger

* api-docs
<http://localhost:8080/v2/api-docs>

* swagger-ui
<http://localhost:8080/swagger-ui.html>

* gradle dependency 추가

```groovy
compile("io.springfox:springfox-swagger2:2.9.2")
compile group: 'io.springfox', name: 'springfox-swagger-ui', version: '2.9.2'
```

* NumberFormatException

```groovy
compile("io.springfox:springfox-swagger2:2.9.2") {
    exclude module: 'swagger-annotations'   // 1.5.20 제외
    exclude module: 'swagger-models'
}
compile("io.swagger:swagger-annotations:1.5.21")    // ApiModelProperty 사용 시 NumberFormatException 발생해서 수정된 버전 사용
compile("io.swagger:swagger-models:1.5.21")
```
