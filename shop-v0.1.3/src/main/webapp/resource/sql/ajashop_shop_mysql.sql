
CREATE SEQUENCE seq_ajashop_member START 1;
CREATE TABLE tbl_ajashop_member (
	no int not null nextval(seq_ajashop_member)	-- 자동증가 값(기본필수)
	id varchar(50) ,							-- 아이디
	password varchar(100) ,						-- 비밀번호
	first_name varchar(255) ,					-- 성
	last_name varchar(255) ,					-- 명
	
	email1 varchar(50) ,						-- 이메일
	email2 varchar(50) ,						-- 이메일
	mobile1 varchar(255) ,						-- 모바일1 
	mobile2 varchar(255) ,						-- 모바일2 
	mobile3 varchar(255) ,						-- 모바일3 
	phone1 varchar(255) ,						-- 전화번호1 
	phone2 varchar(255) ,						-- 전화번호2 
	phone3 varchar(255) ,						-- 전화번호3 
	fax1 varchar(255) ,							-- 팩스번호1
	fax2 varchar(255) ,							-- 팩스번호2
	fax3 varchar(255) ,							-- 팩스번호3
	
	device_type	,								-- 모바일 타입 [아이폰 , 안드로이드]
	device_sn	,								-- 모바일 번호 [유일한기기번호]
	
	sns_type	,								-- sns상태 > sns 로그인상태 kakao,qq,
	sns_id	,									-- sns 아이디 
	sns_name	,								-- sns 이름
	sns_auth	,								-- sns 토큰을받기위한 auth
	sns_token	,								-- sns 토큰
	
	push_token	,								-- 푸쉬토큰
	
	group_code	,								-- 그룹코드 key 
	delivery_id	,								-- 배송정보코드[사용자 아이디] ? 
	
	status ,									-- 상태여부(기본필수)
	del ,										-- 삭제여부(기본필수)
	udp_dt	,									-- 수정일자(기본필수)
	reg_dt	,									-- 최초일자(기본필수)
	
	--------------------------------
	created_date datetime not null,
	last_date datetime not null,
	authority varchar(20) not null default 'ROLE_USER',
	image_path varchar(50) default 'default.jpg',
	primary key (no),
	unique index (email)
);

-- 추후 히스토리 테이블


-- 유저 그룹
CREATE TABLE tbl_ajashop_member_group (
	
};

CREATE SEQUENCE seq_ajashop_member_history START 1;
-- 유저 히스토리 저장용
CREATE TABLE tbl_ajashop_member_history (
	no int not null nextval(seq_ajashop_member_history)	-- 자동증가 값(기본필수)
	id varchar(50) not null,							-- 아이디
	
	zoon_lat	,								-- 위도
	zoon_log	,								-- 경도
	zoon_location	,							-- 위치
	zoon_name	,								-- 위치이름
	
	device_type	,								-- 모바일 타입 [아이폰 , 안드로이드]
	device_sn	,								-- 모바일 번호 [유일한기기번호]
	
	login_type	,								-- 로그인 타입 [로그인 > web | mobile | kakao | facebook | instagram .. ]
	login_action	,							-- 로그인 액션 [login > change >  ]
	login_prev	,								-- 로그인 이전이벤트 [change : asdasd  | page : main.do]
	login_next	,								-- 로그인 다음이벤트 [change : 123123  | page : store.do]
	
	status ,									-- 상태여부(기본필수)
	reg_dt	not null default ,					-- 최초일자(기본필수)	=> 추후 히스토리 수정 날자와 member 테이블의 udp_dt 수정날자로 확인한다
};

