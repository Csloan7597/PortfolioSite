package com.csloan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.csloan.data.Project;

public class ProjectMapper implements RowMapper<Project> {

	@Override
	public Project mapRow(ResultSet rs, int arg) throws SQLException {
		Project project = new Project();
		project.setId(rs.getString(1));
		project.setName(rs.getString(2));
		project.setDescription(rs.getString(3));
		project.setLargeIconLink(rs.getString(4));
		project.setSmallIconLink(rs.getString(5));
		project.setTechUsed(rs.getString(6));
		project.setRepoLink(rs.getString(7));
		return project;
	}

}
