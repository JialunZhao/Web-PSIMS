CREATE DATABASE /*!32312 IF NOT EXISTS*/`psims` /*!40100 DEFAULT CHARACTER SET utf8 */;

use psims;
drop table if exists tb_customer;

drop table if exists tb_customer_log;

drop table if exists tb_employee;

drop table if exists tb_employee_log;

drop table if exists tb_goods;

drop table if exists tb_goods2customer;

drop table if exists tb_goods2customer_log;

drop table if exists tb_goods_log;

drop table if exists tb_import;

drop table if exists tb_import_goods;

drop table if exists tb_import_goods_log;

drop table if exists tb_import_log;

drop table if exists tb_importback;

drop table if exists tb_importback_goods;

drop table if exists tb_importback_goods_log;

drop table if exists tb_inportback_log;

drop table if exists tb_menu;

drop table if exists tb_privilege;

drop table if exists tb_privilege_log;

drop table if exists tb_provider;

drop table if exists tb_provider_log;

drop table if exists tb_sales;

drop table if exists tb_sales_goods;

drop table if exists tb_sales_goods_log;

drop table if exists tb_sales_log;

drop table if exists tb_salesback;

drop table if exists tb_salesback_goods;

drop table if exists tb_salesback_goods_log;

drop table if exists tb_salesback_log;

drop table if exists tb_storagecheck;

drop table if exists tb_storagecheck_log;

drop table if exists tb_storehouse;

drop table if exists tb_storehouse_log;

drop table if exists tb_system_parameter;

drop table if exists tb_system_parameter_log;

/*==============================================================*/
/* Table: tb_customer                                           */
/*==============================================================*/
create table tb_customer
(
   customer_id          int not null auto_increment,
   customer_name        varchar(200),
   customer_code        varchar(200),
   contact_name         varchar(20),
   contact_tel          varchar(20),
   contact_addr         varchar(200),
   email                varchar(100),
   area                 varchar(20),
   customer_type        varchar(2),
   createtime           datetime,
   modifytime           datetime,
   endtime              datetime,
   status               varchar(200),
   remark               varchar(200),
   credit_count         BIGINT,
   primary key (customer_id)
);

/*==============================================================*/
/* Table: tb_customer_log                                       */
/*==============================================================*/
create table tb_customer_log
(
   log_id               int not null auto_increment,
   log_datetime         DATETIME,
   customer_id          int,
   customer_name        varchar(200),
   customer_code        varchar(200),
   contact_name         varchar(20),
   contact_tel          varchar(20),
   contact_addr         varchar(200),
   email                varchar(100),
   area                 varchar(20),
   customer_type        varchar(2),
   createtime           datetime,
   modifytime           datetime,
   endtime              datetime,
   status               varchar(200),
   remark               varchar(200),
   credit_count         BIGINT,
   primary key (log_id)
);

/*==============================================================*/
/* Table: tb_employee                                           */
/*==============================================================*/
create table tb_employee
(
   employee_id          int not null auto_increment,
   employee_name        varchar(20),
   employee_code        varchar(20),
   sex                  varchar(5),
   birthday             datetime,
   contact_tel          varchar(20),
   contact_addr         varchar(200),
   role                 varchar(20),
   status               varchar(2) comment '00 失效
            01 正常',
   remark               varchar(200),
   createtime           DATETIME,
   modifytime           DATETIME,
   endtime              DATETIME,
   islogin              varchar(2),
   login_password       varchar(50),
   primary key (employee_id)
);

alter table tb_employee comment '公司员工的基本信息的管理，公司员工基本包括：员工编号、姓名、性别、出生日期、联系电话、联系地址、职务、状态（有效、离职）';

/*==============================================================*/
/* Table: tb_employee_log                                       */
/*==============================================================*/
create table tb_employee_log
(
   log_id               int not null auto_increment,
   log_datetime         DATETIME,
   employee_id          int,
   employee_name        varchar(20),
   employee_code        varchar(20),
   sex                  varchar(5),
   birthday             datetime,
   contact_tel          varchar(20),
   contact_addr         varchar(200),
   role                 varchar(20),
   status               varchar(2),
   remark               varchar(200),
   islogin              varchar(2),
   login_password       varchar(50),
   createtime           DATETIME,
   modifytime           DATETIME,
   endtime              DATETIME,
   primary key (log_id)
);