--CREATE SEQUENCE seq_ajashop_member_delivery START 1;
-- 배송지 정보
CREATE TABLE tbl_ajashop_member_delivery (
--	no int not null nextval(seq_ajashop_member_delivery)	-- 자동증가 값(기본필수)
	id varchar(50) ,							-- 아이디
	email1 varchar(50) ,						-- 이메일
	email2 varchar(50) ,						-- 이메일
	mobile1 varchar(255) ,						-- 모바일1 
	mobile2 varchar(255) ,						-- 모바일2 
	mobile3 varchar(255) ,						-- 모바일3 
	phone1 varchar(255) ,						-- 전화번호1 
	phone2 varchar(255) ,						-- 전화번호2 
	phone3 varchar(255) ,						-- 전화번호3 
	
	delivery_name	,								-- 배송지 이름
	
	delivery_postcode  ,									-- 주소우편번호
	delivery_addr1  ,									-- 주소1
	delivery_addr2  ,									-- 주소2
	delivery_memo	,									-- 배송 멘트
	
	default_yn	,								-- 기본배송지 설정
	
	zoon_lat	,								-- 배송지 위도
	zoon_log	,								-- 배송지 경도
	
	status ,									-- 상태여부(기본필수)
	del ,										-- 삭제여부(기본필수)
	udp_dt	,									-- 수정일자(기본필수)
	reg_dt	,									-- 최초일자(기본필수)
};

