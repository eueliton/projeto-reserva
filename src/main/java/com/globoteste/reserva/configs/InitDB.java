package com.globoteste.reserva.configs;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class InitDB {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@PostConstruct
	private void initDb() {
		String sqlStatements[] = { "DROP TABLE estoque IF EXISTS",
				"CREATE TABLE estoque(id  BIGINT, id_programa varchar(10) DEFAULT NULL, data_exibicao DATE, tempo_disponivel int DEFAULT 0)",
				"INSERT INTO estoque(id, id_programa, data_exibicao, tempo_disponivel) values('1','MAVO','2020-09-04',100)",
				"INSERT INTO estoque(id, id_programa, data_exibicao, tempo_disponivel) values('2','N19H','2020-09-09',100)",
				"INSERT INTO estoque(id, id_programa, data_exibicao, tempo_disponivel) values('3','HUCK','2020-09-05',40)",
				"INSERT INTO estoque(id, id_programa, data_exibicao, tempo_disponivel) values('4','DFAU','2020-09-06',100)",
				"CREATE UNIQUE INDEX IDXNAME ON estoque(id)"

		};

		Arrays.asList(sqlStatements).forEach(sql -> {
			jdbcTemplate.execute(sql);
		});
		 
	}

}
