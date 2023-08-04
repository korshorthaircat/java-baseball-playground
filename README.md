## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)
- - -
## 학습 목표
### 경험해야 할 학습 목표
* 자바 code convention을 지키면서 프로그래밍하는 경험
* JUnit 사용법을 익혀 단위 테스트하는 경험
* 학습테스트를 하면서 JUnit 사용법을 익히는 경험
* 메소드를 분리하는 리팩터링 경험

### 경험할 객체지향 생활 체조 원칙
이번 과정을 통해 연습할 원칙은 다음 두 가지이다.

* 규칙 1: 한 메서드에 오직 한 단계의 들여쓰기만 한다.
* 규칙 2: else 예약어를 쓰지 않는다.
  이 두가지 원칙을 통해 메소드를 분리해 메소드가 한 가지 작업만 담당하도록 구현하는 연습을 목표로 한다.
  이 같은 원칙 아래에서 메소드의 라인 수를 15라인이 넘지 않도록 구현한다.

### Clean Code 가이드
#### 함수(메소드)
##### 작게 만들어라.
* 함수를 만드는 첫 번재 규칙은 '작게'다. 함수를 만드는 두 번째 규칙은 '더 작게'다.
##### 한 가지만 해라.
* 함수는 한 가지를 해야 한다. 그 한 가지를 잘 해야 한다. 그 한 가지만 해야 한다.
##### 함수 당 추상화 수준은 하나로
* 함수가 확실히 '한 가지' 작업만 하려면 함수 내 모든 문장이 **동일한 추상화 수준**에 있어야 한다.
* 코드는 위에서 아래로 이야기처럼 일해야 좋다.
##### 서술적인 이름을 사용하라
* 이름이 길어도 괜찮다.
* 이름을 정하느라 시간을 들여도 괜찮다.
* 이름을 붙일 때는 일관성이 있어야 한다.
##### 함수 인수
* 함수에서 이상적인 인수 개수는 0개(무항)이다. 다음은 1개이고, 다음은 2개이다.
* 3개는 가능한 피하는 편이 좋다.
* **4개 이상은 특별한 이유가 있어도 사용하면 안된다.**
* 인수가 2 ~ 3개 필요한 경우가 생긴다면 인수를 독자적인 클래스를 생성할 수 있는지 검토해 본다.
```
Circle makeCircle(double x, double y, double radius);
Circle makeCircle(Point center, double radius);
```
##### side effect를 만들지 마라.
* side effect는 많은 경우 예상치 못한 버그를 발생시킨다.
##### 명령과 조회를 분리하라.
* 함수는 뭔가를 수행하거나 답하거나 둘 중 하나만 해야 한다. 둘 다 하면 안된다.
* 개체 상태를 변경하거나 아니면 개체 정보를 반환하거나 둘 중 하나다.
##### 오류 코드보다 예외를 사용하라.
* 오류 처리도 한 가지 작업이다.
    * 함수는 '한 가지' 작업만 해야 한다. 오류 처리도 '한 가지' 작업에 속한다.
    * 그러므로 오류를 처리하는 함수는 오류만 처리해야 마땅하다.
