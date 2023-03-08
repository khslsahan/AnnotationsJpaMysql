package com.hsenidmobile.AnnotationsJPAMysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
@ComponentScan("com.hsenidmobile.AnnotationsJPAMysql.config")
public class AnnotationsJpaMysqlApplication implements CommandLineRunner {

	@Autowired
	DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(AnnotationsJpaMysqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n\nOur DataSource is = " + dataSource);
		 Connection connection = dataSource.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SHOW TABLES");

		System.out.println("\n\n++++++++++++ View Tables In The hSenid_Employee +++++++++++++++++++++");

		while(resultSet.next()) {
			String tableName = resultSet.getString(1);
			System.out.println(tableName);
		}

		System.out.println("++++++++++++ END of The hSenid_Employee +++++++++++++++++++++\n\n");

	}
}
