package uz.pdp.cascadetype.payload;

import lombok.Data;

import java.util.List;

@Data
public class RegionDTO {
    //Buuxoro
    private String name;
    //Jondor,Olot
    private List<DistrictDTO> districtDTOList;
}