/*
CREATE TABLE "public"."tblmember" (
"id" varchar(50) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"passwd" varchar(100) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"name" varchar(20) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"resno" varchar(50) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"email" varchar(50) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"mobile" varchar(20) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"news_yn" char(1) COLLATE "default" DEFAULT 'Y'::bpchar NOT NULL,
"age" char(3) COLLATE "default" DEFAULT ''::bpchar NOT NULL,
"gender" char(1) COLLATE "default" DEFAULT ''::bpchar NOT NULL,
"married_yn" char(1) COLLATE "default" DEFAULT 'N'::bpchar NOT NULL,
"job" varchar(20) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"birth" varchar(10) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"lunar" char(1) COLLATE "default" DEFAULT '1'::bpchar NOT NULL,
"home_post" varchar(6) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"home_addr" varchar(120) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"home_tel" varchar(20) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"office_post" varchar(6) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"office_addr" varchar(120) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"office_tel" varchar(20) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"memo" text COLLATE "default" DEFAULT ''::character varying NOT NULL,
"reserve" int4 DEFAULT 0 NOT NULL,
"joinip" varchar(15) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"ip" varchar(15) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"logindate" varchar(14) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"logincnt" int4 DEFAULT 0 NOT NULL,
"date" varchar(14) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"confirm_yn" char(1) COLLATE "default" DEFAULT 'Y'::bpchar NOT NULL,
"rec_id" varchar(100) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"authidkey" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"group_code" varchar(4) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"member_out" char(1) COLLATE "default" DEFAULT 'N'::bpchar NOT NULL,
"etcdata" text COLLATE "default" DEFAULT ''::text NOT NULL,
"nickname" varchar(30) COLLATE "default",
"mem_type" int4 DEFAULT 0 NOT NULL,
"office_name" varchar(255) COLLATE "default",
"office_representative" varchar(20) COLLATE "default",
"office_no" varchar(100) COLLATE "default",
"dupinfo" varchar(100) COLLATE "default",
"black" int4 DEFAULT 0 NOT NULL,
"resetday" timestamp(6) DEFAULT '1970-01-01 00:00:00'::timestamp without time zone NOT NULL,
"m_no" int4 DEFAULT 0 NOT NULL,
"married_date" varchar(14) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"interest" int4 DEFAULT 0 NOT NULL,
"reserve_chk" char(1) COLLATE "default",
"mem_wholesale" char(1) COLLATE "default" DEFAULT 0,
"sumprice" int4 DEFAULT 0 NOT NULL,
"random_price" int4 DEFAULT 0 NOT NULL,
"vip_type" int4 DEFAULT 0,
"pwmod_date" varchar(14) COLLATE "default",
"partner_date" varchar(14) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"staff_type" int4 DEFAULT 0,
"master_eprise_code" int4 DEFAULT 0,
"member_code" int4 DEFAULT 0,
"regist_eprise_code" int4 DEFAULT 9999,
"member_no" varchar(50) COLLATE "default" DEFAULT NULL::character varying,
"seq_no" int4 DEFAULT 0,
"card_data" varchar(50) COLLATE "default" DEFAULT NULL::character varying,
"sub_char1" varchar(3) COLLATE "default" DEFAULT NULL::character varying,
"sub_number1" int4 DEFAULT 0,
"sub_varchar1" varchar(15) COLLATE "default" DEFAULT NULL::character varying,
"sub_varchar2" varchar(100) COLLATE "default" DEFAULT NULL::character varying,
"modify_date" date,
"member_grade" int4 DEFAULT 0,
"anniversary" varchar(10) COLLATE "default" DEFAULT NULL::character varying,
"keyword" varchar(200) COLLATE "default" DEFAULT NULL::character varying,
"office_form" varchar(100) COLLATE "default",
"staff_limit_max" int4 DEFAULT 0 NOT NULL,
"staff_limit" int4 DEFAULT 0 NOT NULL,
"mb_nick_date" varchar(10) COLLATE "default",
"mb_homepage" varchar(255) COLLATE "default",
"mb_email_certify" varchar(14) COLLATE "default",
"mb_type" varchar(100) COLLATE "default" DEFAULT 'adm'::character varying NOT NULL,
"home_zonecode" varchar(5) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"office_zonecode" varchar(5) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"push_token" text COLLATE "default",
"auth_type" varchar(30) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"is_save_search_keyword" char(1) COLLATE "default" DEFAULT 'Y'::bpchar NOT NULL,
"push_token_ios" text COLLATE "default",
"staff_yn" char(1) COLLATE "default" DEFAULT 'N'::bpchar NOT NULL,
"staff_reserve" int4 DEFAULT 0 NOT NULL,
"sns_type" varchar(100) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"gdn_name" varchar(20) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"gdn_birth" varchar(10) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"gdn_mobile" varchar(13) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"gdn_email" varchar(50) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"act_point" int4 DEFAULT 0 NOT NULL,
"bank_code" varchar(10) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"account_num" varchar(20) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"depositor" varchar(20) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"mem_store_code" varchar(50) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"trandate" varchar(14) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"mem_seq" int4 DEFAULT nextval('tblmember_mem_seq_seq'::regclass) NOT NULL,
"staffcardno" varchar(20) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"gdn_gender" varchar(1) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"icon" varchar COLLATE "default",
"height" varchar(3) COLLATE "default" DEFAULT ''::character varying,
"weigh" varchar(3) COLLATE "default" DEFAULT ''::character varying,
"job_code" varchar(2) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"kko_yn" char(1) COLLATE "default" DEFAULT ''::bpchar NOT NULL,
"erp_mem_id" varchar(100) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"erp_shopmem_id" varchar(100) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"erp_emp_id" varchar(100) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"cooper_yn" varchar(1) COLLATE "default" DEFAULT 'N'::bpchar NOT NULL,
"cooper_reserve" int4 DEFAULT 0 NOT NULL,
CONSTRAINT "tblmember_pkey" PRIMARY KEY ("id")
)
WITH (OIDS=FALSE)
;

ALTER TABLE "public"."tblmember" OWNER TO "devaja";

COMMENT ON TABLE "public"."tblmember" IS '회원정보';

COMMENT ON COLUMN "public"."tblmember"."id" IS '회원아이디';

COMMENT ON COLUMN "public"."tblmember"."passwd" IS '비밀번호';

COMMENT ON COLUMN "public"."tblmember"."name" IS '이름';

COMMENT ON COLUMN "public"."tblmember"."email" IS '메일주소';

COMMENT ON COLUMN "public"."tblmember"."mobile" IS '핸폰';

COMMENT ON COLUMN "public"."tblmember"."news_yn" IS '뉴스레터수신여부(Y:메일,핸폰수신동의,M:메일수신동의,S:핸폰수신동의,N:수신거부)';

COMMENT ON COLUMN "public"."tblmember"."age" IS '나이';

COMMENT ON COLUMN "public"."tblmember"."gender" IS '성별(남자1)';

COMMENT ON COLUMN "public"."tblmember"."married_yn" IS '결혼여부(기혼Y)';

COMMENT ON COLUMN "public"."tblmember"."birth" IS '생년월일(YYYY-MM-DD)';

COMMENT ON COLUMN "public"."tblmember"."lunar" IS '음력여부';

COMMENT ON COLUMN "public"."tblmember"."home_post" IS '집우편번호';

COMMENT ON COLUMN "public"."tblmember"."home_addr" IS '집주소+상세주소(구분자 : ↑=↑)';

COMMENT ON COLUMN "public"."tblmember"."home_tel" IS '집전화';

COMMENT ON COLUMN "public"."tblmember"."office_post" IS '직장 우편번호';

COMMENT ON COLUMN "public"."tblmember"."office_addr" IS '직장주소+상세주소(구분자 : ↑=↑)';

COMMENT ON COLUMN "public"."tblmember"."office_tel" IS '직장전화';

COMMENT ON COLUMN "public"."tblmember"."reserve" IS '적립금';

COMMENT ON COLUMN "public"."tblmember"."joinip" IS '가입IP';

COMMENT ON COLUMN "public"."tblmember"."ip" IS '접속IP';

COMMENT ON COLUMN "public"."tblmember"."logindate" IS '최종접속년월일시분초';

COMMENT ON COLUMN "public"."tblmember"."logincnt" IS '로긴횟수';

COMMENT ON COLUMN "public"."tblmember"."date" IS '가입년월일시분초';

COMMENT ON COLUMN "public"."tblmember"."confirm_yn" IS '관리자승인???';

COMMENT ON COLUMN "public"."tblmember"."rec_id" IS '추천인ID';

COMMENT ON COLUMN "public"."tblmember"."authidkey" IS '중복로그인방지키값(관리자만 씀??)';

COMMENT ON COLUMN "public"."tblmember"."group_code" IS '회원등급코드';

COMMENT ON COLUMN "public"."tblmember"."member_out" IS '탈퇴여부(탈퇴:Y)';

COMMENT ON COLUMN "public"."tblmember"."nickname" IS '별명';

COMMENT ON COLUMN "public"."tblmember"."mem_type" IS '0:일반회원, 1:사업자';

COMMENT ON COLUMN "public"."tblmember"."dupinfo" IS '본인인증키값';

COMMENT ON COLUMN "public"."tblmember"."black" IS '블랙회원여부(블랙회원:1) ??';

COMMENT ON COLUMN "public"."tblmember"."married_date" IS '결혼기념일';

COMMENT ON COLUMN "public"."tblmember"."mem_wholesale" IS '0: 일반 ,1:도매회원';

COMMENT ON COLUMN "public"."tblmember"."sumprice" IS '총 구매금액';

COMMENT ON COLUMN "public"."tblmember"."random_price" IS '임의 누적금액???(관리자에서 등록함.)';

COMMENT ON COLUMN "public"."tblmember"."pwmod_date" IS '패스워드 변경 날짜';

COMMENT ON COLUMN "public"."tblmember"."partner_date" IS '배우자 생일';

COMMENT ON COLUMN "public"."tblmember"."staff_type" IS '권한 -> 1 : 리뷰쓰기가능';

COMMENT ON COLUMN "public"."tblmember"."member_grade" IS '(1:A 어드민, 2:S 공급자, 3:C 일반, 4:P 모름)';

COMMENT ON COLUMN "public"."tblmember"."anniversary" IS '기념일';

COMMENT ON COLUMN "public"."tblmember"."office_form" IS '사업장 형태';

COMMENT ON COLUMN "public"."tblmember"."mb_nick_date" IS '별명변경일';

COMMENT ON COLUMN "public"."tblmember"."mb_homepage" IS '홈페이지';

COMMENT ON COLUMN "public"."tblmember"."mb_email_certify" IS '이메일인증일';

COMMENT ON COLUMN "public"."tblmember"."mb_type" IS '가입형태(adm, web, store)';

COMMENT ON COLUMN "public"."tblmember"."home_zonecode" IS '주소 새우편번호';

COMMENT ON COLUMN "public"."tblmember"."office_zonecode" IS '회사주소 새우편번호';

COMMENT ON COLUMN "public"."tblmember"."push_token" IS '푸쉬를 보내기 위한 안드로이드 토큰값
어플 재설치시 바뀜';

COMMENT ON COLUMN "public"."tblmember"."auth_type" IS '가입시 인증타입
- ipin : 아이핀 인증
- mobile : 휴대폰 인증';

COMMENT ON COLUMN "public"."tblmember"."is_save_search_keyword" IS '모바일에서 검색어 저장 여부(기본값은 저장''Y'')';

COMMENT ON COLUMN "public"."tblmember"."push_token_ios" IS '푸쉬를 보내기 위한 IOS 토큰값
어플 재설치시 바뀜';

COMMENT ON COLUMN "public"."tblmember"."staff_yn" IS '임직원여부 (N : 일반 , Y : 임직원)';

COMMENT ON COLUMN "public"."tblmember"."staff_reserve" IS '임직원 포인트';

COMMENT ON COLUMN "public"."tblmember"."sns_type" IS '간편 가입한 SNS : id||code';

COMMENT ON COLUMN "public"."tblmember"."gdn_name" IS '보호자 이름';

COMMENT ON COLUMN "public"."tblmember"."gdn_birth" IS '보호자 생년월일';

COMMENT ON COLUMN "public"."tblmember"."gdn_mobile" IS '보호자 휴대폰';

COMMENT ON COLUMN "public"."tblmember"."gdn_email" IS '보호자 이메일';

COMMENT ON COLUMN "public"."tblmember"."act_point" IS '활동 포인트';

COMMENT ON COLUMN "public"."tblmember"."bank_code" IS '은행코드';

COMMENT ON COLUMN "public"."tblmember"."account_num" IS '계좌번호';

COMMENT ON COLUMN "public"."tblmember"."depositor" IS '예금주';

COMMENT ON COLUMN "public"."tblmember"."mem_store_code" IS '매장에서 등록시 해당 매장코드';

COMMENT ON COLUMN "public"."tblmember"."trandate" IS '정회원 전환일';

COMMENT ON COLUMN "public"."tblmember"."mem_seq" IS '회원 유니크번호';

COMMENT ON COLUMN "public"."tblmember"."staffcardno" IS 'ERP 임직원 STAFFCARDNO';

COMMENT ON COLUMN "public"."tblmember"."gdn_gender" IS '보호자 성별(남자 : 1, 여자 : 2)';

COMMENT ON COLUMN "public"."tblmember"."icon" IS '아이콘 이미지';

COMMENT ON COLUMN "public"."tblmember"."height" IS '키';

COMMENT ON COLUMN "public"."tblmember"."weigh" IS '몸무게';

COMMENT ON COLUMN "public"."tblmember"."job_code" IS '직업코드';

COMMENT ON COLUMN "public"."tblmember"."kko_yn" IS '카카오톡 수신여부';

COMMENT ON COLUMN "public"."tblmember"."erp_mem_id" IS 'ERP 회원아이디(=신원오프라인아이디)';

COMMENT ON COLUMN "public"."tblmember"."erp_shopmem_id" IS 'ERP 회원아이디(=신원통합아이디)';

COMMENT ON COLUMN "public"."tblmember"."erp_emp_id" IS 'ERP 사번';

COMMENT ON COLUMN "public"."tblmember"."cooper_yn" IS '협력업체여부(N : 협력업체 아님,Y : 협력업체)';

COMMENT ON COLUMN "public"."tblmember"."cooper_reserve" IS '협력업체 포인트';



CREATE INDEX "idx_tblmember_1" ON "public"."tblmember" USING btree (name);

CREATE INDEX "idx_tblmember_2" ON "public"."tblmember" USING btree (resno);

CREATE INDEX "idx_tblmember_3" ON "public"."tblmember" USING btree (email);

CREATE INDEX "idx_tblmember_4" ON "public"."tblmember" USING btree (logindate);

CREATE INDEX "idx_tblmember_5" ON "public"."tblmember" USING btree (rec_id);

CREATE INDEX "idx_tblmember_6" ON "public"."tblmember" USING btree (date);

CREATE INDEX "idx_tblmember_7" ON "public"."tblmember" USING btree (group_code);

CREATE INDEX "idx_tblmember_8" ON "public"."tblmember" USING btree (member_out);
 * 
 */

