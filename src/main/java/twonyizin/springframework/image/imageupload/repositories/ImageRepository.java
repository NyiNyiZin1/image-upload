package twonyizin.springframework.image.imageupload.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import twonyizin.springframework.image.imageupload.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
    @Query(value = "select * from image m where m.employee_id=:id", nativeQuery = true)
    Image getImageByEmployeeId(@Param("id") Long id);
}
