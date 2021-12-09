package com.apps.ops.repository;
import java.io.FileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Repository;

@Repository
public class LeerJson {

	private static final Logger logger = LogManager.getLogger(LeerJson.class);

	public double leerData() {
		try {
			
			logger.info("Lectura de TipoCambio Web");

			JSONParser jsonParser = new JSONParser();
			

			FileReader fileReader = new FileReader("data.json");
			logger.info(fileReader);
			
			Object dataProveedor = new JSONParser().parse(new FileReader("data.json"));
			JSONObject data = (JSONObject) dataProveedor;
			
			logger.info(data);
			
			Object contenido=data.get("data");
			JSONObject contenidoJ=(JSONObject) contenido;
			logger.info(contenidoJ);
			
			Object moneda=contenidoJ.get("PEN");
			
			logger.info(moneda);
			return (double) moneda;

		} catch (Exception e) {
		
			logger.error(e);
			return 0;
		}
		
		
	}

}