/* 
 * CREATE TABLE "public"."tblmembergroup" (
"group_code" varchar(4) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"group_name" varchar(50) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"group_description" varchar(250) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"group_payment" char(1) COLLATE "default" DEFAULT 'N'::bpchar NOT NULL,
"group_usemoney" int4 DEFAULT 0 NOT NULL,
"group_addmoney_old" int4 DEFAULT 0 NOT NULL,
"group_level" int4,
"group_no" int4 DEFAULT nextval('tblmembergroup_group_no_seq'::regclass) NOT NULL,
"group_deli_free" int4 DEFAULT 0 NOT NULL,
"group_wsmember" char(1) COLLATE "default" DEFAULT 'N'::bpchar NOT NULL,
"group_wsmoney" int4 DEFAULT 0 NOT NULL,
"group_addreserve" varchar(12) COLLATE "default",
"group_addmoney" varchar(12) COLLATE "default",
"group_orderprice_s" int4 DEFAULT 0,
"group_orderprice_e" int4 DEFAULT 0,
"group_ordercnt_s" int2 DEFAULT 0,
"group_ordercnt_e" int2 DEFAULT 0,
"group_couponcode" varchar(100) COLLATE "default",
"group_ap_s" int4 DEFAULT 0 NOT NULL,
"group_ap_e" int4 DEFAULT 0 NOT NULL,
CONSTRAINT "tblmembergroup_pkey" PRIMARY KEY ("group_code")
)
WITH (OIDS=FALSE)
;

ALTER TABLE "public"."tblmembergroup" OWNER TO "devaja";

COMMENT ON TABLE "public"."tblmembergroup" IS '회원등급관리';

COMMENT ON COLUMN "public"."tblmembergroup"."group_code" IS '그룹코드';

COMMENT ON COLUMN "public"."tblmembergroup"."group_name" IS '그룹명';

COMMENT ON COLUMN "public"."tblmembergroup"."group_description" IS '그룹설명';

COMMENT ON COLUMN "public"."tblmembergroup"."group_payment" IS 'X 결제조건(현금/카드:N, 현금결제만:B, 카드결제만:C)';

COMMENT ON COLUMN "public"."tblmembergroup"."group_usemoney" IS 'X 등급속성-000원 이상 구매시(사용안함)';

COMMENT ON COLUMN "public"."tblmembergroup"."group_level" IS '그룹레벨';

COMMENT ON COLUMN "public"."tblmembergroup"."group_no" IS '일련번호';

COMMENT ON COLUMN "public"."tblmembergroup"."group_deli_free" IS '배송비무료여부(배송비무료:1)';

COMMENT ON COLUMN "public"."tblmembergroup"."group_wsmember" IS 'X 도매회원여부';

COMMENT ON COLUMN "public"."tblmembergroup"."group_wsmoney" IS 'X 도매회원유지금액';

COMMENT ON COLUMN "public"."tblmembergroup"."group_addreserve" IS '등급별 구매시 추가적립%';

COMMENT ON COLUMN "public"."tblmembergroup"."group_addmoney" IS 'usemoney 이상 구매시 추가할인';

COMMENT ON COLUMN "public"."tblmembergroup"."group_orderprice_s" IS 'X 등업속성(누적구매금액이상)';

COMMENT ON COLUMN "public"."tblmembergroup"."group_orderprice_e" IS 'X 등업속성(누적구매금액이하)';

COMMENT ON COLUMN "public"."tblmembergroup"."group_ordercnt_s" IS 'X 등업속성(누적구매횟수시작이상)';

COMMENT ON COLUMN "public"."tblmembergroup"."group_ordercnt_e" IS 'X 등업속성(누적구매횟수시작이하)';

COMMENT ON COLUMN "public"."tblmembergroup"."group_couponcode" IS '등급별 제공 쿠폰코드-등업시 제공';

COMMENT ON COLUMN "public"."tblmembergroup"."group_ap_s" IS '등업속성(누적활동포인트이상)';

COMMENT ON COLUMN "public"."tblmembergroup"."group_ap_e" IS '등업속성(누적활동포인트이하)';
 */

