package twonyizin.springframework.image.imageupload.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import twonyizin.springframework.image.imageupload.entity.Image;
import twonyizin.springframework.image.imageupload.exception.ResourceNotFoundException;
import twonyizin.springframework.image.imageupload.models.Dtos.EmployeeDto;
import twonyizin.springframework.image.imageupload.models.response.CommonResponse;
import twonyizin.springframework.image.imageupload.models.response.EmployeeResponse;
import twonyizin.springframework.image.imageupload.services.EmployeeService;
import twonyizin.springframework.image.imageupload.services.ImageService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ImageController {
    Logger logger = LoggerFactory.getLogger(ImageController.class);

    @Autowired
    private final ImageService imageService;

    @Autowired
    private final EmployeeService employeeService;

    @Autowired
    Environment environment;

    public ImageController(ImageService imageService, EmployeeService employeeService) {
        this.imageService = imageService;
        this.employeeService = employeeService;
    }


    @PostMapping("/employeeId/{id}/image")
    public ResponseEntity<CommonResponse> uploadEmployeeImgage(@PathVariable long id,
                                                               @RequestParam("file") MultipartFile file) {
        imageService.storeFile(file, id);
        return new ResponseEntity<>(new CommonResponse(true), HttpStatus.OK);
    }

    @GetMapping("/employeeId/{id}/image")
    public ResponseEntity<Resource> getEmployeeProfileImage(@PathVariable("id") Long id, HttpServletRequest request) {
        try {
            Image databaseFile = imageService.getImageByEmployeeId(id);
            return ResponseEntity.ok().contentType(MediaType.parseMediaType(databaseFile.getFileType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=\"" + databaseFile.getFileName() + "\"")
                    .body(new ByteArrayResource(databaseFile.getData()));
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("No Image Uploaded!");
        }
    }

    @GetMapping("/employeeId/{id}/profile")
    public EmployeeResponse getEmployeeProfile(@PathVariable long id) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        EmployeeResponse employeeResponse = new EmployeeResponse(employeeDto.getId(),employeeDto.getEmployeeName());
        Link link = new Link(environment.getProperty("employee.image.link") + "employeeId/" + employeeDto.getId() + "/image")
                .withSelfRel();
        employeeResponse.add(link);
        employeeResponse.setResult(true);
        return employeeResponse;
    }
    }

