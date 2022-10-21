package com.nexos.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.nexos.constants.Constants;
import com.nexos.domain.AuditoriaSitioWebDTO;
import com.nexos.model.Empleado;
import com.nexos.repository.AuditoriaSitioWebRepository;
import com.nexos.repository.EmpleadoRepository;
import com.nexos.translator.TranslateAuditoriaSitioWeb;
import com.nexos.translator.TranslateMercancia;
import com.nexos.translator.TranslateMercanciaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.domain.MercanciaDTO;
import com.nexos.model.Mercancia;
import com.nexos.repository.MercanciaRepository;
import com.nexos.service.MercanciaService;

@Service
@Transactional
public class MercanciaServiceImpl implements MercanciaService {

  @Autowired
  private TranslateMercancia translateMercancia;
  
  @Autowired
  private TranslateMercanciaDTO translateMercanciaDTO;

  @Autowired
  private TranslateAuditoriaSitioWeb translateAuditoriaSitioWeb;

  @Autowired
  private MercanciaRepository mercanciaRepository;

  @Autowired
  private EmpleadoRepository empleadoRepository;

  @Autowired
  private AuditoriaSitioWebRepository auditoriaSitioWebRepository;

  @Override
  public Mercancia create(Mercancia mercancia) {
    return mercanciaRepository.save(mercancia);
  }

  @Override
  public List<Mercancia> findAll() {
    return mercanciaRepository.findAll();
  }

  @Override
  public List<Mercancia> getAllMercancia() {
    return mercanciaRepository.findAll();
  }

  @Override
  public Optional<Mercancia> findById(Long id) {
    return mercanciaRepository.findById(id);
  }

  @Override
  public List<Mercancia> findByNombre(String nombre) {
    return mercanciaRepository.findByNombreContainingIgnoreCase(nombre);
  }

  @Override
  public Boolean deleteById(Long id) {
    if (mercanciaRepository.existsById(id)) {
      mercanciaRepository.deleteById(id);
      return true;
    }
    return false;
  }

  @Override
  public void delete(Mercancia entity) {
    mercanciaRepository.delete(entity);
  }
    
  @Override
  public MercanciaDTO save(MercanciaDTO mercanciaDto) {
    Mercancia mercanciaIsExist = mercanciaRepository.findByNombre(mercanciaDto.getNombre());
    if (mercanciaIsExist == null) {
      System.out.print("El nombre de la mercancía no existe, se puede crear");

      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      LocalDate now = LocalDate.now();
      mercanciaDto.setFecha_ingreso(dtf.format(now));
      Optional<Empleado> empleado = empleadoRepository.findById(mercanciaDto.getId_empleado());
      auditoriaSitioWebRepository.save(
          translateAuditoriaSitioWeb
              .translate(AuditoriaSitioWebDTO
                  .builder()
                  .id(null)
                  .nombre_mercancia(mercanciaDto.getNombre())
                  .nombre_empleado(empleado.isPresent() ? empleado.get().getNombre() : "N/A")
                  .operacion(Constants.CREATED)
                  .fecha_creacion(now)
                  .build()
              )
      );
      return translateMercanciaDTO.translate(mercanciaRepository.save(translateMercancia.translate(mercanciaDto)));
    } else {
      System.out.print("El nombre de la mercancía existe, NO se puede crear");
      return null;
    }
  }

  @Override
  public void updateMercanciaDTO (MercanciaDTO MercanciaDTO) {
    Optional<Mercancia> mercancia = this.mercanciaRepository.findById(MercanciaDTO.getId());
    Mercancia mercancia1 = mercancia.get();
    if (mercancia.get().getId_empleado().equals(MercanciaDTO.getId_empleado())) {
      mercancia1.setId_empleado(MercanciaDTO.getId_empleado());
      System.out.print("El usuario tiene permisos para editar este objeto");
      mercancia1.setNombre(MercanciaDTO.getNombre());
      mercancia1.setCantidad(MercanciaDTO.getCantidad());
      mercancia1.setFecha_modificacion(MercanciaDTO.getFecha_modificacion());

    } else {
      System.out.print("El usuario NO tiene permisos para editar este objeto");

    }
  }
  @Override
  public void deleteById(long id, Long id_empleado) {
    Optional<Mercancia> mercancia = mercanciaRepository.findById(id);
    if (mercancia.isPresent()) {
      if (mercancia.get().getId_empleado().equals(id_empleado)) {
        System.out.print("El usuario tiene permisos para borrar este objeto");
        mercanciaRepository.deleteById(id);
      } else {
        System.out.print("El usuario NO tiene permisos para borrar este objeto");
      }
    } else {
      System.out.println("No existe");
    }
  }
}