CREATE TABLE persistent_logins (
    username VARCHAR(64) NOT NULL,
    series VARCHAR(64) NOT NULL,
    token VARCHAR(64) NOT NULL,
    last_used TIMESTAMP NOT NULL,
    PRIMARY KEY (series)
);

create table shop_board (
	no int not null auto_increment,
	group_no int not null,
	sequence_no char(12) not null,
	title varchar(100) not null,
	content longtext not null,
	posting_date datetime not null,
	read_count int not null,
	comment_count int not null,
	file_count int not null,
	goods_count int not null,
	user_no int not null,
	user_email varchar(50) not null,
	separator_name varchar(20) not null,
	file_no int,
	total_price int not null,
	image_path varchar(50),
	primary key (no),
	index (sequence_no),
	foreign key(user_no) references shop_user(no),
	foreign key(user_email) references shop_user(email)
);


create table shop_comment(
	no int not null auto_increment,
	group_no int not null,
	sequence_no char(12) not null,
	content text not null,
	posting_date datetime not null,
	user_no int not null,
	user_email varchar(50) not null,
	board_no int not null,
	separator_name varchar(20) not null,
	primary key (no),
	index (sequence_no),
	foreign key(board_no) references shop_board(no) on delete cascade,
	foreign key(user_no) references shop_user(no),
	foreign key(user_email) references shop_user(email)
);

