package com.bayard7523.kpac.persistence.dao;

import com.bayard7523.kpac.model.KnowledgePackage;
import com.bayard7523.kpac.persistence.mapper.KnowledgePackageRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Component
public class KnowledgePackageDAO {
	private final JdbcTemplate jdbcTemplate;

	public KnowledgePackageDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<KnowledgePackage> getAll() {
		return jdbcTemplate.query("SELECT * FROM knowledge_packages", new KnowledgePackageRowMapper());
	}

	public Optional<Integer> save(KnowledgePackage knowledgePackage) {
		final KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(connection -> {
			final PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO knowledge_packages(title, description) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, knowledgePackage.getTitle());
			preparedStatement.setString(2, knowledgePackage.getDescription());

			return preparedStatement;
		}, keyHolder);

		return Optional.ofNullable(keyHolder.getKey()).map(Number::intValue);
	}

	public Optional<KnowledgePackage> findById(Integer id) {
		return jdbcTemplate.query("SELECT * FROM knowledge_packages WHERE id = ?", new KnowledgePackageRowMapper(), id).stream().findAny();
	}

	public boolean existsById(Integer id) {
		final Integer count = jdbcTemplate.queryForObject("SELECT count(*) FROM knowledge_packages WHERE id = ?", Integer.class, id);

		if (count == null) return false;

		return count != 0;
	}

	public boolean existsByTitle(String title) {
		final Integer count = jdbcTemplate.queryForObject("SELECT count(*) FROM knowledge_packages WHERE title = ?", Integer.class, title);

		if (count == null) return false;

		return count != 0;
	}

	public void deleteById(Integer id) {
		jdbcTemplate.update("DELETE FROM knowledge_packages WHERE id = ?", id);
	}


}
