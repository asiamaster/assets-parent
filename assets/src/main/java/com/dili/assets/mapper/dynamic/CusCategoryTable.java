package com.dili.assets.mapper.dynamic;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;
import java.time.LocalDateTime;

public final class CusCategoryTable {
    public static final CusCategoryDO cusCategoryDO = new CusCategoryDO();

    /**
     * id
     */
    public static final SqlColumn<Long> id = cusCategoryDO.id;

    /**
     * 品类名称
     */
    public static final SqlColumn<String> name = cusCategoryDO.name;

    /**
     * 拼音
     */
    public static final SqlColumn<String> pingying = cusCategoryDO.pingying;

    /**
     * 拼音缩写
     */
    public static final SqlColumn<String> pyInitials = cusCategoryDO.pyInitials;

    /**
     * 图标
     */
    public static final SqlColumn<String> icon = cusCategoryDO.icon;

    /**
     * 市场
     */
    public static final SqlColumn<Long> marketId = cusCategoryDO.marketId;

    /**
     * 状态
     */
    public static final SqlColumn<Integer> delete = cusCategoryDO.delete;

    /**
     * 父品类
     */
    public static final SqlColumn<Long> parent = cusCategoryDO.parent;

    /**
     * 路劲
     */
    public static final SqlColumn<String> path = cusCategoryDO.path;

    /**
     * 创建人
     */
    public static final SqlColumn<Long> creatorId = cusCategoryDO.creatorId;

    /**
     * 创建时间
     */
    public static final SqlColumn<LocalDateTime> createTime = cusCategoryDO.createTime;

    /**
     * 更新时间
     */
    public static final SqlColumn<LocalDateTime> modifyTime = cusCategoryDO.modifyTime;

    /**
     * 状态
     */
    public static final SqlColumn<Byte> state = cusCategoryDO.state;

    /**
     * 快捷码
     */
    public static final SqlColumn<String> keycode = cusCategoryDO.keycode;

    /**
     * 品类id
     */
    public static final SqlColumn<Long> categoryId = cusCategoryDO.categoryId;

    public static final class CusCategoryDO extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> pingying = column("pingying", JDBCType.VARCHAR);

        public final SqlColumn<String> pyInitials = column("py_initials", JDBCType.VARCHAR);

        public final SqlColumn<String> icon = column("icon", JDBCType.VARCHAR);

        public final SqlColumn<Long> marketId = column("market_id", JDBCType.BIGINT);

        public final SqlColumn<Integer> delete = column("is_delete", JDBCType.INTEGER);

        public final SqlColumn<Long> parent = column("parent", JDBCType.BIGINT);

        public final SqlColumn<String> path = column("path", JDBCType.VARCHAR);

        public final SqlColumn<Long> creatorId = column("creator_id", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> modifyTime = column("modify_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Byte> state = column("state", JDBCType.TINYINT);

        public final SqlColumn<String> keycode = column("keycode", JDBCType.VARCHAR);

        public final SqlColumn<Long> categoryId = column("category_id", JDBCType.BIGINT);

        public CusCategoryDO() {
            super("cus_category");
        }
    }
}