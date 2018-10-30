package academy.softserve.eschool.controller;

import academy.softserve.eschool.dto.ClassDTO;
import academy.softserve.eschool.service.ClassServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students/transition")
@Api(value = "transition", description = "Endpoints for transition to new school year")
public class NYTransitionController {
    @Autowired ClassServiceImpl classService;

    @PostMapping
    @ApiOperation(value = "Add new classes based on currently classes with new year and name")
    public Boolean addNewYearClasses(){
        classService.addNewYearClasses();
        return true;
    }

    @GetMapping
    @ApiOperation(value = "Get true active classes with students", response = ClassDTO.class)
    public List<ClassDTO> getActiveClassesWithStudents(){
        return classService.getActiveClassesWithStudents();
    }
}