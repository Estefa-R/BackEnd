package com.nexos.service;

import com.nexos.model.HistorialMercancia;

public interface HistorialMercanciaService {

	HistorialMercancia save(HistorialMercancia historialMercancia, Long id_empleado, Long id_mercancia,
			String operacion);

}
