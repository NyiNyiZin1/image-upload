package twonyizin.springframework.image.imageupload.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import twonyizin.springframework.image.imageupload.entity.Image;
import twonyizin.springframework.image.imageupload.handler.ImageNotFoundException;
import twonyizin.springframework.image.imageupload.handler.ImageStorageException;
import twonyizin.springframework.image.imageupload.repositories.ImageRepository;

import java.io.IOException;

@Service
public class ImageService {
    @Autowired
    private ImageRepository dbFileRepository;

    public Image storeFile(MultipartFile file, long employeeId) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                // throw new ImageStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            Image dbFile = new Image(fileName, file.getContentType(), file.getBytes(),employeeId);

            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
              throw new ImageStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
    public Image getFile(Long fileId) {
        return dbFileRepository.findById(fileId)
                .orElseThrow(() -> new ImageNotFoundException("File not found with id " + fileId));
    }

    public Image getImageId(Long id) {
        return dbFileRepository.getOne(id);
    }

    public Image getImageByEmployeeId(Long id) {
        return dbFileRepository.getImageByEmployeeId(id);
    }
}
