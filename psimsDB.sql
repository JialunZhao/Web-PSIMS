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
   customer_id          int not null auto_increment comment '客户ID',
   customer_name        varchar(200) comment '客户名称',
   customer_code        varchar(200) comment '客户代码',
   contact_name         varchar(20) comment '联系人名称',
   contact_tel          varchar(20) comment '联系人电话',
   contact_addr         varchar(200) comment '联系地址',
   email                varchar(100) comment 'E-mail',
   area                 varchar(20) comment '客户地域',
   customer_type        varchar(2) comment '客户类别',
   createtime           datetime comment '客户添加时间',
   modifytime           datetime comment '客户修改时间',
   endtime              datetime comment '客户终止时间',
   status               varchar(200) comment '客户状态',
   remark               varchar(200) comment '客户备注',
   credit_count         varchar(20) comment '赊账金额',
   checkout_code        varchar(2) comment '结账方式编码',
   checkout_name        varchar(45) comment '结账方式名称',
   checkout_warning     varchar(20) comment '结账到期阈值',
   employee_id          int not null comment '员工ID',
   employee_name        varchar(20) comment '员工姓名',
   employee_code        varchar(20) comment '员工代码',
   primary key (customer_id)
);

/*==============================================================*/
/* Table: tb_customer_log                                       */
/*==============================================================*/
create table tb_customer_log
(
   log_id               int not null auto_increment,
   log_datetime         DATETIME,
   customer_id          int comment '客户ID',
   customer_name        varchar(200) comment '客户名称',
   customer_code        varchar(200) comment '客户代码',
   contact_name         varchar(20) comment '联系人名称',
   contact_tel          varchar(20) comment '联系人电话',
   contact_addr         varchar(200) comment '联系地址',
   email                varchar(100) comment 'E-mail',
   area                 varchar(20) comment '客户地域',
   customer_type        varchar(2) comment '客户类别',
   createtime           datetime comment '客户添加时间',
   modifytime           datetime comment '客户修改时间',
   endtime              datetime comment '客户终止时间',
   status               varchar(200) comment '客户状态',
   remark               varchar(200) comment '客户备注',
   credit_count         varchar(20) comment '赊账金额',
   checkout_code        varchar(2) comment '结账方式编码',
   checkout_name        varchar(45) comment '结账方式名称',
   checkout_warning     varchar(20) comment '结账到期阈值',
   employee_id          int not null comment '员工ID',
   employee_name        varchar(20) comment '员工姓名',
   employee_code        varchar(20) comment '员工代码',
   primary key (log_id)
);

/*==============================================================*/
/* Table: tb_employee                                           */
/*==============================================================*/
create table tb_employee
(
   employee_id          int not null auto_increment comment '员工ID',
   employee_name        varchar(20) comment '员工名称',
   employee_code        varchar(20) comment '员工代码',
   sex                  varchar(5) comment '员工性别',
   birthday             datetime comment '员工出生日期',
   idcard               varchar(20) comment '员工身份证',
   contact_tel          varchar(20) comment '员工联系电话',
   contact_addr         varchar(200) comment '员工联系地址',
   role                 varchar(20) comment '员工职务',
   status               varchar(2) comment '00 失效
            01 正常',
   remark               varchar(200) comment '员工备注',
   createtime           DATETIME comment '添加时间',
   modifytime           DATETIME comment '修改时间',
   endtime              DATETIME comment '终止时间',
   islogin              varchar(2) comment '是否登录系统',
   login_password       varchar(50) comment '登录密码',
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
   employee_id          int comment '员工ID',
   employee_name        varchar(20) comment '员工名称',
   employee_code        varchar(20) comment '员工代码',
   sex                  varchar(5) comment '员工性别',
   birthday             datetime comment '员工出生日期',
   idcard               varchar(20) comment '员工身份证',
   contact_tel          varchar(20) comment '员工联系电话',
   contact_addr         varchar(200) comment '员工联系地址',
   role                 varchar(20) comment '员工职务',
   status               varchar(2) comment '00 失效
            01 正常',
   remark               varchar(200) comment '员工备注',
   createtime           DATETIME comment '添加时间',
   modifytime           DATETIME comment '修改时间',
   endtime              DATETIME comment '终止时间',
   islogin              varchar(2) comment '是否登录系统',
   login_password       varchar(50) comment '登录密码',
   primary key (log_id)
);

