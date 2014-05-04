package com.csloan.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.csloan.data.Project;


@Repository
public class ProjectDAOImpl implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	@Override
	public List<Project> getProjects() {
		String SQL = "select * from projects";
	    List <Project> projects = jdbcTemplate.query(SQL, new ProjectMapper());
	    return projects;
	}

	@Override
	public Project getProjectByName(String name) {
		String SQL = "select * from projects where name = ?";
	    Project project = jdbcTemplate.queryForObject(SQL, new Object[]{name}, new ProjectMapper());
	    return project;
	}

	@Override
	public Project getProjectById(String id) {
		String SQL = "select * from projects where id = ?";
	    Project project = jdbcTemplate.queryForObject(SQL, new Object[]{id}, new ProjectMapper());
	    return project;
	}

	@Override
	public int getProjectCount() {
		String SQL = "select COUNT(*) from projects";
		return (jdbcTemplate.queryForObject(SQL, Integer.class));
	}
}
