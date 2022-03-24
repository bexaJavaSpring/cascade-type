package uz.pdp.cascadetype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.cascadetype.entity.District;
import uz.pdp.cascadetype.entity.Region;

public interface DistrictRepository extends JpaRepository<District,Integer> {
}