alter table tb_employee_log comment '公司员工的基本信息的管理，公司员工基本包括：员工编号、姓名、性别、出生日期、联系电话、联系地址、职务、状态（有效、离职）';

/*==============================================================*/
/* Table: tb_goods                                              */
/*==============================================================*/
create table tb_goods
(
   goods_id             int not null auto_increment,
   goods_name           varchar(200),
   goods_code           varchar(20),
   goods_version        int comment '初始值为 0  
            每次修商品后加1
            ',
   goods_unit           varchar(20),
   goods_bar_code       varchar(200),
   goods_current_stock  int,
   goods_total_stock    int,
   goods_production_date datetime,
   goods_expiration_date datetime,
   goods_shelf_life     int,
   goods_profit         BIGINT,
   goods_price          BIGINT,
   goods_discount_amount BIGINT,
   goods_type           varchar(2),
   goods_status         varchar(2) comment '00-失效 01-正常 02-下架 99-异常',
   goods_createtime     datetime,
   goods_modifytime     datetime,
   goods_endtime        datetime,
   provider_id          int,
   provider_name        varchar(200),
   provider_code        varchar(20),
   remark               varchar(200),
   goods_discount       int comment '例如30%  保存值为 0.3',
   quarter_rebate       BIGINT,
   annual_rebate        BIGINT,
   provider_subsidy     BIGINT,
   provider_package_subsidy BIGINT,
   customer_subsidy     BIGINT,
   other_subsidy        BIGINT,
   goods_actual_cost    BIGINT comment '商品实际成本=
            进价-供应商投入补贴-供应商退盖补贴-季度返利-年度返利-其它返利',
   storage_prewarning   int,
   shelf_life_prewarning int,
   primary key (goods_id)
);

alter table tb_goods comment '商品的创建、查询、上下架的管理。根据商品名称、商品编码、供应商、单价等主要信息创建商品。
商品查询：通过商品';

/*==============================================================*/
/* Table: tb_goods2customer                                     */
/*==============================================================*/
create table tb_goods2customer
(
   goods2customer_id    int not null auto_increment,
   goods_id             int,
   goods_name           varchar(200),
   goods_code           varchar(20),
   customer_id          int,
   customer_name        varchar(200),
   customer_code        varchar(200),
   goods_version        int comment '初始值为 0  
            每次修商品后加1
            ',
   goods_unit           varchar(20),
   goods_bar_code       varchar(200),
   goods_shelf_life     int,
   goods_price          BIGINT,
   goods_discount       int comment '例如30%  保存值为 0.3',
   goods_discount_amount BIGINT,
   goods_type           varchar(2),
   goods_status         varchar(2),
   goods_createtime     datetime,
   goods_modifytime     datetime,
   goods_endtime        datetime,
   provider_id          int,
   provider_name        varchar(200),
   provider_code        varchar(20),
   quarter_rebate       BIGINT,
   annual_rebate        BIGINT,
   provider_subsidy     BIGINT,
   provider_package_subsidy BIGINT,
   customer_subsidy     BIGINT,
   other_subsidy        BIGINT,
   goods_actual_cost    BIGINT comment '商品实际成本=
            进价-供应商投入补贴-供应商退盖补贴-季度返利-年度返利-其它返利',
   goods_profit         BIGINT comment '商品利润=
            销售单价-客户投入-商品实际成本',
   remark               varchar(200),
   primary key (goods2customer_id)
);

alter table tb_goods2customer comment '记录同一商品对不同客户的不同价格，优惠，利润等
';

