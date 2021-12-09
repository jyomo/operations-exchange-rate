package com.apps.ops.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps.ops.repository.LeerJson;
import com.apps.ops.service.LeerDatosService;

@Service
public class LeerDatosServiceImpl implements LeerDatosService {
	
	@Autowired
	private LeerJson leerJson;


	@Override
	public double leerTipoCambioVenta() {
		
		// TODO Auto-generated method stub
		double data=leerJson.leerData();
		System.out.println("DATA PROVEEDOR"+ data);
		return data;
	}





}
