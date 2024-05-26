package com.bayard7523.kpac.persistence.mapper;

import com.bayard7523.kpac.model.KnowledgePackageSet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KnowledgePackageSetRowMapper implements RowMapper<KnowledgePackageSet> {

	@Override
	public KnowledgePackageSet mapRow(ResultSet rs, int rowNum) throws SQLException {

		final KnowledgePackageSet knowledgePackageSet = new KnowledgePackageSet();

		knowledgePackageSet.setId(rs.getInt("id"));
		knowledgePackageSet.setTitle(rs.getString("title"));

		return knowledgePackageSet;
	}
}
