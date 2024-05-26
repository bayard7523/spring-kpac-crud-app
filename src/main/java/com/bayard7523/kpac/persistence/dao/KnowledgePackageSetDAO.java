package com.bayard7523.kpac.persistence.dao;

import com.bayard7523.kpac.controller.request.KnowledgePackageSetCreationRequest;
import com.bayard7523.kpac.model.KnowledgePackage;
import com.bayard7523.kpac.model.KnowledgePackageSet;
import com.bayard7523.kpac.persistence.mapper.KnowledgePackageRowMapper;
import com.bayard7523.kpac.persistence.mapper.KnowledgePackageSetRowMapper;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import javax.swing.plaf.PanelUI;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Component
public class KnowledgePackageSetDAO {

	private final JdbcTemplate jdbcTemplate;

	public KnowledgePackageSetDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<KnowledgePackageSet> getAll() {
		return jdbcTemplate.query("SELECT * FROM knowledge_package_sets", new KnowledgePackageSetRowMapper());
	}

	public Optional<KnowledgePackageSet> getById(int id) {
		return jdbcTemplate.query("SELECT * FROM knowledge_package_sets WHERE id = ?", new KnowledgePackageSetRowMapper(), id).stream()
				.findAny()
				.map(set -> {
					final List<KnowledgePackage> knowledgePackages = jdbcTemplate.query("SELECT * FROM knowledge_packages INNER JOIN kpac.kpac_kpacsets kk ON knowledge_packages.id = kk.kpac_id WHERE kpac_set_id = ?", new KnowledgePackageRowMapper(), id);

					set.setKnowledgePackages(knowledgePackages);
					return set;
				});
	}

	public Optional<Integer> save(KnowledgePackageSetCreationRequest creationRequest) {
		final KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(connection -> {
			final PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO knowledge_package_sets(title) VALUES (?)", Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, creationRequest.getTitle());

			return preparedStatement;
		}, keyHolder);

		final Optional<Integer> idO = Optional.ofNullable(keyHolder.getKey()).map(Number::intValue);

		idO.ifPresent(id -> addToSet(id, creationRequest.getKnowledgePackages()));

		return idO;
	}

	public void addToSet(int id, List<Integer> knowledgePackages) {
		if (knowledgePackages.isEmpty()) return;

		jdbcTemplate.batchUpdate("INSERT INTO kpac_kpacsets VALUES (?,?)", new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setInt(1, id);
				ps.setInt(2, knowledgePackages.get(i));
			}

			@Override
			public int getBatchSize() {
				return knowledgePackages.size();
			}
		});
	}

	public boolean existsById(Integer id) {
		final Integer count = jdbcTemplate.queryForObject("SELECT count(*) FROM knowledge_package_sets WHERE id = ?", Integer.class, id);

		if (count == null) return false;

		return count != 0;
	}

	public boolean existsByTitle(String title) {
		final Integer count = jdbcTemplate.queryForObject("SELECT count(*) FROM knowledge_package_sets WHERE title = ?", Integer.class, title);

		if (count == null) return false;

		return count != 0;
	}

	public void deleteById(int id) {
		jdbcTemplate.update("DELETE FROM knowledge_package_sets WHERE id = ?", id);
	}

}
