package twonyizin.springframework.image.imageupload.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import twonyizin.springframework.image.imageupload.models.CommonResponse;
import twonyizin.springframework.image.imageupload.services.ImageService;

@RestController
public class ImageController {
    Logger logger = LoggerFactory.getLogger(ImageController.class);

    @Autowired
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }


    @PostMapping("/employeeId/{id}/image")
    public ResponseEntity<CommonResponse> uploadEmployeeImgage(@PathVariable long id,
                                                               @RequestParam("file") MultipartFile file) {
        imageService.storeFile(file, id);
        return new ResponseEntity<>(new CommonResponse(true), HttpStatus.OK);
    }
    }

