# 기능 구현 힌트
* Enum을 사용한다.
  * 상금(1등, 2등, ...)은 Enum으로 구현한다. ex) enum Prize
* 모든 원시값, 문자열을 포장한다.
  * 로또 숫자 하나는 int 타입이다. 이 숫자 하나를 추상화한 LottoNumber 객체를 추가해 구현한다.
* 일급 콜렉션을 사용한다.
  * 로또 티켓(LottoTicket)들을 콜렉션으로 관리하는 LottoTickets 객체를 추가해 구현한다.

# JUnit, AssertJ 구현 힌트
## Exception 구현 힌트
* [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion) 문서 참고
```java
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

assertThatExceptionOfType(IndexOutOfBoundsException.class)
  .isThrownBy(() -> {
      // ...
}).hasMessageMatching("Index: \\d+, Size: \\d+");
```
* 자주 발생하는 Exception의 경우 Exception별 메서드 제공하고 있음
  * assertThatIllegalArgumentException()
  * assertThatIllegalStateException()
  * assertThatIOException()
  * assertThatNullPointerException()
```java
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

assertThatIllegalArgumentException().isThrownBy(() -> {
    // ...
});
```
## 테스트 데이터 전달
* [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5) 문서 참고
```java
@ParameterizedTest
@ValueSource(strings = {"", "  "})
void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
    assertTrue(Strings.isBlank(input));
}
```