alter table tb_employee_log comment '公司员工的基本信息的管理，公司员工基本包括：员工编号、姓名、性别、出生日期、联系电话、联系地址、职务、状态（有效、离职）';

/*==============================================================*/
/* Table: tb_goods                                              */
/*==============================================================*/
create table tb_goods
(
   goods_id             int not null auto_increment comment '商品编号',
   goods_name           varchar(200) comment '商品名称',
   goods_code           varchar(20) comment '商品代码',
   goods_version        int comment '商品版本号：初始值为 0  
            每次修商品后加1
            ',
   goods_unit           varchar(20) comment '商品基本单位',
   goods_bar_code       varchar(200) comment '商品条形码',
   goods_current_stock  int comment '当前剩余库存(暂不使用)',
   goods_total_stock    int comment '商品库存总量(暂不使用)',
   goods_production_date datetime comment '商品生产日期(暂不使用)',
   goods_expiration_date datetime comment '商品失效日期(暂不使用)',
   goods_shelf_life     int comment '商品保质期时长',
   goods_actual_cost    varchar(100) comment '进价',
   goods_price          varchar(100) comment '商品单价（售价）',
   goods_profit         varchar(100) comment '商品利润（毛利）',
   goods_discount_amount varchar(100) comment '商品优惠后价格',
   goods_type           varchar(2) comment '商品类型',
   goods_status         varchar(2) comment '00-失效 01-正常 02-下架 99-异常',
   goods_createtime     datetime comment '商品添加时间',
   goods_modifytime     datetime comment '商品修改时间',
   goods_endtime        datetime comment '商品终止时间',
   provider_id          int comment '供应商编号',
   provider_name        varchar(200) comment '供应商名称',
   provider_code        varchar(20) comment '供应商代码',
   remark               varchar(200) comment '商品备注信息',
   goods_discount       varchar(100) comment '例如30%  保存值为 0.3',
   single_rebate        varchar(100) comment '单箱返利',
   quarter_rebate       varchar(100) comment '单箱季返=单箱返利 * 加权平均返利 / 1.17
            ',
   annual_rebate        varchar(100) comment '单箱年度返利',
   purchase_rebate      varchar(100) comment '进货奖励',
   promotion_rebate     varchar(100) comment '售点促销',
   provider_subsidy     varchar(100) comment '供应商投入补贴',
   customer_bottle_subsidy varchar(100) comment '客户回瓶补贴',
   customer_package_subsidy varchar(100) comment '客户回盖补贴',
   provider_package_subsidy varchar(100) comment '供应商退盖补贴',
   customer_subsidy     varchar(100) comment '客户投入补贴（店方投入）',
   other_subsidy        varchar(100) comment '其它补贴',
   single_final_cost    varchar(100) comment '单箱商品实际成本=进价-供应商投入补贴-供应商退盖补贴-季度返利-年度返利-其它返利',
   storage_warning      int comment '库存量预警值',
   shelf_life_warning   int comment '保质期预警值',
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
   goods_version        int comment '商品版本号：初始值为 0  
            每次修商品后加1
            ',
   goods_unit           varchar(20) comment '商品基本单位',
   goods_bar_code       varchar(200) comment '商品条形码',
   goods_current_stock  int comment '当前剩余库存',
   goods_total_stock    int comment '商品库存总量',
   goods_production_date datetime comment '商品生产日期',
   goods_expiration_date datetime comment '商品失效日期',
   goods_shelf_life     int comment '商品保质期时长',
   goods_actual_cost    varchar(100) comment '进价',
   goods_price          varchar(100) comment '商品单价（售价）',
   goods_profit         varchar(100) comment '商品利润（毛利）',
   goods_discount_amount varchar(100) comment '商品优惠后价格',
   goods_type           varchar(2) comment '商品类型',
   goods_status         varchar(2) comment '00-失效 01-正常 02-下架 99-异常',
   goods_createtime     datetime comment '商品添加时间',
   goods_modifytime     datetime comment '商品修改时间',
   goods_endtime        datetime comment '商品终止时间',
   provider_id          int comment '供应商编号',
   provider_name        varchar(200) comment '供应商名称',
   provider_code        varchar(20) comment '供应商代码',
   remark               varchar(200) comment '商品备注信息',
   goods_discount       varchar(100) comment '例如30%  保存值为 0.3',
   single_rebate        varchar(100) comment '单箱返利',
   quarter_rebate       varchar(100) comment '单箱季返=单箱返利 * 加权平均返利 / 1.17
            ',
   annual_rebate        varchar(100) comment '单箱年度返利',
   purchase_rebate      varchar(100) comment '进货奖励',
   promotion_rebate     varchar(100) comment '售点促销',
   provider_subsidy     varchar(100) comment '供应商投入补贴',
   customer_bottle_subsidy varchar(100) comment '客户回瓶补贴',
   customer_package_subsidy varchar(100) comment '客户回盖补贴',
   provider_package_subsidy varchar(100) comment '供应商退盖补贴',
   customer_subsidy     varchar(100) comment '客户投入补贴（店方投入）',
   other_subsidy        varchar(100) comment '其它补贴',
   storage_warning      int comment '库存量预警值',
   shelf_life_warning   int comment '保质期预警值',
   single_final_cost    varchar(100) comment '单箱商品实际成本=进价-供应商投入补贴-供应商退盖补贴-季度返利-年度返利-其它返利',
   primary key (goods2customer_id)
);

