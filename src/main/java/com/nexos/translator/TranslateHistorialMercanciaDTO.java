package com.nexos.translator;

import org.springframework.stereotype.Component;

import com.nexos.domain.HistorialMercanciaDTO;
import com.nexos.model.HistorialMercancia;


@Component
public class TranslateHistorialMercanciaDTO implements Translator<HistorialMercancia, HistorialMercanciaDTO> {

	@Override
	public HistorialMercanciaDTO translate(HistorialMercancia hisotiralMercancia) {

		HistorialMercanciaDTO imput = new HistorialMercanciaDTO();
		imput.setId(hisotiralMercancia.getId());
		imput.setId_mercancia(hisotiralMercancia.getId_mercancia());
		imput.setId_empleado(hisotiralMercancia.getId_empleado());
		imput.setFecha_modificacion(hisotiralMercancia.getFecha_modificacion());
		return imput;
	}

}
