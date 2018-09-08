package com.wetwitter.modules.common.dao;

import java.io.StringReader;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.wetwitter.modules.common.utils.SpringContextUtil;
import com.wetwitter.modules.common.utils.StringHelper;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectItem;
import net.sf.jsqlparser.statement.select.SetOperationList;

public class WeTwitterCommonDao 
{
    private static Logger logger = Logger.getLogger(WeTwitterCommonDao.class);
	
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String SQL_DOT_TAG = ".";
    private static final String SQL_SPACE_TAG = " ";

    protected JdbcOperations getJdbcOperations() {
        return getParameterJdbcTemplate().getJdbcOperations();
    }

    protected void setCacheLimit(int cacheLimit) {
        getParameterJdbcTemplate().setCacheLimit(cacheLimit);
    }

    protected int getCacheLimit() {
        return getParameterJdbcTemplate().getCacheLimit();
    }

    public NamedParameterJdbcTemplate getParameterJdbcTemplate() {
        if (namedParameterJdbcTemplate == null) {
            namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) SpringContextUtil.getBean("namedParameterJdbcTemplate");
        }
        return namedParameterJdbcTemplate;
    }

    public void setParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    protected <T> T execute(String sql, SqlParameterSource paramSource, PreparedStatementCallback<T> action) throws DataAccessException {
        logger.info("print sql is ----:" + sql);
        logger.info("print paramSource is ----:" + paramSource + ";PreparedStatementCallback is " + action);
        return getParameterJdbcTemplate().execute(sql, paramSource, action);

    }

    protected <T> T execute(String sql, Map<String, ?> paramMap, PreparedStatementCallback<T> action)
            throws DataAccessException {
        logger.info("print sql is ----:" + sql);
        logger.info("print paramMap is ----:" + paramMap + ";PreparedStatementCallback is " + action);
        return getParameterJdbcTemplate().execute(sql, paramMap, null);

    }

    protected <T> T execute(String sql, PreparedStatementCallback<T> action) throws DataAccessException {
        logger.info("print sql is ----:" + sql);
        logger.info("print PreparedStatementCallback is ----:" + action);
        return getParameterJdbcTemplate().execute(sql, action);

    }

    protected <T> T execute(CallableStatementCreator csc, CallableStatementCallback<T> action) {
        logger.info("print CallableStatementCreator is ----:" + csc + ";CallableStatementCallback is " + action);
        return getParameterJdbcTemplate().getJdbcOperations().execute(csc, action);

    }

    protected <T> T query(String sql, SqlParameterSource paramSource, ResultSetExtractor<T> rse)
            throws DataAccessException {
        logger.info("print sql is ----:" + sql);
        logger.info("print paramSource is ----:" + paramSource + ";ResultSetExtractor is " + rse);
        return getParameterJdbcTemplate().query(sql, paramSource, rse);
    }

    protected <T> T query(String sql, Map<String, ?> paramMap, ResultSetExtractor<T> rse)
            throws DataAccessException {
        logger.info("print sql is ----:" + sql);
        logger.info("print paramMap is ----:" + paramMap + ";ResultSetExtractor is " + rse);
        return getParameterJdbcTemplate().query(sql, paramMap, rse);
    }

    protected <T> T query(String sql, ResultSetExtractor<T> rse) throws DataAccessException {
        logger.info("print sql is ----:" + sql);
        logger.info("print ResultSetExtractor is ----:" + rse);
        return getParameterJdbcTemplate().query(sql, rse);
    }

    protected void query(String sql, SqlParameterSource paramSource, RowCallbackHandler rch)
            throws DataAccessException {
        logger.info("print sql is ----:" + sql);
        logger.info("print paramSource is ----:" + paramSource + ";RowCallbackHandler is " + rch);
        getParameterJdbcTemplate().query(sql, paramSource, rch);
    }

    protected void query(String sql, Map<String, ?> paramMap, RowCallbackHandler rch)
            throws DataAccessException {
        logger.info("print sql is ----:" + sql);
        logger.info("print paramMap is ----:" + paramMap + ";RowCallbackHandler is " + rch);
        getParameterJdbcTemplate().query(sql, paramMap, rch);
    }

    protected void query(String sql, RowCallbackHandler rch) throws DataAccessException {
        logger.info("print sql is ----:" + sql);
        logger.info("print RowCallbackHandler is " + rch);
        getParameterJdbcTemplate().query(sql, rch);
    }

    protected <T> List<T> query(String sql, SqlParameterSource paramSource, RowMapper<T> rowMapper)
            throws DataAccessException {
        logger.info("print sql is ----:" + sql);
        logger.info("print paramSource is ----:" + (paramSource instanceof MapSqlParameterSource ? ((MapSqlParameterSource)paramSource).getValues() : paramSource));
        return getParameterJdbcTemplate().query(sql, paramSource, rowMapper);
    }

    protected <T> List<T> query(String sql, Map<String, ?> paramMap, RowMapper<T> rowMapper)
            throws DataAccessException {
        logger.info("print sql is ----:" + sql);
        logger.info("print paramMap is ----:" + paramMap);
        return getParameterJdbcTemplate().query(sql, paramMap, rowMapper);
    }

    protected <T> List<T> query(String sql, RowMapper<T> rowMapper) throws DataAccessException {
        logger.info("print sql is ----:" + sql);
        return getParameterJdbcTemplate().query(sql, rowMapper);
    }

    protected <T> T queryForObject(String sql, SqlParameterSource paramSource, RowMapper<T> rowMapper)
            throws DataAccessException {
        logger.info("print sql is ----:" + sql);
        logger.info("print paramSource is ----:" + (paramSource instanceof MapSqlParameterSource ? ((MapSqlParameterSource)paramSource).getValues() : paramSource));
        try {
            return getParameterJdbcTemplate().queryForObject(sql, paramSource, rowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    protected <T> T queryForObject(String sql, Map<String, ?> paramMap, RowMapper<T> rowMapper)
            throws DataAccessException {
        logger.info("print sql is ----:" + sql);
        logger.info("print paramMap is ----:" + paramMap);
        try {
            return getParameterJdbcTemplate().queryForObject(sql, paramMap, rowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    protected <T> T queryForObject(String sql, SqlParameterSource paramSource, Class<T> requiredType)
            throws DataAccessException {
        logger.info("print sql is ----:" + sql);
        logger.info("print paramSource is ----:" + (paramSource instanceof MapSqlParameterSource ? ((MapSqlParameterSource)paramSource).getValues() : paramSource));
        try {
            return getParameterJdbcTemplate().queryForObject(sql, paramSource, requiredType);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    protected <T> T queryForObject(String sql, Map<String, ?> paramMap, Class<T> requiredType)
            throws DataAccessException {
        logger.info("print sql is ----:" + sql);
        logger.info("print paramMap is ----:" + paramMap);
        try {
            return getParameterJdbcTemplate().queryForObject(sql, paramMap, requiredType);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    protected Map<String, Object> queryForMap(String sql, SqlParameterSource paramSource) throws DataAccessException {
        String[] propNoAs = propNameForQryColStr(sql);
        logger.info("print sql is ----:" + sql);
        logger.info("print paramSource is ----:" + (paramSource instanceof MapSqlParameterSource ? ((MapSqlParameterSource)paramSource).getValues() : paramSource));
        if (propNoAs == null) {
            try {
                return getParameterJdbcTemplate().queryForMap(sql, paramSource);
            } catch (EmptyResultDataAccessException e) {
                return null;
            }
        } else {
            try {
                return (Map<String, Object>) getParameterJdbcTemplate().queryForObject(sql, paramSource, new RowMapper() {
                    @Override
                    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                        // TODO Auto-generated method stub
                        return saveValue(rs, propNoAs);
                    }
                });
            } catch (EmptyResultDataAccessException e) {
                return null;
            }
        }

    }

    protected Map<String, Object> queryForMap(String sql, Map<String, ?> paramMap) throws DataAccessException {
        String[] propNoAs = propNameForQryColStr(sql);
        logger.info("print sql is ----:" + sql);
        logger.info("print paramMap is ----:" + paramMap);
        if (propNoAs == null) {
            try {
                return getParameterJdbcTemplate().queryForMap(sql, paramMap);
            } catch (EmptyResultDataAccessException e) {
                return null;
            }
        } else {
            try {
                return (Map<String, Object>) getParameterJdbcTemplate().queryForObject(sql, paramMap, new RowMapper() {
                    @Override
                    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                        // TODO Auto-generated method stub
                        return saveValue(rs, propNoAs);
                    }
                });
            } catch (EmptyResultDataAccessException e) {
                return null;
            }
        }
    }

    protected <T> List<T> queryForList(String sql, SqlParameterSource paramSource, Class<T> elementType)
            throws DataAccessException {
        logger.info("print sql is ----:" + sql);
        logger.info("print paramSource is ----:" + (paramSource instanceof MapSqlParameterSource ? ((MapSqlParameterSource)paramSource).getValues() : paramSource));
        return getParameterJdbcTemplate().queryForList(sql, paramSource, elementType);
    }

    protected <T> List<T> queryForList(String sql, Map<String, ?> paramMap, Class<T> elementType)
            throws DataAccessException {
        logger.info("print sql is ----:" + sql);
        logger.info("print paramMap is ----:" + paramMap);
        return getParameterJdbcTemplate().queryForList(sql, paramMap, elementType);
    }

    protected List<Map<String, Object>> queryForList(String sql, SqlParameterSource paramSource)
            throws DataAccessException {
        logger.info("print sql is ----:" + sql);
        logger.info("print paramSource is ----:" + (paramSource instanceof MapSqlParameterSource ? ((MapSqlParameterSource)paramSource).getValues() : paramSource));
        String[] propNoAs = propNameForQryColStr(sql);
        if (propNoAs == null) {
            return getParameterJdbcTemplate().queryForList(sql, paramSource);
        } else {
            return getParameterJdbcTemplate().query(sql, paramSource, new RowMapper() {
                @Override
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    // TODO Auto-generated method stub
                    return saveValue(rs, propNoAs);
                }
            });
        }
    }

    protected List<Map<String, Object>> queryForList(String sql, Map<String, ?> paramMap)
            throws DataAccessException {
        logger.info("print sql is ----:" + sql);
        logger.info("print paramMap is ----:" + paramMap);
        String[] propNoAs = propNameForQryColStr(sql);
        if (propNoAs == null) {
            return getParameterJdbcTemplate().queryForList(sql, paramMap);
        } else {
            return getParameterJdbcTemplate().query(sql, paramMap, new RowMapper() {
                @Override
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    // TODO Auto-generated method stub
                    return saveValue(rs, propNoAs);
                }
            });
        }
    }

    protected SqlRowSet queryForRowSet(String sql, SqlParameterSource paramSource) throws DataAccessException {
        logger.info("print sql is ----:" + sql);
        logger.info("print paramSource is ----:" + (paramSource instanceof MapSqlParameterSource ? ((MapSqlParameterSource)paramSource).getValues() : paramSource));
        return getParameterJdbcTemplate().queryForRowSet(sql, paramSource);
    }

    protected SqlRowSet queryForRowSet(String sql, Map<String, ?> paramMap) throws DataAccessException {
        logger.info("print sql is ----:" + sql);
        logger.info("print paramMap is ----:" + paramMap);
        return getParameterJdbcTemplate().queryForRowSet(sql, paramMap);
    }

    protected int update(String sql, SqlParameterSource paramSource) throws DataAccessException {
        logger.info("print sql is ----:" + sql);
        logger.info("print paramSource is ----:" + (paramSource instanceof MapSqlParameterSource ? ((MapSqlParameterSource)paramSource).getValues() : paramSource));
        return getParameterJdbcTemplate().update(sql, paramSource);
    }

    protected int update(String sql, Map<String, ?> paramMap) throws DataAccessException {
        logger.info("print sql is ----:" + sql);
        logger.info("print paramMap is ----:" + paramMap);
        return getParameterJdbcTemplate().update(sql, paramMap);
    }

    protected int update(String sql, SqlParameterSource paramSource, KeyHolder generatedKeyHolder)
            throws DataAccessException {
        logger.info("print sql is ----:" + sql);
        logger.info("print paramSource is ----:" + (paramSource instanceof MapSqlParameterSource ? ((MapSqlParameterSource)paramSource).getValues() : paramSource));
        return getParameterJdbcTemplate().update(sql, paramSource, generatedKeyHolder);
    }

    protected int update(
            String sql, SqlParameterSource paramSource, KeyHolder generatedKeyHolder, String[] keyColumnNames)
            throws DataAccessException {
        logger.info("print sql is ----:" + sql);
        logger.info("print paramSource is ----:" + paramSource + ":KeyHolder" + generatedKeyHolder + ":keyColumnNames" + keyColumnNames);
        return getParameterJdbcTemplate().update(sql, paramSource, generatedKeyHolder, keyColumnNames);
    }

    protected int[] batchUpdate(String sql, Map<String, ?>[] batchValues) {
        logger.info("print sql is ----:" + sql);
        logger.info("print batchValues is ----:" + batchValues);
        return getParameterJdbcTemplate().batchUpdate(sql, batchValues);
    }

    protected int[] batchUpdate(String sql, SqlParameterSource[] batchArgs) {
        logger.info("print sql is ----:" + sql);
        logger.info("print batchArgs is ----:" + batchArgs);
        return getParameterJdbcTemplate().batchUpdate(sql, batchArgs);
    }

    protected int queryForInt(String sql, Map<String, ?> paramMap) {
        logger.info("print sql is ----:" + sql);
        logger.info("print paramMap is ----:" + paramMap);
        return getParameterJdbcTemplate().queryForObject(sql, paramMap, Integer.class);
    }

    protected Long getSequence(String sequenceName) {
        String sql = "select " + sequenceName + ".nextval from dual";
        logger.info("print sql is ----:" + sql);
        try {
            return getParameterJdbcTemplate().queryForObject(sql, new HashMap(), Long.class);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /*protected <T> Page<T> queryForPage(String sql, Map<String, ?> paramMap, int pageIndex, int pageSize) throws SystemException, RequiredException, SQLException {
        String countSql = "select count(1) from (" + sql + ")";
        logger.info("print sql is ----:" + sql);
        logger.info("print paramMap is ----:" + paramMap + ":pageIndex is " + pageIndex + ":pageSize is " + pageSize);
        int count = queryForInt(countSql, paramMap);
        if (count == 0) {//没有数据
            return new Page();
        }
        int beginRow = (pageIndex - 1) * pageSize;
        List retList = new ArrayList();

        String[] propNoAs = propNameForQryColStr(sql);//先取出列名，再封装成分页查询语句
        sql = DAOUtils.populateQuerySQL(sql, beginRow, pageSize);

        if (propNoAs == null) {
            retList = getParameterJdbcTemplate().queryForList(sql, paramMap);
        } else {
            retList = getParameterJdbcTemplate().query(sql, paramMap, new RowMapper() {
                @Override
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    // TODO Auto-generated method stub
                    return saveValue(rs, propNoAs);
                }
            });
        }

        return new Page<T>(retList, pageSize, count, pageIndex);
    }*/

   /* protected <T> Page<T> queryForPage(String sql, SqlParameterSource paramMap, int pageIndex, int pageSize) throws SystemException, RequiredException, SQLException {
        String countSql = "select count(1) from (" + sql + ")";
        logger.info("print sql is ----:" + sql);
        logger.info("print paramMap is ----:" + paramMap + ":pageIndex is " + pageIndex + ":pageSize is " + pageSize);
        int count = queryForObject(countSql, paramMap, Integer.class);
        if (count == 0) {//没有数据
            return new Page();
        }
        int beginRow = (pageIndex - 1) * pageSize;


        List retList = new ArrayList();

        String[] propNoAs = propNameForQryColStr(sql);//先取出列名，再封装成分页查询语句
        sql = DAOUtils.populateQuerySQL(sql, beginRow, pageSize);

        if (propNoAs == null) {
            retList = getParameterJdbcTemplate().queryForList(sql, paramMap);
        } else {
            retList = getParameterJdbcTemplate().query(sql, paramMap, new RowMapper() {
                @Override
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    // TODO Auto-generated method stub
                    return saveValue(rs, propNoAs);
                }
            });
        }


        return new Page<T>(retList, pageSize, count, pageIndex);
    }*/

    /**
     * 获取数据库服务器时间
     *
     * @return Date
     * @throws SQLException
     */
    public Date getDataBaseDate() {
        String sql = "SELECT SYSDATE FROM DUAL";
        SimpleDateFormat tf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datStr = getParameterJdbcTemplate().queryForObject(sql, new HashMap(), String.class);
        try {
            return tf.parse(datStr);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error(e.getMessage(), e);
            return new Date();
        }
    }

    /**
     * 从qryColSQL中抽取属性名称
     *
     * @param fromStr String
     * @return String[]
     * @throws JSQLParserException
     */
    private String[] propNameForQryColStr(String fromStr) {
        //原有的处理方式对于字段中包含FROM内容（如：HIRE_FROM）的解析会出异常
        //改用JSqlParser解析 - qi.qingli@2016-06-22 15:40
        CCJSqlParserManager parserManager = new CCJSqlParserManager();
        List<String> colList = new ArrayList<String>();
        try {
            Select select = (Select) parserManager.parse(new StringReader(fromStr));
            Object selectBody = select.getSelectBody();
            PlainSelect pSelect = null;
            if (selectBody instanceof PlainSelect) {
                pSelect = ((PlainSelect) select.getSelectBody());
            } else if (selectBody instanceof SetOperationList) {
                pSelect = (PlainSelect) ((SetOperationList) selectBody).getSelects().get(0);
            }
            List<SelectItem> itemList = pSelect.getSelectItems();
            for (SelectItem si : itemList) {
                if (si.toString().indexOf(SQL_SPACE_TAG) != -1) {
                    String[] _s = StringHelper.split(si.toString(), SQL_SPACE_TAG);
                    colList.add(_s[_s.length - 1]);
                } else if (si.toString().indexOf(SQL_DOT_TAG) != -1) {
                    // 如果带别名前缀 比如A.NAME,需要去掉A.只保留NAME
                    String[] _s = StringHelper.split(si.toString(), SQL_DOT_TAG);
                    colList.add(_s[_s.length - 1]);
                } else {
                    // 用列名做属性值
                    colList.add(si.toString());
                }
            }
        } catch (JSQLParserException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
        return colList.toArray(new String[0]);
    }

    private Map saveValue(ResultSet rs, String[] propNoAs) throws SQLException {
        Map tempMap = new HashMap();
        for (int i = 0; i < propNoAs.length; i++) {
            if (!tempMap.containsKey(propNoAs[i].trim())) {
                Object o = rs.getObject(propNoAs[i]);
                if (o instanceof Clob) {
                    o = ((Clob) o).getSubString(1, (int) ((Clob) o).length());
                }
                tempMap.put(propNoAs[i], o);
            }
        }
        return tempMap;
    }

}
