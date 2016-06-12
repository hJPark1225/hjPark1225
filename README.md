# hjPark1225

         Kedu System v1.0

WHAT IS THIS?
   키워드를 이용한 컨텐츠 자동 수집 시스템
  
DOCUMENTATION:
   
   Kedu 시스템은 Spring MVC 기반의 웹 프로젝트이다.
로컬 서버로 구현하였으며, Model, View, Controller 부분으로 구성되었으며, Controller에 request를 맵핑하였다.

- HomeController : main view를 보이기 위한 Controller
/home : 홈 컨트롤러에 의해 메인화면이 보여진다. 

* NewsController : news contents view를 위한 Controller
/news/listPage  : 뉴스에 대한 리스트 화면이 home 화면의 뉴스 탭에 보여진다.

* VedeoController : video contents view를 위한 Controller
/video/listPage : 비디오 컨텐츠에 대한 리스트 화면이 home 화면의 비디오 탭에 보여진다.

* keywodrController : keyword 관리를 위한 Controller
/keyword/listPage : 키워드를 등록, 삭제, 조회할 수 있는 페이지가 보여진다.

* CrawlingController : 크롤링을 통한 컨텐츠 수집 기능을 위한 Controller
/crewling/extract : 키워드에서 색인어를 추출한다.
/crawling/collect : 키워드에 맞는 컨텐츠의 URL을 수집한다.
/crawling/calc : 수집한 데이터와 키워드 간 TF-IDF 가중치를 계산한다.


SOFTWARE REQUIREMENTS:
  
   * bootstrap
   * mysql-connector-java-5.1.38
   * org.snu.ids.ha 꼬꼬마, 한글 형태소 분석기
   * jsoup-1.9.1
