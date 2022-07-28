package com.nexos.translator;

import org.springframework.stereotype.Component;

import com.nexos.domain.MercanciaDTO;
import com.nexos.model.Mercancia;

@Component
public class TranslateMercanciaDTO implements Translator<Mercancia, MercanciaDTO> {

	@Override
	public MercanciaDTO translate(Mercancia mercancia) {
		
		MercanciaDTO imput = new MercanciaDTO();
		imput.setMercanciaId(mercancia.getMercanciaId());
		imput.setNombre(mercancia.getNombre());
		imput.setCantidad(mercancia.getCantidad());
		imput.setFechaIngreso(mercancia.getFechaIngreso());
		imput.setFechaModificacion(mercancia.getFechaModificacion());
		imput.setIdEmpleado(mercancia.getIdEmpleado());
		imput.setIdCreadoPor(mercancia.getIdCreadoPor());
		return imput;
	}

}
