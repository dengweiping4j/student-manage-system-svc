create table sys_dict_info
(
    id           varchar(36)                         not null
        primary key,
    lookup_type  varchar(32)                         null comment '字典类型',
    lookup_name  varchar(64)                         null comment '字典项名称',
    lookup_value varchar(64)                         null comment '字典项值',
    lookup_order int                                 null comment '排序号',
    crt_by       varchar(64)                         null,
    upd_by       varchar(64)                         null,
    del_flag     char      default '0'               not null,
    crt_time     datetime  default CURRENT_TIMESTAMP null comment '创建时间',
    upd_time     timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '修改时间'
)
    comment '基础信息表--字典项';

create table sys_dict_type
(
    id          varchar(36)                         not null
        primary key,
    lookup_type varchar(30)                         not null comment '查询类型',
    type_name   varchar(30)                         null comment '类型名称',
    crt_by      varchar(64)                         null,
    upd_by      varchar(64)                         null,
    del_flag    char      default '0'               not null,
    lookup_desc varchar(500)                        null comment '描述',
    crt_time    datetime  default CURRENT_TIMESTAMP null comment '创建时间',
    upd_time    timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '修改时间'
)
    comment '基础信息表--字典表';

create table sys_menu
(
    id       varchar(36)                         not null comment '主键'
        primary key,
    path     varchar(255)                        null comment '菜单路径',
    role_id  varchar(255)                        null comment '角色ID',
    crt_by   varchar(100)                        null,
    upd_by   varchar(100)                        null,
    crt_time datetime  default CURRENT_TIMESTAMP null comment '创建时间',
    upd_time timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '修改时间'
)
    comment '系统菜单表';

create table sys_role
(
    id        varchar(36)                          not null comment '主键'
        primary key,
    role_name varchar(255)                         null comment '角色名',
    remark    varchar(255)                         null comment '描述',
    del_flag  varchar(1) default '0'               null comment '删除标志：1已删除，0未删除',
    crt_by    varchar(100)                         null,
    upd_by    varchar(100)                         null,
    crt_time  datetime   default CURRENT_TIMESTAMP null comment '创建时间',
    upd_time  timestamp  default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '修改时间',
    role_type varchar(1)                           null comment '角色类型： 1.系统角色 2.自定义角色'
)
    comment '系统角色表';

create table sys_user
(
    id        varchar(36)                          not null comment '主键'
        primary key,
    user_name varchar(255)                         null comment '账号',
    password  varchar(255)                         null comment '密码',
    role_id   varchar(36)                          null comment '角色ID',
    del_flag  varchar(1) default '0'               null comment '删除标志：1已删除，0未删除',
    crt_by    varchar(100)                         null,
    upd_by    varchar(100)                         null,
    crt_time  datetime   default CURRENT_TIMESTAMP null comment '创建时间',
    upd_time  timestamp  default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '修改时间',
    biz_id    varchar(36)                          null comment '业务Id'
)
    comment '系统用户表';

create table t_class
(
    id       varchar(36)            not null
        primary key,
    cla_name varchar(100)           null comment '班级名称',
    grade_id varchar(36)            null comment '所属年级',
    del_flag varchar(1) default '0' null comment '删除标志：1已删除，0未删除'
)
    comment '班级信息表';

create table t_grade
(
    id         varchar(36)            not null
        primary key,
    grade_name varchar(100)           null comment '年级名称',
    del_flag   varchar(1) default '0' null comment '删除标志：1已删除，0未删除'
)
    comment '年级信息表';

create table t_student
(
    id              varchar(36)            not null
        primary key,
    stu_name        varchar(36)            null comment '姓名',
    grade_id        varchar(36)            null comment '年级id',
    class_id        varchar(36)            null comment '班级Id',
    sex             varchar(10)            null comment '性别',
    tel             varchar(100)           null comment '联系方式',
    profile_picture varchar(255)           null comment '证件照',
    del_flag        varchar(1) default '0' null comment '删除标志：1已删除，0未删除',
    stu_code        varchar(100)           null comment '学号',
    birthday        date                   null comment '出生日期'
)
    comment '学生基础信息表';

create table t_teacher
(
    id              varchar(36)            not null
        primary key,
    tea_name        varchar(36)            null comment '姓名',
    tea_code        varchar(100)           null comment '工号',
    subject         varchar(100)           null comment '任教科目',
    sex             varchar(10)            null comment '性别',
    tel             varchar(100)           null comment '联系方式',
    profile_picture varchar(255)           null comment '证件照',
    del_flag        varchar(1) default '0' null comment '删除标志：1已删除，0未删除',
    birthday        date                   null comment '出生日期'
)
    comment '教师基础信息表';

create table t_teacher_class
(
    id       varchar(36) not null
        primary key,
    tea_id   varchar(36) null,
    class_id varchar(36) null
)
    comment '教师所教班级表';

