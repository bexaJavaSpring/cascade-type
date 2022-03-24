package uz.pdp.cascadetype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import uz.pdp.cascadetype.entity.Region;

public interface RegionRepository extends JpaRepository<Region, Integer> {

    @Query(value = "select * from region where id=:ketmon", nativeQuery = true)
    Region getRegion(@Param("ketmon") Integer regionId);


    @Procedure(name = "sum_test")
    long getSum(@Param("a") int a, @Param("b") int b);
}
