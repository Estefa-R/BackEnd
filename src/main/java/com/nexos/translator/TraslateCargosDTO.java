package com.nexos.translator;

import com.nexos.domain.CargosDTO;
import com.nexos.model.Cargos;

public class TraslateCargosDTO implements Translator<Cargos, CargosDTO> {

	@Override
	public CargosDTO translate(Cargos cargos) {
		
		CargosDTO imput = new CargosDTO();
		imput.setCargos_id(cargos.getCargos_id());
		imput.setNombre_cargo(cargos.getNombre_cargo());
		return imput;
	}
}