create table shop_goods (
	no int not null auto_increment,
	name char(100) not null,
	size char(20) not null,
	material char(50) not null,
	component char(20) not null,
	options text not null,
	manufacturer char(50) not null,
	madein char(50) not null,
	description text not null,
	price int not null,
	stock int not null,
	user_no int not null,
	user_email varchar(50) not null,
	created_date datetime not null,
	primary key (no),
	foreign key(user_no) references shop_user(no),
	foreign key(user_email) references shop_user(email)
);

create table shop_board_goods (
	board_no int not null,
	goods_no int not null,
	foreign key(board_no) references shop_board(no),
	foreign key(goods_no) references shop_goods(no)
);

create table shop_orders(
	no int not null auto_increment,
	order_date datetime not null,
	order_now varchar(50) not null,
	user_email varchar(255) not null,
	user_name varchar(50) not null,
	address varchar(255) not null,
	postcode int not null,
	receiver varchar(50) not null,
	board_no int not null,
	total_price int not null,
	quantity int not null,
	primary key (no)
);

create table shop_wishlist(
	no int not null auto_increment,
	board_no int not null,
	user_email varchar(255) not null,
	primary key (no),
	foreign key(user_email) references shop_user(email) on delete cascade,
	foreign key(board_no) references shop_board(no)
);

create table shop_cart(
	no int not null auto_increment,
	board_no int not null,
	user_email varchar(255) not null,
	quantity int not null,
	primary key (no),
	foreign key(user_email) references shop_user(email) on delete cascade,
	foreign key(board_no) references shop_board(no)
);

create table shop_file(
	no int not null auto_increment,
	realname varchar(255) not null,
	name varchar(255) not null,
	ext varchar(4) not null,
	uploader varchar(255) not null,
	boardno int null,
	primary key (no)
);