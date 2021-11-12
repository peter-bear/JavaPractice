package com.peter.util;

import java.sql.ResultSet;
/**
 * MatchType接口，要使用DaoUtil中的公共选取方法，需要先实现此接口
 * @author 23881
 *
 */
public interface MatchType {
	public abstract <T> T Matching(ResultSet resultSet);
}
