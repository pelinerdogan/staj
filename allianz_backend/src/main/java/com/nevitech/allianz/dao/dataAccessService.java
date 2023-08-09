package com.nevitech.allianz.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.nevitech.allianz.model.CampaignStatusChange;
import com.nevitech.allianz.model.campaign;

@Repository("insuranceDao")
public class dataAccessService implements campaigndao {

	JdbcTemplate jdbcTemplate;

	@Autowired
	public dataAccessService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insertCampaign(campaign Campaign) {
		String sql = "INSERT INTO allianz (id, name, details,state,category,mukerrer) VALUES (?, ?, ?, ?, ?, ? )";

		jdbcTemplate.update(sql, Campaign.getid(), Campaign.getName(), Campaign.getDetail(),
				Campaign.getStatus(), Campaign.getCategory(), Campaign.getMukerrer());
		return 0;
	}

	public List<campaign> getAllRowsFromTable() {
		String sql = "SELECT * FROM allianz";

		// Replace "your_table_name" with the actual name of your table
		// Replace YourEntity.class with the entity class corresponding to your table

		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			campaign entity = new campaign();

			entity.setid(rs.getString("id"));
			entity.setName(rs.getString("name"));
			entity.setDetail(rs.getString("details"));
			entity.setStatus(rs.getString("state"));
			entity.setCategory(rs.getString("category"));
			entity.setMukerrer(rs.getBoolean("mukerrer"));

			return entity;
		});
	}

	@Override
	public campaign getCampaignByName(String Name) {
		String sql = "SELECT * FROM allianz WHERE name = ?";

		try {

			return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
				campaign entity = new campaign();
				entity.setid(rs.getString("id"));
				entity.setName(rs.getString("name"));
				entity.setDetail(rs.getString("details"));
				entity.setStatus(rs.getString("state"));
				entity.setCategory(rs.getString("category"));
				entity.setMukerrer(rs.getBoolean("mukerrer"));
				return entity;
			}, Name);
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}

	}

	@Override
	public campaign getCampaignById(String id) {
		String sql = "SELECT * FROM allianz WHERE id = ?";

		try {
			return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
				campaign entity = new campaign();
				entity.setid(rs.getString("id"));
				entity.setName(rs.getString("name"));
				entity.setDetail(rs.getString("details"));
				entity.setStatus(rs.getString("state"));
				entity.setCategory(rs.getString("category"));
				entity.setMukerrer(rs.getBoolean("mukerrer"));
				return entity;
			}, id);
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}

	@Override
	public void deactivateoractivate(campaign c) {

		String sql = "UPDATE allianz SET state = ? WHERE id = ?";
		jdbcTemplate.update(sql, c.getStatus(), c.getid());
		String insertChangeSql = "INSERT INTO campaign_status_changes (campaign_id, status, change_timestamp) VALUES (?, ?, NOW())";
		jdbcTemplate.update(insertChangeSql, c.getid(), c.getStatus());

	}

	@Override
	public List<campaign> getactivecampaigns() {
		String sql = "SELECT * FROM allianz WHERE state = ?";
		String state = "active";

		try {

			return jdbcTemplate.query(sql, (rs, rowNum) -> {
				campaign entity = new campaign();
				entity.setid(rs.getString("id"));
				entity.setName(rs.getString("name"));
				entity.setDetail(rs.getString("details"));
				entity.setStatus(rs.getString("state"));
				entity.setCategory(rs.getString("category"));
				entity.setMukerrer(rs.getBoolean("mukerrer"));
				return entity;
			}, state);
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}

	}

	@Override
	public List<campaign> getdeactivecampaigns() {
		String sql = "SELECT * FROM allianz WHERE state = ?";
		String state = "deactive";

		try {

			return jdbcTemplate.query(sql, (rs, rowNum) -> {
				campaign entity = new campaign();
				entity.setid(rs.getString("id"));
				entity.setName(rs.getString("name"));
				entity.setDetail(rs.getString("details"));
				entity.setStatus(rs.getString("state"));
				entity.setCategory(rs.getString("category"));
				entity.setMukerrer(rs.getBoolean("mukerrer"));
				return entity;
			}, state);
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}

	public List<CampaignStatusChange> getCampaignStatusChanges(String campaignId) {
		String sql = "SELECT * FROM campaign_status_changes WHERE campaign_id = ? ORDER BY change_timestamp ASC";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			CampaignStatusChange change = new CampaignStatusChange();
			change.setId(rs.getInt("id"));
			change.setCampaignId(rs.getString("campaign_id"));
			change.setStatus(rs.getString("status"));
			change.setChangeTimestamp(rs.getTimestamp("change_timestamp").toInstant());
			return change;
		}, campaignId);
	}
}