/*==============================================================*/
/* Table: tb_goods2customer_log                                 */
/*==============================================================*/
create table tb_goods2customer_log
(
   log_id               int not null auto_increment,
   log_datetime         DATETIME,
   goods2customer_id    int,
   goods_id             int,
   goods_name           varchar(200),
   goods_code           varchar(20),
   customer_id          int,
   customer_name        varchar(200),
   customer_code        varchar(200),
   goods_version        int comment '初始值为 0  
            每次修商品后加1
            ',
   goods_unit           varchar(20),
   goods_bar_code       varchar(200),
   goods_shelf_life     int,
   goods_price          BIGINT,
   goods_discount       int comment '例如30%  保存值为 0.3',
   goods_discount_amount BIGINT,
   goods_type           varchar(2),
   goods_status         varchar(2),
   goods_createtime     datetime,
   goods_modifytime     datetime,
   goods_endtime        datetime,
   provider_id          int,
   provider_name        varchar(200),
   provider_code        varchar(20),
   quarter_rebate       BIGINT,
   annual_rebate        BIGINT,
   provider_subsidy     BIGINT,
   provider_package_subsidy BIGINT,
   customer_subsidy     BIGINT,
   other_subsidy        BIGINT,
   goods_actual_cost    BIGINT comment '商品实际成本=
            进价-供应商投入补贴-供应商退盖补贴-季度返利-年度返利-其它返利',
   goods_profit         BIGINT comment '商品利润=
            销售单价-客户投入-商品实际成本',
   remark               varchar(200),
   primary key (log_id)
);

alter table tb_goods2customer_log comment '记录同一商品对不同客户的不同价格，优惠，利润等
';

/*==============================================================*/
/* Table: tb_goods_log                                          */
/*==============================================================*/
create table tb_goods_log
(
   log_id               int not null auto_increment,
   log_datetime         DATETIME,
   goods_id             int,
   goods_name           varchar(200),
   goods_code           varchar(20),
   goods_version        int comment '初始值为 0  
            每次修商品后加1
            ',
   goods_unit           varchar(20),
   goods_bar_code       varchar(200),
   goods_current_stock  int,
   goods_total_stock    int,
   goods_production_date datetime,
   goods_expiration_date datetime,
   goods_shelf_life     int,
   goods_profit         BIGINT,
   goods_price          BIGINT,
   goods_discount_amount BIGINT,
   goods_type           varchar(2),
   goods_status         varchar(2),
   goods_createtime     datetime,
   goods_modifytime     datetime,
   goods_endtime        datetime,
   provider_id          int,
   provider_name        varchar(200),
   provider_code        varchar(20),
   remark               varchar(200),
   goods_discount       int comment '例如30%  保存值为 0.3',
   quarter_rebate       BIGINT,
   annual_rebate        BIGINT,
   provider_subsidy     BIGINT,
   provider_package_subsidy BIGINT,
   customer_subsidy     BIGINT,
   other_subsidy        BIGINT,
   goods_actual_cost    BIGINT comment '商品实际成本=
            进价-供应商投入补贴-供应商退盖补贴-季度返利-年度返利-其它返利',
   storage_prewarning   int,
   shelf_life_prewarning int,
   primary key (log_id)
);

alter table tb_goods_log comment '商品的创建、查询、上下架的管理。根据商品名称、商品编码、供应商、单价等主要信息创建商品。
商品查询：通过商品';

/*==============================================================*/
/* Table: tb_import                                             */
/*==============================================================*/
create table tb_import
(
   import_id            int not null auto_increment,
   import_serial_number varchar(200) not null,
   import_datetime      datetime,
   import_batch_number  varchar(200),
   import_total_price   BIGINT,
   payment_type         varchar(2),
   payment_time         datetime,
   import_type          varchar(2),
   import_status        varchar(2),
   import_remark        varchar(200),
   provider_id          int,
   provider_name        varchar(200),
   primary key (import_id, import_serial_number)
);

/*==============================================================*/
/* Table: tb_import_goods                                       */
/*==============================================================*/
create table tb_import_goods
(
   import_goods_id      int not null auto_increment,
   import_serial_number varchar(200),
   goods_id             int,
   goods_name           varchar(200),
   import_goods_type    varchar(20) comment '可售-Y
            不可售-N',
   import_goods_amount  int,
   import_goods_unit    varchar(20),
   import_goods_price   BIGINT,
   import_discount_amount BIGINT,
   import_goods_createtime datetime,
   import_goods_modifytime datetime,
   import_goods_endtime datetime,
   import_goods_remark  varchar(200),
   is_discount          varchar(2),
   is_box_bottle        varchar(2),
   total_price          BIGINT,
   discount_duty_total_price BIGINT,
   discount_total_price BIGINT,
   discount_rate        BIGINT,
   box_bottle_price     BIGINT,
   box_bottle_total_price BIGINT,
   res_import_goods_amount int,
   goods_shelf_life     int,
   primary key (import_goods_id)
);

