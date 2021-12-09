package com.apps.ops.service.impl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps.ops.repository.LeerJson;
import com.apps.ops.service.LeerDatosService;

@Service
public class LeerDatosServiceImpl implements LeerDatosService {
	private static final Logger logger = LogManager.getLogger(LeerDatosServiceImpl.class);

	@Autowired
	private LeerJson leerJson;


	@Override
	public double leerTipoCambioVenta() {
		
		double data=leerJson.leerData();
		logger.info("---->DATA PROVEEDOR: {}", data);
		return data;
	}





}
