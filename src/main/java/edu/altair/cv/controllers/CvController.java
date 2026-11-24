package edu.altair.cv.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.altair.cv.dtos.alumnos.AlumnoInfoResponseDto;
import edu.altair.cv.dtos.alumnos.AptitudResponseDto;
import edu.altair.cv.dtos.alumnos.CvResponseDto;
import edu.altair.cv.dtos.alumnos.ExperienciaResponseDto;
import edu.altair.cv.dtos.alumnos.FormacionResponseDto;
import edu.altair.cv.services.CVByAlumnoService;

@RestController
@RequestMapping("/api/cvs")
public class CvController {

	private CVByAlumnoService cvByAlumnoService;

	public CvController(CVByAlumnoService cvByAlumnoService) {
		super();
		this.cvByAlumnoService = cvByAlumnoService;
	}

	@GetMapping("/id/{idAlumno}")
	public ResponseEntity<CvResponseDto> obtainById(@PathVariable Long idAlumno) {
		AlumnoInfoResponseDto alumnoInfo = cvByAlumnoService.obtainByIdAlumno(idAlumno);

		List<ExperienciaResponseDto> listaExperiencias = cvByAlumnoService.obtainAllExperiencias().stream()
				.filter(experiencias -> experiencias.alumno().getIdAlumno().equals(alumnoInfo.idAlumno())).toList();

		List<FormacionResponseDto> listaFormaciones = cvByAlumnoService.obtainAllFormaciones().stream()
				.filter(formaciones -> formaciones.alumno().getIdAlumno().equals(alumnoInfo.idAlumno())).toList();

		List<AptitudResponseDto> listaAptitudes = cvByAlumnoService.obtainAllAptitudes().stream()
				.filter(aptitudes -> aptitudes.alumno().getIdAlumno().equals(alumnoInfo.idAlumno())).toList();

		CvResponseDto CVCompleto = new CvResponseDto(alumnoInfo, listaExperiencias, listaFormaciones,
				listaAptitudes);

		return ResponseEntity.ok(CVCompleto);
	}

}
