package com.peter.util;

import java.sql.ResultSet;
/**
 * MatchType�ӿڣ�Ҫʹ��DaoUtil�еĹ���ѡȡ��������Ҫ��ʵ�ִ˽ӿ�
 * @author 23881
 *
 */
public interface MatchType {
	public abstract <T> T Matching(ResultSet resultSet);
}