alter table tb_goods2customer comment '记录同一商品对不同客户的不同价格，优惠，利润等
';

/*==============================================================*/
/* Table: tb_goods2customer_log                                 */
/*==============================================================*/
create table tb_goods2customer_log
(
   log_id               int not null auto_increment comment '日志id',
   log_datetime         DATETIME comment '日志记录时间',
   goods2customer_id    int not null,
   goods_id             int,
   goods_name           varchar(200),
   goods_code           varchar(20),
   customer_id          int,
   customer_name        varchar(200),
   customer_code        varchar(200),
   goods_version        int comment '商品版本号：初始值为 0  
            每次修商品后加1
            ',
   goods_unit           varchar(20) comment '商品基本单位',
   goods_bar_code       varchar(200) comment '商品条形码',
   goods_current_stock  int comment '当前剩余库存',
   goods_total_stock    int comment '商品库存总量',
   goods_production_date datetime comment '商品生产日期',
   goods_expiration_date datetime comment '商品失效日期',
   goods_shelf_life     int comment '商品保质期时长',
   goods_actual_cost    varchar(100) comment '进价',
   goods_price          varchar(100) comment '商品单价（售价）',
   goods_profit         varchar(100) comment '商品利润（毛利）',
   goods_discount_amount varchar(100) comment '商品优惠后价格',
   goods_type           varchar(2) comment '商品类型',
   goods_status         varchar(2) comment '00-失效 01-正常 02-下架 99-异常',
   goods_createtime     datetime comment '商品添加时间',
   goods_modifytime     datetime comment '商品修改时间',
   goods_endtime        datetime comment '商品终止时间',
   provider_id          int comment '供应商编号',
   provider_name        varchar(200) comment '供应商名称',
   provider_code        varchar(20) comment '供应商代码',
   remark               varchar(200) comment '商品备注信息',
   goods_discount       varchar(100) comment '例如30%  保存值为 0.3',
   single_rebate        varchar(100) comment '单箱返利',
   quarter_rebate       varchar(100) comment '单箱季返=单箱返利 * 加权平均返利 / 1.17
            ',
   annual_rebate        varchar(100) comment '单箱年度返利',
   purchase_rebate      varchar(100) comment '进货奖励',
   promotion_rebate     varchar(100) comment '售点促销',
   provider_subsidy     varchar(100) comment '供应商投入补贴',
   customer_bottle_subsidy varchar(100) comment '客户回瓶补贴',
   customer_package_subsidy varchar(100) comment '客户回盖补贴',
   provider_package_subsidy varchar(100) comment '供应商退盖补贴',
   customer_subsidy     varchar(100) comment '客户投入补贴（店方投入）',
   other_subsidy        varchar(100) comment '其它补贴',
   storage_warning      int comment '库存量预警值',
   shelf_life_warning   int comment '保质期预警值',
   single_final_cost    varchar(100) comment '单箱商品实际成本=进价-供应商投入补贴-供应商退盖补贴-季度返利-年度返利-其它返利',
   primary key (log_id)
);

