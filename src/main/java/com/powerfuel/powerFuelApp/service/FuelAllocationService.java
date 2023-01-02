package com.powerfuel.powerFuelApp.service;

import com.powerfuel.powerFuelApp.dto.FuelAllocationDTO;
import com.powerfuel.powerFuelApp.model.FuelAllocation;
import com.powerfuel.powerFuelApp.repository.FuelAllocationRepository;
import com.powerfuel.powerFuelApp.util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FuelAllocationService {

    @Autowired
    public FuelAllocationRepository fuelAllocationRepository;

    @Autowired
    private ModelMapper modelMapper;


//    public FuelAllocationDTO saveFuelAllocation(FuelAllocationDTO fuelAllocationDTO) {
//
//        fuelAllocationRepository.save(modelMapper.map(fuelAllocationDTO, FuelAllocation.class));
//        return fuelAllocationDTO;
//
//    }


//    public List<FuelAllocationDTO> getAllAllocations(){
//        List<FuelAllocation> fuelAllocationList= fuelAllocationRepository.findAll();
//        return modelMapper.map(fuelAllocationList,new TypeToken<List<FuelAllocationDTO>>(){}.getType());
//
//    }


    public String saveFuelAllocation(FuelAllocationDTO fuelAllocationDTO){
        if(fuelAllocationRepository.existsById(fuelAllocationDTO.getAllocationId())){
            return VarList.RSP_DUPLICATED;

        }else {

            fuelAllocationRepository.save(modelMapper.map(fuelAllocationDTO, FuelAllocation.class));
            return VarList.RSP_SUCCESS;
        }

    }



    public List<FuelAllocationDTO> getAllAllocations(){
        List<FuelAllocation> fuelAllocationList=fuelAllocationRepository.findAll();
        return modelMapper.map(fuelAllocationList,new TypeToken<ArrayList<FuelAllocationDTO>>(){}.getType());


    }


}





