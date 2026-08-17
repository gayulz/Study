### @Retention : 애노테이션 생존 기간을 지정함.
- RetentionPolicy.RUNTIME : 자바 실행 중에도 남아 있다. 대부분 이 설정을 사용함
- RetentionPolicy.SOURCE : 소스 코드에만 남아있다. 컴파일 시점에 제거 
- RetentionPolicy.CLASS : 컴파일 후 class파일 까지 남아있음, 자바 실행 시점에 제거 됨 ( 기본값 )
   
   
   
   
   

### @Target
- 애노테이션을 적용할 수 있는 위치를 지정한다.
- TYPE, FIELD, METHOD
   
   
   
### @Documented
- 자바 API 문서를 만들 때 해당 애노테이션이 함께 포함 되는 지 지정, 보통 함께 사용 됨
   
   
   

### @Inherited
- 자식 클래스가 애노테이션을 상속 받을 수 있다.
- 단 주의할 점으로 이 기능은 클래스 상속에서만 작동하고 인터페이스의 구현체에는 적용되지 않는다.