alter table tb_goods2customer_log comment '记录同一商品对不同客户的不同价格，优惠，利润等
';

/*==============================================================*/
/* Table: tb_goods_log                                          */
/*==============================================================*/
create table tb_goods_log
(
   log_id               int not null auto_increment comment '日志id',
   log_datetime         DATETIME comment '日志记录时间',
   goods_id             int not null comment '商品编号',
   goods_name           varchar(200) comment '商品名称',
   goods_code           varchar(20) comment '商品代码',
   goods_version        int comment '商品版本号：初始值为 0  
            每次修商品后加1
            ',
   goods_unit           varchar(20) comment '商品基本单位',
   goods_bar_code       varchar(200) comment '商品条形码',
   goods_current_stock  int comment '当前剩余库存(暂不使用)',
   goods_total_stock    int comment '商品库存总量(暂不使用)',
   goods_production_date datetime comment '商品生产日期(暂不使用)',
   goods_expiration_date datetime comment '商品失效日期(暂不使用)',
   goods_shelf_life     int comment '商品保质期时长',
   goods_actual_cost    varchar(100) comment '进价',
   goods_price          varchar(100) comment '商品单价（售价）',
   goods_profit         varchar(100) comment '商品利润（毛利）',
   goods_discount_amount varchar(100) comment '商品优惠后价格',
   goods_type           varchar(2) comment '商品类型',
   goods_status         varchar(2) comment '00-失效 01-正常 02-下架 99-异常',
   goods_createtime     datetime comment '商品添加时间',
   goods_modifytime     datetime comment '商品修改时间',
   goods_endtime        datetime comment '商品终止时间',
   provider_id          int comment '供应商编号',
   provider_name        varchar(200) comment '供应商名称',
   provider_code        varchar(20) comment '供应商代码',
   remark               varchar(200) comment '商品备注信息',
   goods_discount       varchar(100) comment '例如30%  保存值为 0.3',
   single_rebate        varchar(100) comment '单箱返利',
   quarter_rebate       varchar(100) comment '单箱季返=单箱返利 * 加权平均返利 / 1.17
            ',
   annual_rebate        varchar(100) comment '单箱年度返利',
   purchase_rebate      varchar(100) comment '进货奖励',
   promotion_rebate     varchar(100) comment '售点促销',
   provider_subsidy     varchar(100) comment '供应商投入补贴',
   customer_bottle_subsidy varchar(100) comment '客户回瓶补贴',
   customer_package_subsidy varchar(100) comment '客户回盖补贴',
   provider_package_subsidy varchar(100) comment '供应商退盖补贴',
   customer_subsidy     varchar(100) comment '客户投入补贴（店方投入）',
   other_subsidy        varchar(100) comment '其它补贴',
   storage_warning      int comment '库存量预警值',
   shelf_life_warning   int comment '保质期预警值',
   single_final_cost    varchar(100) comment '单箱商品实际成本=进价-供应商投入补贴-供应商退盖补贴-季度返利-年度返利-其它返利',
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
   primary key (importback_id)
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
   provider_id          int not null auto_increment comment '供应商编号',
   provider_name        varchar(200) comment '供应商名称',
   provider_code        varchar(20) comment '供应商代码',
   provider_contact_name varchar(10) comment '供应商联系人名称',
   provider_contact_tel varchar(20) comment '供应商联系人电话',
   provider_contact_fax varchar(20) comment '供应商联系人传真',
   provider_contact_email varchar(100) comment '供应商联系人Email',
   provider_contact_address varchar(200) comment '供应商联系地址',
   provider_bank_name   varchar(100) comment '供应商银行账号开户行',
   provider_bank_account_name varchar(200) comment '供应商银行账号名称',
   provider_bank_account_code varchar(200) comment '供应商银行账号',
   provider_prize_pool  varchar(100) comment '供应商奖金池',
   provider_taxid       varchar(100) comment '供应商税号',
   provider_area        varchar(20) comment '供应商所属地区',
   provider_type        varchar(2) comment '供应商类型00 失效
            01 正常',
   provider_status      varchar(2) comment '00 失效
            01 正常',
   provider_createtime  DATETIME comment '供应商添加时间',
   provider_modifytime  DATETIME comment '供应商修改时间',
   provider_endtime     DATETIME comment '供应商终止时间',
   provider_remark      varchar(200) comment '供应商备注信息',
   primary key (provider_id)
);

