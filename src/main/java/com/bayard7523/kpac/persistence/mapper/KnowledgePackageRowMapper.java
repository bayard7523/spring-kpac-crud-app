package com.bayard7523.kpac.persistence.mapper;

import com.bayard7523.kpac.model.KnowledgePackage;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class KnowledgePackageRowMapper implements RowMapper<KnowledgePackage> {

	@Override
	public KnowledgePackage mapRow(ResultSet rs, int rowNum) throws SQLException {
		final KnowledgePackage knowledgePackage = new KnowledgePackage();

		knowledgePackage.setId(rs.getInt("id"));
		knowledgePackage.setTitle(rs.getString("title"));
		knowledgePackage.setDescription(rs.getString("description"));
		knowledgePackage.setCreatedAt(LocalDate.parse(rs.getString("created_at")));

		return knowledgePackage;
	}
}
