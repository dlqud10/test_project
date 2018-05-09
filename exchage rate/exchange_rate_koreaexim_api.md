#koreaexim open api 설명

https://www.koreaexim.go.kr/site/program/financial/exchangeJSON?authkey=5bC4hLlng7kzfx5HpjA8lJFvs6ehjlV9&searchdate=&data=AP01

요청변수 (Requester Parameter)

변수명		타입		변수설명	값설명
authkey		String(필수)	인증키	OpenAPI 신청시 발급된 인증키
searchdate	String		검색요청날짜	ex) 2015-01-01, 20150101, (DEFAULT)현재일
data		String(필수)	검색요청API타입	AP01 : 환율, AP02 : 대출금리, AP03 : 국제금리

출력결과 (Response Element)

변수명	타입	변수설명	값설명
RESULT		Integer	조회 결과	1 : 성공, 2 : DATA코드 오류, 3 : 인증코드 오류, 4 : 일일제한횟수 마감
CUR_UNIT	String	통화코드	？
CUR_NM		String	국가/통화명	？
TTB		String	전신환(송금)받으실때	？
TTS		String	전신환(송금)보내실때	？
DEAL_BAS_R	String	매매 기준율	？
BKPR		String	장부가격	？
YY_EFEE_R	String	년환가료율	？
TEN_DD_EFEE_R	String	10일환가료율	？
KFTC_DEAL_BAS_R	String	서울외국환중계매매기준율	?
KFTC_BKPR	String	서울외국환중계장부가격	？

이용시 유의사항

비영업일의 데이터, 혹은 영업당일 11시 이전에 해당일의 데이터를 요청할 경우 null 값이 반환