* try/catch 블록은 원래가 추하다. 코드 구조에 혼란을 일으키며, 정상적인 동작과 오류 처리 동작을 뒤섞는다. try/catch 블록을 별도 함수로 뽑아내는 편이 낫다.
##### 반복하지 마라.
* 중복은 소프트웨어에서 모든 악의 근원이다.
##### 함수를 구현하는 방법은?
> 소프트웨어를 구현하는 행위는 여느 글짓기와 비슷하다. 논문이나 기사를 쓸 때는 먼저 생각을 기록한 후 읽기 좋게 다듬는다. 초안은 대개 서투르고 어수선하므로 원하는 대로 읽힐 때까지 말을 다듬고 문장을 고치고 문단을 정리한다.
필자는 함수를 구현할 때도 마찬가지다. 처음에는 길고 복잡하다. 들여쓰기 단계도 많고, 중복된 루프도 많다. 인수 목록도 아주 길다. 이름은 즉흥적이고 코드는 중복된다. 하지만 필자는 그 서투른 코드를 빠짐없이 테스트하는 단위 테스트 케이스도 만든다.
그런 다음 필자는 코드를 다듬고, 함수를 만들고, 이름을 바꾸고, 중복을 제거한다. 메소드를 줄이고, 순서를 바꾼다. 때로는 전체 클래스를 쪼개기도 한다. 이 와중에도 코드는 항상 단위 테스트를 통과한다.
결국에는 앞에서 다룬 규칙을 따르는 함수를 얻을 수 있다. 처음부터 딱 짜내지 않는다. 그게 가능한 사람은 없으리라.
- - -
### code convention, format 맞추기
#### 형식을 맞추는 목적
* code convention은 중요하다! 너무 중요해서 무시하기 어렵다.
* code convention은 의사소통의 일환이다. 의사소통은 전문 개발자의 일차적인 의무다.
#### 적절한 행의 길이를 유지하라
#### 가로 format 맞추기
* 120자 정도로 행 길이를 제한한다.
#### 팀 규칙
* 모든 프로그래머는 자신이 선호하는 규칙이 있다. 하지만 팀에 속한다면 자신이 선호해야 할 규칙은 바로 팀 규칙이다.
* 팀은 한 가지 규칙에 합의해야 한다. 그리고 모든 팀원은 그 규칙을 따라야 한다.
- - -

## 단위 테스트란?
### main method 테스트의 문제점
* 프로덕션 코드
    * 프로그램의 구현ㅇ르 담당하는 부분으로 사용자가 실제 사용하는 소스코드를 의미한다.
* 테스트 코드
    * 프로덕션 코드가 정상 동작하는지 확인하는 코드이다.
* main method 테스트의 문제점
* Production code와 Test Code가 클래스 하나에 존재한다 -> 클래스 크기가 커짐. 복잡도 증가함.
* Test Code가 실 서비스에 같이 배포됨.
* main method 하나에서 여러 개의 기능을 테스트 함. 복잡도 증가.
* method 이름을 통해 어떤 부분을 테스트하는지에 대한 의도를 드러내기 힘듦.
* 테스트 결과를 사람이 수동으로 확인

### JUnit
* main method를 활용해 테스트할 때 발생하는 문제점을 해결할 수 있는 도구이다.
#### JUnit 5.x 버전
* 애노테이션(Annotation)을 활용해 테스트 코드 구현
    * @Test
    * @BeforeEach, @AfterEach
    * Assertions 클래스의 static assert method를 활용해 테스트 결과 검증
```
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Calculator cal;

    @BeforeEach
    public void setUp()  {
        cal = new Calculator();
    }

    @Test
    public void 덧셈()  {
        assertEquals(7, cal.add(3, 4));
    }

    @Test
    public void 뺄셈()  {
        assertEquals(1, cal.subtract(5,  4));
    }

    @Test
    public void 곱셉()  {
        assertEquals(6, cal.multiply(2, 3));
    }

    @Test
    public void 나눗셈()  {
        assertEquals(2, cal.divide(8, 4));
    }

    @AfterEach
    public void tearDown() {
        cal = null;
    }
}
```
#### JUnit 4.x 버전
* 애노테이션(Annotation)을 활용해 테스트 코드 구현하는 방법은 JUnit 5.x와 같음
* 애노테이션의 패키지 위치와 이름만 다름. 다른 부분은 5.x와 같음
    * @org.junit.Test
    * @org.junit.Before, @org.junit.After
    * Assert 클래스의 static assert method를 활용해 테스트 결과 검증

#### method 실행 순서
* 테스트 메소드의 실행 순서는 의도적으로 확실하지 않은 알고리즘으로 결정되게 되어 있다.
* 본래 단위 테스트는 실행 순서에 의존하지 않는 것이 바람직하다.
* 그러나, 결합 테스트 또는 기능 테스트의 경우 실행 순서가 중요 할 수 있다. 예를 들면, 초기 필요한 기능을 먼저 동작 시키고, 각각의 기능을 동작시켜야 하는 경우다.
    * 그러한 경우에는 테스트의 실행 순서를 제어하기 위한 방법이 있다.
---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```