/*==============================================================*/
/* Table: tb_import_goods_log                                   */
/*==============================================================*/
create table tb_import_goods_log
(
   log_id               int not null auto_increment,
   log_datetime         DATETIME,
   import_goods_id      int,
   import_serial_number varchar(200),
   goods_id             int,
   goods_name           varchar(200),
   import_goods_type    varchar(2),
   import_goods_amount  int,
   import_goods_unit    varchar(20),
   import_goods_price   BIGINT,
   import_discount_amount BIGINT,
   import_goods_createtime datetime,
   import_goods_modifytime datetime,
   import_goods_endtime datetime,
   import_goods_remark  varchar(200),
   is_discount          varchar(2),
   is_box_bottle        varchar(2),
   total_price          BIGINT,
   discount_duty_total_price BIGINT,
   discount_total_price BIGINT,
   discount_rate        BIGINT,
   box_bottle_price     BIGINT,
   box_bottle_total_price BIGINT,
   res_import_goods_amount int,
   goods_shelf_life     int,
   primary key (log_id)
);

/*==============================================================*/
/* Table: tb_import_log                                         */
/*==============================================================*/
create table tb_import_log
(
   log_id               int not null auto_increment,
   log_datetime         DATETIME,
   import_id            int,
   import_serial_number varchar(200),
   import_datetime      datetime,
   import_batch_number  varchar(200),
   import_total_price   BIGINT,
   payment_type         varchar(2),
   payment_time         datetime,
   import_type          varchar(2),
   import_status        varchar(2),
   import_remark        varchar(200),
   provider_id          int,
   provider_name        varchar(200),
   primary key (log_id)
);

/*==============================================================*/
/* Table: tb_importback                                         */
/*==============================================================*/
create table tb_importback
(
   importback_id        int not null auto_increment,
   importback_serial_number varchar(200) not null,
   import_id            int not null auto_increment,
   import_serial_number varchar(200),
   provider_id          int,
   provider_name        varchar(200),
   storehouse_id        int,
   storehouse_name      varchar(200),
   importback_type      varchar(2),
   importback_reason    varchar(200),
   importback_time      datetime,
   importback_refund    BIGINT,
   importback_refund_type varchar(2),
   importback_refund_time datetime,
   importback_remark    varchar(200),
   primary key ()
);

/*==============================================================*/
/* Table: tb_importback_goods                                   */
/*==============================================================*/
create table tb_importback_goods
(
   importback_goods_id  varchar(200) not null,
   importback_id        int,
   importback_serial_number varchar(200),
   goods_id             int,
   goods_name           varchar(200),
   importback_goods_type varchar(2),
   importback_goods_amount int,
   importback_goods_unit varchar(20),
   importback_goods_price BIGINT,
   importback_goods_production datetime,
   importback_goods_expiration datetime,
   importback_discount_amount BIGINT,
   importback_goods_createtime datetime,
   importback_goods_modifytime datetime,
   importback_goods_endtime datetime,
   importback_goods_remark varchar(200),
   primary key (importback_goods_id)
);

/*==============================================================*/
/* Table: tb_importback_goods_log                               */
/*==============================================================*/
create table tb_importback_goods_log
(
   log_id               int not null auto_increment,
   log_datetime         DATETIME,
   importback_goods_id  varchar(200),
   importback_id        int,
   importback_serial_number varchar(200),
   goods_id             int,
   goods_name           varchar(200),
   importback_goods_type varchar(2),
   importback_goods_amount int,
   importback_goods_unit varchar(20),
   importback_goods_price BIGINT,
   importback_goods_production datetime,
   importback_goods_expiration datetime,
   importback_discount_amount BIGINT,
   importback_goods_createtime datetime,
   importback_goods_modifytime datetime,
   importback_goods_endtime datetime,
   importback_goods_remark varchar(200),
   primary key (log_id)
);

/*==============================================================*/
/* Table: tb_inportback_log                                     */
/*==============================================================*/
create table tb_inportback_log
(
   log_id               int not null auto_increment,
   log_datetime         DATETIME,
   importback_id        int,
   importback_serial_number varchar(200),
   import_id            int,
   import_serial_number varchar(200),
   provider_id          int,
   provider_name        varchar(200),
   storehouse_id        int,
   storehouse_name      varchar(200),
   importback_type      varchar(2),
   importback_reason    varchar(200),
   importback_time      datetime,
   importback_refund    BIGINT,
   importback_refund_type varchar(2),
   importback_refund_time datetime,
   importback_remark    varchar(200),
   primary key (log_id)
);

