package uz.pdp.cascadetype.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import uz.pdp.cascadetype.entity.District;
import uz.pdp.cascadetype.entity.Region;
import uz.pdp.cascadetype.payload.DistrictDTO;
import uz.pdp.cascadetype.payload.RegionDTO;
import uz.pdp.cascadetype.repository.RegionRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/region")
//service yoki controller ustiga
@Transactional(rollbackFor = {SQLException.class})
public class RegionController {

    @Autowired
    RegionRepository regionRepository;


    //aynan metod ustiga
//    @Transactional(rollbackFor = { SQLException.class })
    @PostMapping
    public HttpEntity<?> add(@RequestBody RegionDTO regionDTO) {
        Region region = new Region();
        region.setName(regionDTO.getName());

        List<DistrictDTO> districtDTOList = regionDTO.getDistrictDTOList();

        List<District> districtList = new ArrayList<>();
        for (DistrictDTO districtDTO : districtDTOList) {
            District district = new District();
            district.setName(districtDTO.getName());
            district.setRegion(region);
            districtList.add(district);

        }
        region.setDistricts(districtList);

        regionRepository.save(region);
        return ResponseEntity.ok("Saved!");
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        regionRepository.deleteById(id);
        return ResponseEntity.ok("Deleted!");
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @RequestBody RegionDTO regionDTO) {
        Optional<Region> byId = regionRepository.findById(id);
        Region region = byId.get();

        region.setName(regionDTO.getName());
        List<District> districtList = new ArrayList<>();
        List<District> districts = region.getDistricts();
        for (District district : districts) {
            district.setName("Update");
            district.setRegion(region);
            districtList.add(district);
        }

        regionRepository.save(region);
        return ResponseEntity.ok("Updated!");
    }

    @GetMapping
    public HttpEntity<?> get() {
        long sum = regionRepository.getSum(2, 2);
        return ResponseEntity.ok(sum);
    }


}
