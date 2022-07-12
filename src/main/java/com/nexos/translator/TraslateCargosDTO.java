package com.nexos.translator;

import com.nexos.domain.CargosDTO;
import com.nexos.model.Cargos;

public class TraslateCargosDTO implements Translator<Cargos, CargosDTO> {

	@Override
	public CargosDTO translate(Cargos cargos) {
		
		CargosDTO imput = new CargosDTO();
		imput.setId(cargos.getId());
		imput.setNombre(cargos.getNombre());
		return imput;
	}
}