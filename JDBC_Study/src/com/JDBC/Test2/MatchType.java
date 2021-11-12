package com.JDBC.Test2;

import java.sql.ResultSet;

public interface MatchType {
	public abstract <T> T matching(ResultSet set);

}