/*==============================================================*/
/* Table: tb_menu                                               */
/*==============================================================*/
create table tb_menu
(
   menu_id              int not null auto_increment,
   menu_name            varchar(20),
   menu_status          varchar(20),
   menu_code            varchar(20),
   menu_url             VARCHAR(50),
   remark               varchar(200),
   createtime           DATETIME,
   modifytime           DATETIME,
   endtime              DATETIME,
   priv                 VARCHAR(255),
   primary key (menu_id)
);

/*==============================================================*/
/* Table: tb_privilege                                          */
/*==============================================================*/
create table tb_privilege
(
   id                   INT not null auto_increment,
   user_id              VARCHAR(20),
   privilege            VARCHAR(10000),
   createtime           DATETIME,
   modifytime           DATETIME,
   endtime              DATETIME,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_privilege_log                                      */
/*==============================================================*/
create table tb_privilege_log
(
   log_id               INT not null auto_increment,
   log_datetime         DATETIME,
   id                   INT,
   user_id              VARCHAR(20),
   privilege            VARCHAR(10000),
   createtime           DATETIME,
   modifytime           DATETIME,
   endtime              DATETIME,
   primary key (log_id)
);

/*==============================================================*/
/* Table: tb_provider                                           */
/*==============================================================*/
create table tb_provider
(
   provider_id          int not null auto_increment,
   provider_name        varchar(200),
   provider_code        varchar(20),
   provider_contact_name varchar(10),
   provider_contact_tel varchar(20),
   provider_contact_fax varchar(20),
   provider_contact_email varchar(100),
   provider_contact_address varchar(200),
   provider_bank_name   varchar(100),
   provider_bank_account_name varchar(200),
   provider_bank_account_code varchar(200),
   provider_prize_pool  BIGINT,
   provider_taxid       varchar(100),
   provider_area        varchar(20),
   provider_type        varchar(2) comment '00 失效
            01 正常',
   provider_status      varchar(2) comment '00 失效
            01 正常',
   provider_createtime  DATETIME,
   provider_modifytime  DATETIME,
   provider_endtime     DATETIME,
   provider_remark      varchar(200),
   primary key (provider_id)
);

alter table tb_provider comment '供应商基本信息：单位名称、联系人、联系电话、传真、联系地址、银行账号、税号、e-mail、所属地区。';

/*==============================================================*/
/* Table: tb_provider_log                                       */
/*==============================================================*/
create table tb_provider_log
(
   log_id               int not null auto_increment,
   log_datetime         DATETIME,
   provider_id          int,
   provider_name        varchar(200),
   provider_code        varchar(20),
   provider_contact_name varchar(10),
   provider_contact_tel varchar(20),
   provider_contact_fax varchar(20),
   provider_contact_email varchar(100),
   provider_prize_pool  BIGINT,
   provider_contact_address varchar(200),
   provider_bank_name   varchar(100),
   provider_bank_account_name varchar(200),
   provider_bank_account_code varchar(200),
   provider_taxid       varchar(100),
   provider_area        varchar(20),
   provider_status      varchar(2) comment '00 失效
            01 正常',
   provider_createtime  DATETIME,
   provider_modifytime  DATETIME,
   provider_endtime     DATETIME,
   provider_remark      varchar(200),
   primary key (log_id)
);

alter table tb_provider_log comment '供应商基本信息：单位名称、联系人、联系电话、传真、联系地址、银行账号、税号、e-mail、所属地区。';

/*==============================================================*/
/* Table: tb_sales                                              */
/*==============================================================*/
create table tb_sales
(
   sales_id             int not null auto_increment,
   sales_serial_number  varchar(200) not null,
   sales_date           datetime,
   customer_id          int,
   customer_name        varchar(200),
   storehouse_id        int,
   storehouse_name      varchar(200),
   employee_id          int,
   employee_name        varchar(20),
   income_type          varchar(2),
   income_time          datetime,
   sales_total_price    BIGINT,
   sales_status         varchar(2) comment '01 下单 	
            02 出单 据（4联）--库房收取1联	
            03 提送货（司机无单据）	
            04 到店 （1联单据） （现金）	
            05 结账 （收2联）	/
             
            01 下单 	
            02 出单 据（4联）--库房收取1联	
            03 提送货（司机无单据）	
            04 到店 （1联单据） （现金）	
            05 应收账款。/欠付（统一结算）
            06 结账',
   sales_type           varchar(2),
   sales_remark         varchar(200),
   credit_count         BIGINT,
   primary key (sales_id, sales_serial_number)
);

/*==============================================================*/
/* Table: tb_sales_goods                                        */
/*==============================================================*/
create table tb_sales_goods
(
   sales_goods_id       int not null auto_increment,
   sales_serial_number  varchar(200),
   goods_id             int,
   goods_name           varchar(200),
   sales_goods_type     varchar(2),
   sales_goods_amount   int,
   sales_goods_unit     varchar(20),
   sales_goods_price    BIGINT,
   sales_goods_production_date datetime,
   sales_goods_expiration_date datetime,
   sales_goods_total_price BIGINT,
   sales_discount_amount BIGINT,
   sales_final_amount   BIGINT,
   sales_goods_createtime datetime,
   sales_goods_modifytime datetime,
   sales_goods_endtime  datetime,
   sales_goods_remark   varchar(200),
   storage_id           int,
   primary key (sales_goods_id)
);

/*==============================================================*/
/* Table: tb_sales_goods_log                                    */
/*==============================================================*/
create table tb_sales_goods_log
(
   log_id               int not null auto_increment,
   log_datetime         DATETIME,
   sales_goods_id       int,
   sales_serial_number  varchar(200),
   goods_id             int,
   goods_name           varchar(200),
   sales_goods_type     varchar(2),
   sales_goods_amount   int,
   sales_goods_unit     varchar(20),
   sales_goods_price    BIGINT,
   sales_goods_production_date datetime,
   sales_goods_expiration_date datetime,
   sales_goods_total_price BIGINT,
   sales_discount_amount BIGINT,
   sales_final_amount   BIGINT,
   sales_goods_createtime datetime,
   sales_goods_modifytime datetime,
   sales_goods_endtime  datetime,
   sales_goods_remark   varchar(200),
   storage_id           int,
   primary key (log_id)
);

/*==============================================================*/
/* Table: tb_sales_log                                          */
/*==============================================================*/
create table tb_sales_log
(
   log_id               int not null auto_increment,
   log_datetime         DATETIME,
   sales_id             int,
   sales_serial_number  varchar(200),
   sales_date           datetime,
   customer_id          int,
   customer_name        varchar(200),
   storehouse_id        int,
   storehouse_name      varchar(200),
   employee_id          int,
   employee_name        varchar(20),
   income_type          varchar(2),
   income_time          datetime,
   sales_total_price    BIGINT,
   sales_status         varchar(2),
   sales_type           varchar(2),
   sales_remark         varchar(200),
   credit_count         BIGINT,
   primary key (log_id)
);

/*==============================================================*/
/* Table: tb_salesback                                          */
/*==============================================================*/
create table tb_salesback
(
   salesback_id         int not null auto_increment,
   salesback_serial_number varchar(200) not null,
   sales_serial_number  varchar(200),
   customer_id          int,
   customer_name        varchar(200),
   storehouse_id        int,
   storehouse_name      varchar(200),
   employee_id          int,
   employee_name        varchar(20),
   salesback_type       varchar(2),
   salesback_reason     varchar(200),
   salesback_time       datetime,
   salesback_refund     BIGINT,
   salesback_refund_type varchar(2),
   salesback_refund_time datetime,
   salesback_remark     varchar(200),
   primary key (salesback_id, salesback_serial_number)
);

/*==============================================================*/
/* Table: tb_salesback_goods                                    */
/*==============================================================*/
create table tb_salesback_goods
(
   salesback_goods_id   int not null auto_increment,
   salesback_serial_number varchar(200) not null,
   goods_id             int,
   goods_name           varchar(200),
   goods_status         varchar(2),
   goods_type           varchar(2),
   goods_amount         int,
   goods_unit           varchar(20),
   goods_price          BIGINT,
   goods_production     datetime,
   goods_expiration     datetime,
   discount_amount      BIGINT,
   createtime           datetime,
   modifytime           datetime,
   endtime              datetime,
   remark               varchar(200),
   storage_id           int,
   primary key (salesback_goods_id, salesback_serial_number)
);

/*==============================================================*/
/* Table: tb_salesback_goods_log                                */
/*==============================================================*/
create table tb_salesback_goods_log
(
   log_id               int not null auto_increment,
   log_datetime         DATETIME,
   salesback_goods_id   int,
   salesback_serial_number varchar(200),
   goods_id             int,
   goods_name           varchar(200),
   goods_status         varchar(2),
   goods_type           varchar(2),
   goods_amount         int,
   goods_unit           varchar(20),
   goods_price          BIGINT,
   goods_production     datetime,
   goods_expiration     datetime,
   discount_amount      BIGINT,
   createtime           datetime,
   modifytime           datetime,
   endtime              datetime,
   remark               varchar(200),
   storage_id           int,
   primary key (log_id)
);

/*==============================================================*/
/* Table: tb_salesback_log                                      */
/*==============================================================*/
create table tb_salesback_log
(
   log_id               int not null auto_increment,
   log_datetime         DATETIME,
   salesback_id         int,
   salesback_serial_number varchar(200),
   sales_serial_number  varchar(200),
   customer_id          int,
   customer_name        varchar(200),
   storehouse_id        int,
   storehouse_name      varchar(200),
   employee_id          int,
   employee_name        varchar(20),
   salesback_type       varchar(2),
   salesback_reason     varchar(200),
   salesback_time       datetime,
   salesback_refund     BIGINT,
   salesback_refund_type varchar(2),
   salesback_refund_time datetime,
   salesback_remark     varchar(200),
   primary key (log_id)
);

/*==============================================================*/
/* Table: tb_storagecheck                                       */
/*==============================================================*/
create table tb_storagecheck
(
   storage_id           int not null auto_increment,
   goods_id             int,
   goods_name           varchar(200),
   goods_bar_code       varchar(200),
   provider_id          int,
   provider_name        varchar(200),
   storage_rate_current int,
   storage_rate_total   int,
   goods_production_date datetime,
   goods_expiration_date datetime,
   goods_shelf_life     int,
   goods_price          BIGINT,
   goods_status         varchar(2),
   storage_type         varchar(2),
   createtime           datetime,
   modifytime           datetime,
   endtime              datetime,
   remark               varchar(200),
   import_serial_number varchar(200),
   import_goods_unit    varchar(20),
   storage_warning      int,
   shelf_life_warning   int,
   primary key (storage_id)
);

/*==============================================================*/
/* Table: tb_storagecheck_log                                   */
/*==============================================================*/
create table tb_storagecheck_log
(
   log_id               int not null auto_increment,
   log_datetime         DATETIME,
   storage_id           int,
   goods_id             int,
   goods_name           varchar(200),
   goods_bar_code       varchar(200),
   provider_id          int,
   provider_name        varchar(200),
   storage_rate_current int,
   storage_rate_total   int,
   goods_production_date datetime,
   goods_expiration_date datetime,
   goods_shelf_life     int,
   goods_price          BIGINT,
   goods_status         varchar(2),
   storage_type         varchar(2),
   createtime           datetime,
   modifytime           datetime,
   endtime              datetime,
   remark               varchar(200),
   import_serial_number varchar(200),
   import_goods_unit    varchar(20),
   storage_warning      int,
   shelf_life_warning   int,
   primary key (log_id)
);

/*==============================================================*/
/* Table: tb_storehouse                                         */
/*==============================================================*/
create table tb_storehouse
(
   storehouse_id        int not null auto_increment,
   storehouse_name      varchar(200),
   storehouse_code      varchar(20),
   area                 varchar(20),
   type                 varchar(10),
   contact_name         varchar(10),
   contact_tel          varchar(20),
   contact_fax          varchar(20),
   contact_email        varchar(100),
   contact_address      varchar(200),
   status               varchar(2),
   createtime           datetime,
   modifytime           datetime,
   endtime              datetime,
   remark               varchar(200),
   primary key (storehouse_id)
);

/*==============================================================*/
/* Table: tb_storehouse_log                                     */
/*==============================================================*/
create table tb_storehouse_log
(
   log_id               int not null auto_increment,
   log_datetime         DATETIME,
   storehouse_id        int,
   storehouse_name      varchar(200),
   storehouse_code      varchar(20),
   area                 varchar(20),
   type                 varchar(10),
   contact_name         varchar(10),
   contact_tel          varchar(20),
   contact_fax          varchar(20),
   contact_email        varchar(100),
   contact_address      varchar(200),
   status               varchar(2),
   createtime           datetime,
   modifytime           datetime,
   endtime              datetime,
   remark               varchar(200),
   primary key (log_id)
);

/*==============================================================*/
/* Table: tb_system_parameter                                   */
/*==============================================================*/
create table tb_system_parameter
(
   param_id             int not null auto_increment,
   p_key                varchar(45),
   p_desc               varchar(45),
   p_value              varchar(45),
   pp_key               varchar(45),
   pp_desc              varchar(45),
   pp_value             varchar(45),
   pp_valueINT          BIGINT,
   p_remark             varchar(200),
   p_createtime         DATETIME,
   p_status             varchar(2),
   primary key (param_id)
);

alter table tb_system_parameter comment '管理系统基本参数包括：库存缺货、积压、过期的提醒设置；
回收类型（瓶子、瓶子盖）、基本单位（箱、瓶）、支付方';

/*==============================================================*/
/* Table: tb_system_parameter_log                               */
/*==============================================================*/
create table tb_system_parameter_log
(
   log_id               int not null auto_increment,
   log_datetime         DATETIME,
   param_id             int,
   p_key                varchar(45),
   p_desc               varchar(45),
   p_value              varchar(45),
   pp_key               varchar(45),
   pp_desc              varchar(45),
   pp_value             varchar(45),
   pp_valueINT          BIGINT,
   p_remark             varchar(200),
   p_createtime         DATETIME,
   p_status             varchar(2),
   primary key (log_id)
);

alter table tb_system_parameter_log comment '管理系统基本参数包括：库存缺货、积压、过期的提醒设置；
回收类型（瓶子、瓶子盖）、基本单位（箱、瓶）、支付方';

/*Data for the table `tb_menu` */

insert  into `tb_menu`(`menu_id`,`menu_name`,`menu_status`,`menu_code`,`menu_url`,`remark`,`createtime`,`modifytime`,`endtime`,`priv`) values (1,'客户管理',NULL,NULL,'/customerController/customer.do',NULL,NULL,NULL,NULL,'客户管理.显示菜单'),(2,'供应商',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'供应商.显示菜单'),(3,'商品管理',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'商品管理.显示菜单'),(4,'仓库管理',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'仓库管理.显示菜单'),(5,'货品入库',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'商品入库.显示菜单'),(6,'销售出库',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'销售出库.显示菜单'),(7,'退货管理',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'退货管理.显示菜单'),(8,'有效期调整',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'有效期管理.显示菜单'),(9,'销毁出库',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'销毁出库.显示菜单'),(10,'回收物入库',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'回收物入库.显示菜单'),(11,'回收物出库',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'回收物出库.显示菜单'),(12,'统计报表',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'统计报表.显示菜单'),(13,'系统设置','01 ',NULL,'/sys/show.do',NULL,NULL,NULL,NULL,'系统设置.显示菜单'),(14,'员工权限','01 ',NULL,'/user/show.do',NULL,NULL,NULL,NULL,'员工权限.显示菜单');

/*Data for the table `tb_privilege` */

insert  into `tb_privilege`(`id`,`user_id`,`privilege`,`createtime`,`modifytime`,`endtime`) values (1,'1','系统设置.增删改,员工权限.增删改,客户管理.增删改,供应商.增删改,商品管理.增删改,仓库管理.增删改,商品入库.增删改,销售出库.增删改,退货管理.增删改,有效期管理.增删改,销毁出库.增删改,回收物入库.增删改,回收物出库.增删改,统计报表.增删改,系统设置.显示菜单,,员工权限.显示菜单,,客户管理.显示菜单,,供应商.显示菜单,,商品管理.显示菜单,,仓库管理.显示菜单,,商品入库.显示菜单,,销售出库.显示菜单,,退货管理.显示菜单,,有效期管理.显示菜单,,销毁出库.显示菜单,,回收物入库.显示菜单,,回收物出库.显示菜单,,统计报表.显示菜单','2015-04-21 00:00:00','2015-04-21 00:00:00','2020-04-21 00:00:00');


