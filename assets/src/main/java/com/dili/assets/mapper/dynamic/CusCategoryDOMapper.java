package com.dili.assets.mapper.dynamic;

import com.github.liuhuagui.mybatis.dynamicsql.auxiliary.mapper.DynamicSqlMapper;

import static com.dili.assets.mapper.dynamic.CusCategoryTable.*;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface CusCategoryDOMapper extends DynamicSqlMapper<CusCategoryDO> {
    BasicColumn[] selectList = BasicColumn.columnList(id, name, pingying, pyInitials, icon, marketId, delete, parent, path, creatorId, createTime, modifyTime, state, keycode, categoryId);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("CusCategoryDOResult")
    Optional<CusCategoryDO> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "CusCategoryDOResult", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "pingying", property = "pingying", jdbcType = JdbcType.VARCHAR),
            @Result(column = "py_initials", property = "pyInitials", jdbcType = JdbcType.VARCHAR),
            @Result(column = "icon", property = "icon", jdbcType = JdbcType.VARCHAR),
            @Result(column = "market_id", property = "marketId", jdbcType = JdbcType.BIGINT),
            @Result(column = "is_delete", property = "delete", jdbcType = JdbcType.INTEGER),
            @Result(column = "parent", property = "parent", jdbcType = JdbcType.BIGINT),
            @Result(column = "path", property = "path", jdbcType = JdbcType.VARCHAR),
            @Result(column = "creator_id", property = "creatorId", jdbcType = JdbcType.BIGINT),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "modify_time", property = "modifyTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "state", property = "state", jdbcType = JdbcType.TINYINT),
            @Result(column = "keycode", property = "keycode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "category_id", property = "categoryId", jdbcType = JdbcType.BIGINT)
    })
    List<CusCategoryDO> selectMany(SelectStatementProvider selectStatement);

    @Override
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, cusCategoryDO, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, cusCategoryDO, completer);
    }

    default int deleteByPrimaryKey(Long id_) {
        return delete(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    default int insert(CusCategoryDO record) {
        return MyBatis3Utils.insert(this::insert, record, cusCategoryDO, c ->
                c.map(id).toProperty("id")
                        .map(name).toProperty("name")
                        .map(pingying).toProperty("pingying")
                        .map(pyInitials).toProperty("pyInitials")
                        .map(icon).toProperty("icon")
                        .map(marketId).toProperty("marketId")
                        .map(delete).toProperty("delete")
                        .map(parent).toProperty("parent")
                        .map(path).toProperty("path")
                        .map(creatorId).toProperty("creatorId")
                        .map(createTime).toProperty("createTime")
                        .map(modifyTime).toProperty("modifyTime")
                        .map(state).toProperty("state")
                        .map(keycode).toProperty("keycode")
                        .map(categoryId).toProperty("categoryId")
        );
    }

    default int insertMultiple(Collection<CusCategoryDO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, cusCategoryDO, c ->
                c.map(id).toProperty("id")
                        .map(name).toProperty("name")
                        .map(pingying).toProperty("pingying")
                        .map(pyInitials).toProperty("pyInitials")
                        .map(icon).toProperty("icon")
                        .map(marketId).toProperty("marketId")
                        .map(delete).toProperty("delete")
                        .map(parent).toProperty("parent")
                        .map(path).toProperty("path")
                        .map(creatorId).toProperty("creatorId")
                        .map(createTime).toProperty("createTime")
                        .map(modifyTime).toProperty("modifyTime")
                        .map(state).toProperty("state")
                        .map(keycode).toProperty("keycode")
                        .map(categoryId).toProperty("categoryId")
        );
    }

    default int insertSelective(CusCategoryDO record) {
        return MyBatis3Utils.insert(this::insert, record, cusCategoryDO, c ->
                c.map(id).toPropertyWhenPresent("id", record::getId)
                        .map(name).toPropertyWhenPresent("name", record::getName)
                        .map(pingying).toPropertyWhenPresent("pingying", record::getPingying)
                        .map(pyInitials).toPropertyWhenPresent("pyInitials", record::getPyInitials)
                        .map(icon).toPropertyWhenPresent("icon", record::getIcon)
                        .map(marketId).toPropertyWhenPresent("marketId", record::getMarketId)
                        .map(delete).toPropertyWhenPresent("delete", record::getDelete)
                        .map(parent).toPropertyWhenPresent("parent", record::getParent)
                        .map(path).toPropertyWhenPresent("path", record::getPath)
                        .map(creatorId).toPropertyWhenPresent("creatorId", record::getCreatorId)
                        .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                        .map(modifyTime).toPropertyWhenPresent("modifyTime", record::getModifyTime)
                        .map(state).toPropertyWhenPresent("state", record::getState)
                        .map(keycode).toPropertyWhenPresent("keycode", record::getKeycode)
                        .map(categoryId).toPropertyWhenPresent("categoryId", record::getCategoryId)
        );
    }

    default Optional<CusCategoryDO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, cusCategoryDO, completer);
    }

    @Override
    default List<CusCategoryDO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, cusCategoryDO, completer);
    }

    default List<CusCategoryDO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, cusCategoryDO, completer);
    }

    default Optional<CusCategoryDO> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, cusCategoryDO, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(CusCategoryDO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(name).equalTo(record::getName)
                .set(pingying).equalTo(record::getPingying)
                .set(pyInitials).equalTo(record::getPyInitials)
                .set(icon).equalTo(record::getIcon)
                .set(marketId).equalTo(record::getMarketId)
                .set(delete).equalTo(record::getDelete)
                .set(parent).equalTo(record::getParent)
                .set(path).equalTo(record::getPath)
                .set(creatorId).equalTo(record::getCreatorId)
                .set(createTime).equalTo(record::getCreateTime)
                .set(modifyTime).equalTo(record::getModifyTime)
                .set(state).equalTo(record::getState)
                .set(keycode).equalTo(record::getKeycode)
                .set(categoryId).equalTo(record::getCategoryId);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(CusCategoryDO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(name).equalToWhenPresent(record::getName)
                .set(pingying).equalToWhenPresent(record::getPingying)
                .set(pyInitials).equalToWhenPresent(record::getPyInitials)
                .set(icon).equalToWhenPresent(record::getIcon)
                .set(marketId).equalToWhenPresent(record::getMarketId)
                .set(delete).equalToWhenPresent(record::getDelete)
                .set(parent).equalToWhenPresent(record::getParent)
                .set(path).equalToWhenPresent(record::getPath)
                .set(creatorId).equalToWhenPresent(record::getCreatorId)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(modifyTime).equalToWhenPresent(record::getModifyTime)
                .set(state).equalToWhenPresent(record::getState)
                .set(keycode).equalToWhenPresent(record::getKeycode)
                .set(categoryId).equalToWhenPresent(record::getCategoryId);
    }

    default int updateByPrimaryKey(CusCategoryDO record) {
        return update(c ->
                c.set(name).equalTo(record::getName)
                        .set(pingying).equalTo(record::getPingying)
                        .set(pyInitials).equalTo(record::getPyInitials)
                        .set(icon).equalTo(record::getIcon)
                        .set(marketId).equalTo(record::getMarketId)
                        .set(delete).equalTo(record::getDelete)
                        .set(parent).equalTo(record::getParent)
                        .set(path).equalTo(record::getPath)
                        .set(creatorId).equalTo(record::getCreatorId)
                        .set(createTime).equalTo(record::getCreateTime)
                        .set(modifyTime).equalTo(record::getModifyTime)
                        .set(state).equalTo(record::getState)
                        .set(keycode).equalTo(record::getKeycode)
                        .set(categoryId).equalTo(record::getCategoryId)
                        .where(id, isEqualTo(record::getId))
        );
    }

    default int updateByPrimaryKeySelective(CusCategoryDO record) {
        return update(c ->
                c.set(name).equalToWhenPresent(record::getName)
                        .set(pingying).equalToWhenPresent(record::getPingying)
                        .set(pyInitials).equalToWhenPresent(record::getPyInitials)
                        .set(icon).equalToWhenPresent(record::getIcon)
                        .set(marketId).equalToWhenPresent(record::getMarketId)
                        .set(delete).equalToWhenPresent(record::getDelete)
                        .set(parent).equalToWhenPresent(record::getParent)
                        .set(path).equalToWhenPresent(record::getPath)
                        .set(creatorId).equalToWhenPresent(record::getCreatorId)
                        .set(createTime).equalToWhenPresent(record::getCreateTime)
                        .set(modifyTime).equalToWhenPresent(record::getModifyTime)
                        .set(state).equalToWhenPresent(record::getState)
                        .set(keycode).equalToWhenPresent(record::getKeycode)
                        .set(categoryId).equalToWhenPresent(record::getCategoryId)
                        .where(id, isEqualTo(record::getId))
        );
    }
}