alter table tb_provider comment '供应商基本信息：单位名称、联系人、联系电话、传真、联系地址、银行账号、税号、e-mail、所属地区。';

/*==============================================================*/
/* Table: tb_provider_log                                       */
/*==============================================================*/
create table tb_provider_log
(
   log_id               int not null auto_increment comment '日志id',
   log_datetime         DATETIME comment '日志记录时间',
   provider_id          int comment '供应商编号',
   provider_name        varchar(200) comment '供应商名称',
   provider_code        varchar(20) comment '供应商代码',
   provider_contact_name varchar(10) comment '供应商联系人名称',
   provider_contact_tel varchar(20) comment '供应商联系人电话',
   provider_contact_fax varchar(20) comment '供应商联系人传真',
   provider_contact_email varchar(100) comment '供应商联系人Email',
   provider_contact_address varchar(200) comment '供应商联系地址',
   provider_bank_name   varchar(100) comment '供应商银行账号开户行',
   provider_bank_account_name varchar(200) comment '供应商银行账号名称',
   provider_bank_account_code varchar(200) comment '供应商银行账号',
   provider_prize_pool  varchar(100) comment '供应商奖金池',
   provider_taxid       varchar(100) comment '供应商税号',
   provider_area        varchar(20) comment '供应商所属地区',
   provider_type        varchar(2) comment '供应商类型00 失效
            01 正常',
   provider_status      varchar(2) comment '00 失效
            01 正常',
   provider_createtime  DATETIME comment '供应商添加时间',
   provider_modifytime  DATETIME comment '供应商修改时间',
   provider_endtime     DATETIME comment '供应商终止时间',
   provider_remark      varchar(200) comment '供应商备注信息',
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
   goods_id             int,
   goods_name           varchar(200),
   goods_code           varchar(20) comment '商品代码',
   goods_version        int comment '商品版本号：初始值为 0  
            每次修商品后加1
            ',
   goods_unit           varchar(20) comment '商品基本单位',
   goods_bar_code       varchar(200) comment '商品条形码',
   goods_current_stock  int comment '当前剩余库存(暂不使用)',
   goods_total_stock    int comment '商品库存总量(暂不使用)',
   goods_production_date datetime comment '商品生产日期(暂不使用)',
   goods_expiration_date datetime comment '商品失效日期(暂不使用)',
   goods_shelf_life     int comment '商品保质期时长',
   goods_actual_cost    varchar(100) comment '进价',
   goods_price          varchar(100) comment '商品单价（售价）',
   goods_profit         varchar(100) comment '商品利润（毛利）',
   goods_discount_amount varchar(100) comment '商品优惠后价格',
   goods_type           varchar(2) comment '商品类型',
   goods_status         varchar(2) comment '00-失效 01-正常 02-下架 99-异常',
   goods_createtime     datetime comment '商品添加时间',
   goods_modifytime     datetime comment '商品修改时间',
   goods_endtime        datetime comment '商品终止时间',
   provider_id          int comment '供应商编号',
   provider_name        varchar(200) comment '供应商名称',
   provider_code        varchar(20) comment '供应商代码',
   remark               varchar(200) comment '商品备注信息',
   goods_discount       varchar(100) comment '例如30%  保存值为 0.3',
   single_rebate        varchar(100) comment '单箱返利',
   quarter_rebate       varchar(100) comment '单箱季返=单箱返利 * 加权平均返利 / 1.17
            ',
   annual_rebate        varchar(100) comment '单箱年度返利',
   purchase_rebate      varchar(100) comment '进货奖励',
   promotion_rebate     varchar(100) comment '售点促销',
   provider_subsidy     varchar(100) comment '供应商投入补贴',
   customer_bottle_subsidy varchar(100) comment '客户回瓶补贴',
   customer_package_subsidy varchar(100) comment '客户回盖补贴',
   provider_package_subsidy varchar(100) comment '供应商退盖补贴',
   customer_subsidy     varchar(100) comment '客户投入补贴（店方投入）',
   other_subsidy        varchar(100) comment '其它补贴',
   single_final_cost    varchar(100) comment '单箱商品实际成本=进价-供应商投入补贴-供应商退盖补贴-季度返利-年度返利-其它返利',
   storage_warning      int comment '库存量预警值',
   shelf_life_warning   int comment '保质期预警值',
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
   goods_code           varchar(20),
   provider_id          int,
   provider_name        varchar(200),
   provider_code        varchar(20),
   storehouse_id        int,
   storehouse_name      varchar(200),
   storehouse_code      varchar(20),
   goods_bar_code       varchar(200),
   storage_rate_current int,
   storage_rate_total   int,
   goods_production_date datetime,
   goods_expiration_date datetime,
   goods_shelf_life     int,
   goods_price          BIGINT,
   goods_status         varchar(2),
   goods_type           varchar(2),
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
   goods_code           varchar(20),
   provider_id          int,
   provider_name        varchar(200),
   provider_code        varchar(20),
   storehouse_id        int,
   storehouse_name      varchar(200),
   storehouse_code      varchar(20),
   goods_bar_code       varchar(200),
   storage_rate_current int,
   storage_rate_total   int,
   goods_production_date datetime,
   goods_expiration_date datetime,
   goods_shelf_life     int,
   goods_price          BIGINT,
   goods_status         varchar(2),
   goods_type           varchar(2),
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
   storehouse_id        int not null auto_increment comment '仓库编码',
   storehouse_name      varchar(200) comment '仓库名称',
   storehouse_code      varchar(20) comment '仓库简称',
   area                 varchar(20) comment '所属区域',
   type                 varchar(10) comment '仓库类型',
   contact_name         varchar(10) comment '仓库联系人名称',
   contact_tel          varchar(20) comment '仓库联系人电话',
   contact_fax          varchar(20) comment '仓库联系人传真',
   contact_email        varchar(100) comment '仓库联系人Email',
   contact_address      varchar(200) comment '仓库地址',
   status               varchar(2) comment '仓库状态',
   createtime           datetime comment '仓库添加时间',
   modifytime           datetime comment '仓库修改时间',
   endtime              datetime comment '仓库终止时间',
   remark               varchar(200) comment '仓库备注信息',
   primary key (storehouse_id)
);

/*==============================================================*/
/* Table: tb_storehouse_log                                     */
/*==============================================================*/
create table tb_storehouse_log
(
   log_id               int not null auto_increment comment '日志id',
   log_datetime         DATETIME comment '日志记录时间',
   storehouse_id        int comment '仓库编码',
   storehouse_name      varchar(200) comment '仓库名称',
   storehouse_code      varchar(20) comment '仓库简称',
   area                 varchar(20) comment '所属区域',
   type                 varchar(10) comment '仓库类型',
   contact_name         varchar(10) comment '仓库联系人名称',
   contact_tel          varchar(20) comment '仓库联系人电话',
   contact_fax          varchar(20) comment '仓库联系人传真',
   contact_email        varchar(100) comment '仓库联系人Email',
   contact_address      varchar(200) comment '仓库地址',
   status               varchar(2) comment '仓库状态',
   createtime           datetime comment '仓库添加时间',
   modifytime           datetime comment '仓库修改时间',
   endtime              datetime comment '仓库终止时间',
   remark               varchar(200) comment '仓库备注信息',
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


