# 포트폴리오 프로젝트

이 프로젝트는 **Spring Boot**와 **JPA**, **MySQL**을 기반으로 한 웹 애플리케이션입니다. 
다양한 기능을 구현하여 개발 능력을 보여주는 것을 목표로 합니다. 
이 프로젝트는 RESTful API, 데이터베이스 연동, 사용자 인증 등 기본적인 백엔드 기술을 중심으로 구축되었습니다.

## 기술 스택

- **Spring Boot**: 빠르고 쉽게 애플리케이션을 만들 수 있도록 지원하는 프레임워크
- **JPA (Java Persistence API)**: 관계형 데이터베이스와 객체를 매핑하기 위한 Java 표준 API
- **MySQL**: 관계형 데이터베이스 관리 시스템 (RDBMS)
- **JUnit 5**: 자바에서 유닛 테스트를 작성하고 실행하기 위한 프레임워크
- **AssertJ**: 풍부한 API를 제공하는 Java 테스트 라이브러리로, 가독성이 좋고 직관적인 assertions을 지원

## 기능

- **사용자 관리**: 사용자 등록, 로그인, 정보 수정, 삭제 기능
- **게시글 관리**: 게시글 작성, 조회, 수정, 삭제 기능
- **회원가입과 로그인**: JWT(JSON Web Token)를 사용한 사용자 인증 기능

## 테스트

이 프로젝트에서는 **JUnit 5**와 **AssertJ**를 활용하여 **유닛 테스트**와 **통합 테스트**를 구현했습니다. 테스트는 애플리케이션의 안정성과 기능을 보장하며, 코드를 변경하거나 기능을 추가할 때 기존 기능이 정상적으로 동작하는지 확인하는 데 중요한 역할을 합니다.

### JUnit 5

- **유닛 테스트**: 개별 클래스 및 메서드에 대한 테스트를 작성하여 각 기능이 독립적으로 정확하게 동작하는지 확인했습니다.
- **통합 테스트**: 여러 컴포넌트가 협력하여 전체 시스템이 정상적으로 동작하는지 확인하는 테스트를 작성했습니다.

### AssertJ

- **Assertions**: AssertJ를 활용하여 테스트에서 사용할 수 있는 직관적이고 가독성 높은 assertion을 사용했습니다. 예를 들어, 객체의 상태나 리스트의 크기, 특정 값이 예상대로 존재하는지 쉽게 검증할 수 있었습니다.

```java
// 예시: 유닛 테스트 코드 (JUnit 5 + AssertJ)
@DisplayName("원하는 판매상태를 가진 상품들을 반환한다.")
    @Test
    void findAllBySellingStatusIn()
    {
        // given
        Product product1 = Product.builder()
                .name("뿡뿡아파트")
                .price(4000)
                .type(JEOUNSE)
                .sellingStatus(SELLING)
                .build();

        Product product2 = Product.builder()
                .name("빵빵아파트")
                .price(4000)
                .type(JEOUNSE)
                .sellingStatus(HOLD)
                .build();

        productRepository.saveAll(List.of(product1, product2));

        // when
        List<Product> products = productRepository.findBySellingStatusIn(List.of(SELLING,HOLD));

        // then
        assertThat(products).hasSize(2)
                .extracting("name", "price", "type", "sellingStatus")
                        .containsExactlyInAnyOrder(
                                tuple("뿡뿡아파트", 4000, JEOUNSE, SELLING),
                                tuple("빵빵아파트", 4000, JEOUNSE, HOLD)
                        );
    }
```
